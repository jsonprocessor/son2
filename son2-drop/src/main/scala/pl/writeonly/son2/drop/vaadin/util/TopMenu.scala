package pl.writeonly.son2.drop.vaadin.util

import com.vaadin.ui.{Link, Panel}

class TopMenu extends UIUtil {

  def linkPanel: Panel = horizontalPanelEx("Top Menu",
    mainLink,
    jacksonConverter,
    jsonComparatorLink,
    jsonDiffLink,
    jsonFormatterLink,
    jsonPatchLink,
    jsonPathLink)

  def mainLink: Link = link("Main Side", "/ui");

  def jacksonConverter: Link = link("Jackson Converter", "/ui/converter");

  def jsonComparatorLink: Link = link("Json Comparator", "/ui/comparator");

  def jsonDiffLink: Link = link("Json Diff", "/ui/diff");

  def jsonFormatterLink: Link = link("Json Formatter", "/ui/formatter");

  def jsonPatchLink: Link = link("Json Patch", "/ui/patch");

  def jsonPathLink: Link = link("Json Path", "/ui/path");

}
