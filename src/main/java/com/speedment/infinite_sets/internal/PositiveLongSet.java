package com.speedment.infinite_sets.internal;

import com.speedment.infinite_sets.ImmutableStreamSet;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 *
 * @author Per Minborg
 */
public final class PositiveLongSet implements ImmutableStreamSet<Long> {

    public static final PositiveLongSet INSTANCE = new PositiveLongSet();

    private PositiveLongSet() {
    }

    @Override
    public Stream<Long> stream() {
        return LongStream.rangeClosed(1, Long.MAX_VALUE).boxed();
    }

    @Override
    public int size() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean contains(Object o) {
        return SetUtil.contains(this, Long.class, other -> other > 0, o);
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
