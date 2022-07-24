package me.fanhua.piggies.users.data;

import com.google.gson.JsonElement;
import me.fanhua.piggies.users.IComponent;
import me.fanhua.piggies.users.IUser;
import me.fanhua.piggies.users.IUserComponent;

public interface IUserDataHandler<C extends IComponent> {

	C from(IUserComponent<C> userComponent, IUser user, JsonElement json);
	JsonElement to(IUserComponent<C> userComponent, IUser user, C component);

}
