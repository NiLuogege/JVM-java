package com.niluogege.javajvm.rtda.heap;

import com.niluogege.javajvm.classfile.ClassFile;
import com.niluogege.javajvm.classfile.MemberInfo;
import com.niluogege.javajvm.classpath.Classpath;
import com.niluogege.javajvm.rtda.heap.methodarea.Class;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 类加载器
 *
 * 类的生命周期是 加载 -》 链接 -》 初始化 -》使用 -》卸载
 */
public class ClassLoader {
    private Classpath classpath;//路径封装类
    private Map<String, Class> classMap;//Class对象缓存器

    public ClassLoader(Classpath classpath) {
        this.classpath=classpath;
        classMap=new HashMap<>();
    }

    public Class loadClass(String className) {
        Class clazz = classMap.get(className);
        if (clazz!=null)return clazz;
        try {
            return loadNonArrayClass(className);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加载没有缓存过的 Class
     */
    private Class loadNonArrayClass(String className) throws Exception{
        byte[] bytes = classpath.readClass(className);
        if (null==bytes){
            throw new ClassNotFoundException(className);
        }
        //bytes数组转为 Class
        Class clazz = defineClass(bytes);
        return clazz;
    }

    private Class defineClass(byte[] bytes) {
        ClassFile classFile = new ClassFile(bytes);
//        printClassInfo(classFile);
        Class clazz = new Class(classFile);
        return clazz;
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
