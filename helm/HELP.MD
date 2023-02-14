# Kubernetes-Mentoring-Program
##### The Markdown Editor, Shorasul Shoazimov


## Installation

```sh
helm install -f backend-app/user-ms-values.yaml user-ms ./backend-app/ -n kong
helm install -f backend-app/post-ms-values.yaml post-ms ./backend-app/ -n kong
```

## Or Replication with replication setups

```sh
helm install -f backend-app/user-ms-values.yaml user-ms ./backend-app/ -n kong --set serviceApp.replicas=5
helm install -f backend-app/post-ms-values.yaml post-ms ./backend-app/ -n kong --set serviceApp.replicas=5
```


## Installation

```sh
helm install -f backend-app/user-ms-values.yaml user-ms ./backend-app/ -n kong
helm install -f backend-app/post-ms-values.yaml post-ms ./backend-app/ -n kong
```



## Upgrade
```sh
helm upgrade -f backend-app/user-ms-values.yaml user-ms ./backend-app/ -n kong
helm upgrade -f backend-app/post-ms-values.yaml post-ms ./backend-app/ -n kong
```

## Delete
```sh
helm delete user-ms -n kong
helm delete post-ms -n kong
```
