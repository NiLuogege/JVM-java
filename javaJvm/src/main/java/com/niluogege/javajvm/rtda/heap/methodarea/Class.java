package com.niluogege.javajvm.rtda.heap.methodarea;

import com.niluogege.javajvm.classfile.ClassFile;
import com.niluogege.javajvm.rtda.heap.ClassLoader;
import com.niluogege.javajvm.rtda.heap.constantpool.RunTimeConstantPool;

import java.util.Arrays;

public class Class {
    public int accessFlags;
    public String name;
    public String superClassName;
    public String[] interfaceNames;
    public RunTimeConstantPool runTimeConstantPool;
    public Field[] fields;
    public Method[] method;
    public ClassLoader classLoader;
    public Class superClass;
    public Class[] interfaces;
    public int instanceSlotCount;//成员数据槽个数
    public int staticSlotCount;//静态数据槽个数
    public Slots staticVars;


    public Class(ClassFile classFile) {
        this.accessFlags = classFile.accessFlags();
        this.name=classFile.className();
        this.superClassName=classFile.superClassName();
        this.interfaceNames=classFile.interfaceNames();
        this.runTimeConstantPool=new RunTimeConstantPool(this,classFile.constantPool());
    }

    public String getPackageName() {
        int i = this.name.lastIndexOf("/");
        if (i >= 0) return this.name;
        return "";
    }


    @Override
    public String toString() {
        return "Class{" +
                "accessFlags=" + accessFlags +
                ", name='" + name + '\'' +
                ", superClassName='" + superClassName + '\'' +
                ", interfaceNames=" + Arrays.toString(interfaceNames) +
                ", runTimeConstantPool=" + runTimeConstantPool +
                ", fields=" + Arrays.toString(fields) +
                ", method=" + Arrays.toString(method) +
                ", classLoader=" + classLoader +
                ", superClass=" + superClass +
                ", interfaces=" + Arrays.toString(interfaces) +
                ", instanceSlotCount=" + instanceSlotCount +
                ", staticSlotCount=" + staticSlotCount +
                ", staticVars=" + staticVars +
                '}';
    }
}
