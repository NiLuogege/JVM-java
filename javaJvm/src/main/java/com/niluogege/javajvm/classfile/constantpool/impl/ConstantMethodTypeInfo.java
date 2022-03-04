package com.niluogege.javajvm.classfile.constantpool.impl;


import com.niluogege.javajvm.classfile.ClassReader;
import com.niluogege.javajvm.classfile.constantpool.ConstantInfo;

/**
 * http://www.itstack.org
 * create by fuzhengwei on 2019/4/26
 */
public class ConstantMethodTypeInfo implements ConstantInfo {

    private int descriptorIdx;

    @Override
    public void readInfo(ClassReader reader) {
          this.descriptorIdx = reader.readUint16();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_METHODTYPE;
    }
}
