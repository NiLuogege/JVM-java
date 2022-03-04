package com.niluogege.javajvm.classfile.attributes.impl;


import com.niluogege.javajvm.classfile.ClassReader;
import com.niluogege.javajvm.classfile.attributes.AttributeInfo;
import com.niluogege.javajvm.classfile.constantpool.ConstantPool;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.itstack.org
 * create by fuzhengwei on 2019/4/26
 */
public class EnclosingMethodAttribute implements AttributeInfo {

    private ConstantPool constantPool;
    private int classIdx;
    private int methodIdx;


    public EnclosingMethodAttribute(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.classIdx = reader.readUint16();
        this.methodIdx = reader.readUint16();
    }

    public String className() {
        return this.constantPool.getClassName(this.classIdx);
    }

    public Map<String, String> methodNameAndDescriptor() {
        if (this.methodIdx <= 0) return new HashMap<>();
        return this.constantPool.getNameAndType(this.methodIdx);
    }

}
