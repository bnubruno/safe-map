package com.github.bnubruno.safe;

import java.util.Optional;
import java.util.function.Function;

public class Safe {

	public static <I, O, M> O safeConverter(Optional<I> object, Function<I, M> mapFunction,
			Function<M, O> converterFunction) {
		return safeConverter( object, mapFunction, converterFunction, null );
	}

	public static <I, O, M> O safeConverter(Optional<I> object, Function<I, M> getAttribute, Function<M, O> converter,
			O defaultValue) {
		return object.map( getAttribute ).map( converter ).orElse( defaultValue );
	}

	public static <O, I> O safeMap(Optional<I> object, Function<I, O> getAttribute, O defaultValue) {
		return object.map( getAttribute ).orElse( defaultValue );
	}

	public static <O, I> O safeMap(Optional<I> object, Function<I, O> getAttribute) {
		return safeMap( object, getAttribute, (O) null );
	}

}
