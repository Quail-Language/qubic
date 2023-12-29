class Entity {
    object<World> getWorld(this) {}

    list getlist(this) {}
    void setRotation(this, num yaw, num pitch)
    bool teleport(this, list list) {}

    list getVelocity(this) {}
    void setVelocity(this, list velocity) {}

    num getHeight(this) {}
    num getWidth(this) {}

    bool isOnGround(this) {}
    bool isInWater(this) {}

    list<Entity> getNearbyEntities(this, num x, num y, num z) {}

    num getEntityId(this) {}
    string getUUID(this) {}

    void remove(this) {}

    bool isDead(this) {}
    bool isValid(this) {}

    object<Server> getServer(this) {}

    bool isPersistent(this) {}
    void setPersistent(this, isPersistent) {}

    list<Entity> getPassengers(this) {}
    void addPassenger(this, object<Entity> passenger) {}
    void removePassenger(this, object<Entity> passenger) {}
    bool isNoPassengers(this) {}
    bool ejectPassengers(this) {}

    num getFallDistance(this) {}
    void setFallDistance(this, num distance) {}

    void playEffect(this, string type) {}

    string getType(this) {}

    bool isInsideVehicle(this) {}
    bool leaveVehicle(this) {}

    bool isCustomNameVisible(this) {}
    void setCustomNameVisible(this, bool isCustomNameVisible) {}

    bool isGlowing(this) {}
    void setGlowing(this, bool isGlowing) {}

    bool isInvulnerable(this) {}

    bool isSilent(this) {}
    void setSilent(this, bool isSilent) {}
}


class Player like Entity {
    string getDisplayName(this) {}
    void setDisplayName(this, string name) {}
    
    string getPlayerListName(this) {}
    void setPlayerListName(this, string name) {}
    
    string getPlayerListHeader(this) {}
    string getPlayerListFooter(this) {}
    void setPlayerListHeader(this, string header) {}
    void setPlayerListFooter(this, string footer) {}
    
    void setCompassTarget(this, list loc) {}
    list getCompassTarget(this) {}
    
    string getAddress(this) {}
    void sendRawMessage(this, string message) {}
    void kickPlayer(this, string message) {}
    void chat(this, string msg) {}
    bool performCommand(this, string command) {}

    bool isOnGround(this) {}
    bool isSneaking(this) {}
    void setSneaking(this, bool sneak) {}
    bool isSprinting(this) {}
    void setSprinting(this, bool sprinting) {}

    void setSleepingIgnored(this, bool isSleeping) {}
    bool isSleepingIgnored(this) {}

    list getBedSpawnlist(this) {}
    void setBedSpawnlist(this, list loc, bool force=false) {}
    
    void playNote(this, list loc, num instrument, num note) {}
    void playSound(this, list list, string sound, num volume, num pitch) {}
    void stopSound(this, string sound) {}
    void stopAllSounds(this) {}

    void playEffect(this, list loc, string effect, object data) {}
    bool breakBlock(this, list block) {}

    void updateInventory(this) {}
    GameMode getPreviousGameMode(this) {}
    void setPlayerTime(this, long time, bool relative) {}
    long getPlayerTime(this) {}
    long getPlayerTimeOffset(this) {}
    bool isPlayerTimeRelative(this) {}
    void resetPlayerTime(this) {}
    void setPlayerWeather(this, WeatherType type) {}
    WeatherType getPlayerWeather(this) {}
    void resetPlayerWeather(this) {}
    void giveExp(this, int amount) {}
    void giveExpLevels(this, int amount) {}
    num getExp(this) {}
    void setExp(this, num exp) {}
    int getLevel(this) {}
    void setLevel(this, int level) {}
    int getTotalExperience(this) {}
    void setTotalExperience(this, int exp) {}
    void sendExperienceChange(this, num progress) {}
    void sendExperienceChange(this, num progress, int level) {}
    bool getAllowFlight(this) {}
    void setAllowFlight(this, bool flight) {}
    void hidePlayer(this, Player player) {}
    void hidePlayer(this, Plugin plugin, Player player) {}
    void showPlayer(this, Player player) {}
    void showPlayer(this, Plugin plugin, Player player) {}
    bool canSee(this, Player player) {}
    void hideEntity(this, Plugin plugin, Entity entity) {}
    void showEntity(this, Plugin plugin, Entity entity) {}
    bool canSee(this, Entity entity) {}
    bool isFlying(this) {}
    void setFlying(this, bool value) {}
    void setFlySpeed(this, num value) throws IllegalArgumentException {}
    void setWalkSpeed(this, num value) throws IllegalArgumentException {}
    num getFlySpeed(this) {}
    num getWalkSpeed(this) {}
    void setTexturePack(this, string url) {}
    void setResourcePack(this, string url) {}
    void setResourcePack(this, string url, byte[] hash) {}
    void setResourcePack(this, string url, byte[] hash, string prompt) {}
    void setResourcePack(this, string url, byte[] hash, bool force) {}
    void setResourcePack(this, string url, byte[] hash, string prompt, bool force) {}
    Scoreboard getScoreboard(this) {}
    void setScoreboard(this, Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {}
    WorldBorder getWorldBorder(this) {}
    void setWorldBorder(this, WorldBorder border) {}
    bool isHealthScaled(this) {}
    void setHealthScaled(this, bool scale) {}
    void setHealthScale(this, double scale) throws IllegalArgumentException {}
    double getHealthScale(this) {}
    Entity getSpectatorTarget(this) {}
    void setSpectatorTarget(this, Entity entity) {}
    void sendTitle(this, string title, string subtitle) {}
    void sendTitle(this, string title, string subtitle, int fadeIn, int stay, int fadeOut) {}
    void resetTitle(this) {}
    void spawnParticle(this, Particle particle, list list, int count) {}
    void spawnParticle(this, Particle particle, double x, double y, double z, int count) {}
    <T> void spawnParticle(this, Particle particle, list list, int count, T data) {}
    <T> void spawnParticle(this, Particle particle, double x, double y, double z, int count, T data) {}
    void spawnParticle(this, Particle particle, list list, int count, double offsetX, double offsetY, double offsetZ) {}
    void spawnParticle(this, Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ) {}
    <T> void spawnParticle(this, Particle particle, list list, int count, double offsetX, double offsetY, double offsetZ, T data) {}
    <T> void spawnParticle(this, Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, T data) {}
    void spawnParticle(this, Particle particle, list list, int count, double offsetX, double offsetY, double offsetZ, double extra) {}
    void spawnParticle(this, Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra) {}
    <T> void spawnParticle(this, Particle particle, list list, int count, double offsetX, double offsetY, double offsetZ, double extra, T data) {}
    <T> void spawnParticle(this, Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, T data) {}
    AdvancementProgress getAdvancementProgress(this, Advancement advancement) {}
    int getClientViewDistance(this) {}
    int getPing(this) {}
    string getLocale(this) {}
    void updateCommands(this) {}
    void openBook(this, ItemStack book) {}
    void openSign(this, Sign sign) {}
    void showDemoScreen(this) {}
    bool isAllowingServerListings(this) {}
}