package com.speedment.infinite_sets.internal;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author Per Minborg
 */
final class SetUtil {

    private static final int TO_STRING_MAX_ELEMENTS = 8;

    static <E> String toString(Set<E> set) {
        final List<String> first = set.stream()
            .limit(TO_STRING_MAX_ELEMENTS + 1)
            .map(Object::toString)
            .collect(toList());

        final String endMarker = first.size() > TO_STRING_MAX_ELEMENTS ? ", ...]" : "]";

        return first.stream()
            .limit(TO_STRING_MAX_ELEMENTS)
            .collect(
                joining(", ", "[", endMarker)
            );
    }

    static <E> boolean contains(
        final Set<E> set,
        final Class<E> clazz,
        final Predicate<E> predicate,
        final Object o
    ) {
        if (o == null) {
            return false;
        }
        if (!(clazz.isAssignableFrom(o.getClass()))) {
            return false;
        }
        final E other = clazz.cast(o);
        return predicate.test(other);
    }

}
