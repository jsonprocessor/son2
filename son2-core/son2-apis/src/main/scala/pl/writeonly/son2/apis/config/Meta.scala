package pl.writeonly.son2.apis.config

abstract class Meta(val providerType: ProviderType, val format: Format)

case class MetaImpl(override val providerType: ProviderType,
                    override val format: Format)
    extends Meta(providerType, format)
