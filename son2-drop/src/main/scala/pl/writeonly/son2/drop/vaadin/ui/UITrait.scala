package pl.writeonly.son2.drop.vaadin.ui

import com.vaadin.server.ExternalResource
import com.vaadin.ui.{Link, UI}

trait UITrait extends UI {
  def link(caption: String, sourceURL : String) = new Link(caption, new ExternalResource(sourceURL));

  def linkToBack = new Link("back", new ExternalResource(""));

  def inputJson = "Input Json"

}
