package util.file;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.nio.file.Paths.*;


public class TextUtils {
    private static TextUtils txtUtils = new TextUtils();

    private TextUtils() {
    }

    public static TextUtils getTxtUtils() {
        return txtUtils;
    }

    private BufferedReader readDataFile(String fileName) throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            // wasn"t open, so don"t close it
            System.err.println("Could not open " + fileName);
            System.exit(0);
        }

        return reader;
    }

    /**
     * read
     */
    public List<String> read(String fileName, int numFirst) throws IOException {
        List<String> list = new LinkedList<>();
        BufferedReader reader = readDataFile(fileName);

        // jump to data line
        for (int i = 0; i < numFirst; ++i) {
            reader.readLine();
        }

        String line;

        while ((line = reader.readLine()) != null) {
            list.add(line);
        }

        return list;
    }


    @SuppressWarnings("unchecked")
    public <E> List<E> read(String fileName, Formatter formatter, int numFirst) throws IOException {
        List<E> list = new LinkedList<>();
        BufferedReader reader = readDataFile(fileName);

        // jump to data line
        for (int i = 0; i < numFirst; ++i) {
            reader.readLine();
        }

        String line;

        while ((line = reader.readLine()) != null) {
            list.add((E) formatter.format(line));
        }

        return list;
    }

    public List<double[]> readNumericTable(String fileName, int numFirst) throws IOException {
        List<double[]> lines = new LinkedList<>();
        BufferedReader reader = readDataFile(fileName);

        // jump to data line
        for (int i = 0; i < numFirst; ++i) {
            reader.readLine();
        }

        String line;

        while ((line = reader.readLine()) != null) {
            double[] elements = Arrays.stream(line.split(",")).mapToDouble(Double::parseDouble).toArray();
            lines.add(elements);
        }

        return lines;
    }

    public double[][] readNumericArrayTable(String fileName, int numFirst) throws IOException {
        List<double[]> lines = readNumericTable(fileName, numFirst);

        double[][] array = new double[lines.size()][lines.get(0).length];

        int i = 0;
        for (double[] d : lines) {
            array[i] = d;
            i++;
        }

        return array;
    }

    public List<String[]> readStringTable(String fileName, int numFirst) throws IOException {
        List<String[]> lines = new LinkedList<>();
        BufferedReader reader = readDataFile(fileName);

        // jump to data line
        for (int i = 0; i < numFirst; ++i) {
            reader.readLine();
        }

        String line;

        while ((line = reader.readLine()) != null) {
            String[] elements = line.split(",");
            lines.add(elements);
        }

        return lines;
    }


    public String[][] readStringArrayTable(String fileName, int numFirst) throws IOException {
        List<String[]> lines = readStringTable(fileName, numFirst);

        String[][] array = new String[lines.size()][lines.get(0).length];

        int i = 0;
        for (String[] d : lines) {
            array[i] = d;
            i++;
        }

        return array;
    }

    /**
     * write
     */
    public <E> void write(List<E> list, String columns, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            if (!columns.equals("")) {
                printWriter.println(columns);
            }

            int i = 0;
            for (E e : list) {
                i++;
                if (e != null) {
                    printWriter.println(e.toString());
                } else {
                    System.err.println("ERROR: line " + i + " is null");
                }
            }

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface Formatter {
        Object format(String line);
    }
}
