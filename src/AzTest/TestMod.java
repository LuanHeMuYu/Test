package AzTest;

import AzTest.content.TestTechTree;
import arc.Events;
import arc.util.Time;
import mindustry.game.EventType;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;

import AzTest.content.TestItems;
import AzTest.content.TestBlocks;


public class TestMod extends Mod {
    public TestMod() {
        Events.on(EventType.ClientLoadEvent.class, e->{
            Time.run(10f,()->{
                BaseDialog dialog = new BaseDialog("Welcome to use my mod");
                dialog.cont.add("I am Azazel, Thank 4 ur playing");
                Time.run(100f, dialog::addCloseButton);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent() {
        TestItems.load();
        TestBlocks.load();
        TestTechTree.load();
    }
}
