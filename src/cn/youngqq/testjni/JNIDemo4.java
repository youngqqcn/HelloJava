package cn.youngqq.testjni;

/**
 * 对象数组
 *
 * @author: yqq
 * @create: 2017-10-17 10:59
 * @email: youngqqcn@163.com
 **/

public class JNIDemo4 {

    private native  static  int [][] initInt2DArray(int size);

    static {
        System.loadLibrary("JNIDemo4");
    }

    public static void main(String[] args) {

        int [][] i2arr = null;

        try{
            i2arr = initInt2DArray(3); //调用JNIDemo4.c中实现的函数
        }catch(Exception e){
            e.printStackTrace();
        }

        for (int i = 0; i < i2arr.length; i++){
            for(int j = 0; j < i2arr[0].length; j++){
                System.out.printf(" " + i2arr[i][j]);
            }
            System.out.println();
        }

    }

}
