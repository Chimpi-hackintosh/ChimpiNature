package br.com.chimpi.nature;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class ChimpiNature implements ModInitializer {
    public static final String MOD_ID = "chimpinature";

    public static final Item SANDWICH = register("sandwich",
            new FoodComponent.Builder().hunger(8).saturationModifier(0.65f).build());
    public static final Item FRUIT_SALAD = register("fruit_salad",
            new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build());
    public static final Item HONEY_TOAST = register("honey_toast",
            new FoodComponent.Builder().hunger(5).saturationModifier(0.7f).build());

    private static Item register(String name, FoodComponent food) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, name),
                new Item(new FabricItemSettings().food(food)));
    }

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(SANDWICH);
            entries.add(FRUIT_SALAD);
            entries.add(HONEY_TOAST);
        });
    }
}
