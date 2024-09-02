package helpers;

public class StringUtils {
    public static String substringBefore(String str, String separator) {
        if (str == null || separator == null) {
            return null;
        }
        int pos = str.indexOf(separator);
        if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }
}
