# apigateway-docker

## Resumo do Projeto
Implementar um ambiente de microsserviços que possua as seguintes características:
- Permitir o acesso aos microsserviços através de API Gateway
- Possua capacidade de load balancer para diferentes instâncias em execução
- Consigamos monitorar a performance dos microsserviços
- Documentação automatizada das APIs desenvolvidas
- Tolerancia a falhas
- Solução containerizada rodando via docker compose

![API Gateway Desenho](https://user-images.githubusercontent.com/87205235/157774157-5c927076-4228-45f3-8bfd-768f72b27763.jpg)

## Tecnologia Utilizada
- VSCode + SonarLint
- GitHub
- Postman
- Java 17
- Maven 4.0.0
- API Rest
- Microserviços
- Spring Boot 2.6.3
- Spring Initializr
- Spring Actuator (monitor and manage the Spring Boot application)
- Spring Web (build web RESTful)
- Spring Cloud Gateway
- Spring Cloud OpenFeigh
- Spring Cloud Load Balancer 
- Spring Cloud Distributed Tracing (Zipkin e Sleuth);
- Spring Cloud Netflix Eureka (Service Registry, Service Discovery, Naming Server);
- Springdoc OpenAPI + Swagger UI
- JPA/Hibernate
- MySql DB 8 + Workbench
- Resilience4j (Circuit Breaker, resilient and fault-tolerant applications)
- RabbitMQ (Zipkin fault-tolerant)
- Docker + Docker Compose

## Configuração do ambiente
- Tenha uma conta no DockerHub e instale o Docker na sua estação
- Instale o Postman (vai ajudar nos testes)
- Baixe o arquivo docker-compose.yml do projeto para seu computador
- Execute o comando "docker-compose up -d" no diretorio que o arquivo foi salvo (levará vários minutos para baixar as dock-images e executá-las)
- As seguintes portas devem estar livres no seu computador: 3306, 5672, 8000, 8100, 8700, 8765, 9411, 15672
(se usar windows pode ver se está em uso executando "netstat -aon | findstr :80" onde 80 é a porta procurada, Observe o PID [id do processo]. Se deseja liberar a porta, vá para o gerenciador de tarefas, classifique por pid e feche esse processo) 

## Execução 
- Após o Docker Compose finalizar seu processo iremos validar a execução dos serviços e testar as APIs LinkService e BookService
- 01 MySQL
- 02 Zipkin (http://localhost:9411/)
- 03 RabbitMQ (http://localhost:15672/) Login: guest Pass: guest
- 04 Eureka Naming Server (http://localhost:8765/)
- 05 SpringDoc (http://localhost:8000/v3/api-docs) e (http://localhost:8100/v3/api-docs)
- 06 Swagger (http://localhost:8000/swagger-ui.html) e (http://localhost:8100/swagger-ui.html)
- 07 Bookservice (http://localhost:8000/actuator)
- 08 Linkservice (http://localhost:8100/actuator)
- 09 API Gateway (http://localhost:8700/actuator)
### 09.1 Execução do Linkservice através do Gateway
- get http://localhost:8700/linkservice/photos 
- (API interna acessa API externa e pega lista de fotos existentes)
- get http://localhost:8700/linkservice/photos/{id} 
- (API interna acessa API externa e pega 1 unico item)
- get http://localhost:8700/linkservice/books 
- (API interna acessa outra API interna e pega lista de livros existentes)
- get http://localhost:8700/linkservice/books/{isbn} 
- (API interna acessa outra API interna e pega 1 unico item)
### 09.2 Execução do Bookservice através do Gateway
- get http://localhost:8700/bookservice/books 
- (API interna pega lista de livros existentes)
- get http://localhost:8700/bookservice/books/{isbn} 
- (API interna pega 1 unico item)
- put http://localhost:8700/bookservice/books -> postman 
- (API interna salva alterações no DB, execute via postman)
- delete http://localhost:8700/bookservice/books/{isbn} -> postman 
- (API interna exclui item no DB, execute via postman)
- post http://localhost:8700/bookservice/books -> postman
- (API interna inclui novo item no DB, execute via postman)
- Exemplo JSON: {"isbn": 123456789,"author": "Ulrich Max","category": "TECNOLOGY","edition": 2,"title": "The Greatest IT Code","type": "PAPER"}
