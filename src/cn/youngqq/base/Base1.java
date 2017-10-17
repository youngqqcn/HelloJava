package cn.youngqq.base;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Base1 {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);

        //read sigle line from stdin
        //System.out.println(in.nextLine());

        //System.out.println(in.next());//读一个单词, 以空格分隔

        //System.out.println(in.nextBigInteger(10));//读入一个大整数


        /*从控制台读入一串密码*/


        //文件操作

        //Scanner in = new Scanner(Paths.get("mytest.txt"));

        // 大数(浮点型)
        if(false) {
            BigDecimal bd = new BigDecimal("2432423423423423423.4234234324234");
            BigDecimal bd2 = in.nextBigDecimal();

            //因为除不断,回抛出异常
            //System.out.println((bd.divide(bd2).toString());

            //如果保留20位小数
           System.out.println((bd.divide(bd2, 20, BigDecimal.ROUND_CEILING)).toString());
        }

        if (false) {
             //大整数

            BigInteger bi1 = in.nextBigInteger();
            BigInteger bi2 = in.nextBigInteger();

            System.out.printf((bi1.multiply(bi2)).toString());
        }



        //数组
        if(false) {
            int[] a = new int[100];
            for (int i = 0; i < a.length; i++) {
                a[i] = i;
            }

            if(false) {
                for (int i = 0; i < a.length; i++)
                    System.out.println(a[i]);
            }

            if(true){
                //增强for
                for(int it : a)
                    System.out.println(it);

            }
        }


        if(false) {

            /*
             随机生成10000个正整数, 排序输出
             */


            Random rd = new Random();
            rd.setSeed(3423);


            int[] a = new int[100000];
            for (int i = 0; i < a.length; i++)
                a[i] = Math.abs(rd.nextInt() % 100000) ; //取随机数的绝对值

            Arrays.sort(a);


            for (int it : a)
                System.out.println(it);
        }


        if(false){

            /*
            将数组转为字符串输出
             */
            int [] a = new int[10];
            for(int i = 0; i < a.length; i++)
                a[i] = i;

            //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
            System.out.println(Arrays.toString(a));
        }


        if(false){

            /*
            动态创建二维数组
             */
            int row =  in.nextInt();
            int col = in.nextInt();
            int [][] m = new int[row][col];

            for(int i = 0; i < m.length; i++)
            {
                for(int j = 0; j < m[0].length; j++)
                {
                    m[i][j] = (i + j) * 2;
                }
            }

            //System.out.println(Arrays.deepToString(m));
            for(int []it1 : m) {
                for (int it2 : it1)
                    System.out.printf(Integer.toString(it2) + "\t");
                System.out.println();
            }
        }


        if(false){
            /*
            不规则数组, 即, 每个一维数组的长度的不同
             */

            int [][] a = new int [5][];
            for (int i = 0;  i < a.length; i++){
                a[i] = new int [i+1];
                Arrays.fill(a[i], 9);
            }

            for(int []it1 : a) {
                for (int it2 : it1)
                    System.out.printf(Integer.toString(it2) + "\t");
                System.out.println();
            }
            /*
                9
                9	9
                9	9	9
                9	9	9	9
                9	9	9	9	9
             */
        }












        //System.out.println("Hello World!");
    }
}
