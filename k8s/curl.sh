#!/bin/bash
while : ; do
  curl 'http://localhost:8080/post-ms/version'
  echo -e '  ' $(date +%F_%T)
  sleep 0.5
done