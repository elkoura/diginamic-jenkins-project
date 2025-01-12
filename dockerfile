# Part d'une image openjdk
FROM openjdk:17-jdk

# Choix du dossier de travail
WORKDIR /elkoura/my-app

# Copie le .jar généré dans /elkoura/my-app/app.jar
COPY target/projet-jenkins-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]