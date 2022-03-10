package com.niluogege.javajvm.rtda.heap.constantpool;

import com.niluogege.javajvm.classfile.constantpool.impl.ConstantClassInfo;

public class ClassRef extends SymRef {

    public static ClassRef newClassRef(RunTimeConstantPool runTimeConstantPool, ConstantClassInfo classInfo) {
        ClassRef classRef = new ClassRef();
        classRef.runTimeConstantPool = runTimeConstantPool;
        classRef.className = classInfo.name();
        return classRef;
    }
}
