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
    stage('create package') {
      steps {
        echo 'Packaging..'
        sh 'mvn package'
      }


      
    }
   
stage('SonarQube Analysis') {
      steps {
        script {
          def mvnHome = tool 'Maven 3.9.9' // Assuming Maven is configured in Jenkins
          withSonarQubeEnv('sonarqube') { // Use the 'SonarDocker' SonarQube server name from Jenkins
            sh "${mvnHome}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=SonarProject -Dsonar.projectName='SonarProject'"
            // -Dsonar.projectKey=SonarProject -Dsonar.projectName='SonarProject' must be the same as created from Sonarqube UI
          }
        }
      }
    }


    stage('Deploy') {
      steps {
        echo 'Deploying....'
        sh 'mvn install'
      }
    }
  }
}