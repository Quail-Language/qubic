package me.tapeline.qubic.libs.mc.events.mceventmanager.listeners;

import me.tapeline.quailj.runtime.Runtime;
import me.tapeline.quailj.runtime.RuntimeStriker;
import me.tapeline.quailj.typing.classes.QFunc;
import me.tapeline.quailj.typing.classes.QObject;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Arrays;
import java.util.HashMap;

public abstract class AbstractMcListener<E extends Event> implements Listener {

    private Runtime boundRuntime;
    private QFunc boundHandler;

    public AbstractMcListener(Runtime boundRuntime, QFunc boundHandler) {
        this.boundRuntime = boundRuntime;
        this.boundHandler = boundHandler;
    }

    public abstract QObject[] getArgumentsToPass(E event);

    @EventHandler
    public void handleEvent(E event) throws RuntimeStriker {
        boundHandler.call(boundRuntime, Arrays.asList(getArgumentsToPass(event)), new HashMap<>());
    }

}
