package cn.youngqq.base;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Admin on 2017/6/12.
 */
public class Base5 {
    public static void main(String args[]){
        TalkClock clock = new TalkClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "quit?");

        System.exit(0);

    }
}


class TalkClock{

    private int interval;
    private boolean beep;

    public TalkClock(int interval, boolean beep){
        this.beep = beep;
        this.interval = interval;
    }

    public void start(){
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);

        t.start();
    }

   //private class cn.youngqq.base.TimePrinter implements ActionListener {
    public class TimePrinter implements ActionListener {

        public void actionPerformed(ActionEvent event){
            Date now = new Date();
            System.out.println("At the time: " + now);

            //此处访问的beep是外部类中的beep
            if(beep){
                System.out.println("di di di di !");
            }
        }
    }

}
