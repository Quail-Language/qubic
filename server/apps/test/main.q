import "common.q"
import "bukkit.classes.q"


function onStart() {
    print("Test app started")
    print("Bukkit server name is:", Bukkit.getServer().getName())
    players = [player.getName() for player in Bukkit.getOnlinePlayers()]
    print("Players online:", players)
    print("Total players:", players.size())

}

# Replace regex:    on ([a-zA-Z_]*) ([a-zA-Z_]*) \{((.*\n)*?)\}
# With:             mc.events.registerHandler("$1", function ($2) {$3})
