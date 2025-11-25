package aztest.content;

import arc.graphics.Color;
import mindustry.content.Planets;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.maps.planet.SerpuloPlanetGenerator;
import mindustry.type.Planet;

/**
 * @author Azazel
 * @version 1.0
 * @date 2025/5/23 下午2:59
 */
public class TestPlanets {
    public static Planet nonepro, test;

    public static void load() {
        nonepro = new Planet("none", Planets.sun, 1.0f, 3) {{
            this.generator = new SerpuloPlanetGenerator();
//            this.generator = new AsteroidGenerator();

            this.meshLoader = () -> {
                return new HexMesh(this, 6);
            };

            this.iconColor = Color.valueOf("#ff9899");
            this.atmosphereColor = Color.valueOf("#908232");

            /**大气辐射?*/
            this.atmosphereRadIn = 0.02F;
            /**大气辐射?*/
            this.atmosphereRadOut = 0.3F;

            this.cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this,3,0.3f,0.13f,6, Color.valueOf("#3299CC"),2,0.3F,0.87F,0.2F),
                    new HexSkyMesh(this,1,0.55f,0.23f,6, Color.valueOf("#F5F5F5"),1,0.21F,0.45F,0.3F)
            );

            this.ruleSetter = rules -> {

            };

            alwaysUnlocked = true;
        }};

        test = new Planet("t", Planets.serpulo, 1.0f) {{
            alwaysUnlocked = true;
        }};
    }
}
