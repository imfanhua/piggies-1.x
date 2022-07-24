package me.fanhua.piggies.users.builder;

import me.fanhua.piggies.users.IComponent;

public interface IUserComponentCreator<C extends IComponent> {
	C create();
}
