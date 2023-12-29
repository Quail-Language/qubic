package me.tapeline.qubic.libs.mc.events.mceventmanager;

import me.tapeline.quailj.runtime.Runtime;
import me.tapeline.quailj.runtime.RuntimeStriker;
import me.tapeline.quailj.runtime.Table;
import me.tapeline.quailj.runtime.std.event.event.Event;
import me.tapeline.quailj.typing.classes.QFunc;
import me.tapeline.quailj.typing.classes.QObject;
import me.tapeline.quailj.utils.Dict;
import me.tapeline.quailj.utils.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class McEventManager extends QObject {

    public static McEventManager prototype = null;
    public static McEventManager prototype(Runtime runtime) {
        if (prototype == null)
            prototype = new McEventManager(
                    new Table(Dict.make(
                            new Pair<>("addHandler", new McEventManagerFuncAddHandler(runtime)),
                            new Pair<>("removeHandler", new McEventManagerFuncRemoveHandler(runtime))
                    )),
                    "McEventManager",
                    QObject.superObject,
                    true
            );
        return prototype;
    }

    protected Queue<Event> eventQueue;
    protected HashMap<String, List<QFunc>> eventHandlers;

    public McEventManager(Table table, String className, QObject parent, boolean isPrototype) {
        super(table, className, parent, isPrototype);
    }

    @Override
    public QObject derive(Runtime runtime) throws RuntimeStriker {
        if (!isPrototype)
            runtime.error("Attempt to inherit from non-prototype value");
        return new McEventManager(new Table(), className, this, false);
    }

    @Override
    public QObject extendAs(Runtime runtime, String className) throws RuntimeStriker {
        if (!isPrototype)
            runtime.error("Attempt to inherit from non-prototype value");
        return new McEventManager(new Table(), className, this, true);
    }

    @Override
    public QObject copy() {
        QObject copy = new McEventManager(table, className, parent, isPrototype);
        copy.setInheritableFlag(isInheritable);
        return copy;
    }

    public Queue<Event> getEventQueue() {
        return eventQueue;
    }

    public HashMap<String, List<QFunc>> getEventHandlers() {
        return eventHandlers;
    }

    public void fireEvent(Event event) {
        eventQueue.add(event);
    }

}
