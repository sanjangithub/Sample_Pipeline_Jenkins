pipeline {
    agent any
    
    environment {
        BRANCH_NAME = 'dev'
        NEW_VERSION = '1.2.0'
        SERVER_CREDENTIALS = credentials('test')
    }
    
    parameters {
        // string(name: 'VERSION',defaultValue: "", description: 'version to deploy on pord.') // One type to declare parameters.
        choice(name: 'VERSION', choices: [1.0.0, 1.1.0, 1.2.0], description : 'version to deploy on pord.')
        booleanParam(name: 'executeTest', defaultValue=true, description : '')
    }
    stages {
        stage("checkout") {
            steps {
                echo "Code checkout done."
            }
        }
        stage("Code_Build") {
            steps {
                script 
                {
                    groovy.buildApp()
                }
            }
        }
        stage("Test") {
            when { 
                expression { 
                    // env.BRANCH_NAME == 'dev' || env.BRANCH_NAME == 'master'
                    params.executeTest == true
                } 
            }
            steps 
            {
                script 
                {
                    groovy.runTest()
                }
            }
        }
        stage("Sonar-Scan") {
            steps {
                script 
                {
                    groovy.SonarApp()
                }
            }
        }
        stage("Nexus-Artifact_upload") {
            steps {
                script 
                {
                    groovy.Artifact_uploadTest()
                }
            }
        }
        stage ("Deploy") {
            
            steps {
                script 
                {
                    groovy.deployApp()
                }
            }
        }
    }
}
