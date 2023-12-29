package me.tapeline.qubic.libs.mc.entity.entity;

import me.tapeline.quailj.parsing.nodes.literals.LiteralFunction;
import me.tapeline.quailj.runtime.Runtime;
import me.tapeline.quailj.typing.modifiers.ModifierConstants;
import me.tapeline.quailj.typing.classes.QObject;
import me.tapeline.quailj.typing.utils.FuncArgument;
import me.tapeline.quailj.typing.classes.utils.QBuiltinFunc;
import me.tapeline.quailj.runtime.RuntimeStriker;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EntitySetVelocity extends QBuiltinFunc {

    public EntitySetVelocity(Runtime runtime) {
        super(
                "setVelocity",
                Arrays.asList(
                        new FuncArgument(
                               "this",
                                QObject.Val(),
                                new int[0],
                                LiteralFunction.Argument.POSITIONAL
                        ),
                        new FuncArgument(
                               "velocity",
                                QObject.Val(),
                                new int[] {ModifierConstants.LIST},
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
        thisEntity.getEntity().setVelocity(new Vector(
                args.get("velocity").listValue().get(0).numValue(),
                args.get("velocity").listValue().get(1).numValue(),
                args.get("velocity").listValue().get(2).numValue()
        ));
        return Val();
    }

}
