FROM jenkins/jenkins:lts

ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
ENV JENKINS_HOME /var/jenkins_home
ENV CASC_JENKINS_CONFIG /usr/share/jenkins/config/

WORKDIR /usr/share/jenkins

COPY app/plugins.txt plugins.txt
COPY app/config/ config/
COPY src/ src/
COPY app/init.groovy.d/ ref/init.groovy.d/

RUN /usr/local/bin/install-plugins.sh < plugins.txt
RUN ls -la .

## reverse proxy
#ENV JENKINS_OPTS="--prefix=/jenkins"


#USER root
#RUN apt-get update && apt-get install -y ruby make more-thing-here

#USER jenkins