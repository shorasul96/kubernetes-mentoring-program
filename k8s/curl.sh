#!/bin/bash
while : ; do
  curl 'http://localhost:8081/version'
  echo -e '  ' $(date +%F_%T)
  sleep 0.5
done