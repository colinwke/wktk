package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static String getStringColumns(String s) {
        return s.replaceAll("[\"+ \n;]", "");
    }

    public static String humpToLine(String str) {
        Pattern humpPattern = Pattern.compile("[A-Z]");
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
