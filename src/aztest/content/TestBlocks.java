package aztest.content;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.GenericCrafter;

public class TestBlocks {
    public static Block
            //铁矿产线
            furnace, processingFactory,gearAssemblyMachine, furnaceAdvance,
            //绿化产线
            axeBasic,axeAdvance,
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

        //高炉
        furnaceAdvance = new GenericCrafter("furnaceAdvance"){{
            requirements(Category.crafting, ItemStack.with(Items.copper,100,Items.lead,80, TestItems.ironPlate,30));//建造所需100个铜 80个铅 30个铁矿

            alwaysUnlocked = false;
            outputItem = new ItemStack(TestItems.steel,1);
            consumeItems(ItemStack.with(TestItems.iron,2,Items.coal,1));

            size = 2;
            hasItems = true;
            craftTime = 90f;

        }};

        //初级伐木场
        axeBasic = new GenericCrafter("axeBasic"){{
            requirements(Category.crafting, ItemStack.with(Items.copper,100,Items.lead,80));

            alwaysUnlocked = true;
            outputItem = new ItemStack(TestItems.wood,1);

            size = 1;
            hasItems = true;
            craftTime = 150f;
        }};

        //高级伐木场
        axeAdvance = new GenericCrafter("axeAdvance"){{
           requirements(Category.crafting, ItemStack.with(Items.copper,100,Items.lead,80, TestItems.steel,30));

           alwaysUnlocked = false;
           outputItem = new ItemStack(TestItems.wood,2);

           size = 2;
           hasItems = true;
           craftTime = 60f;
           consumePower(0.5f);
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
            requirements(Category.turret, ItemStack.with(Items.copper,100,Items.lead,80,TestItems.iron,20));

            alwaysUnlocked = false;
            ammo(TestItems.nails, new BasicBulletType(8F, 3.5F) {
                {
                    this.width = 1.0F;
                    this.height = 6.0F;
                    this.lifetime = 45.0F;
                }
            });
            this.shoot = new ShootAlternate(3.5F);
            this.recoils = 2;
            this.recoil = 0.5F;
            this.shootY = 3.0F;
            this.reload = 20.0F;
            this.range = 80.0F;
            this.shootCone = 15.0F;
            this.ammoUseEffect = Fx.casing1;
            this.health = 250;
            this.inaccuracy = 2.0F;
            this.rotateSpeed = 10.0F;
            this.coolant = this.consumeCoolant(0.1F);
            this.researchCostMultiplier = 0.05F;
            this.limitRange();
        }};
    }
}
