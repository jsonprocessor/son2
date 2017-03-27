# Usage

son2 format input.son output.fmt

son2 format < input.son > output.fmt

cat input.son | son2 format | tee output.fmt

cat input.son | sed 's/^[^{]*//' | son2 format | tee output.fmt

format:
*  o, object => JSON
*  y, yaml => YAML
*  x, xml  => XML
