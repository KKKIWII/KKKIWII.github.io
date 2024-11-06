package com.chris.ui;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        //1.创建游戏主界面
        JFrame gameJframe = new JFrame();
        gameJframe.setSize(603,680);
        gameJframe.setVisible(true);

        //2.创建一个登录界面
        JFrame loginFrame = new JFrame();
        loginFrame.setSize(488,430);
        loginFrame.setVisible(true);

        //3.注册界面
        JFrame registerJframe = new JFrame();
        registerJframe.setSize(488,500);
        registerJframe.setVisible(true);
    }
}
