def call (String imagename , String tag) {
  sh "docker pull ${imagename}:${tag}"
}
