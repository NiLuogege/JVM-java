package com.niluogege.javajvm;

import com.niluogege.javajvm.classfile.ClassFile;
import com.niluogege.javajvm.classfile.MemberInfo;
import com.niluogege.javajvm.classpath.Classpath;

import java.util.Arrays;

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
        Classpath classpath = new Classpath(cmd.jre, cmd.classpath);
        System.out.printf("classpath：%s class：%s args：%s\n",
                classpath, cmd.getMainClass(), cmd.getAppArgs());
        //获取className
        String className = cmd.getMainClass().replace(".", "/");
        ClassFile classFile = loadClass(className, classpath);
        assert classFile != null;
        printClassInfo(classFile);
    }

    private static ClassFile loadClass(String className, Classpath classpath) {
        try {
            byte[] classData = classpath.readClass(className);
            return new ClassFile(classData);
        } catch (Exception e) {
            System.out.println("Could not find or load main class " + className);
            return null;
        }
    }

    private static void printClassInfo(ClassFile cf) {
        System.out.println("version: " + cf.majorVersion() + "." + cf.minorVersion());
        System.out.println("constants count：" + cf.constantPool());
        System.out.format("access flags：0x%x\n", cf.accessFlags());
        System.out.println("this class：" + cf.className());
        System.out.println("super class：" + cf.superClassName());
        System.out.println("interfaces：" + Arrays.toString(cf.interfaceNames()));
        System.out.println("fields count：" + cf.fields().length);
        for (MemberInfo memberInfo : cf.fields()) {
            System.out.format("fieldsInfo %s \t\t %s \t\t %s\n", memberInfo.name(), memberInfo.descriptor(),memberInfo.toString());
        }

        System.out.println("methods count: " + cf.methods().length);
        for (MemberInfo memberInfo : cf.methods()) {
            System.out.format("%s \t\t %s  \t\t %s\n", memberInfo.name(), memberInfo.descriptor(),memberInfo.toString());
        }
    }

}