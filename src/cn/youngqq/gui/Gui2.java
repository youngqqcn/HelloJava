package cn.youngqq.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 2017/6/12.
 */
public class Gui2 {
    public static void main(String[] args){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new SizedFrame();
                frame.setTitle("hello");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });


    }
}


class SizedFrame extends JFrame{
    public SizedFrame(){


        Toolkit kit = Toolkit.getDefaultToolkit();

        Dimension screen=  kit.getScreenSize();
        int scrHeight = screen.height;
        int scrWidth = screen.width;

        setSize(scrWidth / 2, scrHeight / 2);


        setLocationByPlatform(true);

        Image image = new ImageIcon("icon.png").getImage();

        setIconImage(image);



    }
}
