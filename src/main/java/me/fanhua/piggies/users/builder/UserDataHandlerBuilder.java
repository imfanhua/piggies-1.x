package me.fanhua.piggies.users.builder;

import com.google.gson.JsonElement;
import me.fanhua.piggies.tools.data.Json;
import me.fanhua.piggies.users.IComponent;
import me.fanhua.piggies.users.data.impl.ImplUserDataHandler;
import org.apache.commons.lang.Validate;

import java.util.ArrayList;
import java.util.List;

public class UserDataHandlerBuilder<C extends IComponent> {

	private record JsonIO<C extends IComponent>(Class<C> clazz) implements IUserDataLoader<C>, IUserDataSerializer<C> {

		@Override
		public C from(JsonElement json) {
			return Json.parse(clazz, json);
		}

		@Override
		public JsonElement to(C component) {
			return Json.as(component);
		}

	}

	public final ComponentBuilder<C> builder;

	private final List<IUserDataUpdater> updaters = new ArrayList<>();
	private IUserDataLoader<C> loader;
	private IUserDataSerializer<C> serializer;

	public UserDataHandlerBuilder(ComponentBuilder<C> builder) {
		this.builder = builder;
	}

	public UserDataHandlerBuilder<C> update(IUserDataUpdater updater) {
		updaters.add(updater);
		return this;
	}

	public UserDataHandlerBuilder<C> from(IUserDataLoader<C> loader) {
		this.loader = loader;
		return this;
	}

	public UserDataHandlerBuilder<C> to(IUserDataSerializer<C> serializer) {
		this.serializer = serializer;
		return this;
	}

	public <I extends IUserDataLoader<C> & IUserDataSerializer<C>> UserDataHandlerBuilder<C> io(I io) {
		this.loader = io;
		this.serializer = io;
		return this;
	}

	public UserDataHandlerBuilder<C> json() {
		return io(new JsonIO<>(builder.clazz));
	}

	public ComponentBuilder<C> build() {
		Validate.notNull(loader, "Loader (method: 'from') cannot be null");
		Validate.notNull(serializer, "Serializer (method: 'to') cannot be null");
		return builder.data(new ImplUserDataHandler<>(updaters, loader, serializer));
	}

}
