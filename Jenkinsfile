pipeline {
  agent any
  stages {
    stage('Compilar fuentes') {
      steps {
        sh '''chmod +x mvnw
./mvnw clean
./mvnw compile'''
      }
    }

  }
}