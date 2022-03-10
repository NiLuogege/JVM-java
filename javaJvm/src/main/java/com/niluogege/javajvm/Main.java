package com.niluogege.javajvm;

import com.niluogege.javajvm.classfile.ClassFile;
import com.niluogege.javajvm.classfile.MemberInfo;
import com.niluogege.javajvm.classpath.Classpath;
import com.niluogege.javajvm.rtda.heap.ClassLoader;
import com.niluogege.javajvm.rtda.heap.methodarea.Class;

import java.util.Arrays;

/**
 * program arguments：
 * -Xjre "D:\soft\jre-8-8u171-64\jre" java.lang.String
 * -Xjre "D:\soft\jre-8-8u171-64\jre" E:\111work\code\code_me\myGitHub\JVM-java\javaJvm\target\test-classes\com\niluogege\javajvm\HelloWorld
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
        System.out.printf("classpath：%s class：%s args：%s\n", classpath, cmd.getMainClass(), cmd.getAppArgs());

        ClassLoader classLoader = new ClassLoader(classpath);

        //获取className
        String className = cmd.getMainClass().replace(".", "/");
        Class clazz = classLoader.loadClass(className);

        System.out.println("clazz="+clazz);

//        ClassFile classFile = loadClass(className, classpath);
//        assert classFile != null;
//        printClassInfo(classFile);
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
            System.out.format("fieldsInfo %s \t\t %s \t\t %s\n", memberInfo.name(), memberInfo.descriptor(), memberInfo.toString());
        }

        System.out.println("methods count: " + cf.methods().length);
        for (MemberInfo memberInfo : cf.methods()) {
            System.out.format("%s \t\t %s  \t\t %s\n", memberInfo.name(), memberInfo.descriptor(), memberInfo.toString());
        }
    }

}