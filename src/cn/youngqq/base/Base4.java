package cn.youngqq.base;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

/**
 * Created by Admin on 2017/6/12.
 */
public class Base4 {
    public static void main(String []args){


        ActionListener listener  = new TimePrinter();

        Timer t  = new Timer(1000, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "quit?");
        System.exit(0);

    }

}

class TimePrinter implements ActionListener{

    //重写父类方法
    public void actionPerformed(ActionEvent event){
        Date now = new Date();
        System.out.println("At the time: " + now);
    }
}
