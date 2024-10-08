def call(String ImageName, String ImageTag, String DockerHubUser){
  withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]){
    sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
  }
  sh "docker push ${DockerHubUser}/${ImageName}:${ImageTag}"
}
