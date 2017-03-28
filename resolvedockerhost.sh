#!/bin/bash

echo "Resolving docker host..."
echo `/sbin/ip route|awk '/default/ { print $3 }'` dockerhost \
   >> /etc/hosts; \
   exec "$@"
