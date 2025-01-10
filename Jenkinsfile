pipeline {
  agent any
  stages {
    stage('initialize') {
      steps {
        git 'https://github.com/elkoura/diginamic-jenkins-project.git'
        
    }
      
    }
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