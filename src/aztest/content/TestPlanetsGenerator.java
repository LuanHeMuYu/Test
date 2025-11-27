package aztest.content;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.math.geom.Vec3;
import arc.util.Tmp;
import arc.util.noise.Simplex;
import mindustry.content.Blocks;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.type.Sector;
import mindustry.world.Block;
import mindustry.world.Tiles;

public class TestPlanetsGenerator extends PlanetGenerator {
//    @Override
//    public void generate(Tiles tiles, Sector sec, int seed) {
//
//    }

    float rawHeight(Vec3 position) {
        position = Tmp.v33.set(position);
        return (Mathf.pow(Simplex.noise3d(this.seed, (double)7.0F, (double)0.5F, (double)0.33333334F, (double)position.x, (double)position.y, (double)position.z), 2.3F));
    }

    Block getBlcok(Vec3 position) {
        // 赛普罗星球的getBlock逻辑 通过一系列随机数，噪声 最后得到一个数字，这个数字是开头Block数组的索引，然后就知道这个方块是什么了
        // 埃里克尔也是得到索引，不过他没有通过随机数获取这个索引，而是简单的缩放

        //

        if(position.y >= 0)
            return Blocks.salt;
        else
            return Blocks.water;
    }

    /// 写星球表面的起伏 :D
    @Override
    public float getHeight(Vec3 vec3) {
        return vec3.y;
    }

    /// 写星球表面的颜色的 :D
    @Override
    public Color getColor(Vec3 vec3) {
//        return Color.white;
        Block block = getBlcok(vec3);
        return Tmp.c1.set(block.mapColor).a(1.0F - block.albedo);
    }
}
