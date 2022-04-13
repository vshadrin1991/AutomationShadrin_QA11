pipeline {
    agent any

    tools {
        maven "MAVEN"
        jdk "JDK"
        commandline '1.4.18'
    }
    environment {
        SUITE = "src/test/resources/${params.Suite}.xml"
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean'
            }
        }
        stage('Test run') {
            steps {
                echo "---------------------------------------------Started ${env.SUITE} -----------------------------------------------------"
                bat 'mvn test -Dsuite=${env.SUITE}'
            }
        }
        stage('Reports') {
            steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}
