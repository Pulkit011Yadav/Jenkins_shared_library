def call(String imageName, String imageTag, String contextPath = '.', String dockerfilePath = 'Dockerfile') {
    sh "docker build -t ${imageName}:${imageTag} -f ${dockerfilePath} ${contextPath}"
}
