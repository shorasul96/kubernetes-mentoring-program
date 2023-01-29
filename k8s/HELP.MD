# Kubernetes-Mentoring-Program
##### The Markdown Editor, Shorasul Shoazimov


## Installation
Install docker-desktop & run kubernetes.
Open `bash/terminal` and write next script to create namespace

```sh
kubectl apply -f namespaces.yml
```
###
Then next need to run postgres database, It will take some minutes to start pod
```sh
kubectl apply -f database --namespace=dev
```
###
Please, be sure that postgres pod is running. Then run scripts below for starting our service-applications
```sh
kubectl apply -f user-app --namespace=dev
kubectl apply -f post-app --namespace=dev
```
###
In the last step we need to forward ports to external (expose). Let's start with user-forward
```sh
bash user-forward.sh
```

Open new tab on `bash/terminal` in order to run port-forward.
```sh
bash post-forward.sh
```
#
## Development server addresses

| Services     | Ports |
|--------------|-------|
| Post-service | 8081  |
| User-service | 8091  |
