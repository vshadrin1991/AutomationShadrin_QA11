pipeline {
    agent any
    tools {
       maven 'M3'
    }
    environment {
       TEST_XML = "${params.TEST}"
    }
    stages {
        stage('Test run') {
            steps {
                // Run Maven on a Unix agent.
                cmd 'mvn clean test -Dsuite="${env.TEST_XML}"'
            }
        }

        /* stage('Reports') {
            steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])}
               }
        } */
    }
}
