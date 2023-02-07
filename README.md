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
kubectl apply -f post-app-deploy.yml -n kong 
kubectl -n kong set image deployment.apps/post-service-app post-service-app=epamshorasulshoazimov/post-service:1.0.0
```

### History of rolling out

```sh
# Watch update status for deployment “post-service”:
kubectl rollout status deployment.apps/post-service-app -n kong

# Pause deployment on “post-service”:
kubectl rollout pause deployment.apps/post-service-app -n kong

# Resume deployment on “post-service”:
kubectl rollout resume deployment.apps/post-service-app -n kong

# View rollout history on “post-service”:
kubectl rollout history deployment.apps/post-service-app -n kong

# Undo most recent update on “post-service”:
kubectl rollout undo deployment.apps/post-service-app -n kong

# Rollback to specific revision on “post-service”:
kubectl rollout undo deployment.apps/post-service-app -n kong --to-revision=1.0.1
```

