package AzTest.content;


import arc.graphics.Color;
import mindustry.type.Item;

public class TestItems {
    ///通过bundles/bundle_zh_CN.properties进行多语言化
    public static Item
            //铁的产线
            iron,ironPlate,nails;

    public static void load(){
        iron = new Item("iron", Color.lightGray){{
            hardness = 1;
            cost = 0.5f;
            alwaysUnlocked = true;
        }};

        ironPlate = new Item("iron_plate",Color.gray){{
            cost = 0.6f;
            hardness = 1;
            alwaysUnlocked = false;
        }};

        nails = new Item("nails",Color.darkGray){{
            cost = 0.5f;
            hardness = 1;
            alwaysUnlocked = false;
        }};
    }
}
