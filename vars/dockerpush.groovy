def call (String dockerHUBCreds , String imagename , String tag) {
                withCredentials([usernamePassword(
                    credentialsId: dockerHUBCreds, 
                    usernameVariable: "dockerHUBUser",
                    passwordVariable: "dockerHUBPass"
                )]) {
                    sh "echo $dockerHUBPass | docker login -u $dockerHUBUser --password-stdin"
                    sh "docker image tag ${imagename}:${tag} ${dockerHUBUser}/${imagename}:${tag}"
                    sh "docker push ${dockerHUBUser}/${imagename}:${tag}"
                }
}
