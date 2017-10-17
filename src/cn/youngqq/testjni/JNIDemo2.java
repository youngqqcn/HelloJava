package cn.youngqq.testjni;

/**
 * 测试JNI得返回值和参数传递
 *
 * @author: yqq
 * @create: 2017-10-17 9:47
 * @email: youngqqcn@163.com
 **/

public class JNIDemo2 {

    static {
        // hello.dll (Windows) or libhello.so (Unixes)
        System.loadLibrary("JNIDemo2");
    }

    private native String sayHello(String name);

    public static void main(String[] args) {
        // invoke the native method
        String rs =  new JNIDemo2().sayHello("Youngqq");
        System.out.println("Java类收到来自JNI的返回："+rs);
    }

}
