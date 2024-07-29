#!/bin/bash
set -e

host="localhost:5436"
shift
cmd="$@"

until PGPASSWORD="admin" psql -h "$host" -U "admin" -c '\q'; do
  >&2 echo "Postgres no está disponible - esperando"
  sleep 1
done

>&2 echo "Postgres está disponible - ejecutando comando"
exec $cmd
