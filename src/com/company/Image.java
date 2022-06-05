package com.company;

import javax.swing.*;
import java.net.URL;
/*先建立一个针对图片的对象,将图片地址封装成对象*/
public class Image {
    public static URL bodyURL = Image.class.getResource("/images/body.png");
//    将图片封装成为对象
    public static ImageIcon bodyImg = new ImageIcon(bodyURL);

    public static URL downURL = Image.class.getResource("/images/down.png");
    //    将图片封装成为对象
    public static ImageIcon downImg = new ImageIcon(downURL);

    public static URL leftURL = Image.class.getResource("/images/left.png");
    //    将图片封装成为对象
    public static ImageIcon leftImg = new ImageIcon(leftURL);

    public static URL rightURL = Image.class.getResource("/images/right.png");
    //    将图片封装成为对象
    public static ImageIcon rightImg = new ImageIcon(rightURL);

    public static URL upURL = Image.class.getResource("/images/up.png");
    //    将图片封装成为对象
    public static ImageIcon upImg = new ImageIcon(upURL);

    public static URL foodURL = Image.class.getResource("/images/food.png");
    //    将图片封装成为对象
    public static ImageIcon foodImg = new ImageIcon(foodURL);

    public static URL headURL = Image.class.getResource("/images/head.png");
    //    将图片封装成为对象
    public static ImageIcon headImg = new ImageIcon(headURL);

}
