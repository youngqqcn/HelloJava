package cn.youngqq.testjni;

/**
 * 简单数组求和demo
 *
 * @author: yqq
 * @create: 2017-10-17 10:26
 * @email: youngqqcn@163.com
 **/

import java.util.Random;

public class JNIDemo3 {

    static {
        System.loadLibrary("JNIDemo3");
    }

    private native int GetSum(int [] arr);


    public static void main(String[] args) {


        Random random = new Random();
        JNIDemo3 jniDemo3 = new JNIDemo3();

        int a[] = new int[10];

        for(int i = 0; i < a.length; i++){
            a[i] = random.nextInt() % 100;
            System.out.println(a[i]);
        }

        int sum = jniDemo3.GetSum(a);

        System.out.println("和等于:" + sum);

    }


}
