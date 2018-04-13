package util;

import java.util.Arrays;
import java.util.Comparator;

public class WMath {
    public static double[] getIncremental(double[] values) {
        double[] incremental = new double[values.length - 1];
        for (int i = 0; i < values.length - 1; ++i) {
            incremental[i] = values[i + 1] - values[i];
        }

        return incremental;
    }

    public static double getEuclideanDistance(double x1, double x2, double y1, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;

        return Math.sqrt((dx * dx) + (dy * dy));
    }

    public static int[][] sortArray(int[][] array, int column) {
        // https://stackoverflow.com/questions/4907683/sort-a-two-dimensional-array-based-on-one-column
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                final int t1 = o1[column];
                final int t2 = o2[column];
                return t2 - t1;
            }
        });

        return array;
    }


    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 1},
                {2, 6, 3},
                {4, 3, 4},
                {1, 7, 8},
                {8, 2, 5}
        };

        System.out.println(Arrays.toString(sortArray(array, 1)));

        PrintUtils.print(array);
    }


}
