package com.speedment.infinite_sets.internal;

import com.speedment.infinite_sets.ImmutableStreamSet;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 *
 * @author Per Minborg
 */
public final class PositiveEvenLongSet implements ImmutableStreamSet<Long> {

    public static final PositiveEvenLongSet INSTANCE = new PositiveEvenLongSet();

    private PositiveEvenLongSet() {
    }

    @Override
    public Stream<Long> stream() {
        return LongStream.rangeClosed(1, Long.MAX_VALUE / 2)
            .map(l -> l * 2)
            .boxed();
    }

    @Override
    public int size() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean contains(Object o) {
        return SetUtil.contains(
            this,
            Long.class,
            other -> other > 0 && other % 2 == 0,
            o
        );
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
