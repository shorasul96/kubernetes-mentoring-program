#!/bin/bash
echo -e "\n* Environment variable in process creating"
kubectl apply -f namespaces.yml;

echo -e "\n* PSQL & Redis in process creating"
kubectl apply -f post-psql --namespace=kong;
kubectl apply -f user-psql --namespace=kong;

echo -e "\n* Post & User services in process creating"
kubectl apply -f user-app --namespace=kong;
kubectl apply -f post-app --namespace=kong;

kubectl create -f https://bit.ly/k4k8s
kubectl apply -f ./gateway;
echo -e "\n* Forwarding internal gateway port to external machine"
kubectl -n kong port-forward --address localhost,0.0.0.0 service/post-ms-service-svc 8081:8081
kubectl -n kong port-forward --address localhost,0.0.0.0 svc/kong-proxy 8080:80