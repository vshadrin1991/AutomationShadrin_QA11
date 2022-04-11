pipeline {
    agent any

    tools {
        maven "MAVEN"
        jdk "JDK"
    }
    environment {
        SUITE = "src/test/resources/${params.Suite}.xml"
    }

    stages {
        stage('Build') {
            steps {
                //git branch: 'main', url: 'https://github.com/vshadrin1991/AutomationShadrin_QA11.git'
                bat 'mvn clean'
            }
        }
        stage('Test run') {
            steps {
                echo "---------------------------------------------Started ${env.SUITE}-----------------------------------------------------"
                bat 'mvn clean test -Dsuite=${env.SUITE}'
            }
        }
        /*stage('Reports') {
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
        }*/
    }
}
