package com.niluogege.javajvm.classfile.constantpool.impl;


import com.niluogege.javajvm.classfile.ClassReader;
import com.niluogege.javajvm.classfile.constantpool.ConstantInfo;

/**
 * http://www.itstack.org
 * create by fuzhengwei on 2019/4/26
 */
public class ConstantUtf8Info implements ConstantInfo {

    private String str;

    @Override
    public void readInfo(ClassReader reader) {
        int length = reader.readUint16();
        byte[] bytes = reader.readBytes(length);
        this.str = new String(bytes);
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_UTF8;
    }

    public String str(){
        return this.str;
    }

}
