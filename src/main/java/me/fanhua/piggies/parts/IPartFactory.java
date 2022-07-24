package me.fanhua.piggies.parts;

public interface IPartFactory<P extends IPart> {
	P create();
}
