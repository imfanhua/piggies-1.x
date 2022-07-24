package me.fanhua.piggies.users.builder;

import com.google.gson.JsonElement;
import me.fanhua.piggies.users.IComponent;

public interface IUserDataSerializer<C extends IComponent> {
	JsonElement to(C component);
}
