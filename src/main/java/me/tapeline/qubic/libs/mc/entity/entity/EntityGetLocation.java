package me.tapeline.qubic.libs.mc.entity.entity;

import me.tapeline.quailj.parsing.nodes.literals.LiteralFunction;
import me.tapeline.quailj.runtime.Runtime;
import me.tapeline.quailj.typing.modifiers.ModifierConstants;
import me.tapeline.quailj.typing.classes.QObject;
import me.tapeline.quailj.typing.utils.FuncArgument;
import me.tapeline.quailj.typing.classes.utils.QBuiltinFunc;
import me.tapeline.quailj.runtime.RuntimeStriker;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EntityGetLocation extends QBuiltinFunc {

    public EntityGetLocation(Runtime runtime) {
        super(
                "getLocation",
                Arrays.asList(
                        new FuncArgument(
                               "this",
                                QObject.Val(),
                                new int[0],
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
        McEntity thisEntity = McEntity.validate(runtime, args.get("this"));
        Location loc = thisEntity.getEntity().getLocation();

        return Val(new ArrayList<>(Arrays.asList(
                Val(loc.getX()),
                Val(loc.getY()),
                Val(loc.getZ())
        )));
    }

}
