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

> alias son2="java -jar project_dir/son2/son2core/target/son2-core-2.8.3-SNAPSHOT.jar"
> alias son2y="son2 y"
> alias son2x="son2 x"

to file ~/.bachrc

## Usage

son2 format [input] [output]

format:
*  y, yaml => YAML
*  x, xml  => XML

