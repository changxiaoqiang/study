package com.demo.LogManage;

public class LogManage {

    public static void main(String[] args) {
        String str = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str.intern() == str);
        String s = "JAVA";
        String str1 = new StringBuilder("JA").append("VA").toString();
        System.out.println(str1.intern() == s);

        InfoManage infoManage = new InfoManage();
        infoManage.writeLog();
        ErrorManage errorManage = new ErrorManage();
        errorManage.writeLog();
    }

}
