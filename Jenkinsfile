pipeline {
  agent any
  stages {
    stage('Compilar fuentes') {
      steps {
        sh `chmod +x mvnw`
        sh `./mvnw clean`
        sh `./mvnw package`
      }
    }

  }
}