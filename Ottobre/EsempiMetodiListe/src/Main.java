import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        // add
        integerList.add(10);
        integerList.add(20);

        // remove
        integerList.remove(Integer.valueOf(10));

        // forEach
        integerList.forEach(System.out::println);

        // addFirst
        integerList.add(0, 5);

        // addLast
        integerList.add(25);

        // clear
        integerList.clear();

        // contains
        boolean contains = integerList.contains(20);

        // getFirst
        Integer first = integerList.isEmpty() ? null : integerList.get(0);

        // getLast
        Integer last = integerList.isEmpty() ? null : integerList.get(integerList.size() - 1);

        // indexOf
        int index = integerList.indexOf(20);

        // isEmpty
        boolean isEmpty = integerList.isEmpty();

        // lastIndexOf
        int lastIndex = integerList.lastIndexOf(20);

        // removeFirst
        if (!integerList.isEmpty()) {
            integerList.remove(0);
        }

        // removeLast
        if (!integerList.isEmpty()) {
            integerList.remove(integerList.size() - 1);
        }

        // set
        integerList.add(10);
        integerList.set(0, 15);

        // equals
        boolean equals = integerList.equals(new ArrayList<>(List.of(15)));

        // size
        int size = integerList.size();

        // reversed
        Collections.reverse(integerList);
    }
}