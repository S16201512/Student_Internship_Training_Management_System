package sample;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import netscape.javascript.JSException;
import sample.JSBridge.RuntimeReflectasm;
import sample.JSBridge.WebViewHelp;
import sample.Json.EJsonType;
import sample.Json.GsonHelp;

public class Controller extends BaseController {

    @FXML
    private WebView webView;

    private WebViewHelp webViewHelp;

    @FXML
    private void initialize() {
        webViewHelp = new WebViewHelp(webView);

        webViewHelp.LoadFile("D:\\testxxxxxxxxx\\test.html");

//        WebEngine webEngine = webView.getEngine();
//        webEngine.load("file:///D:\\testxxxxxxxxx\\test.html");
//
//        webEngine.setOnAlert((WebEvent<String> event) -> {
//            System.out.println("捕捉到了：" + event.getData());
//
//            String port = GsonHelp.GetJsonValue("port", event.getData(), EJsonType.STRING);
//
//           String data = RuntimeReflectasm.MethodCall(
//                   GsonHelp.GetJsonValue("className", event.getData(), EJsonType.STRING),
//                   GsonHelp.GetJsonValue("method", event.getData(), EJsonType.STRING),
//                   GsonHelp.GetJsonValue("params", event.getData(), EJsonType.JSON_OBJ));
//
//            try{
//                webEngine.executeScript("JSBridge.onFinish(" + port + ",'" + data + "')");
//            } catch (JSException e) {
//                System.out.println("js异常:"+e.getMessage());
//            }
//        });
    }

}
