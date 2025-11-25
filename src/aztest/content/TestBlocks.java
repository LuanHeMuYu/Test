package aztest.content;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.GenericCrafter;

public class TestBlocks {
    public static Block
            //铁矿产线
            furnace, processingFactory,gearAssemblyMachine,
            //矿石
            ironOre,
            //炮台
            fireBull;

    public static void load() {
        //熔炉
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

        //制钉厂
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

        //齿轮组装机
        gearAssemblyMachine = new GenericCrafter("gearAssemblyMachine"){{
           requirements(Category.crafting, ItemStack.with(Items.copper,100,Items.lead,80, TestItems.iron,30));
           alwaysUnlocked = true;
           craftEffect = Fx.pulverizeMedium;
           outputItem = new ItemStack(TestItems.gear,1);
           size = 2;
           hasItems = true;
           craftTime = 110f;
           consumePower(0.5f);
           consumeItems(ItemStack.with(TestItems.ironPlate,4,TestItems.nails,4));
        }};

        //铁矿石
        ironOre = new OreBlock(TestItems.iron){{
            oreDefault = true;
            oreThreshold = 0.81f;
            oreScale = 23.47619f;
        }};

        //钉子炮塔
        fireBull = new ItemTurret("fire"){{
            alwaysUnlocked = true;
            ammo();
        }};
    }
}
