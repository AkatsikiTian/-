package com.company;

import javax.swing.*;
import java.awt.*;

public class Begin {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
//        写标题
        jf.setTitle("第一版贪吃蛇 by wjt");
//        设置弹出坐标
        int x=Toolkit.getDefaultToolkit().getScreenSize().width;
        int y=Toolkit.getDefaultToolkit().getScreenSize().height;
        jf.setBounds((x-700)/2,(y-700)/2,700,700);
//        设置窗体不可改变大小
        jf.setResizable(false);
//        创建面板
        GamePanel gamePanel =  new GamePanel();
        jf.add(gamePanel);
        //       关程序
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }
}
