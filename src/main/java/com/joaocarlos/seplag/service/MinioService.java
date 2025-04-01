package com.joaocarlos.seplag.service;

import io.minio.*;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

@Service
public class MinioService {

    private final MinioClient minioClient;

    @Value("${minio.bucketName}")
    private String bucketName;

    public MinioService(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    private void criarBucketSeNaoExistir() throws Exception {
        boolean bucketExiste = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!bucketExiste) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    public String uploadFile(MultipartFile file) throws Exception {
        String fileHash = generateHash(file.getInputStream());
        String fileName = fileHash + "-" + file.getOriginalFilename();

        criarBucketSeNaoExistir();

        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(fileName)
                        .stream(file.getInputStream(), file.getSize(), -1)
                        .contentType(file.getContentType())
                        .build()
        );

        return fileName;
    }

    private String generateHash(InputStream inputStream) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(inputStream.readAllBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    public String generateFileUrl(String fileName) throws Exception {
        String presignedUrl = minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .bucket(bucketName)
                        .object(fileName)
                        .method(Method.GET)
                        .expiry(5, TimeUnit.MINUTES)
                        .build()
        );



        return presignedUrl;
    }

}
