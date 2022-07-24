package me.fanhua.piggies.users.builder;

import me.fanhua.piggies.users.IComponent;
import me.fanhua.piggies.users.IUserComponent;
import me.fanhua.piggies.users.data.IUserDataHandler;
import me.fanhua.piggies.users.data.impl.ImplTempUserDataHandler;
import me.fanhua.piggies.users.impl.ImplComponentController;
import me.fanhua.piggies.users.impl.ImplUserManager;
import org.apache.commons.lang.Validate;
import org.bukkit.NamespacedKey;

public class ComponentBuilder<C extends IComponent> {

	public final Class<C> clazz;
	private String key;
	private IUserComponentCreator<C> creator;
	private IUserDataHandler<C> dataHandler;

	public ComponentBuilder(Class<C> clazz) {
		this.clazz = clazz;
		this.dataHandler = ImplTempUserDataHandler.HANDLER;
	}

	public ComponentBuilder<C> key(NamespacedKey key) {
		this.key = key.toString();
		return this;
	}

	public ComponentBuilder<C> create(IUserComponentCreator<C> creator) {
		this.creator = creator;
		return this;
	}

	public ComponentBuilder<C> data(IUserDataHandler<C> handler) {
		dataHandler = handler;
		return this;
	}

	public UserDataHandlerBuilder<C> data() {
		return new UserDataHandlerBuilder<>(this);
	}

	public IUserComponent<C> build() {
		Validate.notNull(creator, "Creator (method: 'create') cannot be null");
		return ImplUserManager.MANAGER.register(key, new ImplComponentController<>(
				creator, dataHandler
		));
	}

}
