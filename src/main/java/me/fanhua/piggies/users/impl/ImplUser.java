package me.fanhua.piggies.users.impl;

import me.fanhua.piggies.users.IComponent;
import me.fanhua.piggies.users.IUser;
import me.fanhua.piggies.users.IUserComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Objects;
import java.util.UUID;

@Deprecated
public final class ImplUser implements IUser {

	private final UUID id;
	private String name;

	private final IComponent[] components = new IComponent[ImplUserManager.components.size()];

	@Deprecated
	public ImplUser(Player player) {
		this(player.getUniqueId());
		this.name = player.getName();
	}

	@Deprecated
	public ImplUser(UUID id) {
		this.id = id;
	}

	@Deprecated
	public void update(Player player) {
		this.name = player.getName();
	}

	public UUID getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String mustName() {
		if (this.name == null) this.name = Bukkit.getOfflinePlayer(id).getName();
		return this.name;
	}

	@Override
	public <T extends IComponent> T get(IUserComponent<T> component) {
		var obj = components[component.getIndex()];
		if (obj == null) {
			obj = component.getController().create(this);
			components[component.getIndex()] = obj;
		}
		//noinspection unchecked
		return (T) obj;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ImplUser user = (ImplUser) o;
		return id.equals(user.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
