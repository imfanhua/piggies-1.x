package me.fanhua.piggies.users.impl;

import me.fanhua.piggies.users.IComponent;
import me.fanhua.piggies.users.IComponentController;
import me.fanhua.piggies.users.IUserComponent;

@Deprecated
public final class ImplUserComponent<C extends IComponent> implements IUserComponent<C> {

	private final int index;
	private final String key;
	private final IComponentController<C> controller;

	@Deprecated
	public ImplUserComponent(int index, String key, IComponentController<C> controller) {
		this.index = index;
		this.key = key;
		this.controller = controller;
	}

	@Override
	public String getKey() {
		return this.key;
	}

	@Override
	public int getIndex() {
		return this.index;
	}

	@Override
	public IComponentController<C> getController() {
		return this.controller;
	}

}
