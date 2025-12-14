package aztest.content;

import mindustry.annotations.Annotations;
import mindustry.content.UnitTypes;
import mindustry.entities.Units;
import mindustry.gen.UnitEntity;
import mindustry.gen.Unitc;
import mindustry.type.UnitType;

public class TestUnits {
    public static @Annotations.EntityDef({Unitc.class}) UnitType depleted_uranium;

    public static void load(){
//        qwq = new OEPayloadItems() {
//
//        };
        depleted_uranium = new UnitType("depleted_uranium") {
            {
                health = 1f;
                speed = 0f;
                researchCostMultiplier = 0.5f;
                weapons.clear();
                targetAir = false;
                targetGround = false;
                itemCapacity = 0;
                hitSize = 0f;
                drawCell = false;
                flying = false;
                researchCostMultiplier = 0.5f;
                alwaysUnlocked = true;
//                hitSize = 8f;
//                weapons.add(new Weapon("large-weapon"){{
//                    reload = 13f;
//                    x = 4f;
//                    y = 2f;
//                    top = false;
//                    ejectEffect = Fx.casing1;
//                    bullet = new BasicBulletType(2.5f, 9){{
//                        width = 7f;
//                        height = 9f;
//                        lifetime = 60f;
//                    }};
//                }});
            }
        };
        depleted_uranium.constructor = UnitEntity::create;
    }
}
