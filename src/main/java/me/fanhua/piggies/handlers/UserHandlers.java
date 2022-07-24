package me.fanhua.piggies.handlers;

import me.fanhua.piggies.users.impl.ImplUserManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class UserHandlers implements Listener {

	public static final UserHandlers HANDLERS = new UserHandlers();

	private UserHandlers() {}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		var user = ImplUserManager.users.get(event.getPlayer().getUniqueId());
		if (user != null) user.update(event.getPlayer());
	}

}
