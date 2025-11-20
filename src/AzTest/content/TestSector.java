package AzTest.content;

import mindustry.content.Planets;
import mindustry.content.SectorPresets;
import mindustry.type.ItemStack;
import mindustry.type.SectorPreset;

public class TestSector {
    public static SectorPreset groundOne;

    public static void load(){
        groundOne = new SectorPreset("groundOne", Planets.serpulo,1){
            {
                this.addStartingItems = false;
                this.captureWave = 15;
                this.difficulty = 1.2F;
                this.overrideLaunchDefaults = true;
                this.noLighting = true;
                this.startWaveTimeMultiplier = 3.0F;
            }
        };
    }
}
