pipeline {
    agent any
        tools {
           maven "MAVEN"
           jdk "JDK"
        }
        environment {
           TEST_XML = "src/test/resources/${params.TEST}"
        }
        stages {
            stage('Initialize'){
                   steps{
                       echo "PATH = ${M2_HOME}/bin:${PATH}"
                       echo "M2_HOME = /opt/maven"
                   }
            }
            stage('Test run') {
                    steps {
                    // Run Maven on a Unix agent.
                        bat 'echo "Hello"'
                        bat 'mvn -version'
                        bat 'mvn clean test -Dsuite="${env.TEST_XML}"'
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
                        ])}
               }
            }
        }
}
