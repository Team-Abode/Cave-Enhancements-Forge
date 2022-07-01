package com.kekecreations.cave_enhancements;

import com.kekecreations.cave_enhancements.entity.Cruncher;
import com.kekecreations.cave_enhancements.entity.DripstonePike;
import com.kekecreations.cave_enhancements.entity.DripstoneTortoise;
import com.kekecreations.cave_enhancements.entity.Goop;
import com.kekecreations.cave_enhancements.events.DispenseBehaviors;
import com.kekecreations.cave_enhancements.events.EntityEvents;
import com.kekecreations.cave_enhancements.registry.*;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CaveEnhancements.MOD_ID)
@Mod.EventBusSubscriber(modid = CaveEnhancements.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CaveEnhancements
{
    public static final String MOD_ID = "cave_enhancements";
    public static final Logger LOGGER = LogUtils.getLogger();



    public CaveEnhancements()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModItems.register(modEventBus);
        ModBannerPatterns.register(modEventBus);

        ModEntities.register(modEventBus);

        ModParticles.register(modEventBus);
        ModSounds.register(modEventBus);

        ModBiomes.register(modEventBus);
        ModBiomeModifiers.BIOME_MODIIFERS.register(modEventBus);

        ModEffects.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipes(Potions.AWKWARD, ModItems.GOOP.get(), Potions.SLOWNESS));
            DispenseBehaviors.init();
            ModSpawnPlacements.register();
        });
    }
    @SubscribeEvent
    public static void appendAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GOOP.get(), Goop.createGoopAttributes().build());
        event.put(ModEntities.DRIPSTONE_TORTOISE.get(), DripstoneTortoise.createDripstoneTortoiseAttributes().build());
        event.put(ModEntities.DRIPSTONE_PIKE.get(), DripstonePike.createDripstonePikeAttributes().build());
        event.put(ModEntities.CRUNCHER.get(), Cruncher.createCruncherAttributes().build());
    }
}
