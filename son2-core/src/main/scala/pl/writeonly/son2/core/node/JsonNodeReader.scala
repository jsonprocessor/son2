package pl.writeonly.son2.core

import com.fasterxml.jackson.databind.ObjectMapper

class JsonNodeReader(val mapper: ObjectMapper) {
     def readTree(content: String) =  mapper.readTree(content);
}
