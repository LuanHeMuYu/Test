package aztest.content;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.Rand;
import arc.math.geom.Vec3;
import arc.struct.FloatSeq;
import arc.struct.Seq;
import arc.util.Tmp;
import arc.util.noise.Ridged;
import arc.util.noise.Simplex;
import mindustry.Vars;
import mindustry.content.Blocks;
import mindustry.content.UnitTypes;
import mindustry.game.Schematics;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.PlanetMesh;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.type.Sector;
import mindustry.type.UnitType;
import mindustry.ui.dialogs.BaseDialog;
import mindustry.world.Block;
import mindustry.world.Tile;
import mindustry.world.Tiles;
import mindustry.world.blocks.units.UnitFactory;

public class TestPlanetsGenerator extends PlanetGenerator {
    //    Block[][] arr = new Block[][]{
//            {Blocks.stone, Blocks.snow, Blocks.stone},
//            {Blocks.stone, Blocks.sand, Blocks.sand},
//            {Blocks.stone, Blocks.water, Blocks.water},
//    };
    Block[] arr = new Block[]{
            Blocks.water, Blocks.grass, Blocks.stone, Blocks.snow
    };

//    @Override
//    protected void generate() {
//        cells(4);
//        distort(10f, 12f);
//
//        //rivers
//        pass((x, y) -> {
//            if(block.solid) return;
//
//            Vec3 v = sector.rect.project(x, y);
//
//            float rr = Simplex.noise2d(sector.id, (float)2, 0.6f, 1f / 7f, x, y) * 0.1f;
//            float value = Ridged.noise3d(2, v.x, v.y, v.z, 1, 1f / 55f) + rr - rawHeight(v) * 0f;
//            float rrscl = rr * 44 - 2;
//
//            if(value > 0.17f && !Mathf.within(x, y, (float) super.width / 2, super.height, 12 + rrscl)){
//                boolean deep = value > 0.17f + 0.1f && !Mathf.within(x, y, (float) super.width / 2, super.height, 15 + rrscl);
//                boolean spore = floor != Blocks.sand && floor != Blocks.salt;
//                //do not place rivers on ice, they're frozen
//                //ignore pre-existing liquids
//                if(!(floor == Blocks.ice || floor == Blocks.iceSnow || floor == Blocks.snow || floor.asFloor().isLiquid)){
//                    floor = spore ?
//                            (deep ? Blocks.taintedWater : Blocks.darksandTaintedWater) :
//                            (deep ? Blocks.water :
//                                    (floor == Blocks.sand || floor == Blocks.salt ? Blocks.sandWater : Blocks.darksandWater));
//                }
//            }
//        });
//
////        //shoreline setup
////        pass((x, y) -> {
////            int deepRadius = 3;
////
////            if(floor.asFloor().isLiquid && floor.asFloor().shallow){
////
////                for(int cx = -deepRadius; cx <= deepRadius; cx++){
////                    for(int cy = -deepRadius; cy <= deepRadius; cy++){
////                        if((cx) * (cx) + (cy) * (cy) <= deepRadius * deepRadius){
////                            int wx = cx + x, wy = cy + y;
////
////                            Tile tile = tiles.get(wx, wy);
////                            if(tile != null && (!tile.floor().isLiquid || tile.block() != Blocks.air)){
////                                //found something solid, skip replacing anything
////                                return;
////                            }
////                        }
////                    }
////                }
////
////                floor = floor == Blocks.darksandTaintedWater ? Blocks.taintedWater : Blocks.water;
////            }
////        });
//
////        trimDark();
//
//        tiles.getn(0, 0).setOverlay(Blocks.spawn);
//        Schematics.placeLaunchLoadout(Vars.world.tiles.width / 2,Vars.world.tiles.height / 2);
//        //填充世界
//        this.pass((x,y) -> {
//            if(rand.nextInt(Math.abs(this.seed == 0 ? 1 : this.seed)) % 100 > 90)
//                inverseFloodFill(tiles.get(2,2));
//        });

    /// /        inverseFloodFill(tiles.getn(Vars.world.tiles.width / 2,Vars.world.tiles.height / 2));
//
//
//
//        Seq<Block> ores = Seq.with(Blocks.oreCopper, Blocks.oreLead);
//        float poles = Math.abs(this.sector.tile.v.y);
//        float nmag = 0.5F;
//        float scl = 1.0F;
//        float addscl = 1.3F;
//        if (Simplex.noise3d(this.seed, (double)2.0F, (double)0.5F, (double)scl, (double)this.sector.tile.v.x, (double)this.sector.tile.v.y, (double)this.sector.tile.v.z) * nmag + poles > 0.25F * addscl) {
//            ores.add(Blocks.oreCoal);
//        }
//
//        if (Simplex.noise3d(this.seed, (double)2.0F, (double)0.5F, (double)scl, (double)(this.sector.tile.v.x + 1.0F), (double)this.sector.tile.v.y, (double)this.sector.tile.v.z) * nmag + poles > 0.5F * addscl) {
//            ores.add(Blocks.oreTitanium);
//        }
//
//        if (Simplex.noise3d(this.seed, (double)2.0F, (double)0.5F, (double)scl, (double)(this.sector.tile.v.x + 2.0F), (double)this.sector.tile.v.y, (double)this.sector.tile.v.z) * nmag + poles > 0.7F * addscl) {
//            ores.add(Blocks.oreThorium);
//        }
//
//        if (Simplex.noise3d(this.seed, (double)2.0F, (double)0.5F, (double)scl, (double)(this.sector.tile.v.x + 2.0F), (double)this.sector.tile.v.y, (double)this.sector.tile.v.z) * nmag + poles > 0.1F * addscl) {
//            ores.add(TestBlocks.ironOre);
//        }
//
//        if (this.rand.chance((double)0.25F)) {
//            ores.add(Blocks.oreScrap);
//        }
//
//        FloatSeq frequencies = new FloatSeq();
//
//        for(int i = 0; i < ores.size; ++i) {
//            frequencies.add(this.rand.random(-0.1F, 0.01F) - (float)i * 0.01F + poles * 0.04F);
//        }
//
//        this.pass((xx, yx) -> {
//            if (this.floor.asFloor().hasSurface()) {
//                int offsetX = xx - 4;
//                int offsetY = yx + 23;
//
//                for(int i = ores.size - 1; i >= 0; --i) {
//                    Block entry = (Block)ores.get(i);
//                    float freq = frequencies.get(i);
//                    if ((double)Math.abs(0.5F - this.noise((float)offsetX, (float)(offsetY + i * 999), (double)2.0F, 0.7, (double)(40 + i * 2))) > (double)0.22F + (double)i * 0.01 && Math.abs(0.5F - this.noise((float)offsetX, (float)(offsetY - i * 999), (double)1.0F, (double)1.0F, (double)(30 + i * 4))) > 0.37F + freq) {
//                        this.ore = entry;
//                        break;
//                    }
//                }
//
//                if (this.ore == Blocks.oreScrap && this.rand.chance(0.33)) {
//                    this.floor = Blocks.metalFloorDamaged;
//                }
//
//            }
//        });
//
//    }

    float rawHeight(Vec3 position) {
        position = Tmp.v33.set(position);
        return (Mathf.pow(Simplex.noise3d(this.seed, (double) 7.0F, (double) 0.5F, (double) 0.33333334F, (double) position.x, (double) position.y, (double) position.z), 2.3F));
    }

    Block getBlcok(Vec3 position) {
        return Blocks.salt;
        // 赛普罗星球的getBlock逻辑 通过一系列随机数，噪声 最后得到一个数字，这个数字是开头Block数组的索引，然后就知道这个方块是什么了
        // 埃里克尔也是得到索引，不过他没有通过随机数获取这个索引，而是简单的缩放
//        Rand rand = new Rand((long) rawHeight(position));
//        return arr[(int) Simplex.noise3d(this.seed,7.0f,0.5f,0.3334f,position.x,position.y,position.z) % arr.length];
//        return arr[Math.abs(rand.nextInt()) % arr.length][(int) Simplex.noise3d(this.seed,7.0f,0.5f,0.3334f,position.x,position.y,position.z) % arr[0].length];
    }

    /// 写星球表面的起伏 :D
    @Override
    public float getHeight(Vec3 vec3) {
        return rawHeight(vec3);
    }

    /// 写星球表面的颜色的 :D
    @Override
    public Color getColor(Vec3 vec3) {
        //高度确定?
        float height = rawHeight(vec3);
        return arr[(int) Mathf.clamp(height * 10, 0, arr.length - 1)].mapColor;
//        TestItems.ironOre.description = TestItems.ironOre.description + " " + height;
//        return arr[2].mapColor;
    }
}
