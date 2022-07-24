package me.fanhua.piggies.users.impl;

import me.fanhua.piggies.users.*;
import org.bukkit.entity.Player;

import java.util.*;

@Deprecated
public class ImplUserManager implements IUserManager {

	@Deprecated
	public static final ImplUserManager MANAGER = new ImplUserManager();

	@Deprecated
	private ImplUserManager() {}

	@Deprecated
	public static final List<IUserComponent<?>> components = new ArrayList<>();

	@Deprecated
	public static final Map<UUID, ImplUser> users = new HashMap<>();

	@Override
	public IUser get(Player player) {
		var user = users.get(player.getUniqueId());
		if (user == null) {
			user = new ImplUser(player);
			users.put(user.getId(), user);
		}
		return user;
	}

	@Override
	public IUser get(UUID id) {
		var user = users.get(id);
		if (user == null) {
			user = new ImplUser(id);
			users.put(id, user);
		}
		return user;
	}

	@Override
	public <C extends IComponent> IUserComponent<C> register(String key, IComponentController<C> controller) {
		var component = new ImplUserComponent<>(components.size(), key, controller);
		components.add(component);
		return component;
	}

}
