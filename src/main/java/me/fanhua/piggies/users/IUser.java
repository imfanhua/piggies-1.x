package me.fanhua.piggies.users;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface IUser {

	UUID getId();
	String getName();
	String mustName();

	<C extends IComponent> C get(IUserComponent<C> component);

	default Player getPlayer() {
		return Bukkit.getPlayer(this.getId());
	}

	default OfflinePlayer getOfflinePlayer() {
		return Bukkit.getOfflinePlayer(this.getId());
	}

	@Override
	boolean equals(Object other);
	@Override
	int hashCode();

}
