package aztest;

import arc.input.KeyCode;
import aztest.content.*;
import arc.Events;
import arc.util.Time;
import mindustry.content.Planets;
import mindustry.game.EventType;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;

import aztest.content.TestPlanetsGenerator;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class TestMod extends Mod {
    public TestMod() {
        Events.on(EventType.ClientLoadEvent.class, e->{
            Time.run(10f,()->{
                BaseDialog dialog = new BaseDialog("Welcome to use my mod");
                dialog.cont.add("I am Azazel, Thank 4 ur playing");
                Time.run(10f, dialog::addCloseButton);
                dialog.show();
            });
        });
        Events.on(EventType.PayloadDropEvent.class,e->{
            Time.run(10f,()->{
                BaseDialog dia = new BaseDialog("Payload drop");
                dia.cont.add("Drop!!");
                Time.run(10f,dia::addCloseButton);
                dia.show();
                dia.title.setText("Payload drop");
            });

            Events.run(EventType.ClientChatEvent.class,() -> {

            });

        });
    }

    @Override
    public void loadContent() {
        TestItems.load();
        TestBlocks.load();
        TestPlanets.load();
        TestSector.load();
        TestTechTree.load();
    }
}
