import java.util.*;

public class Main {

    public static void main(String[] args) {


        ArrayList<Integer> array = new ArrayList();
        LinkedList<Integer> link = new LinkedList();
        HashSet<Integer> hash = new HashSet();
        TreeSet<Integer> tree = new TreeSet();

        System.out.println("Время добавить в ArrayList() = " + add(array));
        System.out.println("Время удалить в ArrayList() = " + remove(array));
        System.out.println("Время поиска в ArrayList() = " + contains(array));
        System.out.println("Время добавить в LinkedList() = " + add(link));
        System.out.println("Время удалить в LinkedList() = " + remove(link));
        System.out.println("Время поиска в LinkedList() = " + contains(link));
        System.out.println("Время добавить в HashSet() = " + add(hash));
        System.out.println("Время удалить в HashSet() = " + remove(hash));
        System.out.println("Время поиска в HashSet() = " + contains(hash));
        System.out.println("Время добавить в TreeSet() = " + add(tree));
        System.out.println("Время удалить в TreeSet() = " + remove(tree));
        System.out.println("Время поиска в TreeSet() = " + contains(tree));


    }

    public static long add(Collection<Integer> collection) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            collection.add(i);
        }
        long end = System.currentTimeMillis() - start;
        return end;
    }

    public static long remove(Collection<Integer> collection) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            collection.remove(i);
        }
        long end = System.currentTimeMillis() - start;
        return end;
    }

    public static long contains(Collection<Integer> collection) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            collection.contains(i);
        }
        long end = System.currentTimeMillis() - start;
        return end;
    }

}