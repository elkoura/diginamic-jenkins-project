pipeline {
  agent any
  tools {
    maven 'Maven 3.9.9'
  }
  stages {

    stage('Build') {
      steps {
        echo 'Building..'
        sh 'mvn clean compile'
      }
    }

    stage('Test') {
      steps {
        echo 'Testing..'
        sh 'mvn test'
      }
    }

    stage('Create Package') {
      steps {
        echo 'Packaging..'
        // Ici on suppose que le plugin maven-shade-plugin est configuré
        sh 'mvn package'
      }
    }

    stage('SonarQube Analysis') {
      steps {
        script {
          def mvnHome = tool 'Maven 3.9.9'
          withSonarQubeEnv('sonarqube') {
            sh "${mvnHome}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=SonarProject -Dsonar.projectName='SonarProject'"
          }
        }
      }
    }

    // Ici on ajoute la partie Docker
    stage('Docker Build') {
      steps {
        echo 'Building Docker Image...'
        script {
          // On suppose que ton pseudo Docker Hub = 'elkoura'
          // et ton repository = 'my-app'
          sh 'docker build -t elkoura/my-app:latest .'
        }
      }
    }

    stage('Docker Push') {
      steps {
        echo 'Pushing Docker Image to Registry...'
        script {
          withCredentials([usernamePassword(
            credentialsId: 'docker-hub-credentials', // L'ID configuré dans Jenkins
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASSWORD'
          )]) {
            // On se connecte au registre
            sh "docker login -u ${DOCKER_USER} -p ${DOCKER_PASSWORD}"
            // On push l'image
            sh 'docker push elkoura/my-app:latest'
            // Optionnel : se déloguer
            sh 'docker logout'
          }
        }
      }
    }

    // Optionnel : déployer le conteneur Docker localement
    stage('Deploy') {
      steps {
        echo 'Deploying Docker Container...'
        script {
          // Par exemple, lancer le conteneur sur la même machine Jenkins
          sh 'docker run -d -p 8080:8080 --name myApp elkoura/my-app:latest'
        }
      }
    }
  }
}