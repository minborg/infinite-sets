package com.speedment.infinite_sets;

import com.speedment.infinite_sets.internal.FibonacciLongSet;
import com.speedment.infinite_sets.internal.PositiveEvenLongSet;
import com.speedment.infinite_sets.internal.PositiveLongSet;
import com.speedment.infinite_sets.internal.PrimeLongSet;
import java.util.Set;

/**
 *
 * @author Per Minborg
  */
public interface Sets  {

    static Set<Long> positiveLongSet() {
        return PositiveLongSet.INSTANCE;
    }

    static Set<Long> positiveEvenLongSet() {
        return PositiveEvenLongSet.INSTANCE;
    }

    static Set<Long> primeLongSet() {
        return PrimeLongSet.INSTANCE;
    }

    static Set<Long> fibonacciLongSet() {
        return FibonacciLongSet.INSTANCE;
    }

}
