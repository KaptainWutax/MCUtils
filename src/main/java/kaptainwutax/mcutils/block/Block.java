package kaptainwutax.mcutils.block;

import kaptainwutax.mcutils.util.data.Identifier;
import kaptainwutax.mcutils.version.MCVersion;
import kaptainwutax.mcutils.version.VersionMap;

import java.util.HashMap;
import java.util.Map;

public class Block {

    public static final VersionMap<Map<Integer, Block>> VERSIONED_REGISTRY = new VersionMap<Map<Integer, Block>>().add(MCVersion.latest(), new HashMap<>());
    public static final Map<Integer, Block> LATEST_REGISTRY = VERSIONED_REGISTRY.getLatest();

    public static final VersionMap<Map<Identifier, Block>> VERSIONED_ID_REGISTRY = new VersionMap<Map<Identifier, Block>>().add(MCVersion.latest(), new HashMap<>());
    public static final Map<Identifier, Block> LATEST_ID_REGISTRY = VERSIONED_ID_REGISTRY.getLatest();

    private final int id;
    private final Identifier name;
    private final int meta;

    public Block(int id, String name) {
        this(id, name, 0);
    }
    
    public Block(int id, String name, int meta) {
        this.id = id;
        this.name = new Identifier(name);
        this.meta = meta;
    }

    public int getId() {
        return this.id;
    }

    public Identifier getIdentifier() {
        return this.name;
    }

    public String getRegistryName() {
        return this.name.toString();
    }

    public String getName() {
        return this.name.getPath();
    }

    public int getMeta() {
        return this.meta;
    }

    @Override
    public int hashCode() {
        return this.getRegistryName().hashCode() * 31 + this.meta;
    }

    @Override
    public String toString() {
        return this.getRegistryName();
    }

    private static VersionMap<Block> register(VersionMap<Block> versionMap) {
        for(MCVersion v = versionMap.getOldestVersion(); v != null; v = v.newer()) {
            Block block = versionMap.getAsOf(v);
            VERSIONED_REGISTRY.computeIfAbsent(v, i -> new HashMap<>()).put(block.getId(), block);
            VERSIONED_ID_REGISTRY.computeIfAbsent(v, i -> new HashMap<>()).put(block.getIdentifier(), block);
        }

        return versionMap;
    }
    
    public static final VersionMap<Block> AIR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(0, "air")));

    public static final VersionMap<Block> STONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(1, "stone")));

    public static final VersionMap<Block> GRANITE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(2, "granite")));

    public static final VersionMap<Block> POLISHED_GRANITE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(3, "polished_granite")));

    public static final VersionMap<Block> DIORITE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(4, "diorite")));

    public static final VersionMap<Block> POLISHED_DIORITE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(5, "polished_diorite")));

    public static final VersionMap<Block> ANDESITE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(6, "andesite")));

    public static final VersionMap<Block> POLISHED_ANDESITE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(7, "polished_andesite")));

    public static final VersionMap<Block> GRASS_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(8, "grass_block")));

    public static final VersionMap<Block> DIRT_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(9, "dirt")));

    public static final VersionMap<Block> COARSE_DIRT_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(10, "coarse_dirt")));

    public static final VersionMap<Block> PODZOL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(11, "podzol")));

    public static final VersionMap<Block> COBBLESTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(12, "cobblestone")));

    public static final VersionMap<Block> OAK_PLANKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(13, "oak_planks")));

    public static final VersionMap<Block> SPRUCE_PLANKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(14, "spruce_planks")));

    public static final VersionMap<Block> BIRCH_PLANKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(15, "birch_planks")));

    public static final VersionMap<Block> JUNGLE_PLANKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(16, "jungle_planks")));

    public static final VersionMap<Block> ACACIA_PLANKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(17, "acacia_planks")));

    public static final VersionMap<Block> DARK_OAK_PLANKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(18, "dark_oak_planks")));

    public static final VersionMap<Block> OAK_SAPLING_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(19, "oak_sapling")));

    public static final VersionMap<Block> SPRUCE_SAPLING_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(20, "spruce_sapling")));

    public static final VersionMap<Block> BIRCH_SAPLING_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(21, "birch_sapling")));

    public static final VersionMap<Block> JUNGLE_SAPLING_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(22, "jungle_sapling")));

    public static final VersionMap<Block> ACACIA_SAPLING_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(23, "acacia_sapling")));

    public static final VersionMap<Block> DARK_OAK_SAPLING_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(24, "dark_oak_sapling")));

    public static final VersionMap<Block> BEDROCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(25, "bedrock")));

    public static final VersionMap<Block> WATER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(26, "water")));

    public static final VersionMap<Block> LAVA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(27, "lava")));

    public static final VersionMap<Block> SAND_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(28, "sand")));

    public static final VersionMap<Block> RED_SAND_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(29, "red_sand")));

    public static final VersionMap<Block> GRAVEL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(30, "gravel")));

    public static final VersionMap<Block> GOLD_ORE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(31, "gold_ore")));

    public static final VersionMap<Block> IRON_ORE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(32, "iron_ore")));

    public static final VersionMap<Block> COAL_ORE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(33, "coal_ore")));

    public static final VersionMap<Block> NETHER_GOLD_ORE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(34, "nether_gold_ore")));

    public static final VersionMap<Block> OAK_LOG_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(35, "oak_log")));

    public static final VersionMap<Block> SPRUCE_LOG_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(36, "spruce_log")));

    public static final VersionMap<Block> BIRCH_LOG_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(37, "birch_log")));

    public static final VersionMap<Block> JUNGLE_LOG_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(38, "jungle_log")));

    public static final VersionMap<Block> ACACIA_LOG_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(39, "acacia_log")));

    public static final VersionMap<Block> DARK_OAK_LOG_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(40, "dark_oak_log")));

    public static final VersionMap<Block> STRIPPED_SPRUCE_LOG_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(41, "stripped_spruce_log")));

    public static final VersionMap<Block> STRIPPED_BIRCH_LOG_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(42, "stripped_birch_log")));

    public static final VersionMap<Block> STRIPPED_JUNGLE_LOG_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(43, "stripped_jungle_log")));

    public static final VersionMap<Block> STRIPPED_ACACIA_LOG_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(44, "stripped_acacia_log")));

    public static final VersionMap<Block> STRIPPED_DARK_OAK_LOG_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(45, "stripped_dark_oak_log")));

    public static final VersionMap<Block> STRIPPED_OAK_LOG_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(46, "stripped_oak_log")));

    public static final VersionMap<Block> OAK_WOOD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(47, "oak_wood")));

    public static final VersionMap<Block> SPRUCE_WOOD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(48, "spruce_wood")));

    public static final VersionMap<Block> BIRCH_WOOD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(49, "birch_wood")));

    public static final VersionMap<Block> JUNGLE_WOOD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(50, "jungle_wood")));

    public static final VersionMap<Block> ACACIA_WOOD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(51, "acacia_wood")));

    public static final VersionMap<Block> DARK_OAK_WOOD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(52, "dark_oak_wood")));

    public static final VersionMap<Block> STRIPPED_OAK_WOOD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(53, "stripped_oak_wood")));

    public static final VersionMap<Block> STRIPPED_SPRUCE_WOOD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(54, "stripped_spruce_wood")));

    public static final VersionMap<Block> STRIPPED_BIRCH_WOOD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(55, "stripped_birch_wood")));

    public static final VersionMap<Block> STRIPPED_JUNGLE_WOOD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(56, "stripped_jungle_wood")));

    public static final VersionMap<Block> STRIPPED_ACACIA_WOOD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(57, "stripped_acacia_wood")));

    public static final VersionMap<Block> STRIPPED_DARK_OAK_WOOD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(58, "stripped_dark_oak_wood")));

    public static final VersionMap<Block> OAK_LEAVES_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(59, "oak_leaves")));

    public static final VersionMap<Block> SPRUCE_LEAVES_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(60, "spruce_leaves")));

    public static final VersionMap<Block> BIRCH_LEAVES_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(61, "birch_leaves")));

    public static final VersionMap<Block> JUNGLE_LEAVES_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(62, "jungle_leaves")));

    public static final VersionMap<Block> ACACIA_LEAVES_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(63, "acacia_leaves")));

    public static final VersionMap<Block> DARK_OAK_LEAVES_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(64, "dark_oak_leaves")));

    public static final VersionMap<Block> SPONGE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(65, "sponge")));

    public static final VersionMap<Block> WET_SPONGE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(66, "wet_sponge")));

    public static final VersionMap<Block> GLASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(67, "glass")));

    public static final VersionMap<Block> LAPIS_ORE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(68, "lapis_ore")));

    public static final VersionMap<Block> LAPIS_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(69, "lapis_block")));

    public static final VersionMap<Block> DISPENSER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(70, "dispenser")));

    public static final VersionMap<Block> SANDSTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(71, "sandstone")));

    public static final VersionMap<Block> CHISELED_SANDSTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(72, "chiseled_sandstone")));

    public static final VersionMap<Block> CUT_SANDSTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(73, "cut_sandstone")));

    public static final VersionMap<Block> NOTE_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(74, "note_block")));

    public static final VersionMap<Block> WHITE_BED_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(75, "white_bed")));

    public static final VersionMap<Block> ORANGE_BED_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(76, "orange_bed")));

    public static final VersionMap<Block> MAGENTA_BED_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(77, "magenta_bed")));

    public static final VersionMap<Block> LIGHT_BLUE_BED_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(78, "light_blue_bed")));

    public static final VersionMap<Block> YELLOW_BED_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(79, "yellow_bed")));

    public static final VersionMap<Block> LIME_BED_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(80, "lime_bed")));

    public static final VersionMap<Block> PINK_BED_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(81, "pink_bed")));

    public static final VersionMap<Block> GRAY_BED_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(82, "gray_bed")));

    public static final VersionMap<Block> LIGHT_GRAY_BED_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(83, "light_gray_bed")));

    public static final VersionMap<Block> CYAN_BED_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(84, "cyan_bed")));

    public static final VersionMap<Block> PURPLE_BED_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(85, "purple_bed")));

    public static final VersionMap<Block> BLUE_BED_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(86, "blue_bed")));

    public static final VersionMap<Block> BROWN_BED_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(87, "brown_bed")));

    public static final VersionMap<Block> GREEN_BED_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(88, "green_bed")));

    public static final VersionMap<Block> RED_BED_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(89, "red_bed")));

    public static final VersionMap<Block> BLACK_BED_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(90, "black_bed")));

    public static final VersionMap<Block> POWERED_RAIL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(91, "powered_rail")));

    public static final VersionMap<Block> DETECTOR_RAIL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(92, "detector_rail")));

    public static final VersionMap<Block> STICKY_PISTON_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(93, "sticky_piston")));

    public static final VersionMap<Block> COBWEB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(94, "cobweb")));

    public static final VersionMap<Block> GRASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(95, "grass")));

    public static final VersionMap<Block> FERN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(96, "fern")));

    public static final VersionMap<Block> DEAD_BUSH_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(97, "dead_bush")));

    public static final VersionMap<Block> SEAGRASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(98, "seagrass")));

    public static final VersionMap<Block> TALL_SEAGRASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(99, "tall_seagrass")));

    public static final VersionMap<Block> PISTON_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(100, "piston")));

    public static final VersionMap<Block> PISTON_HEAD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(101, "piston_head")));

    public static final VersionMap<Block> WHITE_WOOL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(102, "white_wool")));

    public static final VersionMap<Block> ORANGE_WOOL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(103, "orange_wool")));

    public static final VersionMap<Block> MAGENTA_WOOL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(104, "magenta_wool")));

    public static final VersionMap<Block> LIGHT_BLUE_WOOL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(105, "light_blue_wool")));

    public static final VersionMap<Block> YELLOW_WOOL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(106, "yellow_wool")));

    public static final VersionMap<Block> LIME_WOOL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(107, "lime_wool")));

    public static final VersionMap<Block> PINK_WOOL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(108, "pink_wool")));

    public static final VersionMap<Block> GRAY_WOOL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(109, "gray_wool")));

    public static final VersionMap<Block> LIGHT_GRAY_WOOL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(110, "light_gray_wool")));

    public static final VersionMap<Block> CYAN_WOOL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(111, "cyan_wool")));

    public static final VersionMap<Block> PURPLE_WOOL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(112, "purple_wool")));

    public static final VersionMap<Block> BLUE_WOOL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(113, "blue_wool")));

    public static final VersionMap<Block> BROWN_WOOL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(114, "brown_wool")));

    public static final VersionMap<Block> GREEN_WOOL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(115, "green_wool")));

    public static final VersionMap<Block> RED_WOOL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(116, "red_wool")));

    public static final VersionMap<Block> BLACK_WOOL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(117, "black_wool")));

    public static final VersionMap<Block> MOVING_PISTON_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(118, "moving_piston")));

    public static final VersionMap<Block> DANDELION_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(119, "dandelion")));

    public static final VersionMap<Block> POPPY_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(120, "poppy")));

    public static final VersionMap<Block> BLUE_ORCHID_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(121, "blue_orchid")));

    public static final VersionMap<Block> ALLIUM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(122, "allium")));

    public static final VersionMap<Block> AZURE_BLUET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(123, "azure_bluet")));

    public static final VersionMap<Block> RED_TULIP_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(124, "red_tulip")));

    public static final VersionMap<Block> ORANGE_TULIP_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(125, "orange_tulip")));

    public static final VersionMap<Block> WHITE_TULIP_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(126, "white_tulip")));

    public static final VersionMap<Block> PINK_TULIP_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(127, "pink_tulip")));

    public static final VersionMap<Block> OXEYE_DAISY_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(128, "oxeye_daisy")));

    public static final VersionMap<Block> CORNFLOWER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(129, "cornflower")));

    public static final VersionMap<Block> WITHER_ROSE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(130, "wither_rose")));

    public static final VersionMap<Block> LILY_OF_THE_VALLEY_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(131, "lily_of_the_valley")));

    public static final VersionMap<Block> BROWN_MUSHROOM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(132, "brown_mushroom")));

    public static final VersionMap<Block> RED_MUSHROOM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(133, "red_mushroom")));

    public static final VersionMap<Block> GOLD_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(134, "gold_block")));

    public static final VersionMap<Block> IRON_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(135, "iron_block")));

    public static final VersionMap<Block> BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(136, "bricks")));

    public static final VersionMap<Block> TNT_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(137, "tnt")));

    public static final VersionMap<Block> BOOKSHELF_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(138, "bookshelf")));

    public static final VersionMap<Block> MOSSY_COBBLESTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(139, "mossy_cobblestone")));

    public static final VersionMap<Block> OBSIDIAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(140, "obsidian")));

    public static final VersionMap<Block> TORCH_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(141, "torch")));

    public static final VersionMap<Block> WALL_TORCH_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(142, "wall_torch")));

    public static final VersionMap<Block> FIRE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(143, "fire")));

    public static final VersionMap<Block> SOUL_FIRE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(144, "soul_fire")));

    public static final VersionMap<Block> SPAWNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(145, "spawner")));

    public static final VersionMap<Block> OAK_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(146, "oak_stairs")));

    public static final VersionMap<Block> CHEST_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(147, "chest")));

    public static final VersionMap<Block> REDSTONE_WIRE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(148, "redstone_wire")));

    public static final VersionMap<Block> DIAMOND_ORE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(149, "diamond_ore")));

    public static final VersionMap<Block> DIAMOND_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(150, "diamond_block")));

    public static final VersionMap<Block> CRAFTING_TABLE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(151, "crafting_table")));

    public static final VersionMap<Block> WHEAT_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(152, "wheat")));

    public static final VersionMap<Block> FARMLAND_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(153, "farmland")));

    public static final VersionMap<Block> FURNACE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(154, "furnace")));

    public static final VersionMap<Block> OAK_SIGN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(155, "sign"))
            .add(MCVersion.v1_14, new Block(155, "oak_sign")));

    public static final VersionMap<Block> SPRUCE_SIGN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(156, "spruce_sign")));

    public static final VersionMap<Block> BIRCH_SIGN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(157, "birch_sign")));

    public static final VersionMap<Block> ACACIA_SIGN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(158, "acacia_sign")));

    public static final VersionMap<Block> JUNGLE_SIGN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(159, "jungle_sign")));

    public static final VersionMap<Block> DARK_OAK_SIGN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(160, "dark_oak_sign")));

    public static final VersionMap<Block> OAK_DOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(161, "oak_door")));

    public static final VersionMap<Block> LADDER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(162, "ladder")));

    public static final VersionMap<Block> RAIL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(163, "rail")));

    public static final VersionMap<Block> COBBLESTONE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(164, "cobblestone_stairs")));

    public static final VersionMap<Block> OAK_WALL_SIGN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(165, "wall_sign"))
            .add(MCVersion.v1_14, new Block(165, "oak_wall_sign")));

    public static final VersionMap<Block> SPRUCE_WALL_SIGN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(166, "spruce_wall_sign")));

    public static final VersionMap<Block> BIRCH_WALL_SIGN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(167, "birch_wall_sign")));

    public static final VersionMap<Block> ACACIA_WALL_SIGN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(168, "acacia_wall_sign")));

    public static final VersionMap<Block> JUNGLE_WALL_SIGN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(169, "jungle_wall_sign")));

    public static final VersionMap<Block> DARK_OAK_WALL_SIGN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(170, "dark_oak_wall_sign")));

    public static final VersionMap<Block> LEVER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(171, "lever")));

    public static final VersionMap<Block> STONE_PRESSURE_PLATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(172, "stone_pressure_plate")));

    public static final VersionMap<Block> IRON_DOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(173, "iron_door")));

    public static final VersionMap<Block> OAK_PRESSURE_PLATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(174, "oak_pressure_plate")));

    public static final VersionMap<Block> SPRUCE_PRESSURE_PLATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(175, "spruce_pressure_plate")));

    public static final VersionMap<Block> BIRCH_PRESSURE_PLATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(176, "birch_pressure_plate")));

    public static final VersionMap<Block> JUNGLE_PRESSURE_PLATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(177, "jungle_pressure_plate")));

    public static final VersionMap<Block> ACACIA_PRESSURE_PLATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(178, "acacia_pressure_plate")));

    public static final VersionMap<Block> DARK_OAK_PRESSURE_PLATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(179, "dark_oak_pressure_plate")));

    public static final VersionMap<Block> REDSTONE_ORE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(180, "redstone_ore")));

    public static final VersionMap<Block> REDSTONE_TORCH_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(181, "redstone_torch")));

    public static final VersionMap<Block> REDSTONE_WALL_TORCH_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(182, "redstone_wall_torch")));

    public static final VersionMap<Block> STONE_BUTTON_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(183, "stone_button")));

    public static final VersionMap<Block> SNOW_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(184, "snow")));

    public static final VersionMap<Block> ICE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(185, "ice")));

    public static final VersionMap<Block> SNOW_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(186, "snow_block")));

    public static final VersionMap<Block> CACTUS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(187, "cactus")));

    public static final VersionMap<Block> CLAY_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(188, "clay")));

    public static final VersionMap<Block> SUGAR_CANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(189, "sugar_cane")));

    public static final VersionMap<Block> JUKEBOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(190, "jukebox")));

    public static final VersionMap<Block> OAK_FENCE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(191, "oak_fence")));

    public static final VersionMap<Block> PUMPKIN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(192, "pumpkin")));

    public static final VersionMap<Block> NETHERRACK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(193, "netherrack")));

    public static final VersionMap<Block> SOUL_SAND_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(194, "soul_sand")));

    public static final VersionMap<Block> SOUL_SOIL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(195, "soul_soil")));

    public static final VersionMap<Block> BASALT_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(196, "basalt")));

    public static final VersionMap<Block> POLISHED_BASALT_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(197, "polished_basalt")));

    public static final VersionMap<Block> SOUL_TORCH_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(198, "soul_torch")));

    public static final VersionMap<Block> SOUL_WALL_TORCH_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(199, "soul_wall_torch")));

    public static final VersionMap<Block> GLOWSTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(200, "glowstone")));

    public static final VersionMap<Block> NETHER_PORTAL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(201, "nether_portal")));

    public static final VersionMap<Block> CARVED_PUMPKIN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(202, "carved_pumpkin")));

    public static final VersionMap<Block> JACK_O_LANTERN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(203, "jack_o_lantern")));

    public static final VersionMap<Block> CAKE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(204, "cake")));

    public static final VersionMap<Block> REPEATER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(205, "repeater")));

    public static final VersionMap<Block> WHITE_STAINED_GLASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(206, "white_stained_glass")));

    public static final VersionMap<Block> ORANGE_STAINED_GLASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(207, "orange_stained_glass")));

    public static final VersionMap<Block> MAGENTA_STAINED_GLASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(208, "magenta_stained_glass")));

    public static final VersionMap<Block> LIGHT_BLUE_STAINED_GLASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(209, "light_blue_stained_glass")));

    public static final VersionMap<Block> YELLOW_STAINED_GLASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(210, "yellow_stained_glass")));

    public static final VersionMap<Block> LIME_STAINED_GLASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(211, "lime_stained_glass")));

    public static final VersionMap<Block> PINK_STAINED_GLASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(212, "pink_stained_glass")));

    public static final VersionMap<Block> GRAY_STAINED_GLASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(213, "gray_stained_glass")));

    public static final VersionMap<Block> LIGHT_GRAY_STAINED_GLASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(214, "light_gray_stained_glass")));

    public static final VersionMap<Block> CYAN_STAINED_GLASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(215, "cyan_stained_glass")));

    public static final VersionMap<Block> PURPLE_STAINED_GLASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(216, "purple_stained_glass")));

    public static final VersionMap<Block> BLUE_STAINED_GLASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(217, "blue_stained_glass")));

    public static final VersionMap<Block> BROWN_STAINED_GLASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(218, "brown_stained_glass")));

    public static final VersionMap<Block> GREEN_STAINED_GLASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(219, "green_stained_glass")));

    public static final VersionMap<Block> RED_STAINED_GLASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(220, "red_stained_glass")));

    public static final VersionMap<Block> BLACK_STAINED_GLASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(221, "black_stained_glass")));

    public static final VersionMap<Block> OAK_TRAPDOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(222, "oak_trapdoor")));

    public static final VersionMap<Block> SPRUCE_TRAPDOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(223, "spruce_trapdoor")));

    public static final VersionMap<Block> BIRCH_TRAPDOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(224, "birch_trapdoor")));

    public static final VersionMap<Block> JUNGLE_TRAPDOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(225, "jungle_trapdoor")));

    public static final VersionMap<Block> ACACIA_TRAPDOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(226, "acacia_trapdoor")));

    public static final VersionMap<Block> DARK_OAK_TRAPDOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(227, "dark_oak_trapdoor")));

    public static final VersionMap<Block> STONE_BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(228, "stone_bricks")));

    public static final VersionMap<Block> MOSSY_STONE_BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(229, "mossy_stone_bricks")));

    public static final VersionMap<Block> CRACKED_STONE_BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(230, "cracked_stone_bricks")));

    public static final VersionMap<Block> CHISELED_STONE_BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(231, "chiseled_stone_bricks")));

    public static final VersionMap<Block> INFESTED_STONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(232, "infested_stone")));

    public static final VersionMap<Block> INFESTED_COBBLESTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(233, "infested_cobblestone")));

    public static final VersionMap<Block> INFESTED_STONE_BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(234, "infested_stone_bricks")));

    public static final VersionMap<Block> INFESTED_MOSSY_STONE_BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(235, "infested_mossy_stone_bricks")));

    public static final VersionMap<Block> INFESTED_CRACKED_STONE_BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(236, "infested_cracked_stone_bricks")));

    public static final VersionMap<Block> INFESTED_CHISELED_STONE_BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(237, "infested_chiseled_stone_bricks")));

    public static final VersionMap<Block> BROWN_MUSHROOM_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(238, "brown_mushroom_block")));

    public static final VersionMap<Block> RED_MUSHROOM_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(239, "red_mushroom_block")));

    public static final VersionMap<Block> MUSHROOM_STEM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(240, "mushroom_stem")));

    public static final VersionMap<Block> IRON_BARS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(241, "iron_bars")));

    public static final VersionMap<Block> CHAIN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(242, "chain")));

    public static final VersionMap<Block> GLASS_PANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(243, "glass_pane")));

    public static final VersionMap<Block> MELON_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(244, "melon")));

    public static final VersionMap<Block> ATTACHED_PUMPKIN_STEM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(245, "attached_pumpkin_stem")));

    public static final VersionMap<Block> ATTACHED_MELON_STEM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(246, "attached_melon_stem")));

    public static final VersionMap<Block> PUMPKIN_STEM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(247, "pumpkin_stem")));

    public static final VersionMap<Block> MELON_STEM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(248, "melon_stem")));

    public static final VersionMap<Block> VINE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(249, "vine")));

    public static final VersionMap<Block> OAK_FENCE_GATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(250, "oak_fence_gate")));

    public static final VersionMap<Block> BRICK_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(251, "brick_stairs")));

    public static final VersionMap<Block> STONE_BRICK_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(252, "stone_brick_stairs")));

    public static final VersionMap<Block> MYCELIUM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(253, "mycelium")));

    public static final VersionMap<Block> LILY_PAD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(254, "lily_pad")));

    public static final VersionMap<Block> NETHER_BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(255, "nether_bricks")));

    public static final VersionMap<Block> NETHER_BRICK_FENCE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(256, "nether_brick_fence")));

    public static final VersionMap<Block> NETHER_BRICK_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(257, "nether_brick_stairs")));

    public static final VersionMap<Block> NETHER_WART_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(258, "nether_wart")));

    public static final VersionMap<Block> ENCHANTING_TABLE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(259, "enchanting_table")));

    public static final VersionMap<Block> BREWING_STAND_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(260, "brewing_stand")));

    public static final VersionMap<Block> CAULDRON_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(261, "cauldron")));

    public static final VersionMap<Block> END_PORTAL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(262, "end_portal")));

    public static final VersionMap<Block> END_PORTAL_FRAME_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(263, "end_portal_frame")));

    public static final VersionMap<Block> END_STONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(264, "end_stone")));

    public static final VersionMap<Block> DRAGON_EGG_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(265, "dragon_egg")));

    public static final VersionMap<Block> REDSTONE_LAMP_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(266, "redstone_lamp")));

    public static final VersionMap<Block> COCOA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(267, "cocoa")));

    public static final VersionMap<Block> SANDSTONE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(268, "sandstone_stairs")));

    public static final VersionMap<Block> EMERALD_ORE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(269, "emerald_ore")));

    public static final VersionMap<Block> ENDER_CHEST_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(270, "ender_chest")));

    public static final VersionMap<Block> TRIPWIRE_HOOK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(271, "tripwire_hook")));

    public static final VersionMap<Block> TRIPWIRE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(272, "tripwire")));

    public static final VersionMap<Block> EMERALD_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(273, "emerald_block")));

    public static final VersionMap<Block> SPRUCE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(274, "spruce_stairs")));

    public static final VersionMap<Block> BIRCH_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(275, "birch_stairs")));

    public static final VersionMap<Block> JUNGLE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(276, "jungle_stairs")));

    public static final VersionMap<Block> COMMAND_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(277, "command_block")));

    public static final VersionMap<Block> BEACON_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(278, "beacon")));

    public static final VersionMap<Block> COBBLESTONE_WALL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(279, "cobblestone_wall")));

    public static final VersionMap<Block> MOSSY_COBBLESTONE_WALL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(280, "mossy_cobblestone_wall")));

    public static final VersionMap<Block> FLOWER_POT_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(281, "flower_pot")));

    public static final VersionMap<Block> POTTED_OAK_SAPLING_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(282, "potted_oak_sapling")));

    public static final VersionMap<Block> POTTED_SPRUCE_SAPLING_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(283, "potted_spruce_sapling")));

    public static final VersionMap<Block> POTTED_BIRCH_SAPLING_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(284, "potted_birch_sapling")));

    public static final VersionMap<Block> POTTED_JUNGLE_SAPLING_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(285, "potted_jungle_sapling")));

    public static final VersionMap<Block> POTTED_ACACIA_SAPLING_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(286, "potted_acacia_sapling")));

    public static final VersionMap<Block> POTTED_DARK_OAK_SAPLING_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(287, "potted_dark_oak_sapling")));

    public static final VersionMap<Block> POTTED_FERN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(288, "potted_fern")));

    public static final VersionMap<Block> POTTED_DANDELION_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(289, "potted_dandelion")));

    public static final VersionMap<Block> POTTED_POPPY_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(290, "potted_poppy")));

    public static final VersionMap<Block> POTTED_BLUE_ORCHID_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(291, "potted_blue_orchid")));

    public static final VersionMap<Block> POTTED_ALLIUM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(292, "potted_allium")));

    public static final VersionMap<Block> POTTED_AZURE_BLUET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(293, "potted_azure_bluet")));

    public static final VersionMap<Block> POTTED_RED_TULIP_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(294, "potted_red_tulip")));

    public static final VersionMap<Block> POTTED_ORANGE_TULIP_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(295, "potted_orange_tulip")));

    public static final VersionMap<Block> POTTED_WHITE_TULIP_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(296, "potted_white_tulip")));

    public static final VersionMap<Block> POTTED_PINK_TULIP_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(297, "potted_pink_tulip")));

    public static final VersionMap<Block> POTTED_OXEYE_DAISY_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(298, "potted_oxeye_daisy")));

    public static final VersionMap<Block> POTTED_CORNFLOWER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(299, "potted_cornflower")));

    public static final VersionMap<Block> POTTED_LILY_OF_THE_VALLEY_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(300, "potted_lily_of_the_valley")));

    public static final VersionMap<Block> POTTED_WITHER_ROSE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(301, "potted_wither_rose")));

    public static final VersionMap<Block> POTTED_RED_MUSHROOM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(302, "potted_red_mushroom")));

    public static final VersionMap<Block> POTTED_BROWN_MUSHROOM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(303, "potted_brown_mushroom")));

    public static final VersionMap<Block> POTTED_DEAD_BUSH_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(304, "potted_dead_bush")));

    public static final VersionMap<Block> POTTED_CACTUS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(305, "potted_cactus")));

    public static final VersionMap<Block> CARROTS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(306, "carrots")));

    public static final VersionMap<Block> POTATOES_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(307, "potatoes")));

    public static final VersionMap<Block> OAK_BUTTON_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(308, "oak_button")));

    public static final VersionMap<Block> SPRUCE_BUTTON_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(309, "spruce_button")));

    public static final VersionMap<Block> BIRCH_BUTTON_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(310, "birch_button")));

    public static final VersionMap<Block> JUNGLE_BUTTON_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(311, "jungle_button")));

    public static final VersionMap<Block> ACACIA_BUTTON_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(312, "acacia_button")));

    public static final VersionMap<Block> DARK_OAK_BUTTON_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(313, "dark_oak_button")));

    public static final VersionMap<Block> SKELETON_SKULL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(314, "skeleton_skull")));

    public static final VersionMap<Block> SKELETON_WALL_SKULL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(315, "skeleton_wall_skull")));

    public static final VersionMap<Block> WITHER_SKELETON_SKULL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(316, "wither_skeleton_skull")));

    public static final VersionMap<Block> WITHER_SKELETON_WALL_SKULL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(317, "wither_skeleton_wall_skull")));

    public static final VersionMap<Block> ZOMBIE_HEAD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(318, "zombie_head")));

    public static final VersionMap<Block> ZOMBIE_WALL_HEAD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(319, "zombie_wall_head")));

    public static final VersionMap<Block> PLAYER_HEAD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(320, "player_head")));

    public static final VersionMap<Block> PLAYER_WALL_HEAD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(321, "player_wall_head")));

    public static final VersionMap<Block> CREEPER_HEAD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(322, "creeper_head")));

    public static final VersionMap<Block> CREEPER_WALL_HEAD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(323, "creeper_wall_head")));

    public static final VersionMap<Block> DRAGON_HEAD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(324, "dragon_head")));

    public static final VersionMap<Block> DRAGON_WALL_HEAD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(325, "dragon_wall_head")));

    public static final VersionMap<Block> ANVIL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(326, "anvil")));

    public static final VersionMap<Block> CHIPPED_ANVIL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(327, "chipped_anvil")));

    public static final VersionMap<Block> DAMAGED_ANVIL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(328, "damaged_anvil")));

    public static final VersionMap<Block> TRAPPED_CHEST_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(329, "trapped_chest")));

    public static final VersionMap<Block> LIGHT_WEIGHTED_PRESSURE_PLATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(330, "light_weighted_pressure_plate")));

    public static final VersionMap<Block> HEAVY_WEIGHTED_PRESSURE_PLATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(331, "heavy_weighted_pressure_plate")));

    public static final VersionMap<Block> COMPARATOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(332, "comparator")));

    public static final VersionMap<Block> DAYLIGHT_DETECTOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(333, "daylight_detector")));

    public static final VersionMap<Block> REDSTONE_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(334, "redstone_block")));

    public static final VersionMap<Block> NETHER_QUARTZ_ORE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(335, "nether_quartz_ore")));

    public static final VersionMap<Block> HOPPER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(336, "hopper")));

    public static final VersionMap<Block> QUARTZ_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(337, "quartz_block")));

    public static final VersionMap<Block> CHISELED_QUARTZ_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(338, "chiseled_quartz_block")));

    public static final VersionMap<Block> QUARTZ_PILLAR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(339, "quartz_pillar")));

    public static final VersionMap<Block> QUARTZ_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(340, "quartz_stairs")));

    public static final VersionMap<Block> ACTIVATOR_RAIL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(341, "activator_rail")));

    public static final VersionMap<Block> DROPPER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(342, "dropper")));

    public static final VersionMap<Block> WHITE_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(343, "white_terracotta")));

    public static final VersionMap<Block> ORANGE_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(344, "orange_terracotta")));

    public static final VersionMap<Block> MAGENTA_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(345, "magenta_terracotta")));

    public static final VersionMap<Block> LIGHT_BLUE_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(346, "light_blue_terracotta")));

    public static final VersionMap<Block> YELLOW_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(347, "yellow_terracotta")));

    public static final VersionMap<Block> LIME_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(348, "lime_terracotta")));

    public static final VersionMap<Block> PINK_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(349, "pink_terracotta")));

    public static final VersionMap<Block> GRAY_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(350, "gray_terracotta")));

    public static final VersionMap<Block> LIGHT_GRAY_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(351, "light_gray_terracotta")));

    public static final VersionMap<Block> CYAN_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(352, "cyan_terracotta")));

    public static final VersionMap<Block> PURPLE_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(353, "purple_terracotta")));

    public static final VersionMap<Block> BLUE_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(354, "blue_terracotta")));

    public static final VersionMap<Block> BROWN_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(355, "brown_terracotta")));

    public static final VersionMap<Block> GREEN_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(356, "green_terracotta")));

    public static final VersionMap<Block> RED_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(357, "red_terracotta")));

    public static final VersionMap<Block> BLACK_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(358, "black_terracotta")));

    public static final VersionMap<Block> WHITE_STAINED_GLASS_PANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(359, "white_stained_glass_pane")));

    public static final VersionMap<Block> ORANGE_STAINED_GLASS_PANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(360, "orange_stained_glass_pane")));

    public static final VersionMap<Block> MAGENTA_STAINED_GLASS_PANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(361, "magenta_stained_glass_pane")));

    public static final VersionMap<Block> LIGHT_BLUE_STAINED_GLASS_PANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(362, "light_blue_stained_glass_pane")));

    public static final VersionMap<Block> YELLOW_STAINED_GLASS_PANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(363, "yellow_stained_glass_pane")));

    public static final VersionMap<Block> LIME_STAINED_GLASS_PANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(364, "lime_stained_glass_pane")));

    public static final VersionMap<Block> PINK_STAINED_GLASS_PANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(365, "pink_stained_glass_pane")));

    public static final VersionMap<Block> GRAY_STAINED_GLASS_PANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(366, "gray_stained_glass_pane")));

    public static final VersionMap<Block> LIGHT_GRAY_STAINED_GLASS_PANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(367, "light_gray_stained_glass_pane")));

    public static final VersionMap<Block> CYAN_STAINED_GLASS_PANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(368, "cyan_stained_glass_pane")));

    public static final VersionMap<Block> PURPLE_STAINED_GLASS_PANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(369, "purple_stained_glass_pane")));

    public static final VersionMap<Block> BLUE_STAINED_GLASS_PANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(370, "blue_stained_glass_pane")));

    public static final VersionMap<Block> BROWN_STAINED_GLASS_PANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(371, "brown_stained_glass_pane")));

    public static final VersionMap<Block> GREEN_STAINED_GLASS_PANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(372, "green_stained_glass_pane")));

    public static final VersionMap<Block> RED_STAINED_GLASS_PANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(373, "red_stained_glass_pane")));

    public static final VersionMap<Block> BLACK_STAINED_GLASS_PANE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(374, "black_stained_glass_pane")));

    public static final VersionMap<Block> ACACIA_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(375, "acacia_stairs")));

    public static final VersionMap<Block> DARK_OAK_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(376, "dark_oak_stairs")));

    public static final VersionMap<Block> SLIME_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(377, "slime_block")));

    public static final VersionMap<Block> BARRIER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(378, "barrier")));

    public static final VersionMap<Block> IRON_TRAPDOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(379, "iron_trapdoor")));

    public static final VersionMap<Block> PRISMARINE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(380, "prismarine")));

    public static final VersionMap<Block> PRISMARINE_BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(381, "prismarine_bricks")));

    public static final VersionMap<Block> DARK_PRISMARINE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(382, "dark_prismarine")));

    public static final VersionMap<Block> PRISMARINE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(383, "prismarine_stairs")));

    public static final VersionMap<Block> PRISMARINE_BRICK_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(384, "prismarine_brick_stairs")));

    public static final VersionMap<Block> DARK_PRISMARINE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(385, "dark_prismarine_stairs")));

    public static final VersionMap<Block> PRISMARINE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(386, "prismarine_slab")));

    public static final VersionMap<Block> PRISMARINE_BRICK_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(387, "prismarine_brick_slab")));

    public static final VersionMap<Block> DARK_PRISMARINE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(388, "dark_prismarine_slab")));

    public static final VersionMap<Block> SEA_LANTERN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(389, "sea_lantern")));

    public static final VersionMap<Block> HAY_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(390, "hay_block")));

    public static final VersionMap<Block> WHITE_CARPET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(391, "white_carpet")));

    public static final VersionMap<Block> ORANGE_CARPET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(392, "orange_carpet")));

    public static final VersionMap<Block> MAGENTA_CARPET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(393, "magenta_carpet")));

    public static final VersionMap<Block> LIGHT_BLUE_CARPET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(394, "light_blue_carpet")));

    public static final VersionMap<Block> YELLOW_CARPET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(395, "yellow_carpet")));

    public static final VersionMap<Block> LIME_CARPET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(396, "lime_carpet")));

    public static final VersionMap<Block> PINK_CARPET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(397, "pink_carpet")));

    public static final VersionMap<Block> GRAY_CARPET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(398, "gray_carpet")));

    public static final VersionMap<Block> LIGHT_GRAY_CARPET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(399, "light_gray_carpet")));

    public static final VersionMap<Block> CYAN_CARPET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(400, "cyan_carpet")));

    public static final VersionMap<Block> PURPLE_CARPET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(401, "purple_carpet")));

    public static final VersionMap<Block> BLUE_CARPET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(402, "blue_carpet")));

    public static final VersionMap<Block> BROWN_CARPET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(403, "brown_carpet")));

    public static final VersionMap<Block> GREEN_CARPET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(404, "green_carpet")));

    public static final VersionMap<Block> RED_CARPET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(405, "red_carpet")));

    public static final VersionMap<Block> BLACK_CARPET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(406, "black_carpet")));

    public static final VersionMap<Block> TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(407, "terracotta")));

    public static final VersionMap<Block> COAL_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(408, "coal_block")));

    public static final VersionMap<Block> PACKED_ICE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(409, "packed_ice")));

    public static final VersionMap<Block> SUNFLOWER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(410, "sunflower")));

    public static final VersionMap<Block> LILAC_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(411, "lilac")));

    public static final VersionMap<Block> ROSE_BUSH_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(412, "rose_bush")));

    public static final VersionMap<Block> PEONY_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(413, "peony")));

    public static final VersionMap<Block> TALL_GRASS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(414, "tall_grass")));

    public static final VersionMap<Block> LARGE_FERN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(415, "large_fern")));

    public static final VersionMap<Block> WHITE_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(416, "white_banner")));

    public static final VersionMap<Block> ORANGE_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(417, "orange_banner")));

    public static final VersionMap<Block> MAGENTA_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(418, "magenta_banner")));

    public static final VersionMap<Block> LIGHT_BLUE_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(419, "light_blue_banner")));

    public static final VersionMap<Block> YELLOW_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(420, "yellow_banner")));

    public static final VersionMap<Block> LIME_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(421, "lime_banner")));

    public static final VersionMap<Block> PINK_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(422, "pink_banner")));

    public static final VersionMap<Block> GRAY_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(423, "gray_banner")));

    public static final VersionMap<Block> LIGHT_GRAY_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(424, "light_gray_banner")));

    public static final VersionMap<Block> CYAN_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(425, "cyan_banner")));

    public static final VersionMap<Block> PURPLE_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(426, "purple_banner")));

    public static final VersionMap<Block> BLUE_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(427, "blue_banner")));

    public static final VersionMap<Block> BROWN_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(428, "brown_banner")));

    public static final VersionMap<Block> GREEN_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(429, "green_banner")));

    public static final VersionMap<Block> RED_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(430, "red_banner")));

    public static final VersionMap<Block> BLACK_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(431, "black_banner")));

    public static final VersionMap<Block> WHITE_WALL_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(432, "white_wall_banner")));

    public static final VersionMap<Block> ORANGE_WALL_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(433, "orange_wall_banner")));

    public static final VersionMap<Block> MAGENTA_WALL_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(434, "magenta_wall_banner")));

    public static final VersionMap<Block> LIGHT_BLUE_WALL_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(435, "light_blue_wall_banner")));

    public static final VersionMap<Block> YELLOW_WALL_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(436, "yellow_wall_banner")));

    public static final VersionMap<Block> LIME_WALL_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(437, "lime_wall_banner")));

    public static final VersionMap<Block> PINK_WALL_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(438, "pink_wall_banner")));

    public static final VersionMap<Block> GRAY_WALL_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(439, "gray_wall_banner")));

    public static final VersionMap<Block> LIGHT_GRAY_WALL_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(440, "light_gray_wall_banner")));

    public static final VersionMap<Block> CYAN_WALL_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(441, "cyan_wall_banner")));

    public static final VersionMap<Block> PURPLE_WALL_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(442, "purple_wall_banner")));

    public static final VersionMap<Block> BLUE_WALL_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(443, "blue_wall_banner")));

    public static final VersionMap<Block> BROWN_WALL_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(444, "brown_wall_banner")));

    public static final VersionMap<Block> GREEN_WALL_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(445, "green_wall_banner")));

    public static final VersionMap<Block> RED_WALL_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(446, "red_wall_banner")));

    public static final VersionMap<Block> BLACK_WALL_BANNER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(447, "black_wall_banner")));

    public static final VersionMap<Block> RED_SANDSTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(448, "red_sandstone")));

    public static final VersionMap<Block> CHISELED_RED_SANDSTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(449, "chiseled_red_sandstone")));

    public static final VersionMap<Block> CUT_RED_SANDSTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(450, "cut_red_sandstone")));

    public static final VersionMap<Block> RED_SANDSTONE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(451, "red_sandstone_stairs")));

    public static final VersionMap<Block> OAK_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(452, "oak_slab")));

    public static final VersionMap<Block> SPRUCE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(453, "spruce_slab")));

    public static final VersionMap<Block> BIRCH_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(454, "birch_slab")));

    public static final VersionMap<Block> JUNGLE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(455, "jungle_slab")));

    public static final VersionMap<Block> ACACIA_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(456, "acacia_slab")));

    public static final VersionMap<Block> DARK_OAK_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(457, "dark_oak_slab")));

    public static final VersionMap<Block> STONE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(458, "stone_slab")));

    public static final VersionMap<Block> SMOOTH_STONE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(459, "smooth_stone_slab")));

    public static final VersionMap<Block> SANDSTONE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(460, "sandstone_slab")));

    public static final VersionMap<Block> CUT_SANDSTONE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(461, "cut_sandstone_slab")));

    public static final VersionMap<Block> PETRIFIED_OAK_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(462, "petrified_oak_slab")));

    public static final VersionMap<Block> COBBLESTONE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(463, "cobblestone_slab")));

    public static final VersionMap<Block> BRICK_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(464, "brick_slab")));

    public static final VersionMap<Block> STONE_BRICK_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(465, "stone_brick_slab")));

    public static final VersionMap<Block> NETHER_BRICK_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(466, "nether_brick_slab")));

    public static final VersionMap<Block> QUARTZ_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(467, "quartz_slab")));

    public static final VersionMap<Block> RED_SANDSTONE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(468, "red_sandstone_slab")));

    public static final VersionMap<Block> CUT_RED_SANDSTONE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(469, "cut_red_sandstone_slab")));

    public static final VersionMap<Block> PURPUR_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(470, "purpur_slab")));

    public static final VersionMap<Block> SMOOTH_STONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(471, "smooth_stone")));

    public static final VersionMap<Block> SMOOTH_SANDSTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(472, "smooth_sandstone")));

    public static final VersionMap<Block> SMOOTH_QUARTZ_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(473, "smooth_quartz")));

    public static final VersionMap<Block> SMOOTH_RED_SANDSTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(474, "smooth_red_sandstone")));

    public static final VersionMap<Block> SPRUCE_FENCE_GATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(475, "spruce_fence_gate")));

    public static final VersionMap<Block> BIRCH_FENCE_GATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(476, "birch_fence_gate")));

    public static final VersionMap<Block> JUNGLE_FENCE_GATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(477, "jungle_fence_gate")));

    public static final VersionMap<Block> ACACIA_FENCE_GATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(478, "acacia_fence_gate")));

    public static final VersionMap<Block> DARK_OAK_FENCE_GATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(479, "dark_oak_fence_gate")));

    public static final VersionMap<Block> SPRUCE_FENCE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(480, "spruce_fence")));

    public static final VersionMap<Block> BIRCH_FENCE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(481, "birch_fence")));

    public static final VersionMap<Block> JUNGLE_FENCE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(482, "jungle_fence")));

    public static final VersionMap<Block> ACACIA_FENCE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(483, "acacia_fence")));

    public static final VersionMap<Block> DARK_OAK_FENCE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(484, "dark_oak_fence")));

    public static final VersionMap<Block> SPRUCE_DOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(485, "spruce_door")));

    public static final VersionMap<Block> BIRCH_DOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(486, "birch_door")));

    public static final VersionMap<Block> JUNGLE_DOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(487, "jungle_door")));

    public static final VersionMap<Block> ACACIA_DOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(488, "acacia_door")));

    public static final VersionMap<Block> DARK_OAK_DOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(489, "dark_oak_door")));

    public static final VersionMap<Block> END_ROD_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(490, "end_rod")));

    public static final VersionMap<Block> CHORUS_PLANT_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(491, "chorus_plant")));

    public static final VersionMap<Block> CHORUS_FLOWER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(492, "chorus_flower")));

    public static final VersionMap<Block> PURPUR_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(493, "purpur_block")));

    public static final VersionMap<Block> PURPUR_PILLAR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(494, "purpur_pillar")));

    public static final VersionMap<Block> PURPUR_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(495, "purpur_stairs")));

    public static final VersionMap<Block> END_STONE_BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(496, "end_stone_bricks")));

    public static final VersionMap<Block> BEETROOTS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(497, "beetroots")));

    public static final VersionMap<Block> GRASS_PATH_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(498, "grass_path")));

    public static final VersionMap<Block> END_GATEWAY_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(499, "end_gateway")));

    public static final VersionMap<Block> REPEATING_COMMAND_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(500, "repeating_command_block")));

    public static final VersionMap<Block> CHAIN_COMMAND_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(501, "chain_command_block")));

    public static final VersionMap<Block> FROSTED_ICE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(502, "frosted_ice")));

    public static final VersionMap<Block> MAGMA_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(503, "magma_block")));

    public static final VersionMap<Block> NETHER_WART_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(504, "nether_wart_block")));

    public static final VersionMap<Block> RED_NETHER_BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(505, "red_nether_bricks")));

    public static final VersionMap<Block> BONE_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(506, "bone_block")));

    public static final VersionMap<Block> STRUCTURE_VOID_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(507, "structure_void")));

    public static final VersionMap<Block> OBSERVER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(508, "observer")));

    public static final VersionMap<Block> SHULKER_BOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(509, "shulker_box")));

    public static final VersionMap<Block> WHITE_SHULKER_BOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(510, "white_shulker_box")));

    public static final VersionMap<Block> ORANGE_SHULKER_BOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(511, "orange_shulker_box")));

    public static final VersionMap<Block> MAGENTA_SHULKER_BOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(512, "magenta_shulker_box")));

    public static final VersionMap<Block> LIGHT_BLUE_SHULKER_BOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(513, "light_blue_shulker_box")));

    public static final VersionMap<Block> YELLOW_SHULKER_BOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(514, "yellow_shulker_box")));

    public static final VersionMap<Block> LIME_SHULKER_BOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(515, "lime_shulker_box")));

    public static final VersionMap<Block> PINK_SHULKER_BOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(516, "pink_shulker_box")));

    public static final VersionMap<Block> GRAY_SHULKER_BOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(517, "gray_shulker_box")));

    public static final VersionMap<Block> LIGHT_GRAY_SHULKER_BOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(518, "light_gray_shulker_box")));

    public static final VersionMap<Block> CYAN_SHULKER_BOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(519, "cyan_shulker_box")));

    public static final VersionMap<Block> PURPLE_SHULKER_BOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(520, "purple_shulker_box")));

    public static final VersionMap<Block> BLUE_SHULKER_BOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(521, "blue_shulker_box")));

    public static final VersionMap<Block> BROWN_SHULKER_BOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(522, "brown_shulker_box")));

    public static final VersionMap<Block> GREEN_SHULKER_BOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(523, "green_shulker_box")));

    public static final VersionMap<Block> RED_SHULKER_BOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(524, "red_shulker_box")));

    public static final VersionMap<Block> BLACK_SHULKER_BOX_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(525, "black_shulker_box")));

    public static final VersionMap<Block> WHITE_GLAZED_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(526, "white_glazed_terracotta")));

    public static final VersionMap<Block> ORANGE_GLAZED_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(527, "orange_glazed_terracotta")));

    public static final VersionMap<Block> MAGENTA_GLAZED_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(528, "magenta_glazed_terracotta")));

    public static final VersionMap<Block> LIGHT_BLUE_GLAZED_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(529, "light_blue_glazed_terracotta")));

    public static final VersionMap<Block> YELLOW_GLAZED_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(530, "yellow_glazed_terracotta")));

    public static final VersionMap<Block> LIME_GLAZED_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(531, "lime_glazed_terracotta")));

    public static final VersionMap<Block> PINK_GLAZED_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(532, "pink_glazed_terracotta")));

    public static final VersionMap<Block> GRAY_GLAZED_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(533, "gray_glazed_terracotta")));

    public static final VersionMap<Block> LIGHT_GRAY_GLAZED_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(534, "light_gray_glazed_terracotta")));

    public static final VersionMap<Block> CYAN_GLAZED_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(535, "cyan_glazed_terracotta")));

    public static final VersionMap<Block> PURPLE_GLAZED_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(536, "purple_glazed_terracotta")));

    public static final VersionMap<Block> BLUE_GLAZED_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(537, "blue_glazed_terracotta")));

    public static final VersionMap<Block> BROWN_GLAZED_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(538, "brown_glazed_terracotta")));

    public static final VersionMap<Block> GREEN_GLAZED_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(539, "green_glazed_terracotta")));

    public static final VersionMap<Block> RED_GLAZED_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(540, "red_glazed_terracotta")));

    public static final VersionMap<Block> BLACK_GLAZED_TERRACOTTA_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(541, "black_glazed_terracotta")));

    public static final VersionMap<Block> WHITE_CONCRETE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(542, "white_concrete")));

    public static final VersionMap<Block> ORANGE_CONCRETE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(543, "orange_concrete")));

    public static final VersionMap<Block> MAGENTA_CONCRETE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(544, "magenta_concrete")));

    public static final VersionMap<Block> LIGHT_BLUE_CONCRETE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(545, "light_blue_concrete")));

    public static final VersionMap<Block> YELLOW_CONCRETE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(546, "yellow_concrete")));

    public static final VersionMap<Block> LIME_CONCRETE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(547, "lime_concrete")));

    public static final VersionMap<Block> PINK_CONCRETE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(548, "pink_concrete")));

    public static final VersionMap<Block> GRAY_CONCRETE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(549, "gray_concrete")));

    public static final VersionMap<Block> LIGHT_GRAY_CONCRETE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(550, "light_gray_concrete")));

    public static final VersionMap<Block> CYAN_CONCRETE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(551, "cyan_concrete")));

    public static final VersionMap<Block> PURPLE_CONCRETE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(552, "purple_concrete")));

    public static final VersionMap<Block> BLUE_CONCRETE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(553, "blue_concrete")));

    public static final VersionMap<Block> BROWN_CONCRETE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(554, "brown_concrete")));

    public static final VersionMap<Block> GREEN_CONCRETE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(555, "green_concrete")));

    public static final VersionMap<Block> RED_CONCRETE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(556, "red_concrete")));

    public static final VersionMap<Block> BLACK_CONCRETE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(557, "black_concrete")));

    public static final VersionMap<Block> WHITE_CONCRETE_POWDER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(558, "white_concrete_powder")));

    public static final VersionMap<Block> ORANGE_CONCRETE_POWDER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(559, "orange_concrete_powder")));

    public static final VersionMap<Block> MAGENTA_CONCRETE_POWDER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(560, "magenta_concrete_powder")));

    public static final VersionMap<Block> LIGHT_BLUE_CONCRETE_POWDER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(561, "light_blue_concrete_powder")));

    public static final VersionMap<Block> YELLOW_CONCRETE_POWDER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(562, "yellow_concrete_powder")));

    public static final VersionMap<Block> LIME_CONCRETE_POWDER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(563, "lime_concrete_powder")));

    public static final VersionMap<Block> PINK_CONCRETE_POWDER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(564, "pink_concrete_powder")));

    public static final VersionMap<Block> GRAY_CONCRETE_POWDER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(565, "gray_concrete_powder")));

    public static final VersionMap<Block> LIGHT_GRAY_CONCRETE_POWDER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(566, "light_gray_concrete_powder")));

    public static final VersionMap<Block> CYAN_CONCRETE_POWDER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(567, "cyan_concrete_powder")));

    public static final VersionMap<Block> PURPLE_CONCRETE_POWDER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(568, "purple_concrete_powder")));

    public static final VersionMap<Block> BLUE_CONCRETE_POWDER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(569, "blue_concrete_powder")));

    public static final VersionMap<Block> BROWN_CONCRETE_POWDER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(570, "brown_concrete_powder")));

    public static final VersionMap<Block> GREEN_CONCRETE_POWDER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(571, "green_concrete_powder")));

    public static final VersionMap<Block> RED_CONCRETE_POWDER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(572, "red_concrete_powder")));

    public static final VersionMap<Block> BLACK_CONCRETE_POWDER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(573, "black_concrete_powder")));

    public static final VersionMap<Block> KELP_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(574, "kelp")));

    public static final VersionMap<Block> KELP_PLANT_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(575, "kelp_plant")));

    public static final VersionMap<Block> DRIED_KELP_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(576, "dried_kelp_block")));

    public static final VersionMap<Block> TURTLE_EGG_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(577, "turtle_egg")));

    public static final VersionMap<Block> DEAD_TUBE_CORAL_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(578, "dead_tube_coral_block")));

    public static final VersionMap<Block> DEAD_BRAIN_CORAL_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(579, "dead_brain_coral_block")));

    public static final VersionMap<Block> DEAD_BUBBLE_CORAL_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(580, "dead_bubble_coral_block")));

    public static final VersionMap<Block> DEAD_FIRE_CORAL_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(581, "dead_fire_coral_block")));

    public static final VersionMap<Block> DEAD_HORN_CORAL_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(582, "dead_horn_coral_block")));

    public static final VersionMap<Block> TUBE_CORAL_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(583, "tube_coral_block")));

    public static final VersionMap<Block> BRAIN_CORAL_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(584, "brain_coral_block")));

    public static final VersionMap<Block> BUBBLE_CORAL_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(585, "bubble_coral_block")));

    public static final VersionMap<Block> FIRE_CORAL_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(586, "fire_coral_block")));

    public static final VersionMap<Block> HORN_CORAL_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(587, "horn_coral_block")));

    public static final VersionMap<Block> DEAD_TUBE_CORAL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(588, "dead_tube_coral")));

    public static final VersionMap<Block> DEAD_BRAIN_CORAL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(589, "dead_brain_coral")));

    public static final VersionMap<Block> DEAD_BUBBLE_CORAL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(590, "dead_bubble_coral")));

    public static final VersionMap<Block> DEAD_FIRE_CORAL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(591, "dead_fire_coral")));

    public static final VersionMap<Block> DEAD_HORN_CORAL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(592, "dead_horn_coral")));

    public static final VersionMap<Block> TUBE_CORAL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(593, "tube_coral")));

    public static final VersionMap<Block> BRAIN_CORAL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(594, "brain_coral")));

    public static final VersionMap<Block> BUBBLE_CORAL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(595, "bubble_coral")));

    public static final VersionMap<Block> FIRE_CORAL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(596, "fire_coral")));

    public static final VersionMap<Block> HORN_CORAL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(597, "horn_coral")));

    public static final VersionMap<Block> DEAD_TUBE_CORAL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(598, "dead_tube_coral_fan")));

    public static final VersionMap<Block> DEAD_BRAIN_CORAL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(599, "dead_brain_coral_fan")));

    public static final VersionMap<Block> DEAD_BUBBLE_CORAL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(600, "dead_bubble_coral_fan")));

    public static final VersionMap<Block> DEAD_FIRE_CORAL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(601, "dead_fire_coral_fan")));

    public static final VersionMap<Block> DEAD_HORN_CORAL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(602, "dead_horn_coral_fan")));

    public static final VersionMap<Block> TUBE_CORAL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(603, "tube_coral_fan")));

    public static final VersionMap<Block> BRAIN_CORAL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(604, "brain_coral_fan")));

    public static final VersionMap<Block> BUBBLE_CORAL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(605, "bubble_coral_fan")));

    public static final VersionMap<Block> FIRE_CORAL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(606, "fire_coral_fan")));

    public static final VersionMap<Block> HORN_CORAL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(607, "horn_coral_fan")));

    public static final VersionMap<Block> DEAD_TUBE_CORAL_WALL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(608, "dead_tube_coral_wall_fan")));

    public static final VersionMap<Block> DEAD_BRAIN_CORAL_WALL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(609, "dead_brain_coral_wall_fan")));

    public static final VersionMap<Block> DEAD_BUBBLE_CORAL_WALL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(610, "dead_bubble_coral_wall_fan")));

    public static final VersionMap<Block> DEAD_FIRE_CORAL_WALL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(611, "dead_fire_coral_wall_fan")));

    public static final VersionMap<Block> DEAD_HORN_CORAL_WALL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(612, "dead_horn_coral_wall_fan")));

    public static final VersionMap<Block> TUBE_CORAL_WALL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(613, "tube_coral_wall_fan")));

    public static final VersionMap<Block> BRAIN_CORAL_WALL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(614, "brain_coral_wall_fan")));

    public static final VersionMap<Block> BUBBLE_CORAL_WALL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(615, "bubble_coral_wall_fan")));

    public static final VersionMap<Block> FIRE_CORAL_WALL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(616, "fire_coral_wall_fan")));

    public static final VersionMap<Block> HORN_CORAL_WALL_FAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(617, "horn_coral_wall_fan")));

    public static final VersionMap<Block> SEA_PICKLE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(618, "sea_pickle")));

    public static final VersionMap<Block> BLUE_ICE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(619, "blue_ice")));

    public static final VersionMap<Block> CONDUIT_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(620, "conduit")));

    public static final VersionMap<Block> BAMBOO_SAPLING_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(621, "bamboo_sapling")));

    public static final VersionMap<Block> BAMBOO_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(622, "bamboo")));

    public static final VersionMap<Block> POTTED_BAMBOO_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(623, "potted_bamboo")));

    public static final VersionMap<Block> VOID_AIR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(624, "void_air")));

    public static final VersionMap<Block> CAVE_AIR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(625, "cave_air")));

    public static final VersionMap<Block> BUBBLE_COLUMN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(626, "bubble_column")));

    public static final VersionMap<Block> POLISHED_GRANITE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(627, "polished_granite_stairs")));

    public static final VersionMap<Block> SMOOTH_RED_SANDSTONE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(628, "smooth_red_sandstone_stairs")));

    public static final VersionMap<Block> MOSSY_STONE_BRICK_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(629, "mossy_stone_brick_stairs")));

    public static final VersionMap<Block> POLISHED_DIORITE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(630, "polished_diorite_stairs")));

    public static final VersionMap<Block> MOSSY_COBBLESTONE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(631, "mossy_cobblestone_stairs")));

    public static final VersionMap<Block> END_STONE_BRICK_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(632, "end_stone_brick_stairs")));

    public static final VersionMap<Block> STONE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(633, "stone_stairs")));

    public static final VersionMap<Block> SMOOTH_SANDSTONE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(634, "smooth_sandstone_stairs")));

    public static final VersionMap<Block> SMOOTH_QUARTZ_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(635, "smooth_quartz_stairs")));

    public static final VersionMap<Block> GRANITE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(636, "granite_stairs")));

    public static final VersionMap<Block> ANDESITE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(637, "andesite_stairs")));

    public static final VersionMap<Block> RED_NETHER_BRICK_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(638, "red_nether_brick_stairs")));

    public static final VersionMap<Block> POLISHED_ANDESITE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(639, "polished_andesite_stairs")));

    public static final VersionMap<Block> DIORITE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(640, "diorite_stairs")));

    public static final VersionMap<Block> POLISHED_GRANITE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(641, "polished_granite_slab")));

    public static final VersionMap<Block> SMOOTH_RED_SANDSTONE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(642, "smooth_red_sandstone_slab")));

    public static final VersionMap<Block> MOSSY_STONE_BRICK_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(643, "mossy_stone_brick_slab")));

    public static final VersionMap<Block> POLISHED_DIORITE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(644, "polished_diorite_slab")));

    public static final VersionMap<Block> MOSSY_COBBLESTONE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(645, "mossy_cobblestone_slab")));

    public static final VersionMap<Block> END_STONE_BRICK_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(646, "end_stone_brick_slab")));

    public static final VersionMap<Block> SMOOTH_SANDSTONE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(647, "smooth_sandstone_slab")));

    public static final VersionMap<Block> SMOOTH_QUARTZ_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(648, "smooth_quartz_slab")));

    public static final VersionMap<Block> GRANITE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(649, "granite_slab")));

    public static final VersionMap<Block> ANDESITE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(650, "andesite_slab")));

    public static final VersionMap<Block> RED_NETHER_BRICK_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(651, "red_nether_brick_slab")));

    public static final VersionMap<Block> POLISHED_ANDESITE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(652, "polished_andesite_slab")));

    public static final VersionMap<Block> DIORITE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(653, "diorite_slab")));

    public static final VersionMap<Block> BRICK_WALL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(654, "brick_wall")));

    public static final VersionMap<Block> PRISMARINE_WALL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(655, "prismarine_wall")));

    public static final VersionMap<Block> RED_SANDSTONE_WALL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(656, "red_sandstone_wall")));

    public static final VersionMap<Block> MOSSY_STONE_BRICK_WALL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(657, "mossy_stone_brick_wall")));

    public static final VersionMap<Block> GRANITE_WALL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(658, "granite_wall")));

    public static final VersionMap<Block> STONE_BRICK_WALL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(659, "stone_brick_wall")));

    public static final VersionMap<Block> NETHER_BRICK_WALL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(660, "nether_brick_wall")));

    public static final VersionMap<Block> ANDESITE_WALL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(661, "andesite_wall")));

    public static final VersionMap<Block> RED_NETHER_BRICK_WALL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(662, "red_nether_brick_wall")));

    public static final VersionMap<Block> SANDSTONE_WALL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(663, "sandstone_wall")));

    public static final VersionMap<Block> END_STONE_BRICK_WALL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(664, "end_stone_brick_wall")));

    public static final VersionMap<Block> DIORITE_WALL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(665, "diorite_wall")));

    public static final VersionMap<Block> SCAFFOLDING_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(666, "scaffolding")));

    public static final VersionMap<Block> LOOM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(667, "loom")));

    public static final VersionMap<Block> BARREL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(668, "barrel")));

    public static final VersionMap<Block> SMOKER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(669, "smoker")));

    public static final VersionMap<Block> BLAST_FURNACE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(670, "blast_furnace")));

    public static final VersionMap<Block> CARTOGRAPHY_TABLE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(671, "cartography_table")));

    public static final VersionMap<Block> FLETCHING_TABLE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(672, "fletching_table")));

    public static final VersionMap<Block> GRINDSTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(673, "grindstone")));

    public static final VersionMap<Block> LECTERN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(674, "lectern")));

    public static final VersionMap<Block> SMITHING_TABLE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(675, "smithing_table")));

    public static final VersionMap<Block> STONECUTTER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(676, "stonecutter")));

    public static final VersionMap<Block> BELL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(677, "bell")));

    public static final VersionMap<Block> LANTERN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(678, "lantern")));

    public static final VersionMap<Block> SOUL_LANTERN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(679, "soul_lantern")));

    public static final VersionMap<Block> CAMPFIRE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(680, "campfire")));

    public static final VersionMap<Block> SOUL_CAMPFIRE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(681, "soul_campfire")));

    public static final VersionMap<Block> SWEET_BERRY_BUSH_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(682, "sweet_berry_bush")));

    public static final VersionMap<Block> WARPED_STEM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(683, "warped_stem")));

    public static final VersionMap<Block> STRIPPED_WARPED_STEM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(684, "stripped_warped_stem")));

    public static final VersionMap<Block> WARPED_HYPHAE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(685, "warped_hyphae")));

    public static final VersionMap<Block> STRIPPED_WARPED_HYPHAE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(686, "stripped_warped_hyphae")));

    public static final VersionMap<Block> WARPED_NYLIUM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(687, "warped_nylium")));

    public static final VersionMap<Block> WARPED_FUNGUS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(688, "warped_fungus")));

    public static final VersionMap<Block> WARPED_WART_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(689, "warped_wart_block")));

    public static final VersionMap<Block> WARPED_ROOTS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(690, "warped_roots")));

    public static final VersionMap<Block> NETHER_SPROUTS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(691, "nether_sprouts")));

    public static final VersionMap<Block> CRIMSON_STEM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(692, "crimson_stem")));

    public static final VersionMap<Block> STRIPPED_CRIMSON_STEM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(693, "stripped_crimson_stem")));

    public static final VersionMap<Block> CRIMSON_HYPHAE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(694, "crimson_hyphae")));

    public static final VersionMap<Block> STRIPPED_CRIMSON_HYPHAE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(695, "stripped_crimson_hyphae")));

    public static final VersionMap<Block> CRIMSON_NYLIUM_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(696, "crimson_nylium")));

    public static final VersionMap<Block> CRIMSON_FUNGUS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(697, "crimson_fungus")));

    public static final VersionMap<Block> SHROOMLIGHT_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(698, "shroomlight")));

    public static final VersionMap<Block> WEEPING_VINES_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(699, "weeping_vines")));

    public static final VersionMap<Block> WEEPING_VINES_PLANT_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(700, "weeping_vines_plant")));

    public static final VersionMap<Block> TWISTING_VINES_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(701, "twisting_vines")));

    public static final VersionMap<Block> TWISTING_VINES_PLANT_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(702, "twisting_vines_plant")));

    public static final VersionMap<Block> CRIMSON_ROOTS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(703, "crimson_roots")));

    public static final VersionMap<Block> CRIMSON_PLANKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(704, "crimson_planks")));

    public static final VersionMap<Block> WARPED_PLANKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(705, "warped_planks")));

    public static final VersionMap<Block> CRIMSON_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(706, "crimson_slab")));

    public static final VersionMap<Block> WARPED_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(707, "warped_slab")));

    public static final VersionMap<Block> CRIMSON_PRESSURE_PLATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(708, "crimson_pressure_plate")));

    public static final VersionMap<Block> WARPED_PRESSURE_PLATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(709, "warped_pressure_plate")));

    public static final VersionMap<Block> CRIMSON_FENCE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(710, "crimson_fence")));

    public static final VersionMap<Block> WARPED_FENCE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(711, "warped_fence")));

    public static final VersionMap<Block> CRIMSON_TRAPDOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(712, "crimson_trapdoor")));

    public static final VersionMap<Block> WARPED_TRAPDOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(713, "warped_trapdoor")));

    public static final VersionMap<Block> CRIMSON_FENCE_GATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(714, "crimson_fence_gate")));

    public static final VersionMap<Block> WARPED_FENCE_GATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(715, "warped_fence_gate")));

    public static final VersionMap<Block> CRIMSON_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(716, "crimson_stairs")));

    public static final VersionMap<Block> WARPED_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(717, "warped_stairs")));

    public static final VersionMap<Block> CRIMSON_BUTTON_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(718, "crimson_button")));

    public static final VersionMap<Block> WARPED_BUTTON_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(719, "warped_button")));

    public static final VersionMap<Block> CRIMSON_DOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(720, "crimson_door")));

    public static final VersionMap<Block> WARPED_DOOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(721, "warped_door")));

    public static final VersionMap<Block> CRIMSON_SIGN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(722, "crimson_sign")));

    public static final VersionMap<Block> WARPED_SIGN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(723, "warped_sign")));

    public static final VersionMap<Block> CRIMSON_WALL_SIGN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(724, "crimson_wall_sign")));

    public static final VersionMap<Block> WARPED_WALL_SIGN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(725, "warped_wall_sign")));

    public static final VersionMap<Block> STRUCTURE_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_13, new Block(726, "structure_block")));

    public static final VersionMap<Block> JIGSAW_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(727, "jigsaw")));

    public static final VersionMap<Block> COMPOSTER_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_14, new Block(728, "composter")));

    public static final VersionMap<Block> TARGET_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_15, new Block(729, "target")));

    public static final VersionMap<Block> BEE_NEST_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_15, new Block(730, "bee_nest")));

    public static final VersionMap<Block> BEEHIVE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_15, new Block(731, "beehive")));

    public static final VersionMap<Block> HONEY_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_15, new Block(732, "honey_block")));

    public static final VersionMap<Block> HONEYCOMB_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_15, new Block(733, "honeycomb_block")));

    public static final VersionMap<Block> NETHERITE_BLOCK_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(734, "netherite_block")));

    public static final VersionMap<Block> ANCIENT_DEBRIS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(735, "ancient_debris")));

    public static final VersionMap<Block> CRYING_OBSIDIAN_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(736, "crying_obsidian")));

    public static final VersionMap<Block> RESPAWN_ANCHOR_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(737, "respawn_anchor")));

    public static final VersionMap<Block> POTTED_CRIMSON_FUNGUS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(738, "potted_crimson_fungus")));

    public static final VersionMap<Block> POTTED_WARPED_FUNGUS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(739, "potted_warped_fungus")));

    public static final VersionMap<Block> POTTED_CRIMSON_ROOTS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(740, "potted_crimson_roots")));

    public static final VersionMap<Block> POTTED_WARPED_ROOTS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(741, "potted_warped_roots")));

    public static final VersionMap<Block> LODESTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(742, "lodestone")));

    public static final VersionMap<Block> BLACKSTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(743, "blackstone")));

    public static final VersionMap<Block> BLACKSTONE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(744, "blackstone_stairs")));

    public static final VersionMap<Block> BLACKSTONE_WALL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(745, "blackstone_wall")));

    public static final VersionMap<Block> BLACKSTONE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(746, "blackstone_slab")));

    public static final VersionMap<Block> POLISHED_BLACKSTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(747, "polished_blackstone")));

    public static final VersionMap<Block> POLISHED_BLACKSTONE_BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(748, "polished_blackstone_bricks")));

    public static final VersionMap<Block> CRACKED_POLISHED_BLACKSTONE_BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(749, "cracked_polished_blackstone_bricks")));

    public static final VersionMap<Block> CHISELED_POLISHED_BLACKSTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(750, "chiseled_polished_blackstone")));

    public static final VersionMap<Block> POLISHED_BLACKSTONE_BRICK_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(751, "polished_blackstone_brick_slab")));

    public static final VersionMap<Block> POLISHED_BLACKSTONE_BRICK_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(752, "polished_blackstone_brick_stairs")));

    public static final VersionMap<Block> POLISHED_BLACKSTONE_BRICK_WALL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(753, "polished_blackstone_brick_wall")));

    public static final VersionMap<Block> GILDED_BLACKSTONE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(754, "gilded_blackstone")));

    public static final VersionMap<Block> POLISHED_BLACKSTONE_STAIRS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(755, "polished_blackstone_stairs")));

    public static final VersionMap<Block> POLISHED_BLACKSTONE_SLAB_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(756, "polished_blackstone_slab")));

    public static final VersionMap<Block> POLISHED_BLACKSTONE_PRESSURE_PLATE_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(757, "polished_blackstone_pressure_plate")));

    public static final VersionMap<Block> POLISHED_BLACKSTONE_BUTTON_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(758, "polished_blackstone_button")));

    public static final VersionMap<Block> POLISHED_BLACKSTONE_WALL_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(759, "polished_blackstone_wall")));

    public static final VersionMap<Block> CHISELED_NETHER_BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(760, "chiseled_nether_bricks")));

    public static final VersionMap<Block> CRACKED_NETHER_BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(761, "cracked_nether_bricks")));

    public static final VersionMap<Block> QUARTZ_BRICKS_ENTRY = register(new VersionMap<Block>()
            .add(MCVersion.v1_16, new Block(762, "quartz_bricks")));

    public static final Block AIR = AIR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STONE = STONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRANITE = GRANITE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_GRANITE = POLISHED_GRANITE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DIORITE = DIORITE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_DIORITE = POLISHED_DIORITE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ANDESITE = ANDESITE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_ANDESITE = POLISHED_ANDESITE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRASS_BLOCK = GRASS_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DIRT = DIRT_ENTRY.getAsOf(MCVersion.latest());
    public static final Block COARSE_DIRT = COARSE_DIRT_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PODZOL = PODZOL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block COBBLESTONE = COBBLESTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OAK_PLANKS = OAK_PLANKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SPRUCE_PLANKS = SPRUCE_PLANKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BIRCH_PLANKS = BIRCH_PLANKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JUNGLE_PLANKS = JUNGLE_PLANKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ACACIA_PLANKS = ACACIA_PLANKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_OAK_PLANKS = DARK_OAK_PLANKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OAK_SAPLING = OAK_SAPLING_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SPRUCE_SAPLING = SPRUCE_SAPLING_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BIRCH_SAPLING = BIRCH_SAPLING_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JUNGLE_SAPLING = JUNGLE_SAPLING_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ACACIA_SAPLING = ACACIA_SAPLING_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_OAK_SAPLING = DARK_OAK_SAPLING_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BEDROCK = BEDROCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WATER = WATER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LAVA = LAVA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SAND = SAND_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_SAND = RED_SAND_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRAVEL = GRAVEL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GOLD_ORE = GOLD_ORE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block IRON_ORE = IRON_ORE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block COAL_ORE = COAL_ORE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block NETHER_GOLD_ORE = NETHER_GOLD_ORE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OAK_LOG = OAK_LOG_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SPRUCE_LOG = SPRUCE_LOG_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BIRCH_LOG = BIRCH_LOG_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JUNGLE_LOG = JUNGLE_LOG_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ACACIA_LOG = ACACIA_LOG_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_OAK_LOG = DARK_OAK_LOG_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRIPPED_SPRUCE_LOG = STRIPPED_SPRUCE_LOG_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRIPPED_BIRCH_LOG = STRIPPED_BIRCH_LOG_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRIPPED_JUNGLE_LOG = STRIPPED_JUNGLE_LOG_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRIPPED_ACACIA_LOG = STRIPPED_ACACIA_LOG_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRIPPED_DARK_OAK_LOG = STRIPPED_DARK_OAK_LOG_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRIPPED_OAK_LOG = STRIPPED_OAK_LOG_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OAK_WOOD = OAK_WOOD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SPRUCE_WOOD = SPRUCE_WOOD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BIRCH_WOOD = BIRCH_WOOD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JUNGLE_WOOD = JUNGLE_WOOD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ACACIA_WOOD = ACACIA_WOOD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_OAK_WOOD = DARK_OAK_WOOD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRIPPED_OAK_WOOD = STRIPPED_OAK_WOOD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRIPPED_SPRUCE_WOOD = STRIPPED_SPRUCE_WOOD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRIPPED_BIRCH_WOOD = STRIPPED_BIRCH_WOOD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRIPPED_JUNGLE_WOOD = STRIPPED_JUNGLE_WOOD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRIPPED_ACACIA_WOOD = STRIPPED_ACACIA_WOOD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRIPPED_DARK_OAK_WOOD = STRIPPED_DARK_OAK_WOOD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OAK_LEAVES = OAK_LEAVES_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SPRUCE_LEAVES = SPRUCE_LEAVES_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BIRCH_LEAVES = BIRCH_LEAVES_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JUNGLE_LEAVES = JUNGLE_LEAVES_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ACACIA_LEAVES = ACACIA_LEAVES_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_OAK_LEAVES = DARK_OAK_LEAVES_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SPONGE = SPONGE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WET_SPONGE = WET_SPONGE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GLASS = GLASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LAPIS_ORE = LAPIS_ORE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LAPIS_BLOCK = LAPIS_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DISPENSER = DISPENSER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SANDSTONE = SANDSTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CHISELED_SANDSTONE = CHISELED_SANDSTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CUT_SANDSTONE = CUT_SANDSTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block NOTE_BLOCK = NOTE_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WHITE_BED = WHITE_BED_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ORANGE_BED = ORANGE_BED_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MAGENTA_BED = MAGENTA_BED_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_BLUE_BED = LIGHT_BLUE_BED_ENTRY.getAsOf(MCVersion.latest());
    public static final Block YELLOW_BED = YELLOW_BED_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIME_BED = LIME_BED_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PINK_BED = PINK_BED_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRAY_BED = GRAY_BED_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_GRAY_BED = LIGHT_GRAY_BED_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CYAN_BED = CYAN_BED_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PURPLE_BED = PURPLE_BED_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLUE_BED = BLUE_BED_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BROWN_BED = BROWN_BED_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GREEN_BED = GREEN_BED_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_BED = RED_BED_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLACK_BED = BLACK_BED_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POWERED_RAIL = POWERED_RAIL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DETECTOR_RAIL = DETECTOR_RAIL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STICKY_PISTON = STICKY_PISTON_ENTRY.getAsOf(MCVersion.latest());
    public static final Block COBWEB = COBWEB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRASS = GRASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block FERN = FERN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_BUSH = DEAD_BUSH_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SEAGRASS = SEAGRASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block TALL_SEAGRASS = TALL_SEAGRASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PISTON = PISTON_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PISTON_HEAD = PISTON_HEAD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WHITE_WOOL = WHITE_WOOL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ORANGE_WOOL = ORANGE_WOOL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MAGENTA_WOOL = MAGENTA_WOOL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_BLUE_WOOL = LIGHT_BLUE_WOOL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block YELLOW_WOOL = YELLOW_WOOL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIME_WOOL = LIME_WOOL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PINK_WOOL = PINK_WOOL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRAY_WOOL = GRAY_WOOL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_GRAY_WOOL = LIGHT_GRAY_WOOL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CYAN_WOOL = CYAN_WOOL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PURPLE_WOOL = PURPLE_WOOL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLUE_WOOL = BLUE_WOOL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BROWN_WOOL = BROWN_WOOL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GREEN_WOOL = GREEN_WOOL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_WOOL = RED_WOOL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLACK_WOOL = BLACK_WOOL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MOVING_PISTON = MOVING_PISTON_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DANDELION = DANDELION_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POPPY = POPPY_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLUE_ORCHID = BLUE_ORCHID_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ALLIUM = ALLIUM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block AZURE_BLUET = AZURE_BLUET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_TULIP = RED_TULIP_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ORANGE_TULIP = ORANGE_TULIP_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WHITE_TULIP = WHITE_TULIP_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PINK_TULIP = PINK_TULIP_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OXEYE_DAISY = OXEYE_DAISY_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CORNFLOWER = CORNFLOWER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WITHER_ROSE = WITHER_ROSE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LILY_OF_THE_VALLEY = LILY_OF_THE_VALLEY_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BROWN_MUSHROOM = BROWN_MUSHROOM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_MUSHROOM = RED_MUSHROOM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GOLD_BLOCK = GOLD_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block IRON_BLOCK = IRON_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BRICKS = BRICKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block TNT = TNT_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BOOKSHELF = BOOKSHELF_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MOSSY_COBBLESTONE = MOSSY_COBBLESTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OBSIDIAN = OBSIDIAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block TORCH = TORCH_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WALL_TORCH = WALL_TORCH_ENTRY.getAsOf(MCVersion.latest());
    public static final Block FIRE = FIRE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SOUL_FIRE = SOUL_FIRE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SPAWNER = SPAWNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OAK_STAIRS = OAK_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CHEST = CHEST_ENTRY.getAsOf(MCVersion.latest());
    public static final Block REDSTONE_WIRE = REDSTONE_WIRE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DIAMOND_ORE = DIAMOND_ORE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DIAMOND_BLOCK = DIAMOND_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRAFTING_TABLE = CRAFTING_TABLE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WHEAT = WHEAT_ENTRY.getAsOf(MCVersion.latest());
    public static final Block FARMLAND = FARMLAND_ENTRY.getAsOf(MCVersion.latest());
    public static final Block FURNACE = FURNACE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OAK_SIGN = OAK_SIGN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SPRUCE_SIGN = SPRUCE_SIGN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BIRCH_SIGN = BIRCH_SIGN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ACACIA_SIGN = ACACIA_SIGN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JUNGLE_SIGN = JUNGLE_SIGN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_OAK_SIGN = DARK_OAK_SIGN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OAK_DOOR = OAK_DOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LADDER = LADDER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RAIL = RAIL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block COBBLESTONE_STAIRS = COBBLESTONE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OAK_WALL_SIGN = OAK_WALL_SIGN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SPRUCE_WALL_SIGN = SPRUCE_WALL_SIGN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BIRCH_WALL_SIGN = BIRCH_WALL_SIGN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ACACIA_WALL_SIGN = ACACIA_WALL_SIGN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JUNGLE_WALL_SIGN = JUNGLE_WALL_SIGN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_OAK_WALL_SIGN = DARK_OAK_WALL_SIGN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LEVER = LEVER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STONE_PRESSURE_PLATE = STONE_PRESSURE_PLATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block IRON_DOOR = IRON_DOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OAK_PRESSURE_PLATE = OAK_PRESSURE_PLATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SPRUCE_PRESSURE_PLATE = SPRUCE_PRESSURE_PLATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BIRCH_PRESSURE_PLATE = BIRCH_PRESSURE_PLATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JUNGLE_PRESSURE_PLATE = JUNGLE_PRESSURE_PLATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ACACIA_PRESSURE_PLATE = ACACIA_PRESSURE_PLATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_OAK_PRESSURE_PLATE = DARK_OAK_PRESSURE_PLATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block REDSTONE_ORE = REDSTONE_ORE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block REDSTONE_TORCH = REDSTONE_TORCH_ENTRY.getAsOf(MCVersion.latest());
    public static final Block REDSTONE_WALL_TORCH = REDSTONE_WALL_TORCH_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STONE_BUTTON = STONE_BUTTON_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SNOW = SNOW_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ICE = ICE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SNOW_BLOCK = SNOW_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CACTUS = CACTUS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CLAY = CLAY_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SUGAR_CANE = SUGAR_CANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JUKEBOX = JUKEBOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OAK_FENCE = OAK_FENCE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PUMPKIN = PUMPKIN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block NETHERRACK = NETHERRACK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SOUL_SAND = SOUL_SAND_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SOUL_SOIL = SOUL_SOIL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BASALT = BASALT_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_BASALT = POLISHED_BASALT_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SOUL_TORCH = SOUL_TORCH_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SOUL_WALL_TORCH = SOUL_WALL_TORCH_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GLOWSTONE = GLOWSTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block NETHER_PORTAL = NETHER_PORTAL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CARVED_PUMPKIN = CARVED_PUMPKIN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JACK_O_LANTERN = JACK_O_LANTERN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CAKE = CAKE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block REPEATER = REPEATER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WHITE_STAINED_GLASS = WHITE_STAINED_GLASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ORANGE_STAINED_GLASS = ORANGE_STAINED_GLASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MAGENTA_STAINED_GLASS = MAGENTA_STAINED_GLASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_BLUE_STAINED_GLASS = LIGHT_BLUE_STAINED_GLASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block YELLOW_STAINED_GLASS = YELLOW_STAINED_GLASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIME_STAINED_GLASS = LIME_STAINED_GLASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PINK_STAINED_GLASS = PINK_STAINED_GLASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRAY_STAINED_GLASS = GRAY_STAINED_GLASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_GRAY_STAINED_GLASS = LIGHT_GRAY_STAINED_GLASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CYAN_STAINED_GLASS = CYAN_STAINED_GLASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PURPLE_STAINED_GLASS = PURPLE_STAINED_GLASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLUE_STAINED_GLASS = BLUE_STAINED_GLASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BROWN_STAINED_GLASS = BROWN_STAINED_GLASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GREEN_STAINED_GLASS = GREEN_STAINED_GLASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_STAINED_GLASS = RED_STAINED_GLASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLACK_STAINED_GLASS = BLACK_STAINED_GLASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OAK_TRAPDOOR = OAK_TRAPDOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SPRUCE_TRAPDOOR = SPRUCE_TRAPDOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BIRCH_TRAPDOOR = BIRCH_TRAPDOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JUNGLE_TRAPDOOR = JUNGLE_TRAPDOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ACACIA_TRAPDOOR = ACACIA_TRAPDOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_OAK_TRAPDOOR = DARK_OAK_TRAPDOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STONE_BRICKS = STONE_BRICKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MOSSY_STONE_BRICKS = MOSSY_STONE_BRICKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRACKED_STONE_BRICKS = CRACKED_STONE_BRICKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CHISELED_STONE_BRICKS = CHISELED_STONE_BRICKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block INFESTED_STONE = INFESTED_STONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block INFESTED_COBBLESTONE = INFESTED_COBBLESTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block INFESTED_STONE_BRICKS = INFESTED_STONE_BRICKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block INFESTED_MOSSY_STONE_BRICKS = INFESTED_MOSSY_STONE_BRICKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block INFESTED_CRACKED_STONE_BRICKS = INFESTED_CRACKED_STONE_BRICKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block INFESTED_CHISELED_STONE_BRICKS = INFESTED_CHISELED_STONE_BRICKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BROWN_MUSHROOM_BLOCK = BROWN_MUSHROOM_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_MUSHROOM_BLOCK = RED_MUSHROOM_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MUSHROOM_STEM = MUSHROOM_STEM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block IRON_BARS = IRON_BARS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CHAIN = CHAIN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GLASS_PANE = GLASS_PANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MELON = MELON_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ATTACHED_PUMPKIN_STEM = ATTACHED_PUMPKIN_STEM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ATTACHED_MELON_STEM = ATTACHED_MELON_STEM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PUMPKIN_STEM = PUMPKIN_STEM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MELON_STEM = MELON_STEM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block VINE = VINE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OAK_FENCE_GATE = OAK_FENCE_GATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BRICK_STAIRS = BRICK_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STONE_BRICK_STAIRS = STONE_BRICK_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MYCELIUM = MYCELIUM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LILY_PAD = LILY_PAD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block NETHER_BRICKS = NETHER_BRICKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block NETHER_BRICK_FENCE = NETHER_BRICK_FENCE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block NETHER_BRICK_STAIRS = NETHER_BRICK_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block NETHER_WART = NETHER_WART_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ENCHANTING_TABLE = ENCHANTING_TABLE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BREWING_STAND = BREWING_STAND_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CAULDRON = CAULDRON_ENTRY.getAsOf(MCVersion.latest());
    public static final Block END_PORTAL = END_PORTAL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block END_PORTAL_FRAME = END_PORTAL_FRAME_ENTRY.getAsOf(MCVersion.latest());
    public static final Block END_STONE = END_STONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DRAGON_EGG = DRAGON_EGG_ENTRY.getAsOf(MCVersion.latest());
    public static final Block REDSTONE_LAMP = REDSTONE_LAMP_ENTRY.getAsOf(MCVersion.latest());
    public static final Block COCOA = COCOA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SANDSTONE_STAIRS = SANDSTONE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block EMERALD_ORE = EMERALD_ORE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ENDER_CHEST = ENDER_CHEST_ENTRY.getAsOf(MCVersion.latest());
    public static final Block TRIPWIRE_HOOK = TRIPWIRE_HOOK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block TRIPWIRE = TRIPWIRE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block EMERALD_BLOCK = EMERALD_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SPRUCE_STAIRS = SPRUCE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BIRCH_STAIRS = BIRCH_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JUNGLE_STAIRS = JUNGLE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block COMMAND_BLOCK = COMMAND_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BEACON = BEACON_ENTRY.getAsOf(MCVersion.latest());
    public static final Block COBBLESTONE_WALL = COBBLESTONE_WALL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MOSSY_COBBLESTONE_WALL = MOSSY_COBBLESTONE_WALL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block FLOWER_POT = FLOWER_POT_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_OAK_SAPLING = POTTED_OAK_SAPLING_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_SPRUCE_SAPLING = POTTED_SPRUCE_SAPLING_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_BIRCH_SAPLING = POTTED_BIRCH_SAPLING_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_JUNGLE_SAPLING = POTTED_JUNGLE_SAPLING_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_ACACIA_SAPLING = POTTED_ACACIA_SAPLING_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_DARK_OAK_SAPLING = POTTED_DARK_OAK_SAPLING_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_FERN = POTTED_FERN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_DANDELION = POTTED_DANDELION_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_POPPY = POTTED_POPPY_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_BLUE_ORCHID = POTTED_BLUE_ORCHID_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_ALLIUM = POTTED_ALLIUM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_AZURE_BLUET = POTTED_AZURE_BLUET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_RED_TULIP = POTTED_RED_TULIP_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_ORANGE_TULIP = POTTED_ORANGE_TULIP_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_WHITE_TULIP = POTTED_WHITE_TULIP_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_PINK_TULIP = POTTED_PINK_TULIP_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_OXEYE_DAISY = POTTED_OXEYE_DAISY_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_CORNFLOWER = POTTED_CORNFLOWER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_LILY_OF_THE_VALLEY = POTTED_LILY_OF_THE_VALLEY_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_WITHER_ROSE = POTTED_WITHER_ROSE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_RED_MUSHROOM = POTTED_RED_MUSHROOM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_BROWN_MUSHROOM = POTTED_BROWN_MUSHROOM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_DEAD_BUSH = POTTED_DEAD_BUSH_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_CACTUS = POTTED_CACTUS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CARROTS = CARROTS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTATOES = POTATOES_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OAK_BUTTON = OAK_BUTTON_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SPRUCE_BUTTON = SPRUCE_BUTTON_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BIRCH_BUTTON = BIRCH_BUTTON_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JUNGLE_BUTTON = JUNGLE_BUTTON_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ACACIA_BUTTON = ACACIA_BUTTON_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_OAK_BUTTON = DARK_OAK_BUTTON_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SKELETON_SKULL = SKELETON_SKULL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SKELETON_WALL_SKULL = SKELETON_WALL_SKULL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WITHER_SKELETON_SKULL = WITHER_SKELETON_SKULL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WITHER_SKELETON_WALL_SKULL = WITHER_SKELETON_WALL_SKULL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ZOMBIE_HEAD = ZOMBIE_HEAD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ZOMBIE_WALL_HEAD = ZOMBIE_WALL_HEAD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PLAYER_HEAD = PLAYER_HEAD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PLAYER_WALL_HEAD = PLAYER_WALL_HEAD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CREEPER_HEAD = CREEPER_HEAD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CREEPER_WALL_HEAD = CREEPER_WALL_HEAD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DRAGON_HEAD = DRAGON_HEAD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DRAGON_WALL_HEAD = DRAGON_WALL_HEAD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ANVIL = ANVIL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CHIPPED_ANVIL = CHIPPED_ANVIL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DAMAGED_ANVIL = DAMAGED_ANVIL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block TRAPPED_CHEST = TRAPPED_CHEST_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_WEIGHTED_PRESSURE_PLATE = LIGHT_WEIGHTED_PRESSURE_PLATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block HEAVY_WEIGHTED_PRESSURE_PLATE = HEAVY_WEIGHTED_PRESSURE_PLATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block COMPARATOR = COMPARATOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DAYLIGHT_DETECTOR = DAYLIGHT_DETECTOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block REDSTONE_BLOCK = REDSTONE_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block NETHER_QUARTZ_ORE = NETHER_QUARTZ_ORE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block HOPPER = HOPPER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block QUARTZ_BLOCK = QUARTZ_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CHISELED_QUARTZ_BLOCK = CHISELED_QUARTZ_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block QUARTZ_PILLAR = QUARTZ_PILLAR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block QUARTZ_STAIRS = QUARTZ_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ACTIVATOR_RAIL = ACTIVATOR_RAIL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DROPPER = DROPPER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WHITE_TERRACOTTA = WHITE_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ORANGE_TERRACOTTA = ORANGE_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MAGENTA_TERRACOTTA = MAGENTA_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_BLUE_TERRACOTTA = LIGHT_BLUE_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block YELLOW_TERRACOTTA = YELLOW_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIME_TERRACOTTA = LIME_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PINK_TERRACOTTA = PINK_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRAY_TERRACOTTA = GRAY_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_GRAY_TERRACOTTA = LIGHT_GRAY_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CYAN_TERRACOTTA = CYAN_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PURPLE_TERRACOTTA = PURPLE_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLUE_TERRACOTTA = BLUE_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BROWN_TERRACOTTA = BROWN_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GREEN_TERRACOTTA = GREEN_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_TERRACOTTA = RED_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLACK_TERRACOTTA = BLACK_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WHITE_STAINED_GLASS_PANE = WHITE_STAINED_GLASS_PANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ORANGE_STAINED_GLASS_PANE = ORANGE_STAINED_GLASS_PANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MAGENTA_STAINED_GLASS_PANE = MAGENTA_STAINED_GLASS_PANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_BLUE_STAINED_GLASS_PANE = LIGHT_BLUE_STAINED_GLASS_PANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block YELLOW_STAINED_GLASS_PANE = YELLOW_STAINED_GLASS_PANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIME_STAINED_GLASS_PANE = LIME_STAINED_GLASS_PANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PINK_STAINED_GLASS_PANE = PINK_STAINED_GLASS_PANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRAY_STAINED_GLASS_PANE = GRAY_STAINED_GLASS_PANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_GRAY_STAINED_GLASS_PANE = LIGHT_GRAY_STAINED_GLASS_PANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CYAN_STAINED_GLASS_PANE = CYAN_STAINED_GLASS_PANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PURPLE_STAINED_GLASS_PANE = PURPLE_STAINED_GLASS_PANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLUE_STAINED_GLASS_PANE = BLUE_STAINED_GLASS_PANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BROWN_STAINED_GLASS_PANE = BROWN_STAINED_GLASS_PANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GREEN_STAINED_GLASS_PANE = GREEN_STAINED_GLASS_PANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_STAINED_GLASS_PANE = RED_STAINED_GLASS_PANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLACK_STAINED_GLASS_PANE = BLACK_STAINED_GLASS_PANE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ACACIA_STAIRS = ACACIA_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_OAK_STAIRS = DARK_OAK_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SLIME_BLOCK = SLIME_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BARRIER = BARRIER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block IRON_TRAPDOOR = IRON_TRAPDOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PRISMARINE = PRISMARINE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PRISMARINE_BRICKS = PRISMARINE_BRICKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_PRISMARINE = DARK_PRISMARINE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PRISMARINE_STAIRS = PRISMARINE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PRISMARINE_BRICK_STAIRS = PRISMARINE_BRICK_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_PRISMARINE_STAIRS = DARK_PRISMARINE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PRISMARINE_SLAB = PRISMARINE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PRISMARINE_BRICK_SLAB = PRISMARINE_BRICK_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_PRISMARINE_SLAB = DARK_PRISMARINE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SEA_LANTERN = SEA_LANTERN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block HAY_BLOCK = HAY_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WHITE_CARPET = WHITE_CARPET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ORANGE_CARPET = ORANGE_CARPET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MAGENTA_CARPET = MAGENTA_CARPET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_BLUE_CARPET = LIGHT_BLUE_CARPET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block YELLOW_CARPET = YELLOW_CARPET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIME_CARPET = LIME_CARPET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PINK_CARPET = PINK_CARPET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRAY_CARPET = GRAY_CARPET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_GRAY_CARPET = LIGHT_GRAY_CARPET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CYAN_CARPET = CYAN_CARPET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PURPLE_CARPET = PURPLE_CARPET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLUE_CARPET = BLUE_CARPET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BROWN_CARPET = BROWN_CARPET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GREEN_CARPET = GREEN_CARPET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_CARPET = RED_CARPET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLACK_CARPET = BLACK_CARPET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block TERRACOTTA = TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block COAL_BLOCK = COAL_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PACKED_ICE = PACKED_ICE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SUNFLOWER = SUNFLOWER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LILAC = LILAC_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ROSE_BUSH = ROSE_BUSH_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PEONY = PEONY_ENTRY.getAsOf(MCVersion.latest());
    public static final Block TALL_GRASS = TALL_GRASS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LARGE_FERN = LARGE_FERN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WHITE_BANNER = WHITE_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ORANGE_BANNER = ORANGE_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MAGENTA_BANNER = MAGENTA_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_BLUE_BANNER = LIGHT_BLUE_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block YELLOW_BANNER = YELLOW_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIME_BANNER = LIME_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PINK_BANNER = PINK_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRAY_BANNER = GRAY_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_GRAY_BANNER = LIGHT_GRAY_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CYAN_BANNER = CYAN_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PURPLE_BANNER = PURPLE_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLUE_BANNER = BLUE_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BROWN_BANNER = BROWN_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GREEN_BANNER = GREEN_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_BANNER = RED_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLACK_BANNER = BLACK_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WHITE_WALL_BANNER = WHITE_WALL_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ORANGE_WALL_BANNER = ORANGE_WALL_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MAGENTA_WALL_BANNER = MAGENTA_WALL_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_BLUE_WALL_BANNER = LIGHT_BLUE_WALL_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block YELLOW_WALL_BANNER = YELLOW_WALL_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIME_WALL_BANNER = LIME_WALL_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PINK_WALL_BANNER = PINK_WALL_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRAY_WALL_BANNER = GRAY_WALL_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_GRAY_WALL_BANNER = LIGHT_GRAY_WALL_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CYAN_WALL_BANNER = CYAN_WALL_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PURPLE_WALL_BANNER = PURPLE_WALL_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLUE_WALL_BANNER = BLUE_WALL_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BROWN_WALL_BANNER = BROWN_WALL_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GREEN_WALL_BANNER = GREEN_WALL_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_WALL_BANNER = RED_WALL_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLACK_WALL_BANNER = BLACK_WALL_BANNER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_SANDSTONE = RED_SANDSTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CHISELED_RED_SANDSTONE = CHISELED_RED_SANDSTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CUT_RED_SANDSTONE = CUT_RED_SANDSTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_SANDSTONE_STAIRS = RED_SANDSTONE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OAK_SLAB = OAK_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SPRUCE_SLAB = SPRUCE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BIRCH_SLAB = BIRCH_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JUNGLE_SLAB = JUNGLE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ACACIA_SLAB = ACACIA_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_OAK_SLAB = DARK_OAK_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STONE_SLAB = STONE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SMOOTH_STONE_SLAB = SMOOTH_STONE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SANDSTONE_SLAB = SANDSTONE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CUT_SANDSTONE_SLAB = CUT_SANDSTONE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PETRIFIED_OAK_SLAB = PETRIFIED_OAK_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block COBBLESTONE_SLAB = COBBLESTONE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BRICK_SLAB = BRICK_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STONE_BRICK_SLAB = STONE_BRICK_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block NETHER_BRICK_SLAB = NETHER_BRICK_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block QUARTZ_SLAB = QUARTZ_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_SANDSTONE_SLAB = RED_SANDSTONE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CUT_RED_SANDSTONE_SLAB = CUT_RED_SANDSTONE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PURPUR_SLAB = PURPUR_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SMOOTH_STONE = SMOOTH_STONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SMOOTH_SANDSTONE = SMOOTH_SANDSTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SMOOTH_QUARTZ = SMOOTH_QUARTZ_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SMOOTH_RED_SANDSTONE = SMOOTH_RED_SANDSTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SPRUCE_FENCE_GATE = SPRUCE_FENCE_GATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BIRCH_FENCE_GATE = BIRCH_FENCE_GATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JUNGLE_FENCE_GATE = JUNGLE_FENCE_GATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ACACIA_FENCE_GATE = ACACIA_FENCE_GATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_OAK_FENCE_GATE = DARK_OAK_FENCE_GATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SPRUCE_FENCE = SPRUCE_FENCE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BIRCH_FENCE = BIRCH_FENCE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JUNGLE_FENCE = JUNGLE_FENCE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ACACIA_FENCE = ACACIA_FENCE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_OAK_FENCE = DARK_OAK_FENCE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SPRUCE_DOOR = SPRUCE_DOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BIRCH_DOOR = BIRCH_DOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JUNGLE_DOOR = JUNGLE_DOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ACACIA_DOOR = ACACIA_DOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DARK_OAK_DOOR = DARK_OAK_DOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block END_ROD = END_ROD_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CHORUS_PLANT = CHORUS_PLANT_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CHORUS_FLOWER = CHORUS_FLOWER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PURPUR_BLOCK = PURPUR_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PURPUR_PILLAR = PURPUR_PILLAR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PURPUR_STAIRS = PURPUR_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block END_STONE_BRICKS = END_STONE_BRICKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BEETROOTS = BEETROOTS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRASS_PATH = GRASS_PATH_ENTRY.getAsOf(MCVersion.latest());
    public static final Block END_GATEWAY = END_GATEWAY_ENTRY.getAsOf(MCVersion.latest());
    public static final Block REPEATING_COMMAND_BLOCK = REPEATING_COMMAND_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CHAIN_COMMAND_BLOCK = CHAIN_COMMAND_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block FROSTED_ICE = FROSTED_ICE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MAGMA_BLOCK = MAGMA_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block NETHER_WART_BLOCK = NETHER_WART_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_NETHER_BRICKS = RED_NETHER_BRICKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BONE_BLOCK = BONE_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRUCTURE_VOID = STRUCTURE_VOID_ENTRY.getAsOf(MCVersion.latest());
    public static final Block OBSERVER = OBSERVER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SHULKER_BOX = SHULKER_BOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WHITE_SHULKER_BOX = WHITE_SHULKER_BOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ORANGE_SHULKER_BOX = ORANGE_SHULKER_BOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MAGENTA_SHULKER_BOX = MAGENTA_SHULKER_BOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_BLUE_SHULKER_BOX = LIGHT_BLUE_SHULKER_BOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block YELLOW_SHULKER_BOX = YELLOW_SHULKER_BOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIME_SHULKER_BOX = LIME_SHULKER_BOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PINK_SHULKER_BOX = PINK_SHULKER_BOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRAY_SHULKER_BOX = GRAY_SHULKER_BOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_GRAY_SHULKER_BOX = LIGHT_GRAY_SHULKER_BOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CYAN_SHULKER_BOX = CYAN_SHULKER_BOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PURPLE_SHULKER_BOX = PURPLE_SHULKER_BOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLUE_SHULKER_BOX = BLUE_SHULKER_BOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BROWN_SHULKER_BOX = BROWN_SHULKER_BOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GREEN_SHULKER_BOX = GREEN_SHULKER_BOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_SHULKER_BOX = RED_SHULKER_BOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLACK_SHULKER_BOX = BLACK_SHULKER_BOX_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WHITE_GLAZED_TERRACOTTA = WHITE_GLAZED_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ORANGE_GLAZED_TERRACOTTA = ORANGE_GLAZED_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MAGENTA_GLAZED_TERRACOTTA = MAGENTA_GLAZED_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_BLUE_GLAZED_TERRACOTTA = LIGHT_BLUE_GLAZED_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block YELLOW_GLAZED_TERRACOTTA = YELLOW_GLAZED_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIME_GLAZED_TERRACOTTA = LIME_GLAZED_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PINK_GLAZED_TERRACOTTA = PINK_GLAZED_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRAY_GLAZED_TERRACOTTA = GRAY_GLAZED_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_GRAY_GLAZED_TERRACOTTA = LIGHT_GRAY_GLAZED_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CYAN_GLAZED_TERRACOTTA = CYAN_GLAZED_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PURPLE_GLAZED_TERRACOTTA = PURPLE_GLAZED_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLUE_GLAZED_TERRACOTTA = BLUE_GLAZED_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BROWN_GLAZED_TERRACOTTA = BROWN_GLAZED_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GREEN_GLAZED_TERRACOTTA = GREEN_GLAZED_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_GLAZED_TERRACOTTA = RED_GLAZED_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLACK_GLAZED_TERRACOTTA = BLACK_GLAZED_TERRACOTTA_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WHITE_CONCRETE = WHITE_CONCRETE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ORANGE_CONCRETE = ORANGE_CONCRETE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MAGENTA_CONCRETE = MAGENTA_CONCRETE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_BLUE_CONCRETE = LIGHT_BLUE_CONCRETE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block YELLOW_CONCRETE = YELLOW_CONCRETE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIME_CONCRETE = LIME_CONCRETE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PINK_CONCRETE = PINK_CONCRETE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRAY_CONCRETE = GRAY_CONCRETE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_GRAY_CONCRETE = LIGHT_GRAY_CONCRETE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CYAN_CONCRETE = CYAN_CONCRETE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PURPLE_CONCRETE = PURPLE_CONCRETE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLUE_CONCRETE = BLUE_CONCRETE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BROWN_CONCRETE = BROWN_CONCRETE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GREEN_CONCRETE = GREEN_CONCRETE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_CONCRETE = RED_CONCRETE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLACK_CONCRETE = BLACK_CONCRETE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WHITE_CONCRETE_POWDER = WHITE_CONCRETE_POWDER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ORANGE_CONCRETE_POWDER = ORANGE_CONCRETE_POWDER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MAGENTA_CONCRETE_POWDER = MAGENTA_CONCRETE_POWDER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_BLUE_CONCRETE_POWDER = LIGHT_BLUE_CONCRETE_POWDER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block YELLOW_CONCRETE_POWDER = YELLOW_CONCRETE_POWDER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIME_CONCRETE_POWDER = LIME_CONCRETE_POWDER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PINK_CONCRETE_POWDER = PINK_CONCRETE_POWDER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRAY_CONCRETE_POWDER = GRAY_CONCRETE_POWDER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LIGHT_GRAY_CONCRETE_POWDER = LIGHT_GRAY_CONCRETE_POWDER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CYAN_CONCRETE_POWDER = CYAN_CONCRETE_POWDER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PURPLE_CONCRETE_POWDER = PURPLE_CONCRETE_POWDER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLUE_CONCRETE_POWDER = BLUE_CONCRETE_POWDER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BROWN_CONCRETE_POWDER = BROWN_CONCRETE_POWDER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GREEN_CONCRETE_POWDER = GREEN_CONCRETE_POWDER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_CONCRETE_POWDER = RED_CONCRETE_POWDER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLACK_CONCRETE_POWDER = BLACK_CONCRETE_POWDER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block KELP = KELP_ENTRY.getAsOf(MCVersion.latest());
    public static final Block KELP_PLANT = KELP_PLANT_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DRIED_KELP_BLOCK = DRIED_KELP_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block TURTLE_EGG = TURTLE_EGG_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_TUBE_CORAL_BLOCK = DEAD_TUBE_CORAL_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_BRAIN_CORAL_BLOCK = DEAD_BRAIN_CORAL_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_BUBBLE_CORAL_BLOCK = DEAD_BUBBLE_CORAL_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_FIRE_CORAL_BLOCK = DEAD_FIRE_CORAL_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_HORN_CORAL_BLOCK = DEAD_HORN_CORAL_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block TUBE_CORAL_BLOCK = TUBE_CORAL_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BRAIN_CORAL_BLOCK = BRAIN_CORAL_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BUBBLE_CORAL_BLOCK = BUBBLE_CORAL_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block FIRE_CORAL_BLOCK = FIRE_CORAL_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block HORN_CORAL_BLOCK = HORN_CORAL_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_TUBE_CORAL = DEAD_TUBE_CORAL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_BRAIN_CORAL = DEAD_BRAIN_CORAL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_BUBBLE_CORAL = DEAD_BUBBLE_CORAL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_FIRE_CORAL = DEAD_FIRE_CORAL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_HORN_CORAL = DEAD_HORN_CORAL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block TUBE_CORAL = TUBE_CORAL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BRAIN_CORAL = BRAIN_CORAL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BUBBLE_CORAL = BUBBLE_CORAL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block FIRE_CORAL = FIRE_CORAL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block HORN_CORAL = HORN_CORAL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_TUBE_CORAL_FAN = DEAD_TUBE_CORAL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_BRAIN_CORAL_FAN = DEAD_BRAIN_CORAL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_BUBBLE_CORAL_FAN = DEAD_BUBBLE_CORAL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_FIRE_CORAL_FAN = DEAD_FIRE_CORAL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_HORN_CORAL_FAN = DEAD_HORN_CORAL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block TUBE_CORAL_FAN = TUBE_CORAL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BRAIN_CORAL_FAN = BRAIN_CORAL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BUBBLE_CORAL_FAN = BUBBLE_CORAL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block FIRE_CORAL_FAN = FIRE_CORAL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block HORN_CORAL_FAN = HORN_CORAL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_TUBE_CORAL_WALL_FAN = DEAD_TUBE_CORAL_WALL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_BRAIN_CORAL_WALL_FAN = DEAD_BRAIN_CORAL_WALL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_BUBBLE_CORAL_WALL_FAN = DEAD_BUBBLE_CORAL_WALL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_FIRE_CORAL_WALL_FAN = DEAD_FIRE_CORAL_WALL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DEAD_HORN_CORAL_WALL_FAN = DEAD_HORN_CORAL_WALL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block TUBE_CORAL_WALL_FAN = TUBE_CORAL_WALL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BRAIN_CORAL_WALL_FAN = BRAIN_CORAL_WALL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BUBBLE_CORAL_WALL_FAN = BUBBLE_CORAL_WALL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block FIRE_CORAL_WALL_FAN = FIRE_CORAL_WALL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block HORN_CORAL_WALL_FAN = HORN_CORAL_WALL_FAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SEA_PICKLE = SEA_PICKLE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLUE_ICE = BLUE_ICE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CONDUIT = CONDUIT_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BAMBOO_SAPLING = BAMBOO_SAPLING_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BAMBOO = BAMBOO_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_BAMBOO = POTTED_BAMBOO_ENTRY.getAsOf(MCVersion.latest());
    public static final Block VOID_AIR = VOID_AIR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CAVE_AIR = CAVE_AIR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BUBBLE_COLUMN = BUBBLE_COLUMN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_GRANITE_STAIRS = POLISHED_GRANITE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SMOOTH_RED_SANDSTONE_STAIRS = SMOOTH_RED_SANDSTONE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MOSSY_STONE_BRICK_STAIRS = MOSSY_STONE_BRICK_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_DIORITE_STAIRS = POLISHED_DIORITE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MOSSY_COBBLESTONE_STAIRS = MOSSY_COBBLESTONE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block END_STONE_BRICK_STAIRS = END_STONE_BRICK_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STONE_STAIRS = STONE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SMOOTH_SANDSTONE_STAIRS = SMOOTH_SANDSTONE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SMOOTH_QUARTZ_STAIRS = SMOOTH_QUARTZ_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRANITE_STAIRS = GRANITE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ANDESITE_STAIRS = ANDESITE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_NETHER_BRICK_STAIRS = RED_NETHER_BRICK_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_ANDESITE_STAIRS = POLISHED_ANDESITE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DIORITE_STAIRS = DIORITE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_GRANITE_SLAB = POLISHED_GRANITE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SMOOTH_RED_SANDSTONE_SLAB = SMOOTH_RED_SANDSTONE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MOSSY_STONE_BRICK_SLAB = MOSSY_STONE_BRICK_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_DIORITE_SLAB = POLISHED_DIORITE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MOSSY_COBBLESTONE_SLAB = MOSSY_COBBLESTONE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block END_STONE_BRICK_SLAB = END_STONE_BRICK_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SMOOTH_SANDSTONE_SLAB = SMOOTH_SANDSTONE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SMOOTH_QUARTZ_SLAB = SMOOTH_QUARTZ_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRANITE_SLAB = GRANITE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ANDESITE_SLAB = ANDESITE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_NETHER_BRICK_SLAB = RED_NETHER_BRICK_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_ANDESITE_SLAB = POLISHED_ANDESITE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DIORITE_SLAB = DIORITE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BRICK_WALL = BRICK_WALL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block PRISMARINE_WALL = PRISMARINE_WALL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_SANDSTONE_WALL = RED_SANDSTONE_WALL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block MOSSY_STONE_BRICK_WALL = MOSSY_STONE_BRICK_WALL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRANITE_WALL = GRANITE_WALL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STONE_BRICK_WALL = STONE_BRICK_WALL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block NETHER_BRICK_WALL = NETHER_BRICK_WALL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ANDESITE_WALL = ANDESITE_WALL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RED_NETHER_BRICK_WALL = RED_NETHER_BRICK_WALL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SANDSTONE_WALL = SANDSTONE_WALL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block END_STONE_BRICK_WALL = END_STONE_BRICK_WALL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block DIORITE_WALL = DIORITE_WALL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SCAFFOLDING = SCAFFOLDING_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LOOM = LOOM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BARREL = BARREL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SMOKER = SMOKER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLAST_FURNACE = BLAST_FURNACE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CARTOGRAPHY_TABLE = CARTOGRAPHY_TABLE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block FLETCHING_TABLE = FLETCHING_TABLE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GRINDSTONE = GRINDSTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LECTERN = LECTERN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SMITHING_TABLE = SMITHING_TABLE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STONECUTTER = STONECUTTER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BELL = BELL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LANTERN = LANTERN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SOUL_LANTERN = SOUL_LANTERN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CAMPFIRE = CAMPFIRE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SOUL_CAMPFIRE = SOUL_CAMPFIRE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SWEET_BERRY_BUSH = SWEET_BERRY_BUSH_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WARPED_STEM = WARPED_STEM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRIPPED_WARPED_STEM = STRIPPED_WARPED_STEM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WARPED_HYPHAE = WARPED_HYPHAE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRIPPED_WARPED_HYPHAE = STRIPPED_WARPED_HYPHAE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WARPED_NYLIUM = WARPED_NYLIUM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WARPED_FUNGUS = WARPED_FUNGUS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WARPED_WART_BLOCK = WARPED_WART_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WARPED_ROOTS = WARPED_ROOTS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block NETHER_SPROUTS = NETHER_SPROUTS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRIMSON_STEM = CRIMSON_STEM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRIPPED_CRIMSON_STEM = STRIPPED_CRIMSON_STEM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRIMSON_HYPHAE = CRIMSON_HYPHAE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRIPPED_CRIMSON_HYPHAE = STRIPPED_CRIMSON_HYPHAE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRIMSON_NYLIUM = CRIMSON_NYLIUM_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRIMSON_FUNGUS = CRIMSON_FUNGUS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block SHROOMLIGHT = SHROOMLIGHT_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WEEPING_VINES = WEEPING_VINES_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WEEPING_VINES_PLANT = WEEPING_VINES_PLANT_ENTRY.getAsOf(MCVersion.latest());
    public static final Block TWISTING_VINES = TWISTING_VINES_ENTRY.getAsOf(MCVersion.latest());
    public static final Block TWISTING_VINES_PLANT = TWISTING_VINES_PLANT_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRIMSON_ROOTS = CRIMSON_ROOTS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRIMSON_PLANKS = CRIMSON_PLANKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WARPED_PLANKS = WARPED_PLANKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRIMSON_SLAB = CRIMSON_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WARPED_SLAB = WARPED_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRIMSON_PRESSURE_PLATE = CRIMSON_PRESSURE_PLATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WARPED_PRESSURE_PLATE = WARPED_PRESSURE_PLATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRIMSON_FENCE = CRIMSON_FENCE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WARPED_FENCE = WARPED_FENCE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRIMSON_TRAPDOOR = CRIMSON_TRAPDOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WARPED_TRAPDOOR = WARPED_TRAPDOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRIMSON_FENCE_GATE = CRIMSON_FENCE_GATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WARPED_FENCE_GATE = WARPED_FENCE_GATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRIMSON_STAIRS = CRIMSON_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WARPED_STAIRS = WARPED_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRIMSON_BUTTON = CRIMSON_BUTTON_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WARPED_BUTTON = WARPED_BUTTON_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRIMSON_DOOR = CRIMSON_DOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WARPED_DOOR = WARPED_DOOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRIMSON_SIGN = CRIMSON_SIGN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WARPED_SIGN = WARPED_SIGN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRIMSON_WALL_SIGN = CRIMSON_WALL_SIGN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block WARPED_WALL_SIGN = WARPED_WALL_SIGN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block STRUCTURE_BLOCK = STRUCTURE_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block JIGSAW = JIGSAW_ENTRY.getAsOf(MCVersion.latest());
    public static final Block COMPOSTER = COMPOSTER_ENTRY.getAsOf(MCVersion.latest());
    public static final Block TARGET = TARGET_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BEE_NEST = BEE_NEST_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BEEHIVE = BEEHIVE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block HONEY_BLOCK = HONEY_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block HONEYCOMB_BLOCK = HONEYCOMB_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block NETHERITE_BLOCK = NETHERITE_BLOCK_ENTRY.getAsOf(MCVersion.latest());
    public static final Block ANCIENT_DEBRIS = ANCIENT_DEBRIS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRYING_OBSIDIAN = CRYING_OBSIDIAN_ENTRY.getAsOf(MCVersion.latest());
    public static final Block RESPAWN_ANCHOR = RESPAWN_ANCHOR_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_CRIMSON_FUNGUS = POTTED_CRIMSON_FUNGUS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_WARPED_FUNGUS = POTTED_WARPED_FUNGUS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_CRIMSON_ROOTS = POTTED_CRIMSON_ROOTS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POTTED_WARPED_ROOTS = POTTED_WARPED_ROOTS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block LODESTONE = LODESTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLACKSTONE = BLACKSTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLACKSTONE_STAIRS = BLACKSTONE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLACKSTONE_WALL = BLACKSTONE_WALL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block BLACKSTONE_SLAB = BLACKSTONE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_BLACKSTONE = POLISHED_BLACKSTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_BLACKSTONE_BRICKS = POLISHED_BLACKSTONE_BRICKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRACKED_POLISHED_BLACKSTONE_BRICKS = CRACKED_POLISHED_BLACKSTONE_BRICKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CHISELED_POLISHED_BLACKSTONE = CHISELED_POLISHED_BLACKSTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_BLACKSTONE_BRICK_SLAB = POLISHED_BLACKSTONE_BRICK_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_BLACKSTONE_BRICK_STAIRS = POLISHED_BLACKSTONE_BRICK_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_BLACKSTONE_BRICK_WALL = POLISHED_BLACKSTONE_BRICK_WALL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block GILDED_BLACKSTONE = GILDED_BLACKSTONE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_BLACKSTONE_STAIRS = POLISHED_BLACKSTONE_STAIRS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_BLACKSTONE_SLAB = POLISHED_BLACKSTONE_SLAB_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_BLACKSTONE_PRESSURE_PLATE = POLISHED_BLACKSTONE_PRESSURE_PLATE_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_BLACKSTONE_BUTTON = POLISHED_BLACKSTONE_BUTTON_ENTRY.getAsOf(MCVersion.latest());
    public static final Block POLISHED_BLACKSTONE_WALL = POLISHED_BLACKSTONE_WALL_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CHISELED_NETHER_BRICKS = CHISELED_NETHER_BRICKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block CRACKED_NETHER_BRICKS = CRACKED_NETHER_BRICKS_ENTRY.getAsOf(MCVersion.latest());
    public static final Block QUARTZ_BRICKS = QUARTZ_BRICKS_ENTRY.getAsOf(MCVersion.latest());

}
