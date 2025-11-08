pipeline {
    agent any
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
