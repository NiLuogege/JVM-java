package com.niluogege.javajvm.classfile.attributes.impl;


import com.niluogege.javajvm.classfile.ClassReader;
import com.niluogege.javajvm.classfile.attributes.AttributeInfo;
import com.niluogege.javajvm.classfile.constantpool.ConstantPool;

/**
 * http://www.itstack.org
 * create by fuzhengwei on 2019/4/26
 */
public class SourceFileAttribute implements AttributeInfo {

    private ConstantPool constantPool;
    private int sourceFileIdx;

    public SourceFileAttribute(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.sourceFileIdx = reader.readUint16();
    }

    public String fileName(){
        return this.constantPool.getUTF8(this.sourceFileIdx);
    }

}
