### Building and uploading into hub
```sh
cd user-service;
docker build -t epamshorasulshoazimov/user-service:1.0.1 .
docker tag epamshorasulshoazimov/user-service:1.0.1 epamshorasulshoazimov/user-service:1.0.1
docker push epamshorasulshoazimov/user-service:1.0.1
```

```sh
cd post-service;
docker build -t epamshorasulshoazimov/post-service:1.0.2 .
docker tag epamshorasulshoazimov/post-service:1.0.2 epamshorasulshoazimov/post-service:1.0.2
docker push epamshorasulshoazimov/post-service:1.0.2
```


## RollingUpdate script

```sh
cd k8s/post-app/
kubectl apply -f post-app-deploy.yml -n kong --record
kubectl -n kong set image deployment.apps/post-service-app post-service-app=epamshorasulshoazimov/post-service:1.0.2
```

