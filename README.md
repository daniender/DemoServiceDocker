# taskService

To run this microservice (there are many ways to do it, just explaining a simple one):

- clone or download this repo and these other: https://github.com/daniender/DemoEurekaDocker, https://github.com/daniender/DemoGatewayDocker
- build .jar files with Maven: "clean package install"
IMPORTANT: DemoServiceDocker project has 3 profiles: test, dev and prod. For standalone execution, use "dev" profile (Eurkea independent), for Docker functionality, use "prod" profile. 
- build docker images: "docker build -t /docker-image-name/** ." for each microservice (Dockerfile is provided for each one)
- Rise docker containers with docker-compose: "docker-compose -f docker-compose.yml up"

Endpoints will be available through ApiGateway service on: http://localhost:8762/task-service/swagger-ui.html

Eureka service will be available on: http://localhost:8761/

**(images names are defined in docker-compose.yml file)
