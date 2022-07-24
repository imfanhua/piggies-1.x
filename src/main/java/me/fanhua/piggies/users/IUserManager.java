package me.fanhua.piggies.users;

import org.bukkit.entity.Player;

import java.util.UUID;

public interface IUserManager {

	IUser get(Player player);
	IUser get(UUID id);
	<C extends IComponent> IUserComponent<C> register(String key, IComponentController<C> controller);

}
