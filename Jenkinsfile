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
    stage('Deploy') {
      steps {
        echo 'Deploying....'
        sh 'mvn install'
      }
    }
  }
}