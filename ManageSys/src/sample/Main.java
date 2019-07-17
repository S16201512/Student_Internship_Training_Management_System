package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.JSBridge.RuntimeReflectasm;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        RuntimeReflectasm.Init();

        WebViewControllerInit("sample.fxml", primaryStage);
    }

    private void WebViewControllerInit(String xmlName, Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(xmlName));
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent root = fxmlLoader.load();

        BaseController controller = fxmlLoader.getController();   //获取Controller的实例对象
        controller.Init(primaryStage, root);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
