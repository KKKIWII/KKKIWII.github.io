package com.chris.test;

import java.util.Random;

public class test {
    public static void main(String[] args) {
        //需求：把一个一维数组的数据：0-15 打乱顺序
        //然后再把它4个一组的方式添加到二维数组中

        //1.定义数组
        int[] tempArr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
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
        for (int i = 0; i < tempArr.length; i++) {
            System.out.print(tempArr[i]+" ,");
        }
        System.out.println();

        //4.创建一个二维数组
        int[][] data = new int[4][4];

        //5.给二维数组添加数据
        //遍历一遍一维数组，把数据放入二维数组中
        for (int i = 0; i < tempArr.length; i++) {
            data[i / 4][i % 4] = tempArr[i];
        }
        //方法二
        //int index = 0;
        //for (int i = 0; i < data.length; i++) {
        //            for (int j = 0; j < data[i].length; j++) {
        //              data[i][j] = tempArr[index];
        //               index ++;
        //            }

        //遍历
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            //约等于换行符
            System.out.println();
        }
    }
}
