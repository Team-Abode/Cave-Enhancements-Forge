package com.kekecreations.cave_enhancements.registry;

import com.kekecreations.cave_enhancements.CaveEnhancements;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, CaveEnhancements.MOD_ID);

    public static RegistryObject<SoundEvent> GLOW_PASTE_PLACE__ID = registerSoundEvent("block.glow_paste.place");


    // Goop Blocks
    public static RegistryObject<SoundEvent> BLOCK_GOOP_BLOCK_BREAK_ID = registerSoundEvent("block.goop_block.break");
    public static RegistryObject<SoundEvent> BLOCK_GOOP_BLOCK_STEP_ID = registerSoundEvent("block.goop_block.step");
    public static RegistryObject<SoundEvent> BLOCK_GOOP_BLOCK_HIT_ID = registerSoundEvent("block.goop_block.hit");
    public static RegistryObject<SoundEvent> BLOCK_GOOP_BLOCK_PLACE_ID = registerSoundEvent("block.goop_block.place");
    public static RegistryObject<SoundEvent> BLOCK_GOOP_BLOCK_FALL_ID = registerSoundEvent("block.goop_block.fall");

    // Goop Decoration Blocks
    public static RegistryObject<SoundEvent> BLOCK_GOOP_DECORATION_BREAK_ID = registerSoundEvent("block.goop_decoration.break");
    public static RegistryObject<SoundEvent> BLOCK_GOOP_DECORATION_STEP_ID = registerSoundEvent("block.goop_decoration.step");
    public static RegistryObject<SoundEvent> BLOCK_GOOP_DECORATION_HIT_ID = registerSoundEvent("block.goop_decoration.hit");
    public static RegistryObject<SoundEvent> BLOCK_GOOP_DECORATION_PLACE_ID = registerSoundEvent("block.goop_decoration.place");
    public static RegistryObject<SoundEvent> BLOCK_GOOP_DECORATION_FALL_ID = registerSoundEvent("block.goop_decoration.fall");

    // Goop Entity Sounds
    public static RegistryObject<SoundEvent> ENTITY_GOOP_DEATH_ID = registerSoundEvent("entity.goop.death");
    public static RegistryObject<SoundEvent> ENTITY_GOOP_HURT_ID = registerSoundEvent("entity.goop.hurt");

    // Dripstone Tortoise Entity Sounds
    public static RegistryObject<SoundEvent> ENTITY_DRIPSTONE_TORTOISE_HURT_ID = registerSoundEvent("entity.dripstone_tortoise.hurt");
    public static RegistryObject<SoundEvent> ENTITY_DRIPSTONE_TORTOISE_DEATH_ID = registerSoundEvent("entity.dripstone_tortoise.death");
    public static RegistryObject<SoundEvent> ENTITY_DRIPSTONE_TORTOISE_STEP_ID = registerSoundEvent("entity.dripstone_tortoise.step");
    public static RegistryObject<SoundEvent> ENTITY_DRIPSTONE_TORTOISE_IDLE_ID = registerSoundEvent("entity.dripstone_tortoise.idle");


    // Rose Quartz
    public static RegistryObject<SoundEvent> BLOCK_ROSE_QUARTZ_BREAK_ID = registerSoundEvent("block.rose_quartz.break");



    // Block Sounds
    public static final SoundType ROSE_QUARTZ  = new SoundType(1.0F, 1.0F, SoundEvents.GLASS_STEP, SoundEvents.GLASS_STEP, SoundEvents.CALCITE_PLACE, SoundEvents.GLASS_HIT, SoundEvents.GLASS_FALL);
    public static final ForgeSoundType GOOP_BLOCK = new ForgeSoundType(1.0F, 1.0F, BLOCK_GOOP_BLOCK_BREAK_ID, BLOCK_GOOP_BLOCK_STEP_ID, BLOCK_GOOP_BLOCK_PLACE_ID, BLOCK_GOOP_BLOCK_HIT_ID, BLOCK_GOOP_BLOCK_FALL_ID);
    public static final ForgeSoundType GOOP_DECORATION = new ForgeSoundType(1.0F, 1.0F, BLOCK_GOOP_DECORATION_BREAK_ID, BLOCK_GOOP_DECORATION_STEP_ID, BLOCK_GOOP_DECORATION_PLACE_ID, BLOCK_GOOP_DECORATION_HIT_ID, BLOCK_GOOP_DECORATION_FALL_ID);


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(CaveEnhancements.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}

