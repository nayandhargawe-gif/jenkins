pipeline {
    agent {label 'slave'}
    stages {
        stage('git_checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/mayurmwagh/student-ui.git'
            }
        }
        stage('build-stage') {
            steps {
               sh '/opt/maven/bin/mvn clean package'
             
            }
        }
        stage('test-stage') {
            steps {
           echo "test successfull"
        }
        //   stage('Quality-gate') {
        //     steps {
        //         timeout(10) {
               
        //     }
        //         waitForQualityGate true
        //     }
        // }

      
        stage('Deploy') {
            steps {
                // deploy adapters: [tomcat9(alternativeDeploymentContext: '', credentialsId: 'tomcat', path: '', url: 'http://13.53.158.116:8080')], contextPath: '/', war: '**/*.war'
                echo "deploy successfull"
            }
        }
    }
}
