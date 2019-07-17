package sample.Json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

/**
 * gosn 解析帮助类
 *
 */
public class GsonHelp {

    private static Gson gson = null;

    private GsonHelp() {}

    static {

        if (gson == null) {
            gson = new Gson();
        }
    }

    /**
     * 将对象转成json字符串
     */
    public static String GsonString(Object object) {
        String gsonString = null;
        if (gson != null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }


    /**
     * json字符串转成bean
     */
    public static <T> T GsonToBean(String jsonStr, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(jsonStr, cls);
        }
        return t;
    }

    /**
     * json字符串转成list
     */
    public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * 将json数组转成list中有map的
     *
     * @param gsonString
     * @return
     */
    public static <T> List<Map<String, T>> GsonToListMaps(String gsonString) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }

    /**
     * 转成map
     */
    public static <T> Map<String, T> GsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }

    /**
     * 根据json字符串获取对应的key
     */
    private static JsonElement GetJsonObjStr(String key, String json){
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        return jsonObject.get(key);
    }

    /**
     * 根据key返回对应的类型
     * @param key
     * @param json
     * @param <T>
     * @return
     */
    public static <T> T GetJsonValue(String key, String json, EJsonType eJsonType) {

        JsonElement jsonElement = GetJsonObjStr(key, json);

        switch (eJsonType){
            case STRING:
                return (T) jsonElement.getAsString();
            case INT:
                return (T) Integer.valueOf(jsonElement.getAsInt());
            case BOOL:
                return (T) Boolean.valueOf(jsonElement.getAsBoolean());
            case JSON_OBJ:
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                return (T) jsonObject.toString();
            case JSON_ARRAY:
                return (T) jsonElement.getAsJsonArray();
        }

        return null;
    }

}