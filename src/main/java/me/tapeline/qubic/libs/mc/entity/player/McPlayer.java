package me.tapeline.qubic.libs.mc.entity.player;

import me.tapeline.quailj.runtime.Runtime;
import me.tapeline.quailj.runtime.RuntimeStriker;
import me.tapeline.quailj.runtime.Table;
import me.tapeline.quailj.typing.classes.QObject;
import me.tapeline.quailj.utils.Dict;
import me.tapeline.quailj.utils.Pair;
import me.tapeline.qubic.libs.mc.entity.entity.McEntity;

public class McPlayer extends QObject {

    public static McPlayer prototype = null;
    public static McPlayer prototype(Runtime runtime) {
        if (prototype == null)
            prototype = new McPlayer(
                    new Table(Dict.<String, QObject>make(

                    )),
                    "McPlayer",
                    McEntity.prototype,
                    true
            );
        return prototype;
    }

    public McPlayer(Table table, String className, QObject parent, boolean isPrototype) {
        super(table, className, parent, isPrototype);
    }

    @Override
    public QObject derive(Runtime runtime) throws RuntimeStriker {
        if (!isPrototype)
            runtime.error("Attempt to inherit from non-prototype value");
        return new McPlayer(new Table(), className, this, false);
    }

    @Override
    public QObject extendAs(Runtime runtime, String className) throws RuntimeStriker {
        if (!isPrototype)
            runtime.error("Attempt to inherit from non-prototype value");
        return new McPlayer(new Table(), className, this, true);
    }

    @Override
    public QObject copy() {
        QObject copy = new McPlayer(table, className, parent, isPrototype);
        copy.setInheritableFlag(isInheritable);
        return copy;
    }

}
