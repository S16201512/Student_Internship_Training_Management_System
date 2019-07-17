package sample.Utils;

/**
 * string 工具类
 */
public class StringUtlis {

    /**
     * 判断字符串是否为空，true表示为空，false表示不为空
     * @param str
     * @return
     */
    public static boolean IsNull(String str) {
        if (str == null || str.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
