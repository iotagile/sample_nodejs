job('NodeJS Job') {
    scm {
        git('https://github.com/msekibe/sample_nodejs.git') {  node ->
            node / gitConfigName('DSL User')
            node / gitConfigEmail('msekibe@ysk.co.jp')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs_v11')
    }
    steps {
        shell("npm install")
        shell("npm test")
    }
}
