package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel {
    int[] snakeX = new int[300];
    int[] snakeY = new int[300];
    int len;//蛇长
    char direction;//蛇头方向
    //    游戏默认两个状态，开始和暂停
    boolean isbegin = false;
    //加入定时器
    Timer timer;
    //定义食物的x和y轴
    int foodx = 300;
    int foody = 200;
    //积分
    int score;
    //判断状态
    boolean isdie = false;

    public void Init() {
//        初始化蛇头坐标
        snakeX[0] = 175;
        snakeY[0] = 275;
//        初始化第一身体坐标
        snakeX[1] = 150;
        snakeY[1] = 275;
//        初始化第二身体坐标
        snakeX[2] = 125;
        snakeY[2] = 275;
        len = 3;
        direction = 'R';
        score = 0;
    }

    public GamePanel() {
        Init();
//        将焦点定义在当前面板上
        this.setFocusable(true);
//        加入监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keycode = e.getKeyCode();
                switch (keycode) {
                    case 37:
                        direction = 'L';
                        break;
                    case 38:
                        direction = 'U';
                        break;
                    case 39:
                        direction = 'R';
                        break;
                    case 40:
                        direction = 'D';
                        break;
                    case 32:
                        if (isdie) {
//                            恢复初始化
                            Init();
                            isdie = false;
                        } else {
                            isbegin = !isbegin;
                        }
                        repaint();
                        break;
                }
            }
        });
//        初始化定时器
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isbegin == true && !isdie) {
                    for (int i = len - 1; i > 0; i--) {
                        snakeX[i] = snakeX[i - 1];
                        snakeY[i] = snakeY[i - 1];
                    }
                    switch (direction) {
                        case 'U':
                            snakeY[0] -= 25;
                            break;
                        case 'D':
                            snakeY[0] += 25;
                            break;
                        case 'R':
                            snakeX[0] += 25;
                            break;
                        case 'L':
                            snakeX[0] -= 25;
                            break;
                    }
//                        防止蛇超出边界
                    if (snakeX[0] >= 650) {
                        snakeX[0] = 25;
                    }
                    if (snakeX[0] < 25) {
                        snakeX[0] = 650;
                    }
                    if (snakeY[0] > 575) {
                        snakeY[0] = 75;
                    }
                    if (snakeY[0] <= 50) {
                        snakeY[0] = 575;
                    }
//                    判断是否吃到食物
                    if (snakeX[0] == foodx && snakeY[0] == foody) {
                        len++;
                        foodx = ((int) (Math.random() * 24 + 2)) * 25;
                        foody = (new Random().nextInt(21) + 3) * 25;
//                        吃到食物积分加10
                        score += 10;
                    }
//                    死亡判定
                    for (int i = 1; i < len; i++) {
                        if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                            isdie = true;
                        }
                    }
                    repaint();
                }
            }
        });
//        定时器必须要启动
        timer.start();
    }

    /*
    paintcomponent这个方法比较特殊，这个方法就是图形的main方法
    自动调用
    */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(255, 185, 253, 218));
        Image.headImg.paintIcon(this, g, 60, 10);
//        调画笔，画矩形
        g.setColor(new Color(153, 217, 234));
        g.fillRect(5, 70, 675, 585);
        switch (direction) {
            case 'U':
                Image.upImg.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case 'D':
                Image.downImg.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case 'R':
                Image.rightImg.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
            case 'L':
                Image.leftImg.paintIcon(this, g, snakeX[0], snakeY[0]);
                break;
        }
        for (int i = 1; i < len; i++) {
            Image.bodyImg.paintIcon(this, g, snakeX[i], snakeY[i]);
        }
        Image.foodImg.paintIcon(this, g, foodx, foody);
        if (isbegin == false) {
            g.setColor(new Color(210, 232, 11, 255));
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("暂停中", 270, 260);
            g.drawString("点击空格开始或继续", 180, 300);
        }
        g.setColor(new Color(13, 14, 13, 255));
        g.setFont(new Font("微软雅黑", Font.BOLD, 20));
        g.drawString("积分：" + score, 400, 50);
        if (isdie) {
            g.setColor(new Color(246, 0, 0, 255));
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("游戏结束，积分：" + score, 180, 300);
            g.drawString("按空格键重新开始", 180, 340);
        }
    }
}
