# taskService

To run this microservice (there are many ways to do it, just explaining a simple one):

- clone or download all 3 repos: https://github.com/daniender/dockerEureka, https://github.com/daniender/dockerGateway and https://github.com/daniender/taskService
- build .jar files with Maven: "mvn clean package install"
- build docker images: "docker build -t /docker-image-name/** ." for each microservice (Dockerfile is provided for each one)
- Place docker-compose.yml file on root of downloaded projects (see orientative image attached)
- Rise docker containers with docker-compose: "docker-compose -f docker-compose.yml up"

Endpoints will be available through ApiGateway service on: http://localhost:8762/task-service/swagger-ui.html


![image](https://user-images.githubusercontent.com/80528316/111029294-51a99e80-83fc-11eb-8339-751d6549f82f.png)

**(images names are defined in docker-compose.yml file)
