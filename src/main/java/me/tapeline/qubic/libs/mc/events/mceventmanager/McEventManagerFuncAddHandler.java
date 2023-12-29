package me.tapeline.qubic.libs.mc.events.mceventmanager;

import me.tapeline.quailj.parsing.nodes.literals.LiteralFunction;
import me.tapeline.quailj.runtime.Runtime;
import me.tapeline.quailj.runtime.RuntimeStriker;
import me.tapeline.quailj.runtime.std.event.eventmanager.EventManager;
import me.tapeline.quailj.runtime.std.event.eventmanager.EventManagerNotInitializedException;
import me.tapeline.quailj.typing.classes.QFunc;
import me.tapeline.quailj.typing.classes.QObject;
import me.tapeline.quailj.typing.classes.errors.QUnsuitableTypeException;
import me.tapeline.quailj.typing.classes.utils.QBuiltinFunc;
import me.tapeline.quailj.typing.modifiers.ModifierConstants;
import me.tapeline.quailj.typing.utils.FuncArgument;
import me.tapeline.qubic.QubicPlugin;
import me.tapeline.qubic.libs.mc.events.mceventmanager.listeners.AbstractMcListener;
import me.tapeline.qubic.libs.mc.events.mceventmanager.listeners.AreaCloudEffectListener;
import org.bukkit.Bukkit;

import java.util.*;

public class McEventManagerFuncAddHandler extends QBuiltinFunc {


    public McEventManagerFuncAddHandler(Runtime runtime) {
        super(
                "addHandler",
                Arrays.asList(
                        new FuncArgument(
                                "this",
                                QObject.Val(),
                                new int[] {},
                                LiteralFunction.Argument.POSITIONAL
                        ),
                        new FuncArgument(
                                "event",
                                QObject.Val(),
                                new int[] {ModifierConstants.STR},
                                LiteralFunction.Argument.POSITIONAL
                        ),
                        new FuncArgument(
                                "handler",
                                QObject.Val(),
                                new int[] {ModifierConstants.FUNC},
                                LiteralFunction.Argument.POSITIONAL
                        )
                ),
                runtime,
                runtime.getMemory(),
                false
        );
    }

    @Override
    public QObject action(Runtime runtime, HashMap<String, QObject> args, List<QObject> argList) throws RuntimeStriker {
        if (!(args.get("this") instanceof McEventManager))
            runtime.error(new QUnsuitableTypeException("McEventManager", args.get("this")));
        McEventManager thisManager = ((McEventManager) args.get("this"));
        QFunc handler = ((QFunc) args.get("handler"));
        String event = args.get("event").toString();

        Bukkit.getServer().getPluginManager().registerEvents(
                Objects.requireNonNull(getListener(event, runtime, handler)),
                QubicPlugin.getPlugin(QubicPlugin.class)
        );

        return Val();
    }

    public static AbstractMcListener<?> getListener(String event, Runtime runtime, QFunc handler) {
        switch (event) {
            case "areaCloudEffect": return new AreaCloudEffectListener(runtime, handler);
        }
        return null;
    }

}
