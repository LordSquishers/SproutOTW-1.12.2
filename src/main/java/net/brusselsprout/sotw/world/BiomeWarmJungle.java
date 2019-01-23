package net.brusselsprout.sotw.world;

import net.minecraft.block.BlockFlower;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class BiomeWarmJungle extends Biome {

    public BiomeWarmJungle() {
        super(new BiomeProperties("warm_jungle")
                .setBaseHeight(1.0F)
                .setHeightVariation(0.95F)
                .setTemperature(1.0F)
        );

        topBlock = Blocks.GRASS.getDefaultState();
        fillerBlock = Blocks.STONE.getDefaultState();

    }

    @Override
    public BiomeDecorator createBiomeDecorator() {
        BiomeDecorator biomeDecorator = new BiomeDecorator();

        biomeDecorator.waterlilyPerChunk = 0;
        biomeDecorator.treesPerChunk = 8;
        biomeDecorator.extraTreeChance = 0.2F;
        biomeDecorator.flowersPerChunk = 4;
        biomeDecorator.grassPerChunk = 2;
        biomeDecorator.deadBushPerChunk = 0;
        biomeDecorator.mushroomsPerChunk = 0;
        biomeDecorator.reedsPerChunk = 2;
        biomeDecorator.cactiPerChunk = 0;
        biomeDecorator.gravelPatchesPerChunk = 1;
        biomeDecorator.sandPatchesPerChunk = 1;
        biomeDecorator.clayPerChunk = 3;
        biomeDecorator.bigMushroomsPerChunk = 0;
        biomeDecorator.generateFalls = false;

        return biomeDecorator;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return new WorldGenTreesBanana(false);
    }

    private void setSpawnables()
    {
        spawnableCreatureList.clear();
        spawnableMonsterList.clear();
        spawnableWaterCreatureList.clear();
        spawnableCaveCreatureList.clear();
        spawnableCreatureList.add(new Biome.SpawnListEntry(EntitySheep.class, 12, 4, 4));
        spawnableCreatureList.add(new Biome.SpawnListEntry(EntityPig.class, 10, 4, 4));
        spawnableCreatureList.add(new Biome.SpawnListEntry(EntityChicken.class, 20, 4, 8));
        spawnableCreatureList.add(new Biome.SpawnListEntry(EntityOcelot.class, 8, 4, 4));
        spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntitySquid.class, 10, 4, 4));
        spawnableCaveCreatureList.add(new Biome.SpawnListEntry(EntityBat.class, 10, 8, 8));
    }
}
