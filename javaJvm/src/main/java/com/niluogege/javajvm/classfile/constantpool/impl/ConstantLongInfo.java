package com.niluogege.javajvm.classfile.constantpool.impl;


import com.niluogege.javajvm.classfile.ClassReader;
import com.niluogege.javajvm.classfile.constantpool.ConstantInfo;

/**
 * http://www.itstack.org
 * create by fuzhengwei on 2019/4/26
 */
public class ConstantLongInfo implements ConstantInfo {

    private long val;

    @Override
    public void readInfo(ClassReader reader) {
        this.val = reader.readUint64TLong();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_LONG;
    }

    public long value(){
        return this.val;
    }

}
