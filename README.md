This repo is under construction.

The application is currently under the process of continuing the backend API, and kubernetes deployment.

It is a simple portfolio app built with the goal of using security precautions(most likely many vulnerabilities atm).

This is built with in Springboot(Java).

The application can run in a k8 cluster, which is configured in this repository. Commands can be seen in the makefile.
With make, you can run the cluster with make start. To know what ip address minikube uses, run minikube ip. With that ip, you can access endpoints from the Spring api.
Example: curl http://$(minikube ip)/home/getdata

The application can also run in just a docker network, by running the docker-compose.yml file.
run source set-random-secrets.bash (if you want to set random secrets as env variables, you can otherwise set them yourself)
and then docker compose up -d --build (-d for detached mode and --build to rebuild Docker image) 

For kubernetes deployment, have kubectl, minikube, docker and make(for configured commands) installed.
For only using docker compose. Have docker and bash installed.

Exact version requirements have not been determined. The versions currently used in my environment are:
minikube version: v1.36.0
kubectl Client Version: v1.33.3
Docker version: 28.3.3
GNU Make: 4.4.1
GNU bash version : 5.2.37


