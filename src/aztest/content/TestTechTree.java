package aztest.content;

import arc.struct.Seq;
import mindustry.content.*;
import mindustry.content.TechTree.TechNode;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives;
import mindustry.type.ItemStack;

public class TestTechTree {
    private static TechNode context = null;
    public static Seq<TechNode> all = new Seq<>();
    public static Seq<TechNode> roots = new Seq<>();

    public static void load(){
//        Planets.serpulo.techTree = nodeRoot("TestTechTree",Blocks.coreShard,() -> {
//            nodeProduce(TestItems.iron,() -> {
//                nodeProduce(TestItems.ironPlate);
//                nodeProduce(TestItems.nails);
//            });
//
//            node(TestBlocks.furnace,() -> {
//                node(TestBlocks.processingFactory);
//            });
//        });
        addToNext(Blocks.graphitePress, () -> node(TestBlocks.furnace,Seq.with(new Objectives.Objective[]{new Objectives.SectorComplete(SectorPresets.groundZero)}),() -> {
        node(TestBlocks.furnaceAdvance);
        node(TestBlocks.processingFactory, () -> {
            node(TestBlocks.fireBull);
            node(TestBlocks.gearAssemblyMachine);
        });
        node(TestBlocks.axeBasic, () -> node(TestBlocks.axeAdvance));
    }));

        addToNext(Items.copper,() -> nodeProduce(TestItems.ironOre,() -> {
            nodeProduce(TestItems.ironPlate,() -> {
                nodeProduce(TestItems.nails);
                nodeProduce(TestItems.gear);
                nodeProduce(TestItems.steel, () -> {
                    nodeProduce(TestItems.steelPlate,() -> {});
                });
            });
        }));

        addToNext(Items.copper, () -> nodeProduce(TestItems.wood));

        addToNext(SectorPresets.groundZero,() -> {
            //node(TestSector.groundOne,Seq.with(new Objectives.Objective[]{new Objectives.SectorComplete(SectorPresets.groundZero)}),() -> {});
            node(TestSector.groundOne,Seq.with(new Objectives.SectorComplete(SectorPresets.groundZero)));
        });
    }

    public static void addToNext(UnlockableContent content,Runnable run){
        context = TechTree.all.find(t -> t.content == content);
        run.run();
    }

    public static TechNode nodeRoot(String name, UnlockableContent content, Runnable children) {
        return nodeRoot(name, content, false, children);
    }

    public static TechNode nodeRoot(String name, UnlockableContent content, boolean requireUnlock, Runnable children) {
        TechNode root = node(content, content.researchRequirements(), children);
        root.name = name;
        root.requiresUnlock = requireUnlock;
        roots.add(root);
        return root;
    }

    public static TechNode node(UnlockableContent content, Runnable children) {
        return node(content, content.researchRequirements(), children);
    }

    public static TechNode node(UnlockableContent content, ItemStack[] requirements, Runnable children) {
        return node(content, requirements, null, children);
    }

    public static TechNode node(UnlockableContent content, ItemStack[] requirements, Seq<Objectives.Objective> objectives, Runnable children) {
        TechNode node = new TechNode(context, content, requirements);
        if (objectives != null) {
            node.objectives.addAll(objectives);
        }

        TechNode prev = context;
        context = node;
        children.run();
        context = prev;
        return node;
    }

    public static TechNode node(UnlockableContent content, Seq<Objectives.Objective> objectives) {
        return node(content, content.researchRequirements(), objectives,() -> {});
    }

    public static TechNode node(UnlockableContent content, Seq<Objectives.Objective> objectives, Runnable children) {
        return node(content, content.researchRequirements(), objectives, children);
    }

    public static TechNode node(UnlockableContent block) {
        return node(block, () -> {
        });
    }

    public static TechNode nodeProduce(UnlockableContent content, Seq<Objectives.Objective> objectives, Runnable children) {
        return node(content, content.researchRequirements(), objectives.add(new Objectives.Produce(content)), children);
    }

    public static TechNode nodeProduce(UnlockableContent content, Runnable children) {
        return nodeProduce(content, new Seq<>(), children);
    }

    public static TechNode nodeProduce(UnlockableContent content){
        return nodeProduce(content,() -> {});
    }
}
