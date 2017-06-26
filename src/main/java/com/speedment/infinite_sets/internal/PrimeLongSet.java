package com.speedment.infinite_sets.internal;

import com.speedment.infinite_sets.ImmutableStreamSet;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 *
 * @author Per Minborg
 */
public final class PrimeLongSet implements ImmutableStreamSet<Long> {

    public static final PrimeLongSet INSTANCE = new PrimeLongSet();

    private PrimeLongSet() {
    }

    private static final LongPredicate IS_PRIME =
        x -> LongStream.rangeClosed(2, (long) Math.sqrt(x)).allMatch(n -> x % n != 0);

    @Override
    public Stream<Long> stream() {
        return LongStream.rangeClosed(2, Long.MAX_VALUE)
            .filter(IS_PRIME)
            .boxed();
    }

    @Override
    public int size() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean contains(Object o) {
        return SetUtil.contains(this, Long.class, IS_PRIME::test, o);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        return SetUtil.toString(this);
    }

}
