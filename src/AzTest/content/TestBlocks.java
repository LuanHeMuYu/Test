package AzTest.content;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;

public class TestBlocks {
    public static Block
            //铁矿产线
            furnace, processingFactory;

    public static void load() {
        furnace = new GenericCrafter("furnace"){{
            requirements(Category.crafting, ItemStack.with(Items.copper,100,Items.lead,80, TestItems.iron,30));//建造所需100个铜 80个铅 30个铁矿

            alwaysUnlocked = false;
            craftEffect = Fx.pulverizeMedium;

            outputItem = new ItemStack(TestItems.ironPlate,1);
            consumeItem(TestItems.iron,1);

            size = 2;
            hasItems = true;
            craftTime = 90f;
        }};

        processingFactory = new GenericCrafter("processingFactory"){{
            requirements(Category.crafting, ItemStack.with(Items.copper,100,Items.lead,80, TestItems.ironPlate,30));//建造所需100个铜 80个铅 30个铁矿

            alwaysUnlocked = false;
            craftEffect = Fx.blockCrash;

            outputItem = new ItemStack(TestItems.nails,2);
            consumeItem(TestItems.ironPlate,1);

            size = 2;
            hasItems = true;
            craftTime = 110f;
        }};
    }
}
