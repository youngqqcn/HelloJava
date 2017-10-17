package cn.youngqq.test;

/**
 * 测试Java中的Char以及算术运算时类型的提升
 *
 * @author: yqq
 * @create: 2017-10-13 15:55
 * @email: youngqqcn@163.com
 **/

public class TestChar {


    public static void main(String[] args) {


        byte bitA = 0x7F;
        //byte bitB = 0x80;   //错
        System.out.printf("%d\n", bitA);


        System.out.println("\n");

        char chA = 0x7F;
        char chB = 0x80;
        char chC = 0xFFFF;
        System.out.printf("%d\n", (int)chA);
        System.out.printf("%d\n", (int)chB);
        System.out.printf("%d\n", (int)chC);

    }


}
