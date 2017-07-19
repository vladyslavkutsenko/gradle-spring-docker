FROM postgres:9.6
EXPOSE 5432
ENV \
   POSTGRES_DB=chuck \
   POSTGRES_USER=chuck \
   POSTGRES_PASSWORD=chuck


ADD init.sql /docker-entrypoint-initdb.d
