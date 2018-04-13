package util;

import java.util.List;

public class PrintUtils {
    public static void print(int[][] array) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        for (int[] anArray : array) {
            stringBuilder.append('[');
            for (int j = 0; j < array[0].length - 1; ++j) {
                stringBuilder.append(anArray[j]).append(", ");
            }
            stringBuilder.append(anArray[array[0].length - 1]).append("]\n ");
        }
        stringBuilder.insert(stringBuilder.length() - 2, "]");

        System.out.println(stringBuilder.toString());
    }

    public static void print(List list, int maxRows) {
        int i = 0;
        for (Object o : list) {
            System.out.println(o.toString());
            if (i == maxRows) break;
            i++;
        }
    }
}
