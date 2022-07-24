package me.fanhua.piggies.users.builder;

import com.google.gson.JsonElement;
import me.fanhua.piggies.users.IComponent;

public interface IUserDataLoader<C extends IComponent> {
	C from(JsonElement json);
}
