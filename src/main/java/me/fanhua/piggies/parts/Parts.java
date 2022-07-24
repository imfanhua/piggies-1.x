package me.fanhua.piggies.parts;

import org.bukkit.entity.Player;

import java.util.*;

public final class Parts {

	private static final class PartsBank {
		public final IPart[] parts = new IPart[SIZE];
	}

	private Parts() {}

	@Deprecated
	private static final List<IPartFactory<?>> PARTS = new ArrayList<>();
	private static final Map<UUID, PartsBank> BANKS = new HashMap<>();

	private static int SIZE;

	public static <P extends IPart> Part<P> register(IPartFactory<P> factory) {
		var index = PARTS.size();
		PARTS.add(factory);
		SIZE = index + 1;
		return new Part<P>(index);
	}

	public static <P extends IPart> P get(Player player, Part<P> part) {
		var bank = BANKS.get(player.getUniqueId());
		if (bank == null) {
			bank = new PartsBank();
			BANKS.put(player.getUniqueId(), bank);
		}
		var value = bank.parts[part.index()];
		if (value == null) {
			value = PARTS.get(part.index()).create();
			bank.parts[part.index()] = value;
		}
		//noinspection unchecked
		return (P) value;
	}

}
