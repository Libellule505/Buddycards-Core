package com.wildcard.buddycards.registries;

import com.wildcard.buddycards.Buddycards;
import com.wildcard.buddycards.block.BuddycardBoosterBoxBlock;
import com.wildcard.buddycards.block.CardDisplayBlock;
import com.wildcard.buddycards.block.KineticChamberBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BuddycardsBlocks {
    public static final List<Supplier<CardDisplayBlock>> DISPLAY_BLOCKS = new ArrayList<>();

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Buddycards.MOD_ID);

    public static void registerBlocks() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final BlockBehaviour.Properties BOOSTER_BOX_PROPERTIES = BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_GRAY).strength(0.8F).sound(SoundType.WOOL);
    static BlockBehaviour.Properties BUDDYSTEEL_PROPERTIES = BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_BLUE).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL);
    static BlockBehaviour.Properties LUMINIS_PROPERTIES = BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD).requiresCorrectToolForDrops().lightLevel((i) -> 12).noOcclusion().strength(3.0F, 6.0F).sound(SoundType.COPPER);
    static BlockBehaviour.Properties CRYSTAL_LUMINIS_PROPERTIES = BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD).requiresCorrectToolForDrops().lightLevel((i) -> 8).noOcclusion().strength(1.5F, 3.0F).sound(SoundType.AMETHYST);
    static BlockBehaviour.Properties CRIMSON_LUMINIS_PROPERTIES = BlockBehaviour.Properties.of(Material.METAL, MaterialColor.CRIMSON_NYLIUM).requiresCorrectToolForDrops().lightLevel((i) -> 8).noOcclusion().strength(3.0F, 6.0F).sound(SoundType.COPPER);
    static BlockBehaviour.Properties ZYLEX_PROPERTIES = BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PURPLE).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL);

    //Basic Blocks
    public static final RegistryObject<Block> BUDDYSTEEL_BLOCK = BLOCKS.register("buddysteel_block", () -> new Block(BUDDYSTEEL_PROPERTIES));
    public static final RegistryObject<Block> LUMINIS_ORE = BLOCKS.register("luminis_ore", () -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> DEEPSLATE_LUMINIS_ORE = BLOCKS.register("deepslate_luminis_ore", () -> new OreBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_GOLD_ORE), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> LUMINIS_CRYSTAL_BLOCK = BLOCKS.register("luminis_crystal_block", () -> new Block(CRYSTAL_LUMINIS_PROPERTIES));
    public static final RegistryObject<Block> LUMINIS_BLOCK = BLOCKS.register("luminis_block", () -> new Block(LUMINIS_PROPERTIES));
    public static final RegistryObject<Block> CRIMSON_LUMINIS_BLOCK = BLOCKS.register("crimson_luminis_block", () -> new Block(CRIMSON_LUMINIS_PROPERTIES));
    public static final RegistryObject<Block> KINETIC_CHAMBER = BLOCKS.register("kinetic_chamber", () -> new KineticChamberBlock(CRIMSON_LUMINIS_PROPERTIES));
    public static final RegistryObject<Block> LUMINIS_PANELS = BLOCKS.register("luminis_panels", () -> new Block(LUMINIS_PROPERTIES));
    public static final RegistryObject<Block> ZYLEX_BLOCK = BLOCKS.register("zylex_block", () -> new Block(ZYLEX_PROPERTIES));
    //Displays
    public static final RegistryObject<CardDisplayBlock> OAK_CARD_DISPLAY = registerDisplay("oak_card_display", () -> new CardDisplayBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<CardDisplayBlock> SPRUCE_CARD_DISPLAY = registerDisplay("spruce_card_display", () -> new CardDisplayBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<CardDisplayBlock> BIRCH_CARD_DISPLAY = registerDisplay("birch_card_display", () -> new CardDisplayBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistryObject<CardDisplayBlock> JUNGLE_CARD_DISPLAY = registerDisplay("jungle_card_display", () -> new CardDisplayBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final RegistryObject<CardDisplayBlock> ACACIA_CARD_DISPLAY = registerDisplay("acacia_card_display", () -> new CardDisplayBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final RegistryObject<CardDisplayBlock> DARK_OAK_CARD_DISPLAY = registerDisplay("dark_oak_card_display", () -> new CardDisplayBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryObject<CardDisplayBlock> CRIMSON_CARD_DISPLAY = registerDisplay("crimson_card_display", () -> new CardDisplayBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistryObject<CardDisplayBlock> WARPED_CARD_DISPLAY = registerDisplay("warped_card_display", () -> new CardDisplayBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)));
    //Booster Boxes
    public static final RegistryObject<Block> BOOSTER_BOX_BASE = BuddycardsBlocks.BLOCKS.register("buddycard_booster_box_base", () -> new BuddycardBoosterBoxBlock(BuddycardsItems.DEFAULT_BUDDYCARD_REQUIREMENT, BuddycardsBlocks.BOOSTER_BOX_PROPERTIES));
    public static final RegistryObject<Block> BOOSTER_BOX_NETHER = BuddycardsBlocks.BLOCKS.register("buddycard_booster_box_nether", () -> new BuddycardBoosterBoxBlock(BuddycardsItems.DEFAULT_BUDDYCARD_REQUIREMENT, BuddycardsBlocks.BOOSTER_BOX_PROPERTIES));
    public static final RegistryObject<Block> BOOSTER_BOX_END = BuddycardsBlocks.BLOCKS.register("buddycard_booster_box_end", () -> new BuddycardBoosterBoxBlock(BuddycardsItems.DEFAULT_BUDDYCARD_REQUIREMENT, BuddycardsBlocks.BOOSTER_BOX_PROPERTIES));
    public static final RegistryObject<Block> BOOSTER_BOX_MYSTERY = BuddycardsBlocks.BLOCKS.register("buddycard_booster_box_mystery", () -> new BuddycardBoosterBoxBlock(BuddycardsItems.DEFAULT_BUDDYCARD_REQUIREMENT, BuddycardsBlocks.BOOSTER_BOX_PROPERTIES));

    public static RegistryObject<CardDisplayBlock> registerDisplay(String id, Supplier<CardDisplayBlock> supplier) {
        RegistryObject<CardDisplayBlock> display = BLOCKS.register(id, supplier);
        DISPLAY_BLOCKS.add(display);
        return display;
    }
}
