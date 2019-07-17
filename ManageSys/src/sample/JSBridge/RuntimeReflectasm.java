package sample.JSBridge;

import sample.Reflectasm.ConstructorAccess;
import sample.Reflectasm.MethodAccess;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现方式可升级
 * 运行时动态获取js需要交互的底层代码
 */
public class RuntimeReflectasm {

    // 存储对象
    private static Map<String, Object> objStrPathMap;

    // 存储方法集合
    private static Map<String, MethodAccess> stringMethodAccessMap;

    // 存储索引
    private static Map<String, Map<String, Integer>> objMethodMap;

    private static String paths[] = {
            "sample.ReflectBean.Test"
    };

    static {
        objStrPathMap = new HashMap<>();
        stringMethodAccessMap = new HashMap<>();
        objMethodMap = new HashMap<>();
    }

    public static void  Init() throws ClassNotFoundException {

        Class myClass = null;

        for (String path: paths) {

            myClass =  Class.forName(path);
            objStrPathMap.put(path, GetObj(myClass));
            SetMethod(myClass, path);
        }
    }

    // 得到obj
    private static <T> Object GetObj(Class<T> myClass) {
        ConstructorAccess<T> constructorAccess = ConstructorAccess.get(myClass);
        return constructorAccess.newInstance();
    }

    // 得到方法
    private static void SetMethod(Class myClass, String pathName){

        MethodAccess access = MethodAccess.get(myClass);

        String matnodNames[] = access.getMethodNames();

        Map<String, Integer> methodAccessMap = new HashMap<>();

        for (String matnodName : matnodNames) {
            methodAccessMap.put(matnodName, access.getIndex(matnodName));
        }
        stringMethodAccessMap.put(pathName, access);
        objMethodMap.put(pathName, methodAccessMap);
    }

    /**
     * 该方法不是通用方法，仅适用当前项目
     * 该方法为通过条件调用方法，此处必须是只能有一个参数并且只能是string且返回值也只能是sring
     * @param path     类路径
     * @param pamName  方法名
     * @param parm     数据
     * @return         执行方法后的返回值
     */
    public static String MethodCall(String path, String pamName, String parm){

        Object obj = objStrPathMap.get(path);
        MethodAccess methodAccess = stringMethodAccessMap.get(path);
        Map<String, Integer> stringIntegerMap = objMethodMap.get(path);

        if (obj == null)
            return "";

        if (stringIntegerMap.get(pamName) == null)
            return "";


        return String.valueOf(methodAccess.invoke(obj, stringIntegerMap.get(pamName), parm));

    }

    /**
     * 无参数但有返回值的方法
     * @param path
     * @param pamName
     * @return
     */
    public static String MethodCall(String path, String pamName){

        Object obj = objStrPathMap.get(path);
        MethodAccess methodAccess = stringMethodAccessMap.get(path);
        Map<String, Integer> stringIntegerMap = objMethodMap.get(path);

        if (obj == null)
            return "";

        if (stringIntegerMap.get(pamName) == null)
            return "";


        return String.valueOf(methodAccess.invoke(obj, stringIntegerMap.get(pamName)));

    }

    /**
     * 无返回值，无参数的方法
     * @param path
     * @param pamName
     */
    public static void MethodCall_v(String path, String pamName){
        Object obj = objStrPathMap.get(path);
        MethodAccess methodAccess = stringMethodAccessMap.get(path);
        Map<String, Integer> stringIntegerMap = objMethodMap.get(path);

        if (obj == null)
            return;

        if (stringIntegerMap.get(pamName) == null)
            return;

        String.valueOf(methodAccess.invoke(obj, stringIntegerMap.get(pamName)));
    }

    /**
     * 无返回值，有一个参数为sting
     * @param path
     * @param pamName
     * @param parm
     */
    public static void MethodCall_v(String path, String pamName, String parm){
        Object obj = objStrPathMap.get(path);
        MethodAccess methodAccess = stringMethodAccessMap.get(path);
        Map<String, Integer> stringIntegerMap = objMethodMap.get(path);

        if (obj == null)
            return;

        if (stringIntegerMap.get(pamName) == null)
            return;

        String.valueOf(methodAccess.invoke(obj, stringIntegerMap.get(pamName), parm));
    }
}
