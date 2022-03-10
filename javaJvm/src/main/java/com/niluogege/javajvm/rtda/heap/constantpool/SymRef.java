package com.niluogege.javajvm.rtda.heap.constantpool;

import com.niluogege.javajvm.rtda.heap.methodarea.Class;

public class SymRef {
    public RunTimeConstantPool runTimeConstantPool;
    public String className;
    public Class clazz;

    /**
     * 加载被依赖的的相关类， 只有在使用的时候才回去加载
     */
    public Class resolvedClass(){
        if (null!=this.clazz) return this.clazz;
        Class d = runTimeConstantPool.getClazz();
        Class c = d.classLoader.loadClass(this.className);
        this.clazz=c;
        return clazz;
    }
}
