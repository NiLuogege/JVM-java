package com.niluogege.javajvm.classfile.constantpool.impl;


import com.niluogege.javajvm.classfile.constantpool.ConstantPool;

/**
 * http://www.itstack.org
 * create by fuzhengwei on 2019/4/26
 */
public class ConstantMethodRefInfo extends ConstantMemberRefInfo {

    public ConstantMethodRefInfo(ConstantPool constantPool) {
        super(constantPool);
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_METHODREF;
    }
}
