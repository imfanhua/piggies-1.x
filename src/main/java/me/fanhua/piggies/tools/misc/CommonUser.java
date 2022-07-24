package me.fanhua.piggies.tools.misc;

import me.fanhua.piggies.tools.math.RandomTools;
import me.fanhua.piggies.tools.data.UUIDTools;
import org.bukkit.World;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public enum CommonUser {

	KAMUSAMA("055ae9065e48407784706254c15077b7", World.Environment.NETHER),
	UNCLE_RED("30ecf6ccf46f405584c4c8b980c0d6d7", World.Environment.NORMAL),
	MELOR_("442ecf549cac4010b3fb70dc57819ee8", World.Environment.NORMAL),
	HEI_MAO("87cc1b9592fa448ca4fc5164b38fbc47", World.Environment.NORMAL),
	BADCEN("a3c7d62a311c4a28b02c1ba2e27f9e67", World.Environment.THE_END),
	FANHUA("27e30fee5cb846999bd0128bd19309a3", World.Environment.NORMAL),
	;

	public final UUID id;
	public final World.Environment environment;

	CommonUser(String id, World.Environment environment) {
		this.id = UUIDTools.from(id);
		this.environment = environment;
	}

	private static final Map<UUID, CommonUser> MAP = new HashMap<>();

	static {
		for (var instance : CommonUser.values())
			if (instance.id != null) MAP.put(instance.id, instance);
	}

	public static CommonUser fromId(UUID id) {
		return MAP.get(id);
	}

	public static CommonUser fromIdOrRandom(UUID id) {
		var instance = MAP.get(id);
		if (instance == null) {
			instance = RandomTools.next(CommonUser.values());
		}
		return instance;
	}

}
