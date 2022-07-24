package me.fanhua.piggies.users;

import me.fanhua.piggies.users.impl.ImplUserManager;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface IUserComponent<T extends IComponent> {

	String getKey();
	int getIndex();
	IComponentController<T> getController();

	default T from(Player player) {
		return ImplUserManager.MANAGER.get(player).get(this);
	}

	default T from(UUID id) {
		return ImplUserManager.MANAGER.get(id).get(this);
	}

}
