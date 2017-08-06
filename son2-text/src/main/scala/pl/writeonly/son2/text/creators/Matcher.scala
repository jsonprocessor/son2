package pl.writeonly.son2.text.creators

import org.apache.commons.text.translate.CharSequenceTranslator
import pl.writeonly.son2.core.config.TranslateConfig

trait Matcher {
  def translatorMatch(p: TranslateConfig): CharSequenceTranslator
}
