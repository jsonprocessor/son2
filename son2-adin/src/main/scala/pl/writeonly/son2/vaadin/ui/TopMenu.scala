package pl.writeonly.son2.vaadin.ui

import com.vaadin.ui.{Link, Panel}
import pl.writeonly.son2.vaadin.util.UIUtil

class TopMenu extends UIUtil {

  def mainLink: Link = link("Main Side", "/ui");

  def jacksonConverter: Link = link("Jackson Converter", "/ui/converter");

  def jsonComparatorLink: Link = link("Json Comparator", "/ui/comparator");

  def jsonDiffLink: Link = link("Json Diff", "/ui/diff");

  def jsonFormatterLink: Link = link("Json Formatter", "/ui/formatter");

  def jsonPatchLink: Link = link("Json Patch", "/ui/patch");

  def jsonPathLink: Link = link("Json Path", "/ui/path");

  def linkPanel: Panel = horizontalPanelEx(
    "Top Menu",
    mainLink,
    jacksonConverter,
    jsonComparatorLink,
    jsonDiffLink,
    jsonFormatterLink,
    jsonPatchLink,
    jsonPathLink)

}

object TopMenu extends UIUtil

