package me.fanhua.piggies.users.data.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import me.fanhua.piggies.users.IComponent;
import me.fanhua.piggies.users.IUser;
import me.fanhua.piggies.users.IUserComponent;
import me.fanhua.piggies.users.builder.IUserDataLoader;
import me.fanhua.piggies.users.builder.IUserDataSerializer;
import me.fanhua.piggies.users.builder.IUserDataUpdater;
import me.fanhua.piggies.users.data.IUserDataHandler;

import java.util.List;

@Deprecated
public final class ImplUserDataHandler<C extends IComponent> implements IUserDataHandler<C> {

	private final IUserDataUpdater[] updaters;
	private final IUserDataLoader<C> loader;
	private final IUserDataSerializer<C> serializer;

	@Deprecated
	public ImplUserDataHandler(List<IUserDataUpdater> updaters,
								  IUserDataLoader<C> loader,
								  IUserDataSerializer<C> serializer) {
		this.updaters = updaters.toArray(IUserDataUpdater[]::new);
		this.loader = loader;
		this.serializer = serializer;
	}

	@Override
	public C from(IUserComponent<C> userComponent, IUser user, JsonElement json) {
		var array = json.getAsJsonArray();
		var version = array.get(0).getAsInt();
		var data = array.get(1);
		for (var i = version; i < updaters.length; i++)
			data = updaters[i].update(data);
		return loader.from(data);
	}

	@Override
	public JsonElement to(IUserComponent<C> userComponent, IUser user, C component) {
		var array = new JsonArray();
		array.add(updaters.length);
		array.add(serializer.to(component));
		return array;
	}

}
