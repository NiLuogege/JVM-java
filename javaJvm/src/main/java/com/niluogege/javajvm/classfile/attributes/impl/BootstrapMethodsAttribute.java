package com.niluogege.javajvm.classfile.attributes.impl;


import com.niluogege.javajvm.classfile.ClassReader;
import com.niluogege.javajvm.classfile.attributes.AttributeInfo;

/**
 * http://www.itstack.org
 * create by fuzhengwei on 2019/4/26
 */
public class BootstrapMethodsAttribute implements AttributeInfo {

    BootstrapMethod[] bootstrapMethods;

    @Override
    public void readInfo(ClassReader reader) {
        int bootstrapMethodNum = reader.readUint16();
        bootstrapMethods = new BootstrapMethod[bootstrapMethodNum];
        for (int i = 0; i < bootstrapMethodNum; i++) {
            bootstrapMethods[i] = new BootstrapMethod(reader.readUint16(), reader.readUint16s());
        }
    }

    static class BootstrapMethod {
        int bootstrapMethodRef;
        int[] bootstrapArguments;

        BootstrapMethod(int bootstrapMethodRef, int[] bootstrapArguments) {
            this.bootstrapMethodRef = bootstrapMethodRef;
            this.bootstrapArguments = bootstrapArguments;
        }
    }

}
