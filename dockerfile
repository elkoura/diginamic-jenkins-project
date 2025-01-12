# Part d'une image openjdk
FROM openjdk:17-jdk

# Choix du dossier de travail
WORKDIR /elkoura/my-app

COPY target/projet-jenkins-1.0-SNAPSHOT-shaded.jar app.jar



EXPOSE 8080

CMD ["java", "-jar", "app.jar"]