def call (String dockerHUBCreds , String imagename , String tag) {
                withCredentials([usernamePassword(
                    credentialsId: dockerHUBCreds, 
                    usernameVariable: "U",
                    passwordVariable: "P"
                )]) {
                    sh "echo \"$P\" | docker login -u \"$U\" --password-stdin"
                    sh "docker image tag ${imagename}:${tag} ${U}/${imagename}:${tag}"
                    sh "docker push ${U}/${imagename}:${tag}"
                }
}
