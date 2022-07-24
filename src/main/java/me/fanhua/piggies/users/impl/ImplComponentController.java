package me.fanhua.piggies.users.impl;

import me.fanhua.piggies.users.IComponent;
import me.fanhua.piggies.users.IComponentController;
import me.fanhua.piggies.users.IUser;
import me.fanhua.piggies.users.builder.IUserComponentCreator;
import me.fanhua.piggies.users.data.IUserDataHandler;

@Deprecated
public final class ImplComponentController<C extends IComponent> implements IComponentController<C> {

	private final IUserComponentCreator<C> creator;
	private final IUserDataHandler<C> dataHandler;

	@Deprecated
	public ImplComponentController(IUserComponentCreator<C> creator, IUserDataHandler<C> dataHandler) {
		this.creator = creator;
		this.dataHandler = dataHandler;
	}

	@Override
	public IUserDataHandler<C> getDataHandler() {
		return dataHandler;
	}

	@Override
	public C create(IUser user) {
		return creator.create();
	}
}
