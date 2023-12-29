package me.tapeline.qubic.libs.mc.entity.entity;

import me.tapeline.quailj.runtime.Runtime;
import me.tapeline.quailj.runtime.RuntimeStriker;
import me.tapeline.quailj.runtime.Table;
import me.tapeline.quailj.typing.classes.QObject;
import me.tapeline.quailj.typing.classes.errors.QException;

public class EntityNotInitializedException extends QException {

    public static final EntityNotInitializedException prototype = new EntityNotInitializedException(
            new Table(),
            "EntityNotInitializedException",
            QException.prototype,
            true
    );

    public EntityNotInitializedException(Table table, String className, QObject parent, boolean isPrototype) {
        super(table, className, parent, isPrototype);
    }

    public EntityNotInitializedException(Table table, String className,
                                         QObject parent, boolean isPrototype,
                                         String message) {
        super(table, className, parent, isPrototype, message);
    }

    public EntityNotInitializedException() {
        this(new Table(), prototype.className, prototype, false,
                "Entity method was called, but entity was not initialized");
    }

    @Override
    public QObject derive(Runtime runtime) throws RuntimeStriker {
        if (!isPrototype)
            runtime.error("Attempt to derive from non-prototype value");
        return new EntityNotInitializedException(new Table(), className, this, false);
    }

    @Override
    public QObject extendAs(Runtime runtime, String className) throws RuntimeStriker {
        if (!isPrototype)
            runtime.error("Attempt to inherit from non-prototype value");
        return new EntityNotInitializedException(new Table(), className, this, true);
    }

    @Override
    public QObject copy() {
        QObject copy = new EntityNotInitializedException(table, className, parent, isPrototype);
        copy.setInheritableFlag(isInheritable);
        return copy;
    }

}
