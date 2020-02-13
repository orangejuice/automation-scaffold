# A Jenkins Automation Startup

To run this project, simply run `./docker/buildAndRun.sh`

## Introduction

Thanks for these projects:
 - [Job DSL](https://github.com/jenkinsci/job-dsl-plugin)
 - [Job DSL Gradle example](https://github.com/sheehan/job-dsl-gradle-example)
 - [Configuration as code](https://github.com/jenkinsci/configuration-as-code-plugin)
 - [Jenkins Docker Repo](https://github.com/jenkinsci/docker)

In tools folder, there are some tools might be useful or can be used for learning perspective.

Example jobs are come from **Job DSL Gradle example**

## Update

Feb 13, 2020: remove updatePlugins.groovy from the auto run script scope.

Feb 11, 2020: first release

## File structure

    .
    ├── app
    │   ├── config
    │   │   └── ...             # jenkins congfig ymls
    │   ├── init.groovy.d
    │   │   └── ...             # jenkins initialization hook groovy scripts
    │   └── plugins.txt         # plugins to be auto installed
    ├── docker
    │   ├── buildAndRun.sh
    │   ├── clean.sh
    │   ├── docker-compose.yml
    │   └── Dockerfile
    ├── src
    │   ├── jobs                # DSL script files
    │   ├── main
    │   │   ├── groovy          # support classes
    │   │   └── resources
    │   │       └── idea.gdsl   # IDE support for IDEA
    │   ├── scripts             # scripts to use with "readFileFromWorkspace"
    │   └── test
    │       └── groovy          # specs
    └── build.gradle            # build file
