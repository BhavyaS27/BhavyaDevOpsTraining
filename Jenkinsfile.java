pipeline {
    agent any
    tools { 
            maven 'Maven3.6.3' 
    }
 
    stages {
        stage('Checkout') {
            steps {        
            checkout([$class: 'GitSCM', branches: [[name: 'main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/BhavyaS27/BhavyaDevOpsTraining.git']]])

 

             echo 'Checkout source code from git'
            }
        }
        stage('Quality Check') {
            steps {
                echo 'QA verified'
            }
        }
        stage('Security Check') {
            steps {
                echo 'All security checks done'
            }
        }
        stage('Build Push App') {
            steps {
               sh "mvn clean install"        
        }
        }    
        
         stage('Deploy') {
            steps {
                echo 'Deployment done'
            }
        }
         stage('Post Deployment Check') {
            steps {
                echo 'All deployment check done'
            }
        }
    }
}