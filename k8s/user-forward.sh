#!/bin/bash

kubectl port-forward service/user-service-svc 8091:8091 --namespace dev

