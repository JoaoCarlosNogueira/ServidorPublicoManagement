# ServidorPublicoManagement
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)

## Requisitos
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) (opcional, mas recomendado)
- **Se estiver utilizando IntelliJ IDEA, é recomendado instalar o plugin [Lombok](https://plugins.jetbrains.com/plugin/6317-lombok)** para evitar erros ao compilar o projeto.


## Iniciar o Docker
Para subir os containers necessários, execute o seguinte comando no terminal:
```sh
docker-compose up -d
```
Isso irá iniciar os serviços necessários, incluindo o banco de dados PostgreSQL.

## Executar a Aplicação
Após iniciar os containers, execute a aplicação Spring Boot da forma que preferir, seja via IDE ou terminal.

## Acessar o Banco de Dados no Container
Para acessar o container do PostgreSQL, utilize o comando abaixo:
```sh
docker exec -it postgrescontainer bash
```

Dentro do container, execute o seguinte comando para popular o banco de dados com um script SQL:
```sh
psql -U postgres -d seplag -f /docker-entrypoint-initdb.d/script.sql
```
Isso irá garantir que todas as tabelas e dados necessários sejam criados.

## Acessar a Aplicação
Após a aplicação estar rodando, acesse a interface do Swagger para testar os endpoints:
```sh
http://localhost:8080/swagger-ui/index.html#/
```

## Autenticação na Aplicação
Para acessar os endpoints protegidos, siga os passos abaixo:

1. Acesse o endpoint de login: `/auth/login`
2. Digite as credenciais padrão:
   - **Usuário**: `admin`
   - **Senha**: `1234`
3. Clique no botão **Executar**.
4. Copie o **Token** gerado na resposta da requisição.
5. No Swagger, clique no botão **Authorize**.
6. No campo de autenticação digite o **Token copiado**.
7. Clique em **Authorize**.

Após seguir esses passos, os endpoints protegidos poderão ser acessados normalmente pelo Swagger.

## Renovação do Token
O token de autenticação expira a cada **5 minutos**. Para evitar que o usuário precise realizar login novamente, há um endpoint para renovação do token:

1. Copie o token gerado no login.
2. Acesse o endpoint `POST /auth/refresh`.
3. No campo **token**, cole o token copiado.
4. Clique em **Executar**.
5. O token será renovado e poderá ser reutilizado.

Ao chamar esse endpoint com um token válido, um novo período de validade será concedido ao token informado.
## Enviar e Recuperar Foto de Pessoa
### Upload de Foto (`POST /foto-pessoa/upload`)
Este endpoint permite o envio de uma foto para uma pessoa específica pelo **ID**.

1. No Swagger, acesse `POST /foto-pessoa/upload`.
2. Informe o **ID de uma pessoa existente no banco de dados** no campo `pesId`.
3. No campo `file`, clique em "Escolher arquivo" e selecione uma imagem.
4. Clique em **Executar**.

### Recuperar Foto (`GET /foto-pessoa/buscar/{pessoaId}`)
Este endpoint recupera a foto associada a uma pessoa.

1. No Swagger, acesse `GET /foto-pessoa/buscar/{pessoaId}`.
2. Informe o **ID da pessoa em que você enviou a imagem** no parâmetro `pessoaId`.
3. Clique em **Executar**.
4. A resposta será um link para acessar a imagem armazenada.


