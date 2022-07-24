package me.fanhua.piggies.users.builder;

import com.google.gson.JsonElement;

public interface IUserDataUpdater {

	JsonElement update(JsonElement old);

}
