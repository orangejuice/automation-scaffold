#!/bin/sh

cd /usr/share/jenkins/keys || exit

PORT=$(curl -Lv localhost:8080/login 2>&1 | grep -i 'x-ssh-endpoint' | grep -Eo '[0-9]{4,5}')
curl -Lv localhost:8080/login 2>&1
echo "jenkins ssh port: $PORT"

sshEP="ssh -l admin -i id_jenkins_ssh -p $PORT localhost"
UPDATE_LIST=$($sshEP list-plugins | grep -e ')$' | awk '{ print $1 }')
if [ -n "$UPDATE_LIST" ]; then
  echo Updating Jenkins Plugins: "$UPDATE_LIST"
  $sshEP install-plugin "$UPDATE_LIST"
  $sshEP safe-restart
fi
