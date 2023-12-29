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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class McEventManagerFuncRemoveHandler extends QBuiltinFunc {


    public McEventManagerFuncRemoveHandler(Runtime runtime) {
        super(
                "removeHandler",
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
        if (!(args.get("this") instanceof me.tapeline.quailj.runtime.std.event.eventmanager.EventManager))
            runtime.error(new QUnsuitableTypeException("EventManager", args.get("this")));
        me.tapeline.quailj.runtime.std.event.eventmanager.EventManager thisManager = ((EventManager) args.get("this"));
        if (thisManager.eventHandlers == null || thisManager.eventQueue == null)
            runtime.error(new EventManagerNotInitializedException());
        QFunc handler = ((QFunc) args.get("handler"));
        String event = args.get("event").toString();

        if (thisManager.eventHandlers.containsKey(event))
            thisManager.eventHandlers.get(event).remove(handler);

        return Val();
    }

}
