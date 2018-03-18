# Usage

son2 format input.son output.fmt

son2 format input.son | tee output.fmt

son2 format < input.son > output.fmt

cat input.son | son2 format | tee output.fmt

cat input.son | sed 's/^[^{]*//' | son2 format | tee output.fmt

cat input.log | son2 $.log | sed 's/^"//' | sed 's/\\n"$//' | son2 u_s | tee output.fmt


## Formats
* o, object => output is pretty JSON
* y, yaml => output is YAML
* x, xml  => output is pretty XML
* j, p => output is java properties 
* $(query) => output is raw, filtered JSON, (query) is json-path query

## Examples

son2 o input.son

son2 y input.son output.yaml

son2 $.* input.son | son2 p
