[![Build Status](https://api.travis-ci.org/writeonly/scallions.svg?branch=master)](https://travis-ci.org/writeonly/scallions)
[![Codacy grade](https://img.shields.io/codacy/grade/e27821fb6289410b8f58338c7e0bc686.svg)](https://www.codacy.com/app/writeonly/scallions/dashboard)
[![Codecov](https://img.shields.io/codecov/c/github/writeonly/scallions.svg)](https://codecov.io/gh/writeonly/scallions)
[![GitHub issues](https://img.shields.io/github/issues/writeonly/scallions.svg)](https://github.com/writeonly/scallions/issues)
[![License][licenseImg]][licenseLink]
 
[licenseImg]: https://img.shields.io/github/license/writeonly/scallions.svg
[licenseImg2]: https://img.shields.io/:license-mit-blue.svg
[licenseLink]: LICENSE

* https://circleci.com/gh/writeonly/scallions

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
* ScalaCheck for property-based testing
* Jackson to convert json
* JsonPath to filtering json
* json-patch to patch json


## Build
```
cd ~
git clone https://github.com/writeonly/scallions.git
cd scallions
git submodule update --init --recursive
sbt clean scalafmt::test test:scalafmt::test it:scalafmt::test jacoco it:jacoco coverage test it:test assembly coverageReport && sbt coverageAggregate && sbt stats scalastyle
sbt clean compile assembly
```

### CLI
Add line to file ~/.bashrc
```
alias scallions="java -jar ~/scallions/scallions-clis/scallions-main/target/scala-2.12/scallions-main-assembly-2.8.11-SNAPSHOT.jar"
alias scallionso="scallions o"
alias scallionsy="scallions y"
alias scallionsx="scallions x"
alias scallionsp="scallions p"
```
## Usage

[usage](https://github.com/writeonly/scallions/tree/master/scallions-main/src/main/resources/README.md)

