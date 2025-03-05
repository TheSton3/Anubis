package com.thestone.anubis.main;

import com.thestone.anubis.Anubis;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ANUBIS_SPAWN_EGG = registerItem("anubis_spawn_egg",
            new SpawnEggItem(ModEntities.ANUBIS_ENTITY, 0xffd300, 0xc2b280,
                    new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Anubis.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addItemsToItemGroup(ANUBIS_SPAWN_EGG);
    }

    private static void addItemsToItemGroup(Item item) {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        Anubis.LOGGER.info("Registering Mod Items for " + Anubis.MOD_ID);

        addItemsToItemGroup();
    }
}
