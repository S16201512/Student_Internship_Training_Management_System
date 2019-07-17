package sample;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class BaseController {

    private Stage primaryStage;

    /**
     * 自定义实现
     * @param primaryStage
     */
    public void Init(Stage primaryStage, Parent root)
    {
        if (primaryStage == null) {
            return;
        }
        this.primaryStage = primaryStage;
        primaryStage.setTitle(getTitle());
        primaryStage.setResizable(isResizable()); // 禁止自由拉伸窗口

        Scene scene = new Scene(root, 1300, 800);
        primaryStage.setScene(scene);

        primaryStage.show(); // 显示
    }

    /**
     * 获取from title
     * @return
     */
    public String getTitle() {
        return "MyFrom";
    }

    /**
     * 禁止自由拉伸窗口（禁止后不能最大化）
     * @return 默认禁止，否则为true
     */
    public boolean isResizable() {
        return false;
    }

    /**
     * 关闭当前窗口
     */
    public void close() {
        if (primaryStage != null) {
            primaryStage.close();
            primaryStage = null;
        }
    }
}
