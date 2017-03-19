# SON2

Stream Object Notation to
* YAML
* XML
<!---
* CVS
* Properties
-->

## Build
mvn clean install

and next add line

> alias son2="java -jar <dir>/son2/son2core/target/son2-core-2.8.3-SNAPSHOT.jar"

to file ~/.bachrc

## Usage

son2 format [input] [output]

format
* y => YAML
* x => XML

