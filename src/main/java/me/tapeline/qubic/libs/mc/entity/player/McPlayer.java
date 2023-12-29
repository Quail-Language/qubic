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
                            new Pair<>("getAddress", new McPlayerFuncGetAddress(runtime)),
                            new Pair<>("getDisplayName", new McPlayerFuncGetDisplayName(runtime)),
                            new Pair<>("getCompassTarget", new McPlayerFuncGetCompassTarget(runtime)),
                            new Pair<>("sendRawMessage", new McPlayerFuncSendRawMessage(runtime)),
                            new Pair<>("kickPlayer", new McPlayerFuncKickPlayer(runtime)),
                            new Pair<>("chat", new McPlayerFuncChat(runtime)),
                            new Pair<>("performCommand", new McPlayerFuncPerformCommand(runtime)),
                            new Pair<>("setDisplayName", new McPlayerFuncSetDisplayName(runtime)),
                            new Pair<>("setCompassTarget", new McPlayerFuncSetCompassTarget(runtime)),
                            new Pair<>("getPlayerListName", new McPlayerFuncGetPlayerListName(runtime)),
                            new Pair<>("getPreviousGameMode", new McPlayerFuncGetPreviousGameMode(runtime)),
                            new Pair<>("sendExperienceChange", new McPlayerFuncSendExperienceChange(runtime)),
                            new Pair<>("sendExperienceChange", new McPlayerFuncSendExperienceChange(runtime)),
                            new Pair<>("getSpectatorTarget", new McPlayerFuncGetSpectatorTarget(runtime)),
                            new Pair<>("isSleepingIgnored", new McPlayerFuncIsSleepingIgnored(runtime)),
                            new Pair<>("getTotalExperience", new McPlayerFuncGetTotalExperience(runtime)),
                            new Pair<>("setPlayerListName", new McPlayerFuncSetPlayerListName(runtime)),
                            new Pair<>("getAdvancementProgress", new McPlayerFuncGetAdvancementProgress(runtime)),
                            new Pair<>("setBedSpawnLocation", new McPlayerFuncSetBedSpawnLocation(runtime)),
                            new Pair<>("setBedSpawnLocation", new McPlayerFuncSetBedSpawnLocation(runtime)),
                            new Pair<>("getClientViewDistance", new McPlayerFuncGetClientViewDistance(runtime)),
                            new Pair<>("setSleepingIgnored", new McPlayerFuncSetSleepingIgnored(runtime)),
                            new Pair<>("getPlayerListHeader", new McPlayerFuncGetPlayerListHeader(runtime)),
                            new Pair<>("getPlayerListFooter", new McPlayerFuncGetPlayerListFooter(runtime)),
                            new Pair<>("setSpectatorTarget", new McPlayerFuncSetSpectatorTarget(runtime)),
                            new Pair<>("isAllowingServerListings", new McPlayerFuncIsAllowingServerListings(runtime)),
                            new Pair<>("setPlayerListHeader", new McPlayerFuncSetPlayerListHeader(runtime)),
                            new Pair<>("setTotalExperience", new McPlayerFuncSetTotalExperience(runtime)),
                            new Pair<>("getBedSpawnLocation", new McPlayerFuncGetBedSpawnLocation(runtime)),
                            new Pair<>("setPlayerListHeaderFooter", new McPlayerFuncSetPlayerListHeaderFooter(runtime)),
                            new Pair<>("sendEquipmentChange", new McPlayerFuncSendEquipmentChange(runtime)),
                            new Pair<>("getPlayerTimeOffset", new McPlayerFuncGetPlayerTimeOffset(runtime)),
                            new Pair<>("setPlayerListFooter", new McPlayerFuncSetPlayerListFooter(runtime)),
                            new Pair<>("isPlayerTimeRelative", new McPlayerFuncIsPlayerTimeRelative(runtime)),
                            new Pair<>("resetPlayerWeather", new McPlayerFuncResetPlayerWeather(runtime)),
                            new Pair<>("playNote", new McPlayerFuncPlayNote(runtime)),
                            new Pair<>("playNote", new McPlayerFuncPlayNote(runtime)),
                            new Pair<>("setLevel", new McPlayerFuncSetLevel(runtime)),
                            new Pair<>("getAllowFlight", new McPlayerFuncGetAllowFlight(runtime)),
                            new Pair<>("isSneaking", new McPlayerFuncIsSneaking(runtime)),
                            new Pair<>("canSee", new McPlayerFuncCanSee(runtime)),
                            new Pair<>("canSee", new McPlayerFuncCanSee(runtime)),
                            new Pair<>("getHealthScale", new McPlayerFuncGetHealthScale(runtime)),
                            new Pair<>("spawnParticle", new McPlayerFuncSpawnParticle(runtime)),
                            new Pair<>("spawnParticle", new McPlayerFuncSpawnParticle(runtime)),
                            new Pair<>("spawnParticle", new McPlayerFuncSpawnParticle(runtime)),
                            new Pair<>("spawnParticle", new McPlayerFuncSpawnParticle(runtime)),
                            new Pair<>("spawnParticle", new McPlayerFuncSpawnParticle(runtime)),
                            new Pair<>("spawnParticle", new McPlayerFuncSpawnParticle(runtime)),
                            new Pair<>("spawnParticle", new McPlayerFuncSpawnParticle(runtime)),
                            new Pair<>("spawnParticle", new McPlayerFuncSpawnParticle(runtime)),
                            new Pair<>("spawnParticle", new McPlayerFuncSpawnParticle(runtime)),
                            new Pair<>("spawnParticle", new McPlayerFuncSpawnParticle(runtime)),
                            new Pair<>("spawnParticle", new McPlayerFuncSpawnParticle(runtime)),
                            new Pair<>("spawnParticle", new McPlayerFuncSpawnParticle(runtime)),
                            new Pair<>("isOnGround", new McPlayerFuncIsOnGround(runtime)),
                            new Pair<>("showEntity", new McPlayerFuncShowEntity(runtime)),
                            new Pair<>("setSneaking", new McPlayerFuncSetSneaking(runtime)),
                            new Pair<>("playSound", new McPlayerFuncPlaySound(runtime)),
                            new Pair<>("playSound", new McPlayerFuncPlaySound(runtime)),
                            new Pair<>("playSound", new McPlayerFuncPlaySound(runtime)),
                            new Pair<>("playSound", new McPlayerFuncPlaySound(runtime)),
                            new Pair<>("playSound", new McPlayerFuncPlaySound(runtime)),
                            new Pair<>("playSound", new McPlayerFuncPlaySound(runtime)),
                            new Pair<>("isSprinting", new McPlayerFuncIsSprinting(runtime)),
                            new Pair<>("sendMap", new McPlayerFuncSendMap(runtime)),
                            new Pair<>("getFlySpeed", new McPlayerFuncGetFlySpeed(runtime)),
                            new Pair<>("setTexturePack", new McPlayerFuncSetTexturePack(runtime)),
                            new Pair<>("resetPlayerTime", new McPlayerFuncResetPlayerTime(runtime)),
                            new Pair<>("setAllowFlight", new McPlayerFuncSetAllowFlight(runtime)),
                            new Pair<>("setPlayerTime", new McPlayerFuncSetPlayerTime(runtime)),
                            new Pair<>("giveExp", new McPlayerFuncGiveExp(runtime)),
                            new Pair<>("updateInventory", new McPlayerFuncUpdateInventory(runtime)),
                            new Pair<>("hideEntity", new McPlayerFuncHideEntity(runtime)),
                            new Pair<>("getWalkSpeed", new McPlayerFuncGetWalkSpeed(runtime)),
                            new Pair<>("stopAllSounds", new McPlayerFuncStopAllSounds(runtime)),
                            new Pair<>("setResourcePack", new McPlayerFuncSetResourcePack(runtime)),
                            new Pair<>("setResourcePack", new McPlayerFuncSetResourcePack(runtime)),
                            new Pair<>("setResourcePack", new McPlayerFuncSetResourcePack(runtime)),
                            new Pair<>("setResourcePack", new McPlayerFuncSetResourcePack(runtime)),
                            new Pair<>("setResourcePack", new McPlayerFuncSetResourcePack(runtime)),
                            new Pair<>("getWorldBorder", new McPlayerFuncGetWorldBorder(runtime)),
                            new Pair<>("saveData", new McPlayerFuncSaveData(runtime)),
                            new Pair<>("setHealthScaled", new McPlayerFuncSetHealthScaled(runtime)),
                            new Pair<>("setHealthScale", new McPlayerFuncSetHealthScale(runtime)),
                            new Pair<>("loadData", new McPlayerFuncLoadData(runtime)),
                            new Pair<>("getScoreboard", new McPlayerFuncGetScoreboard(runtime)),
                            new Pair<>("setSprinting", new McPlayerFuncSetSprinting(runtime)),
                            new Pair<>("getExp", new McPlayerFuncGetExp(runtime)),
                            new Pair<>("isHealthScaled", new McPlayerFuncIsHealthScaled(runtime)),
                            new Pair<>("sendTitle", new McPlayerFuncSendTitle(runtime)),
                            new Pair<>("sendTitle", new McPlayerFuncSendTitle(runtime)),
                            new Pair<>("setExp", new McPlayerFuncSetExp(runtime)),
                            new Pair<>("showPlayer", new McPlayerFuncShowPlayer(runtime)),
                            new Pair<>("showPlayer", new McPlayerFuncShowPlayer(runtime)),
                            new Pair<>("getLevel", new McPlayerFuncGetLevel(runtime)),
                            new Pair<>("getPlayerWeather", new McPlayerFuncGetPlayerWeather(runtime)),
                            new Pair<>("breakBlock", new McPlayerFuncBreakBlock(runtime)),
                            new Pair<>("setFlying", new McPlayerFuncSetFlying(runtime)),
                            new Pair<>("sendBlockChange", new McPlayerFuncSendBlockChange(runtime)),
                            new Pair<>("sendBlockChange", new McPlayerFuncSendBlockChange(runtime)),
                            new Pair<>("sendSignChange", new McPlayerFuncSendSignChange(runtime)),
                            new Pair<>("sendSignChange", new McPlayerFuncSendSignChange(runtime)),
                            new Pair<>("sendSignChange", new McPlayerFuncSendSignChange(runtime)),
                            new Pair<>("setFlySpeed", new McPlayerFuncSetFlySpeed(runtime)),
                            new Pair<>("resetTitle", new McPlayerFuncResetTitle(runtime)),
                            new Pair<>("getPing", new McPlayerFuncGetPing(runtime)),
                            new Pair<>("updateCommands", new McPlayerFuncUpdateCommands(runtime)),
                            new Pair<>("getLocale", new McPlayerFuncGetLocale(runtime)),
                            new Pair<>("openBook", new McPlayerFuncOpenBook(runtime)),
                            new Pair<>("openSign", new McPlayerFuncOpenSign(runtime)),
                            new Pair<>("hidePlayer", new McPlayerFuncHidePlayer(runtime)),
                            new Pair<>("hidePlayer", new McPlayerFuncHidePlayer(runtime)),
                            new Pair<>("isFlying", new McPlayerFuncIsFlying(runtime)),
                            new Pair<>("giveExpLevels", new McPlayerFuncGiveExpLevels(runtime)),
                            new Pair<>("setWalkSpeed", new McPlayerFuncSetWalkSpeed(runtime)),
                            new Pair<>("getPlayerTime", new McPlayerFuncGetPlayerTime(runtime)),
                            new Pair<>("setScoreboard", new McPlayerFuncSetScoreboard(runtime)),
                            new Pair<>("sendBlockDamage", new McPlayerFuncSendBlockDamage(runtime)),
                            new Pair<>("setWorldBorder", new McPlayerFuncSetWorldBorder(runtime)),
                            new Pair<>("playEffect", new McPlayerFuncPlayEffect(runtime)),
                            new Pair<>("playEffect", new McPlayerFuncPlayEffect(runtime)),
                            new Pair<>("setPlayerWeather", new McPlayerFuncSetPlayerWeather(runtime)),
                            new Pair<>("stopSound", new McPlayerFuncStopSound(runtime)),
                            new Pair<>("stopSound", new McPlayerFuncStopSound(runtime)),
                            new Pair<>("stopSound", new McPlayerFuncStopSound(runtime)),
                            new Pair<>("stopSound", new McPlayerFuncStopSound(runtime)),
                            new Pair<>("showDemoScreen", new McPlayerFuncShowDemoScreen(runtime)),
                            new Pair<>("spigot", new McPlayerFuncSpigot(runtime)),
                            new Pair<>("spigot", new McPlayerFuncSpigot(runtime)),
                            new Pair<>("spigot", new McPlayerFuncSpigot(runtime))
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
