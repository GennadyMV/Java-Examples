import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DiffArrays {
    public static void main(String[] args) {
        {
//        Set<Character> objectsA = new HashSet<>();
//        char[] a = {'q', 'q', 'D', '1', 'F'};
//        char[] b = {'c', 'd', '2', '1', 'M', 'q'};
//        Set<Object> objectsB = new HashSet<>();
//        for (int i = 0; i < a.length; i++) {
//            for (int i1 = 0; i1 < b.length; i1++) {
//                objectsB.add(a[i]);
//                objectsB.add(b[i1]);
//            }
//            objectsA.add(a[i]);
//        }
//        Iterator iterator = objectsB.iterator();
//        while (iterator.hasNext()) {
//            for (Object o : objectsA) {
//                if (iterator.next().equals(o)) {
//                    iterator.remove();
//                }
//            }
//        }
//        System.out.println(objectsB);


            Character[] a = {'q', 'Q', 'D', '1', 'F'};
            Character[] b = {'c', 'd', '2', '1', 'M', 'q'};
            Set<Character> intersec = new HashSet<>();
            Set<Character> union = new HashSet<>();
//        for (int i = 0; i < a.length; i++) {  //O(n)
//            union.add(a[i]);
//            intersec.add(a[i]);
//        }
            Set<Character> objectsB = new HashSet<>();
            intersec.addAll(Arrays.asList(a));
            union.addAll(Arrays.asList(b));
            union.addAll(Arrays.asList(a));
            objectsB.addAll(Arrays.asList(b));
//        for (int i1 = 0; i1 < b.length; i1++) {  //O(n)
//            union.add(b[i1]);
//            objectsB.add(b[i1]);
//        }

            IntStream.range(1, 100).parallel().reduce(new IntBinaryOperator() {
                @Override
                public int applyAsInt(int i, int i1) {
                    return i * i1;
                }
            }).ifPresent(new IntConsumer() {
                @Override
                public void accept(int i) {
                    System.out.println(i);
                }
            });

            IntStream.range(1, 20).filter(new IntPredicate() {
                @Override
                public boolean test(int i) {
                    return i % 2 == 0;
                }
            }).reduce(new IntBinaryOperator() {
                @Override
                public int applyAsInt(int i, int i1) {
                    return i + i1;
                }
            }).ifPresent(new IntConsumer() {
                @Override
                public void accept(int i) {
                    System.out.println(i);
                }
            });

            intersec.removeIf(character -> !objectsB.contains(character));
//        intersec.removeAll(objectsB);

//        for (Iterator<Character> i = intersec.iterator(); i.hasNext();) { //O(n)
//            Character in = i.next();
//            if (!objectsB.contains(in)) { //O(1)
//                i.remove();
//            }
//        }

//        union.removeAll(intersec);
            union.removeAll(intersec);

//        for (Character ch : intersec) { //O(n)
//            union.remove(ch);
//        }
            System.out.println(union);
        }
        {
            char[] n = {'q', 'Q', 'D', '1', 'F'};

            Character[] a = {'q', 'Q', 'D', '1', 'F'};
            Character[] b = {'c', 'd', '2', '1', 'M', 'q'};
            Set<Character> aSet = new HashSet<>(Arrays.asList(a));
            HashSet<Character> bSet = new HashSet<>(Arrays.asList(b));
//            List<Character>  characterArrays =  new ArrayList<>();
//            characterArrays.addAll(Arrays.asList(a));
//            System.out.println(characterArrays.size());
//            characterArrays.remove(0);
//            System.out.println(characterArrays.size());
//            System.out.println(aSet.size());
//            System.out.println(bSet.size));
            aSet.removeAll(bSet);
            bSet.removeAll(Arrays.asList(a));
//            System.out.println(aSet);
//            System.out.println(bSet);
            Set<Character> characters = new HashSet<>();
//            characters.addAll(aSet);
//            characters.addAll(bSet);
            System.out.println(characters);


        }


        {
            long start = System.nanoTime();
            char[] a = {'q', 'Q', 'D', '1', 'F'};
            char[] b = {'q', 'd', '2', '1', 'M', 'c'};
            char[] s = new char[a.length + b.length];
            char[] red = new char[a.length + b.length];
            System.arraycopy(a, 0, s, 0, a.length);
            System.arraycopy(b, 0, s, a.length, b.length);

            int k = 0;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) { //можно заменить быстрым поисков
                    if (a[i] == b[j]) {
                        red[k++] = a[i];
                        break;
                    }
                }
            }

            k = 0;
            char[] res = new char[a.length + b.length];
            for (int i = 0; i < s.length; i++) {
                boolean add = true;
                for (int m = 0; m < red.length; m++) {
                    if (s[i] == red[m]) {
                        add = false;
                        break;
                    }
                }
                if (add) {
                    res[k++] = s[i];
                }
            }
            char[] result = new char[k];
            System.arraycopy(res, 0, result, 0, k);

            System.out.println(System.nanoTime() - start);
            System.out.println(s);
            System.out.println(result);
            char nol = 40;
            System.out.println(nol);
        }
    }
//TODO удаление элементов в массиве
//TODO как переветси char[] -> Character[]


}

class Controller{
    ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, AtomicInteger>> online;
    public void post(int personId , int  bulutenId, Map<Integer, Boolean> res){
        // 1) в цикле по res сохраняем в PersonResult
        res.forEach( (q, b) -> {
            if(b) {
                online.get(bulutenId).get(q).getAndIncrement();
            }
        });
    };
}

class Person {
    int person_id;
}

class Question {

}

class Buluten {
    List<Question> questionList;
}

class PersonResult {
    Person person;
    Question question;
    Buluten buluten;
    Boolean res;
}

class ResultGrouping {
    int  bul;
    Map<Question,Integer> questionIntegerMap;
}



