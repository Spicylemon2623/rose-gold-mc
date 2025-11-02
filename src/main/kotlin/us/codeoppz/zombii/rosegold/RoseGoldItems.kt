package us.codeoppz.zombii.rosegold

import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Item
import java.util.function.Function

object RoseGoldItems {

    fun registerItem(
        location: ResourceLocation,
        func: Function<Item.Properties, Item>
    ): Item? {
        val resourceKey = ResourceKey.create(
            Registries.ITEM,
            location
        )

        val roseGoldItemProperties = Item.Properties()
        roseGoldItemProperties.setId(resourceKey)

        return Registry.register(
            BuiltInRegistries.ITEM,
            resourceKey,
            func.apply(roseGoldItemProperties)
        )
    }

    fun registerItems() {
        registerItem(
            ResourceLocation.fromNamespaceAndPath(RoseGold.MOD_ID, "raw_rose_gold")
        ) {
            properties ->
            val item = Item(properties)
            item
        }
    }

}