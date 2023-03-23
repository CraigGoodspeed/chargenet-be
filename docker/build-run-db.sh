docker build -f ./mysql/Dockerfile -t mysql-local .
docker run -d --env-file=./mysql/.env --name mysql-local -p 3306:3306 mysql-local

#assume error because it has already been defined in a prior run
if [ $? -ne 0 ]; then
  docker start mysql-local
fi