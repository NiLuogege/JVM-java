package com.niluogege.javajvm.day1;

import com.niluogege.javajvm.day1.classpath.Classpath;

/**
 * program arguments：-Xjre "C:\Program Files\Java\jdk1.8.0_161\jre" E:\itstack\git\istack-demo\itstack-demo-jvm\itstack-demo-jvm-02\target\test-classes\org\itstack\demo\test\HelloWorld
 */
public class Main {

    public static void main(String[] args) {
        Cmd cmd = Cmd.parse(args);
        if (!cmd.ok || cmd.helpFlag) {
            System.out.println("Usage: <main class> [-options] class [args...]");
            return;
        }
        if (cmd.versionFlag) {
            //注意案例测试都是基于1.8，另外jdk1.9以后使用模块化没有rt.jar
            System.out.println("java version \"1.8.0\"");
            return;
        }
        startJVM(cmd);
    }

    private static void startJVM(Cmd cmd) {
        Classpath cp = new Classpath(cmd.jre, cmd.classpath);
        System.out.printf("classpath：%s class：%s args：%s\n", cp, cmd.getMainClass(), cmd.getAppArgs());
        //获取className
        String className = cmd.getMainClass().replace(".", "/");
        try {
            byte[] classData = cp.readClass(className);
            System.out.println("16进制字符串显示 = "+bytesToHexString(classData,false));
            System.out.println("classData：");
            for (byte b : classData) {
                //16进制输出
                System.out.print(String.format("%02x", b & 0xff) + " ");
            }
        } catch (Exception e) {
            System.out.println("Could not find or load main class " + cmd.getMainClass());
            e.printStackTrace();
        }
    }

    /**
     * byte数组转成字符串
     *
     * @param bytes     数组
     * @param isCaptial 使用大写还是小写表示
     * @return 转换后的字符串
     */
    public static String bytesToHexString(byte[] bytes, boolean isCaptial) {
        if (null == bytes || bytes.length <= 0) {
            return null;
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if (isCaptial) {
                //02表示使用2位16进制字符表示当前的byte数据，X或者x表示16进制字符串
                s.append(String.format("%02X", bytes[i]));
            } else {
                s.append(String.format("%02x", bytes[i]));
            }
        }
        return s.toString();
    }

}