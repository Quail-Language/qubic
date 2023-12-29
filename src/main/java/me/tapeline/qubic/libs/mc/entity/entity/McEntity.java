package me.tapeline.qubic.libs.mc.entity.entity;

import me.tapeline.quailj.runtime.Runtime;
import me.tapeline.quailj.runtime.RuntimeStriker;
import me.tapeline.quailj.runtime.Table;
import me.tapeline.quailj.typing.classes.QObject;
import me.tapeline.quailj.typing.classes.errors.QUnsuitableTypeException;
import me.tapeline.quailj.typing.classes.utils.Initializable;
import me.tapeline.quailj.utils.Dict;
import me.tapeline.quailj.utils.Pair;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class McEntity extends QObject implements Initializable {

    public static McEntity prototype = null;
    public static McEntity prototype(Runtime runtime) {
        if (prototype == null)
            prototype = new McEntity(
                    new Table(Dict.make(
                            new Pair<>("getWorld", new EntityGetWorld(runtime)),
                            new Pair<>("getLocation", new EntityGetLocation(runtime)),
                            new Pair<>("getVelocity", new EntityGetVelocity(runtime)),
                            new Pair<>("setFallDistance", new EntitySetFallDistance(runtime)),
                            new Pair<>("playEffect", new EntityPlayEffect(runtime)),
                            new Pair<>("getWidth", new EntityGetWidth(runtime)),
                            new Pair<>("leaveVehicle", new EntityLeaveVehicle(runtime)),
                            new Pair<>("setGlowing", new EntitySetGlowing(runtime)),
                            new Pair<>("remove", new EntityRemove(runtime)),
                            new Pair<>("addPassenger", new EntityAddPassenger(runtime)),
                            new Pair<>("getFallDistance", new EntityGetFallDistance(runtime)),
                            new Pair<>("isDead", new EntityIsDead(runtime)),
                            new Pair<>("getHeight", new EntityGetHeight(runtime)),
                            new Pair<>("getUUID", new EntityGetUUID(runtime)),
                            new Pair<>("setSilent", new EntitySetSilent(runtime)),
                            new Pair<>("setVelocity", new EntitySetVelocity(runtime)),
                            new Pair<>("getNearbyEntities", new EntityGetNearbyEntities(runtime)),
                            new Pair<>("isPersistent", new EntityIsPersistent(runtime)),
                            new Pair<>("isGlowing", new EntityIsGlowing(runtime)),
                            new Pair<>("getEntityId", new EntityGetEntityId(runtime)),
                            new Pair<>("setCustomNameVisible", new EntitySetCustomNameVisible(runtime)),
                            new Pair<>("isInsideVehicle", new EntityIsInsideVehicle(runtime)),
                            new Pair<>("getServer", new EntityGetServer(runtime)),
                            new Pair<>("isInWater", new EntityIsInWater(runtime)),
                            new Pair<>("isValid", new EntityIsValid(runtime)),
                            new Pair<>("setPersistent", new EntitySetPersistent(runtime)),
                            new Pair<>("setRotation", new EntitySetRotation(runtime)),
                            new Pair<>("isInvulnerable", new EntityIsInvulnerable(runtime)),
                            new Pair<>("isNoPassengers", new EntityIsNoPassengers(runtime)),
                            new Pair<>("ejectPassengers", new EntityEjectPassengers(runtime)),
                            new Pair<>("getPassengers", new EntityGetPassengers(runtime)),
                            new Pair<>("getType", new EntityGetType(runtime)),
                            new Pair<>("isCustomNameVisible", new EntityIsCustomNameVisible(runtime)),
                            new Pair<>("isOnGround", new EntityIsOnGround(runtime)),
                            new Pair<>("isSilent", new EntityIsSilent(runtime)),
                            new Pair<>("removePassenger", new EntityRemovePassenger(runtime))
                    )),
                    "Entity",
                    QObject.superObject,
                    true
            );
        return prototype;
    }

    public static @NotNull McEntity validate(Runtime runtime, QObject object) throws RuntimeStriker {
        if (!(object instanceof McEntity))
            runtime.error(new QUnsuitableTypeException(prototype.className, object));
        McEntity thisObject = (McEntity) object;
        if (!thisObject.isInitialized())
            runtime.error(new EntityNotInitializedException());
        return thisObject;
    }

    protected Entity entity;

    public McEntity(Table table, String className, QObject parent, boolean isPrototype) {
        super(table, className, parent, isPrototype);
    }

    public McEntity(Table table, String className, QObject parent, boolean isPrototype, Entity entity) {
        super(table, className, parent, isPrototype);
        this.entity = entity;
    }

    public McEntity(Entity entity) {
        this(new Table(), prototype.className, prototype, false, entity);
    }

    @Override
    public QObject derive(Runtime runtime) throws RuntimeStriker {
        if (!isPrototype)
            runtime.error("Attempt to inherit from non-prototype value");
        return new McEntity(new Table(), className, this, false, entity);
    }

    @Override
    public QObject extendAs(Runtime runtime, String className) throws RuntimeStriker {
        if (!isPrototype)
            runtime.error("Attempt to inherit from non-prototype value");
        return new McEntity(new Table(), className, this, true, entity);
    }

    @Override
    public QObject copy() {
        QObject copy = new McEntity(table, className, parent, isPrototype, entity);
        copy.setInheritableFlag(isInheritable);
        return copy;
    }

    @Override
    public boolean isInitialized() {
        return entity != null;
    }

    public Entity getEntity() {
        return entity;
    }

}