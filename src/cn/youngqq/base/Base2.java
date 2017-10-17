package cn.youngqq.base;

/**
 * Created by Admin on 2017/6/12.
 */


public class Base2 {

    public static void swap(int a, int b){
        a = a + b;
        b = a - b;
        a = a - b;
    }


    public static void main(String args[]){
        int a = 10;
        int b = 20;
        swap(a, b);

        System.out.println("a = " + a + "\n" + "b = " + b);

        A o1 = new A();
        A o2 = new A();
        o1.setA(99);
        o2.setA(344);
        A.swap(o1, o2);

        System.out.println(o1.getA() + "|" +  o2.getA());

    }
}

class A{
    public A(){};

    private  int a;

    public void setA(int value) {
       a = value;
    }

    public int getA() {
        return a;
    }

    public static void swap(A obj1, A obj2){
        A temp;
        temp = obj1;
        obj1 = obj2;
        obj2 = temp;
    }
}


