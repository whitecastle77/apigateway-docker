# apigateway-docker

## Projeto
Implementar um ambiente de microsserviços que possua as seguintes características:
- Permitir o acesso aos microsserviços através de API Gateway
- Possua capacidade de load balancer para diferentes instâncias em execução
- Consigamos monitorar a performance dos microsserviços
- Documentação automatizada das APIs desenvolvidas
- Tolerancia a falhas
- Solução dockerizada rodando via docker compose

![API Gateway Desenho](https://user-images.githubusercontent.com/87205235/157774157-5c927076-4228-45f3-8bfd-768f72b27763.jpg)

## Tecnologias
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

## Como Testar
- Tenha uma conta no DockerHub e instale o Docker na sua estação
- Baixe o arquivo docker-compose.yml do projeto para seu computador
- Execute o comando "docker-compose up" no diretorio que o arquivo foi salvo (levará vários minutos para baixar as dock-images e executá-las)
- As seguintes portas devem estar livres no seu computador: 3306, 5672, 8000, 8100, 8700, 8765, 9411, 15672
(se usar windows pode ver se está em uso executando "netstat -aon | findstr :80" onde 80 é a porta procurada, Observe o PID [id do processo]. Se deseja liberar a porta, vá para o gerenciador de tarefas, classifique por pid e feche esse processo) 
- ...
