package com.chris.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    //表登陆界面

    public LoginJFrame(){
        this.setSize(488,430);

        //设置界面标题
        this.setTitle("拼图 登录");
        //使界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
//设置关闭模式
        this.setDefaultCloseOperation(3);

        this.setVisible(true);
    }
}
