def buildApp()
{
    echo 'Building the application.'
    echo "Building the version : ${params.NEW_VERSION}" // Here we need to use params. Unless it won't work.
}

def runTest()
{
    echo "All the test were run."
}

def Artifact_uploadTest()
{
    echo "Artifact upload completed."
}

def SonarApp()
{
    echo "Scanning completed."
}

def deployApp()
{
    echo "Deploying the application with version ${params.VERSION}"
}


return this 

