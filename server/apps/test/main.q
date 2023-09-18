import "common.q"
import "bukkit.classes.q"


function onStart() {
    print("Test app started")
    print("Bukkit server name is:", Bukkit.getServer().getName())
    players = [player.getName() for player in Bukkit.getOnlinePlayers()]
    print("Players online:", players)
    print("Total players:", players.size())
}
