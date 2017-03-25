package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.databind.ObjectMapper

class Provider {

  def readTree (s:String ) = new ObjectMapper().readTree(s)

  def convert(s: String) = s

  def comment(s: String) = s
}
