package com.niluogege.javajvm.rtda.heap;

import com.niluogege.javajvm.classfile.ClassFile;
import com.niluogege.javajvm.classfile.MemberInfo;
import com.niluogege.javajvm.classpath.Classpath;
import com.niluogege.javajvm.rtda.heap.constantpool.RunTimeConstantPool;
import com.niluogege.javajvm.rtda.heap.methodarea.Class;
import com.niluogege.javajvm.rtda.heap.methodarea.Field;
import com.niluogege.javajvm.rtda.heap.methodarea.Slots;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 类加载器
 * <p>
 * 类的生命周期是 加载 -》 链接 -》 初始化 -》使用 -》卸载
 */
public class ClassLoader {
    private Classpath classpath;//路径封装类
    private Map<String, Class> classMap;//Class对象缓存器

    public ClassLoader(Classpath classpath) {
        this.classpath = classpath;
        classMap = new HashMap<>();
    }

    public Class loadClass(String className) {
        Class clazz = classMap.get(className);
        if (clazz != null) return clazz;
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
    private Class loadNonArrayClass(String className) throws Exception {
        byte[] bytes = classpath.readClass(className);
        if (null == bytes) {
            throw new ClassNotFoundException(className);
        }
        //bytes数组转为 Class
        Class clazz = defineClass(bytes);
        //链接
        link(clazz);
        return clazz;
    }

    private void link(Class clazz) {
        //校验
        verify(clazz);
        //准备
        prepare(clazz);
        //解析

    }

    private void prepare(Class clazz) {
        calcInstanceFieldSlotIds(clazz);
        calcStaticFieldSlotIds(clazz);
        allocAndInitStaticVars(clazz);
    }

    /**
     * 初始化 静态数据槽
     */
    private void allocAndInitStaticVars(Class clazz) {
        //初始化当前类的 静态数据槽
        clazz.staticVars = new Slots(clazz.staticSlotCount);
        for (Field field : clazz.fields) {
            if (field.isStatic() && field.isFinal()) {
                initStaticFinalVar(clazz, field);
            }
        }
    }

    private void initStaticFinalVar(Class clazz, Field field) {
        Slots staticVars = clazz.staticVars;
        RunTimeConstantPool constantPool = clazz.runTimeConstantPool;
        int cpIdx = field.constValueIndex();
        int slotId = field.slotId();

        if (cpIdx > 0) {
            switch (field.descriptor()) {
                case "Z":
                case "B":
                case "C":
                case "S":
                case "I":
                    java.lang.Object val = constantPool.getConstants(cpIdx);
                    staticVars.setInt(slotId, (Integer) val);
                case "J":
                    staticVars.setLong(slotId, (Long) constantPool.getConstants(cpIdx));
                case "F":
                    staticVars.setFloat(slotId, (Float) constantPool.getConstants(cpIdx));
                case "D":
                    staticVars.setDouble(slotId, (Double) constantPool.getConstants(cpIdx));
                case "Ljava/lang/String;":
                    System.out.println("todo");
            }
        }

    }

    /**
     * 计算 静态属性的数据槽个数
     * @param clazz
     */
    private void calcStaticFieldSlotIds(Class clazz) {
        int slotId = 0;
        for (Field field : clazz.fields) {
            if (field.isStatic()) {
                field.slotId = slotId;
                slotId++;
                if (field.isLongOrDouble()) {
                    slotId++;
                }
            }
        }
        clazz.staticSlotCount = slotId;
    }

    /**
     * 计算 成员属性的数据槽数量
     */
    private void calcInstanceFieldSlotIds(Class clazz) {
        int slotId = 0;
        if (clazz.superClass != null) {
            slotId = clazz.superClass.instanceSlotCount;
        }
        for (Field field : clazz.fields) {
            if (!field.isStatic()) {
                field.slotId = slotId;
                slotId++;
                //如果是 Long Or Double 需要占两个数据槽
                if (field.isLongOrDouble()) {
                    slotId++;
                }
            }
        }
        clazz.instanceSlotCount = slotId;
    }

    /**
     * 校验
     */
    private void verify(Class clazz) {
        // 校验字节码，尚未实现
    }

    private Class defineClass(byte[] bytes) throws Exception {
        ClassFile classFile = new ClassFile(bytes);
//        printClassInfo(classFile);
        Class clazz = new Class(classFile);
        clazz.classLoader = this;
        //初始化父类
        resolveSuperClass(clazz);
        //初始化父接口
        resolveInterfaces(clazz);
        this.classMap.put(clazz.name, clazz);
        return clazz;
    }


    private void resolveInterfaces(Class clazz) throws Exception {
        int interfaceCount = clazz.interfaceNames.length;
        if (interfaceCount > 0) {
            clazz.interfaces = new Class[interfaceCount];
            for (int i = 0; i < interfaceCount; i++) {
                clazz.interfaces[i] = clazz.classLoader.loadClass(clazz.interfaceNames[i]);
            }
        }
    }

    private void resolveSuperClass(Class clazz) throws Exception {
        if (!clazz.name.equals("java/lang/Object")) {
            clazz.superClass = clazz.classLoader.loadClass(clazz.superClassName);
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
