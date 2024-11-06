package com.chris.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class myframe extends JFrame implements ActionListener {

    //创建一个按钮对象
    JButton jbt1 = new JButton("点我啊");
    //创建一个按钮对象
    JButton jbt2 = new JButton("再点我啊");
//不是一个构造函数，因为构造函数应该没有返回类型。请将其修改为没有返回类型的构造函数
    public myframe() {
        //设置宽高
        this.setSize(683, 680);
//设置界面标题
        this.setTitle("卡迪亚拼图小游戏 v1.0");
        //使界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
//设置关闭模式
        this.setDefaultCloseOperation(3);

        //取消默认居中放置，只有取消了才会按照Xy轴的形式添加组件
        this.setLayout(null);


        //给按钮设置长宽高
        jbt1.setBounds(0, 0, 100, 50);
        //给按钮添加事件
        jbt1.addActionListener(this);


        //给按钮设置长宽高
        //注意位置，小心重叠
        jbt2.setBounds(100, 0, 100, 50);
        jbt2.addActionListener(this);

        //把按钮添加到整个界面当中
        this.getContentPane().add(jbt1);
        this.getContentPane().add(jbt2);

        //显示界面，建议写在最后
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//对当前按钮进行判断

        //获取当前被操作的按钮对象
        Object source = e.getSource();

        if (source == jbt1) {
            jbt1.setSize(200, 200);
        } else if(source ==jbt2){
            Random r = new Random();
            jbt2.setLocation(r.nextInt(500), r.nextInt(500));
        }
    }
}
