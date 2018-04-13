package util.file;

public class Path {
    public static String pathRename(String path, String fileName) {
        String s = path.substring(0, path.lastIndexOf('\\') + 1) + fileName;

        return s;
    }

    public static String pathAppend(String path, String append) {
        int index = path.lastIndexOf('.');
        String s = path.substring(0, index) + append;

        return s;
    }
}
