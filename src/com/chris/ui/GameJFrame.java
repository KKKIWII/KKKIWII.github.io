package com.chris.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener , ActionListener {
    //继承界面也是界面
    //GameJFrame表游戏的主界面，以后跟游戏相关商业逻辑都写在这个类中。

    //创建一个二维数组
    //用来管理数据，加载图片时会用到
    int[][] data = new int[4][4];
    //记录空白方块在二维数组中的位置
    int x = 0;
    int y = 0;

    //创建功能下的子条目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("公众号");
    JMenuItem changInmage = new JMenuItem("更换图片");
    JMenuItem kadiya = new JMenuItem("卡迪亚");
    JMenuItem animals = new JMenuItem("动物");
    JMenuItem sports = new JMenuItem("运动");

    //定义一个遍历，记录当前展示图片的路径
    int m = 1;
    String path = "image\\kadiya\\kadiya"+m+"\\";

    //定义一个二维数组用来判断是否胜利
    int[][] win ={
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,0},
};

    //定义步数
    int step = 0;
    
    public GameJFrame() {
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数据（先打乱再显示图片）
        initData();

        //初始化图片
        initImage();


        //显示界面，建议写在最后
        this.setVisible(true);
    }

    //初始化数据用于打乱图片顺序
    private void initData() {
        //1.定义数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //2.打乱数组中数据的顺序
        //随机索引，然后遍历数组，把索引号与数组交换
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            //获取随机索引
            int index = r.nextInt(tempArr.length);
            //拿着每一个编导到的数据，跟随机索引上的数据进行交换
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        //5.给二维数组添加数据
        //遍历一遍一维数组，把数据放入二维数组中
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }  {
                data[i / 4][i % 4] = tempArr[i];
            }
        }
    }


    //初始化图片
    private void initImage() {
        //！清空原本已经出现的所有图片
this.getContentPane().removeAll();

if (victory()){
    //显示胜利图片
    JLabel winJlabel = new JLabel(new ImageIcon("C:\\Users\\C2073\\Desktop\\PuzzleGame\\image\\win.png"));
    winJlabel.setBounds(203,283,197,73);
    this.getContentPane().add(winJlabel);
}

//创建步数标签
JLabel stepCount = new JLabel("步数" + step);
stepCount.setBounds(50,30,100,20);
this.getContentPane().add(stepCount);

        //外部循环 ---把内循环执行四次
        for (int i = 0; i < 4; i++) {
            //内部循环----表示每一行添加4张照片
            for (int j = 0; j < 4; j++) {
                //获取当前加载图片的序号
                int num = data[i][j];
                //创建图片ImageIcon的对象
                //ImageIcon icon = new ImageIcon();合并了
                //创建一个JLabel的对象（管理容器）
                JLabel jlabel = new JLabel(new ImageIcon(path+ num + ".jpg"));
                //指定图片位置
                jlabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //给图片添加边框
                //0：凸，1：凹
                jlabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //把管理容器添加到界面
                //this.add(jlabel);
                //先获取JFrame中的隐藏容器，然后再调用add方法，把jlabel1添加到隐藏容器当中
                this.getContentPane().add(jlabel);
            }
        }

        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("image\\background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        //！刷新界面
        this.getContentPane().repaint();
    }


    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单上的两个选项（“功能” ； “关于我们”）
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于我们");

        JMenu changeImage = new JMenu("更换图片");

        //把卡迪亚，动物等标签添加到更换图片当中
        changeImage.add(kadiya);
        changeImage.add(animals);
        changeImage.add(sports);
        //将每一个条目添加到上一级选项中
        functionMenu.add(changeImage);
        functionMenu.add(replayItem);
        functionMenu.add(reLoginItem);
        functionMenu.add(closeItem);

        aboutMenu.add(accountItem);

        //给菜单条目绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        changeImage.addActionListener(this);
        kadiya.addActionListener(this);
        animals.addActionListener(this);
        sports.addActionListener(this);

        //将两个选项添加到菜单当中
        jMenuBar.add(functionMenu);
        jMenuBar.add(aboutMenu);

        //给整个界面设置菜单(don't forget!!!)
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置宽高
        this.setSize(683, 740);
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
        //给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //判断游戏是否胜利，若胜利则此方法需要直接结束，不能继续执行
        if (victory()){
            //1.返回结果2.结束方法（是void的时候）
            return;
        }
//判断使用了哪个建：code
        //left:37,up:38,right:39,down:40
        int code = e.getKeyCode();
        if (code == 37) {
            System.out.println("向左移动");
            if (y == 3){
                return;
            }
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            //步数增加
            step++;
            initImage();

        } else if (code == 38) {
            System.out.println("向上移动");
            if (x == 3){
                return;
            }
            //空白方块下方的图片上移
            //x，y表空白方块，x+1，y表下面的图
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
//注意此时的x已经上升，要++
            x++;
            //步数增加
            step++;
            //调用方法按照最新的数字加载图片
            initImage();

        } else if (code == 39) {
            System.out.println("向右移动");
            if (y == 0){
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            //步数增加
            step++;
            initImage();

        } else if (code == 40) {
            System.out.println("向下移动");
            //防止报错，操作出界
            if (x == 0){
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            //步数增加
            step++;
            initImage();
            //按A可以直接通关
        } else if (code == 65) {
data = new int[][]{
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,0},
};
initImage();

        }
    }
    //判断data中的数据是否与win相同
    //如果全部相同则返回true，反之则false
    public boolean victory () {
        for (int i = 0; i < data.length; i++) {
            //i表示二维数组data里面的索引
            //data[i]表示每一个一维数组
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]){
                    return false;
                }
            }
        }return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//获取当前被点击的条目对象
         Object obj = e.getSource();
         //判断
        if (obj == replayItem){
            System.out.println("重新游戏");
            //计步清零
            step = 0;
            //再次打乱二维数组中的数据
            initData();
            //重新加载图片
            initImage();

        }
        else if (obj == reLoginItem){
            System.out.println("重新登录");
            //关闭当前游戏界面
            dispose();
            //打开登录界面
            new LoginJFrame();

        }
        else if (obj == closeItem) {
            //直接关闭虚拟机
            System.exit(0);
            System.out.println("关闭窗口");

        }
        else if (obj == accountItem) {
            JDialog jDialog = new JDialog();
            //创建一个管理图片的容器对象Jlabel
            JLabel jLabel = new JLabel(new ImageIcon("image\\about.png"));
            //把图片添加到容器中
            jDialog.getContentPane().add(jLabel);
            //给弹窗设置大小
            jDialog.setSize(344,344);
            //让弹窗置顶
            jDialog.setAlwaysOnTop(true);
            //让弹窗居中
            jDialog.setLocationRelativeTo(null);
            //弹窗不关闭无法操作下面的界面
            jDialog.setModal(true);

            jDialog.setVisible(true);
            System.out.println("公众号");
        }
          else if (obj == kadiya){
              System.out.println("卡迪亚");
              m = new Random().nextInt(4) + 1; //随机1-4
              path = "image\\kadiya\\kadiya" + m + "\\"; //更换路径

              //把界面中所有的图片全部删除
              this.getContentPane().removeAll();

              initImage();
              //刷新界面
              this.getContentPane().repaint();
            }
        else if (obj == animals){
            System.out.println("动物");
            m = new Random().nextInt(8) + 1; //随机1-8
            path = "image\\animal\\animal" + m + "\\"; //更换路径

            //把界面中所有的图片全部删除
            this.getContentPane().removeAll();

            initImage();
            //刷新界面
            this.getContentPane().repaint();
        }
        else if (obj == sports){
            System.out.println("运动");
            m = new Random().nextInt(10) + 1; //随机1-4
            path = "image\\sport\\sport" + m + "\\"; //更换路径

            //把界面中所有的图片全部删除
            this.getContentPane().removeAll();

            initImage();
            //刷新界面
            this.getContentPane().repaint();
        }
        }
        }


