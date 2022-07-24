package me.fanhua.piggies.parts;

import org.bukkit.persistence.PersistentDataContainer;

public interface IPart {

	void readFrom(PersistentDataContainer io);
	void saveTo(PersistentDataContainer io);

}
