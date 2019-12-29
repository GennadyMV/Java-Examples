public class Main {
    private static void bubbleSort(char[] intArray) {
        int n = intArray.length;
        char temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (intArray[j - 1] > intArray[j]) {
                    temp = intArray[j - 1];
                    intArray[j - 1] = intArray[j];
                    intArray[j] = temp;
                }
            }
        }
        System.out.println();
    }

    public static boolean areAnagrams(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        bubbleSort(c1);
//        bubbleSort(c2);
        bubbleS(c2);
        String sc1 = new String(c1);
        String sc2 = new String(c2);
        return sc1.equals(sc2);
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("Апельсин", "Спаниель"));
    }

    private static void bubbleS(char[] s) {
        int len = s.length;
        if (len > 0) {
            char temp = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 1; j < len - i; j++) {
                    if (s[j - 1] > s[j]) {
                        temp = s[j - 1];
                        s[j - 1] = s[j];
                        s[j] = temp;

                    }
                }


            }
        }
        System.out.println(s);

    }

}

/*
Реализуйте метод, проверяющий, являются ли две строки анаграммами, т.е. можно ли простой перестановкой символов получить из одной строки другую.

При этом:

должны учитываться все символы строки (т.е. буквы, цифры, знаки препинания), кроме пробелов;
регистр букв не важен.

Sample Input:
Апельсин
Спаниель

Sample Output:
true

 */