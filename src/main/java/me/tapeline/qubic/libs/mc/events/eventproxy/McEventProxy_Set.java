package me.tapeline.qubic.libs.mc.events.eventproxy;

import me.tapeline.quailj.parsing.nodes.literals.LiteralFunction;
import me.tapeline.quailj.runtime.Runtime;
import me.tapeline.quailj.runtime.RuntimeStriker;
import me.tapeline.quailj.runtime.std.event.eventmanager.EventManager;
import me.tapeline.quailj.runtime.std.qml.font.QMLFont;
import me.tapeline.quailj.runtime.std.qml.font.QMLFontNotInitializedException;
import me.tapeline.quailj.runtime.std.qml.surface.QMLSurface;
import me.tapeline.quailj.runtime.std.qml.surface.QMLSurfaceNotInitializedException;
import me.tapeline.quailj.typing.classes.QFunc;
import me.tapeline.quailj.typing.classes.QObject;
import me.tapeline.quailj.typing.classes.errors.QUnsuitableTypeException;
import me.tapeline.quailj.typing.classes.utils.QBuiltinFunc;
import me.tapeline.quailj.typing.modifiers.ModifierConstants;
import me.tapeline.quailj.typing.utils.FuncArgument;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class McEventProxy_Set extends QBuiltinFunc {


    public McEventProxy_Set(Runtime runtime) {
        super(
                "_set",
                Arrays.asList(
                        new FuncArgument(
                                "this",
                                QObject.Val(),
                                new int[] {},
                                LiteralFunction.Argument.POSITIONAL
                        ),
                        new FuncArgument(
                                "name",
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
        if (!(args.get("this") instanceof McEventProxy))
            runtime.error(new QUnsuitableTypeException("EventProxy", args.get("this")));
        McEventProxy thisObject = ((McEventProxy) args.get("this"));
        String event = args.get("name").strValue();

        EventManager eventManager = ((EventManager) runtime.getMemory().get("eventManager"));
        if (!eventManager.getEventHandlers().containsKey(event))
            eventManager.getEventHandlers().put(event, new ArrayList<>());
        eventManager.getEventHandlers().get(event).add(((QFunc) args.get("handler")));

        return Val();
    }

}
