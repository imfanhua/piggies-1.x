package me.fanhua.piggies.users;

import me.fanhua.piggies.users.builder.ComponentBuilder;

public interface IComponent {

	static <C extends IComponent> ComponentBuilder<C> builder(Class<C> clazz) {
		return new ComponentBuilder<>(clazz);
	}

}
