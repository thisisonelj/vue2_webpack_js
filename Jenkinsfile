pipeline {
    agent {
      node {
          label '多分支流水线'
      }
    }
    stages {
      stage("测试部署") {
            when {
                branch 'dev'
            }
          steps {
                echo 'dev branch'
          }
      }
    }
}
