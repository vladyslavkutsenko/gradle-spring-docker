#!/bin/sh

echo `/sbin/ip route|awk '/default/ { print $3 }'` dockerhost >> /etc/hosts

exec "$@"
