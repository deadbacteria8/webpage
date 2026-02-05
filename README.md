This repo is under construction.

The application is currently under the process of continuing the backend API, and kubernetes deployment.

Possible through just docker but also in k8s cluster. Various commands can be seen in the Makefile.

It is a portfolio app for multiple users, built with the goal of using security precautions.

This is built with in Springboot(Java).
With make, you can run the cluster with make start. To know what ip address minikube uses, run minikube ip. With that ip, you can access endpoints from the Spring api.
Example: curl http://$(minikube ip):8080/portfolio/deadbacteria8/about
To see endpoints http://$(minikube ip):8080/swagger-ui.html

The application can also run in just a docker network, by running the docker-compose.yml file.
Run make only-docker. The application will build, when its built, http://localhost:8080/portfolio/deadbacteria8/about will be accesible.

See http://localhost:8080/portfolio/deadbacteria8/about

For kubernetes deployment, have kubectl, minikube, docker and make(for configured commands) installed.
For only using docker compose. Have docker and bash installed.

Exact version requirements have not been determined. The versions currently used in my environment are:
minikube version: v1.36.0
kubectl Client Version: v1.33.3
Docker version: 28.3.3
GNU Make: 4.4.1
GNU bash version : 5.2.37


