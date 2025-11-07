pipeline {
    agent { label 'slave' }

    stages {

        stage('Git Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/mayurmwagh/student-ui.git'
            }
        }

       stage('build-stage') {
            steps {
               sh '/opt/maven/bin/mvn clean package'
             
            }
        }

        stage('Test Stage') {
            steps {
                echo "Test successful"
            }
        }

        // Uncomment below if you want to enable SonarQube Quality Gate check
        /*
        stage('Quality Gate') {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        */

        stage('Deploy') {
            steps {
                // Example deployment step
                // deploy adapters: [tomcat9(alternativeDeploymentContext: '', credentialsId: 'tomcat', path: '', url: 'http://13.53.158.116:8080')], contextPath: '/', war: '**/*.war'
                echo "Deploy successful"
            }
        }
    }
}
