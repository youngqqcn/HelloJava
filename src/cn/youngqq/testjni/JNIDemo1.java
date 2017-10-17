package cn.youngqq.testjni;

/**
 * 测试JNI
 *
 * @author: yqq
 * @create: 2017-10-17 8:52
 * @email: youngqqcn@163.com
 **/


public class JNIDemo1 {

    //在VM options中加入java.library.path，指定dll（或so）文件所在的目录，比如本文中dll放在项目目录中的lib中，如下：
    //   -Djava.library.path=C:\Users\Admin\IdeaProjects\HelloJava\lib     注意 -D后面不能有空格!!!


    //定义一个本地方法
    public native void sayHello();  //在其他语言中实现

    public static void main(String[] args) {
        //调用动态链接库
        System.loadLibrary("JNIDemo1");
        JNIDemo1 testJNI = new JNIDemo1();
        testJNI.sayHello();
    }


}
