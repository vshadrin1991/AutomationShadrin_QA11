pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
       maven 'Maven 3.3.9'
       jdk 'jdk8'
    }

    environment {
        TEST_XML = "${params.TEST}"
    }

    stages {
        stage('Test run') {
            steps {
                // Run Maven on a Unix agent.
                bat 'mvn clean test -Dsuite="${env.TEST_XML}"'
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
