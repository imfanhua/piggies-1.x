package me.fanhua.piggies.users.data.impl;

import com.google.gson.JsonElement;
import me.fanhua.piggies.users.IComponent;
import me.fanhua.piggies.users.IUser;
import me.fanhua.piggies.users.IUserComponent;
import me.fanhua.piggies.users.data.IUserDataHandler;
import me.fanhua.piggies.users.impl.ImplUserManager;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Deprecated
@SuppressWarnings("rawtypes")
public final class ImplTempUserDataHandler implements IUserDataHandler {

	private static class PlayerBank {
		public final IComponent[] components = new IComponent[ImplUserManager.components.size()];
	}

	public static final ImplTempUserDataHandler HANDLER = new ImplTempUserDataHandler();
	private static final Map<UUID, PlayerBank> BANK = new HashMap<>();

	@Override
	public IComponent from(IUserComponent userComponent, IUser user, JsonElement json) {
		var bank = BANK.get(user.getId());
		return bank == null ? null : bank.components[userComponent.getIndex()];
	}

	@Override
	public JsonElement to(IUserComponent userComponent, IUser user, IComponent component) {
		var bank = BANK.get(user.getId());
		if (bank == null) {
			bank = new PlayerBank();
			BANK.put(user.getId(), bank);
		}
		bank.components[userComponent.getIndex()] = component;
		return null;
	}
}
