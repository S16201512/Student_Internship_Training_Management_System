package sample.JSBridge;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import netscape.javascript.JSException;
import sample.Json.EJsonType;
import sample.Json.GsonHelp;
import sample.Utils.StringUtlis;

public class WebViewHelp {

    private WebView webView;
    private WebEngine webEngine;

    public WebViewHelp(WebView webView) {
        this.webView = webView;
        this.webEngine = webView.getEngine();

        webEngine.setOnAlert((WebEvent<String> event) -> {
            LoadMethod(event.getData());
        });
    }

    /**
     * 加载本地路径
     * @param path
     */
    public void LoadFile(String path) {
        if (StringUtlis.IsNull(path))
            return ;

        if(path.contains("file:///")){
            webEngine.load(path);
        } else {
            String url = String.format("%1$s:///%2$s","file", path);
            webEngine.load(url);
        }
    }

    /**
     * 加载网络路径
     * @param path
     */
    public void LoadHttp(String path) {
        if (StringUtlis.IsNull(path))
            return ;

        if(path.contains("http://") || path.contains("https://")){
            webEngine.load(path);
        } else {
            webEngine.load(String.format("%1$s:///%2$s","https", path));
        }
    }

    /**
     * js触发加载本地方法
     * @param data
     */
    private void LoadMethod(String data) {
        String port = GsonHelp.GetJsonValue("port", data, EJsonType.STRING);
        String returnData = RuntimeReflectasm.MethodCall(
                GsonHelp.GetJsonValue("className", data, EJsonType.STRING),
                GsonHelp.GetJsonValue("method", data, EJsonType.STRING),
                GsonHelp.GetJsonValue("params", data, EJsonType.JSON_OBJ));

        try{
            webEngine.executeScript("JSBridge.onFinish(" + port + ",'" + returnData + "')");
        } catch (JSException e) {
            System.out.println("js异常:"+e.getMessage());
        }
    }
}
