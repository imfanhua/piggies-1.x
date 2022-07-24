package me.fanhua.piggies.tools.users;

import me.fanhua.piggies.users.*;
import me.fanhua.piggies.users.impl.ImplUserManager;
import org.bukkit.entity.Player;

import java.util.UUID;

public final class Users {

	private Users() {}

	public static IUserManager manager() { return ImplUserManager.MANAGER; }
	public static <C extends IComponent> IUserComponent<C> register(String key, IComponentController<C> controller) { return ImplUserManager.MANAGER.register(key, controller); }
	public static IUser get(Player player) { return ImplUserManager.MANAGER.get(player); }
	public static IUser get(UUID id) { return ImplUserManager.MANAGER.get(id); }

}
