#!/bin/bash
kubectl port-forward service/post-service-svc 8081:8081 --namespace dev

