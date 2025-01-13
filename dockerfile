FROM jenkins/jenkins:jdk17

# Passer en root pour installer Docker
USER root

# Installer Docker CLI (sous Debian/Ubuntu)
RUN apt-get update && apt-get install -y docker.io

# Ajouter l'utilisateur jenkins au groupe docker 
RUN usermod -aG docker jenkins

# Revenir en mode utilisateur Jenkins
USER jenkins