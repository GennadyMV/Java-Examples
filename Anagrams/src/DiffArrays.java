import java.util.*;

public class DiffArrays {
    public static void main(String[] args) {
        Set<Character> objectsA = new HashSet<>();
        char[] a = {'q', 'q', 'D', '1', 'F'};
        char[] b = {'c', 'd', '2', '1', 'M', 'q'};
        Set<Object> objectsB = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            for (int i1 = 0; i1 < b.length; i1++) {
                objectsB.add(a[i]);
                objectsB.add(b[i1]);
            }
            objectsA.add(a[i]);
        }
        Iterator iterator = objectsB.iterator();
        while (iterator.hasNext()) {
            for (Object o : objectsA) {
                if (iterator.next().equals(o)) {
                    iterator.remove();
                }
            }
        }
        System.out.println(objectsB);
    }
}

