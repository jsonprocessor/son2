[![Build Status](https://api.travis-ci.org/writeonly/son2.svg?branch=master)](https://travis-ci.org/writeonly/son2)
[![Codacy grade](https://img.shields.io/codacy/grade/e27821fb6289410b8f58338c7e0bc686.svg)](https://www.codacy.com/app/writeonly/son2/dashboard)
[![Codecov](https://img.shields.io/codecov/c/github/writeonly/son2.svg)](https://codecov.io/gh/writeonly/son2)
[![GitHub issues](https://img.shields.io/github/issues/writeonly/son2.svg)](https://github.com/writeonly/son2/issues)
[![License][licenseImg]][licenseLink]
 
[licenseImg]: https://img.shields.io/github/license/writeonly/son2.svg
[licenseImg2]: https://img.shields.io/:license-mit-blue.svg
[licenseLink]: LICENSE

* https://circleci.com/gh/writeonly/son2

# SON2

Stream Object Notation to:
* JSON
* YAML
* XML
* Properties
<!---
* CVS

-->

It is a simple application with: 
* ScalaTest for test
* ScalaMock for mock
* ScalaCheck for rroperty-based testing
* Vaadin for view
* Dropwizard for Rest
* Jackson to convert json
* JsonPath to filtering json
* json-patch to patch json


## Build
```
sbt clean compile assembly
```

### CLI
Add line to file ~/.bashrc
```
alias son2="java -jar son2-main/target/scala-2.12/son2-main-assembly-2.8.11-SNAPSHOT.jar
alias son2o="son2 o"
alias son2y="son2 y"
alias son2x="son2 x"
alias son2p="son2 p"
```
## Usage

[usage](https://github.com/writeonly/son2/tree/master/son2-main/src/main/resources/README.md)

