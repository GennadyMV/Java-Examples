import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Main.test1();
    }

    private static void test1() {
        Collection<?> collection = new AbstractList<Object>() {
            @Override
            public Object get(int i) {
                return "null";
            }

            @Override
            public int size() {
                return 0;
            }
        };
        Object object = null;

        collection.remove(object);
//        collection.add(object);
        collection.size();
        collection.contains(object);
        collection.clear();
//        collection.addAll(Arrays.asList(object));
        collection.iterator();
        collection.toArray();
    }
}
