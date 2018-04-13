package util.file;

import java.io.*;

/**
 * Created by Colin Wang on 2017/12/11.
 * Serialization Utils
 */
public class PickleUtils {
    public static void dump(Object object, String filePath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(object);
            out.close();
            fileOut.close();
            System.err.println("PickleUtils: Serialized data is saved in " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object load(String filePath) {
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object ret = in.readObject();
            in.close();
            fileIn.close();
            System.out.println("PickleUtils: Serialized data is loaded from " + filePath);
            return ret;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.err.println("PickleUtils: Serialized class not found!");
            e.printStackTrace();
            return null;
        }
    }

    public static boolean existsFile(String path) {
        File file = new File(path);
        return file.exists() && !file.isDirectory();
    }
}
