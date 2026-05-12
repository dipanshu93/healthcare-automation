pipeline {

    agent any

    tools {

        jdk 'JDK25'
        maven 'Maven3'
    }

    stages {

        stage('Checkout Code') {

            steps {

                git branch: 'main',
                    url: 'https://github.com/dipanshu93/healthcare-automation'
            }
        }

        stage('Build Project') {

            steps {

                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {

            steps {

                bat 'mvn test'
            }
        }
    }
}
