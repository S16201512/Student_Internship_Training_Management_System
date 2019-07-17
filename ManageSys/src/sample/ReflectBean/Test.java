package sample.ReflectBean;

import sample.JSBridge.Annontation.JSImp;

@JSImp
public class Test {


    public void PrintMsg(String msg){
        System.out.println("该语句输出表示反射调用成功!msg:"+msg);
    }

    public String GetMsg(String msg){
        return "msg : " + msg;
    }
}
