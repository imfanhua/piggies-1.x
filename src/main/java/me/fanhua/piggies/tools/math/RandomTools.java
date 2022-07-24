package me.fanhua.piggies.tools.math;

import java.util.List;
import java.util.Random;

public final class RandomTools {

	private RandomTools() {}

	public static final Random RANDOM = new Random();

	public static <T> T next(T[] array) {
		return array == null || array.length < 1 ? null : array[RANDOM.nextInt(array.length)];
	}

	public static <T> int nextIndex(T[] array) {
		return array == null || array.length < 1 ? -1 : RANDOM.nextInt(array.length);
	}

	public static <T> T next(List<T> array) {
		return array == null || array.size() < 1 ? null : array.get(RANDOM.nextInt(array.size()));
	}

	public static <T> int nextIndex(List<T> array) {
		return array == null || array.size() < 1 ? -1 : RANDOM.nextInt(array.size());
	}

}
