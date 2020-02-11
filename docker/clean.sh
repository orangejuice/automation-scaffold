docker container prune --force
docker image rm docker_jenkins --force
docker volume rm docker_jenkinsHome --force

# To clean the environment
#docker system prune --volumes --force
