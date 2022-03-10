package com.niluogege.javajvm.rtda.heap.methodarea;

import com.niluogege.javajvm.classfile.ClassFile;
import com.niluogege.javajvm.rtda.heap.ClassLoader;
import com.niluogege.javajvm.rtda.heap.constantpool.RunTimeConstantPool;

public class Class {
    public int accessFlags;
    public String name;
    public String superClassName;
    public String[] interfaceNames;
    public RunTimeConstantPool runTimeConstantPool;
    public Field[] files;
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
}
