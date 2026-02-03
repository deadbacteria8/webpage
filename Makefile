SHELL := /bin/bash

apply:
	cp database-secrets-template.env kubernetes/cluster-secrets/database/database.env
	cp spring-secrets-template.env kubernetes/cluster-secrets/spring/spring.env
	kubectl apply -k kubernetes/cluster-secrets/database/
	kubectl apply -k kubernetes/cluster-secrets/spring/
	rm kubernetes/cluster-secrets/database/database.env
	rm kubernetes/cluster-secrets/spring/spring.env
	kubectl apply -f kubernetes/database
	kubectl apply -f kubernetes/spring

delete:
	kubectl delete -f kubernetes/ingress/ingress-routing.yml
	kubectl delete -f kubernetes/ingress/template-ingress-nginx.yml
	kubectl delete -f kubernetes/spring
	kubectl delete -f kubernetes/database
	kubectl delete -k kubernetes/cluster-secrets/spring
	kubectl delete -k kubernetes/cluster-secrets/database

start:
	docker build -t portfolio .
	minikube start
	minikube image load portfolio
	minikube addons enable ingress
	$(MAKE) apply
	kubectl wait --namespace ingress-nginx \
	  --for=condition=ready pod -l app.kubernetes.io/component=controller \
	  --timeout=60s
	kubectl apply -f kubernetes/ingress/ingress-routing.yml
	kubectl apply -f kubernetes/ingress/template-ingress-nginx.yml

stop:
	minikube delete

docker-only:
	@source set-random-secrets.bash && \
	docker compose up -d --build
