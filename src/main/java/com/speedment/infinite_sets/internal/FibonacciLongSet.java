package com.speedment.infinite_sets.internal;

import com.speedment.infinite_sets.ImmutableStreamSet;
import java.util.Objects;
import java.util.stream.Stream;

/**
 *
 * @author Per Minborg
 */
public final class FibonacciLongSet implements ImmutableStreamSet<Long> {

    public static final FibonacciLongSet INSTANCE = new FibonacciLongSet();

    private FibonacciLongSet() {
    }

    @Override
    public Stream<Long> stream() {
        return Stream.concat(
            Stream.of(0l),
            Stream.iterate(new Fibonacci(0, 1), Fibonacci::next)
                .mapToLong(Fibonacci::getAsLong)
                .takeWhile(fib -> fib > 0)
                .boxed()
        );
    }

    @Override
    public int size() {
        return 92;
    }

    @Override
    public boolean contains(Object o) {
        return SetUtil.contains(
            this,
            Long.class,
            other -> stream().anyMatch(fib -> Objects.equals(fib, other)),
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

    private static class Fibonacci {

        final long beforeLast;
        final long last;

        public Fibonacci(long beforeLast, long last) {
            this.beforeLast = beforeLast;
            this.last = last;
        }

        public Fibonacci next() {
            return new Fibonacci(last, last + beforeLast);
        }

        public long getAsLong() {
            return beforeLast + last;
        }

    }

}
