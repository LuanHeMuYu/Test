package aztest.content;


import arc.graphics.Color;
import mindustry.type.Item;

public class TestItems {
    ///通过bundles/bundle_zh_CN.properties进行多语言化
    public static Item
            //铁的产线
            iron,ironPlate,nails,gear,
            //钢铁工艺
            steel,steelPlate
            ;

    public static void load(){
        //铁锭
        iron = new Item("iron", Color.lightGray){{
            hardness = 1;
            cost = 0.5f;
            alwaysUnlocked = true;
        }};

        //铁板
        ironPlate = new Item("iron_plate",Color.gray){{
            cost = 0.6f;
            hardness = 1;
            alwaysUnlocked = false;
        }};

        //钉子
        nails = new Item("nails",Color.darkGray){{
            cost = 0.5f;
            hardness = 1;
            alwaysUnlocked = false;
        }};

        //齿轮
        gear = new Item("gear",Color.gray){{
           cost = 0.5f;
           hardness = 1;
           alwaysUnlocked = false;
        }};

        steel = new Item("steel",Color.gray){{
            cost = 0.6f;
            hardness = 1;
            alwaysUnlocked = false;
        }};

        steelPlate = new Item("steel_plate",Color.gray){{
            cost = 0.7f;
            hardness = 1;
            alwaysUnlocked = false;
        }};
    }
}
