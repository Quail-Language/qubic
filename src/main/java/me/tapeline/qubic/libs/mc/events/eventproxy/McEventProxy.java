package me.tapeline.qubic.libs.mc.events.eventproxy;

import me.tapeline.quailj.runtime.Runtime;
import me.tapeline.quailj.runtime.RuntimeStriker;
import me.tapeline.quailj.runtime.Table;
import me.tapeline.quailj.runtime.std.qml.surface.*;
import me.tapeline.quailj.typing.classes.QObject;
import me.tapeline.quailj.utils.Dict;
import me.tapeline.quailj.utils.Pair;

public class McEventProxy extends QObject {

    public static McEventProxy prototype = null;
    public static McEventProxy prototype(Runtime runtime) {
        if (prototype == null)
            prototype = new McEventProxy(
                    new Table(Dict.make(
                            new Pair<>("_set", new McEventProxy_Set(runtime))
                    )),
                    "EventProxy",
                    QObject.superObject,
                    true
            );
        return prototype;
    }

    public McEventProxy(Table table, String className, QObject parent, boolean isPrototype) {
        super(table, className, parent, isPrototype);
    }

    @Override
    public QObject derive(Runtime runtime) throws RuntimeStriker {
        if (!isPrototype)
            runtime.error("Attempt to inherit from non-prototype value");
        return new QMLSurface(new Table(), className, this, false);
    }

    @Override
    public QObject extendAs(Runtime runtime, String className) throws RuntimeStriker {
        if (!isPrototype)
            runtime.error("Attempt to inherit from non-prototype value");
        return new QMLSurface(new Table(), className, this, true);
    }

    @Override
    public QObject copy() {
        QObject copy = new QMLSurface(table, className, parent, isPrototype);
        copy.setInheritableFlag(isInheritable);
        return copy;
    }

}
