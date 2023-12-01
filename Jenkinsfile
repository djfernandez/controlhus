pipeline {
  agent any
  stages {
    stage('Conectar a Git') {
      steps {
        git(url: 'https://github.com/djfernandez/controlhus', branch: 'master')
      }
    }

  }
}