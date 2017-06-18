# infinite-sets
A Demonstration of Infinite Sets under Java 9. You could easily backport the module to Java 8.

This is how you could use this module from your code:

### Main.java
```
import com.speedment.infinite_sets.ImmutableStreamSet;
import static com.speedment.infinite_sets.Sets.*;
import java.util.Collections;
import java.util.Set;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 *
 * @author Per Minborg
 */
public class Main {

    public static void main(String[] args) {

        Stream.of(
            Set.of(1, 2, 3),
            positiveLongSet(),
            positiveEvenLongSet(),
            primeLongSet(),
            fibonacciLongSet()
        ).forEachOrdered(System.out::println);

        positiveLongSet().containsAll(positiveLongSet());

        Set<String> first = ImmutableStreamSet.of(() -> Stream.of("A", "B", "C"));
        System.out.println(first);
        System.out.println("size: " + first.size());
        System.out.println("contains A: " + first.contains("A"));

        Set<Integer> first2 = ImmutableStreamSet.of(() -> Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(first2);

        System.out.println(primeLongSet().contains(3l));
        System.out.println(primeLongSet().contains(4l));

        final Set<Long> setOfAllLongs = ImmutableStreamSet.of(
            () -> LongStream.rangeClosed(Long.MIN_VALUE, Long.MAX_VALUE).boxed()
        );

    }

}
```

You need to declade a module dependency before you use the module. This is how it might look like:

### module-info.java
```
module Infinite_sets_app {
    requires com.speedment.infinite_sets;
}
```







