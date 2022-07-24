package me.fanhua.piggies.users;

import me.fanhua.piggies.users.data.IUserDataHandler;

public interface IComponentController<C extends IComponent> {

	IUserDataHandler<C> getDataHandler();
	C create(IUser user);

}
