package com.speedment.infinite_sets.internal;

import com.speedment.infinite_sets.ImmutableStreamSet;
import static java.util.Objects.requireNonNull;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *
 * @author Per Minborg
 */
public final class ImmutableStreamSetImpl<E> implements ImmutableStreamSet<E> {

    private final Supplier<Stream<E>> supplier;

    public ImmutableStreamSetImpl(Supplier<Stream<E>> supplier) {
        this.supplier = requireNonNull(supplier);
    }

    @Override
    public Stream<E> stream() {
        return supplier.get();
    }

    @Override
    public String toString() {
        return SetUtil.toString(this);
    }

}
