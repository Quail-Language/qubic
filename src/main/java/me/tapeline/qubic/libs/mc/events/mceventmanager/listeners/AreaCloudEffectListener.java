package me.tapeline.qubic.libs.mc.events.mceventmanager.listeners;

import me.tapeline.quailj.runtime.Runtime;
import me.tapeline.quailj.typing.classes.QFunc;
import me.tapeline.quailj.typing.classes.QObject;
import org.bukkit.event.entity.AreaEffectCloudApplyEvent;

public class AreaCloudEffectListener extends AbstractMcListener<AreaEffectCloudApplyEvent> {

    public AreaCloudEffectListener(Runtime boundRuntime, QFunc boundHandler) {
        super(boundRuntime, boundHandler);
    }

    @Override
    public QObject[] getArgumentsToPass(AreaEffectCloudApplyEvent event) {
        return new QObject[] {};
    }

}
