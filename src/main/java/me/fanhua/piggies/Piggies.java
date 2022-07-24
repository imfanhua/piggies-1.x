package me.fanhua.piggies;

import me.fanhua.piggies.handlers.UserHandlers;

public final class Piggies extends PiggyPlugin<Piggies> {

	private static Piggies INSTANCE;
	public static Piggies instance() {
		return INSTANCE;
	}

	@Override
	protected void instance(Piggies instance, boolean set) {
		if (set || INSTANCE == instance) INSTANCE = instance;
	}

	@Override
	protected void init() {
		events(UserHandlers.HANDLERS);
	}

}
