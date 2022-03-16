package com.niluogege.javajvm.rtda.heap.constantpool;

import com.niluogege.javajvm.classfile.constantpool.impl.ConstantMethodRefInfo;
import com.niluogege.javajvm.rtda.heap.methodarea.Class;
import com.niluogege.javajvm.rtda.heap.methodarea.Method;
import com.niluogege.javajvm.rtda.heap.methodarea.MethodLookup;

public class MethodRef extends MemberRef{

    private Method method;

    public static MethodRef newMethodRef(RunTimeConstantPool runTimeConstantPool, ConstantMethodRefInfo refInfo){
        MethodRef ref = new MethodRef();
        ref.runTimeConstantPool=runTimeConstantPool;
        ref.copyMemberRefInfo(refInfo);
        return  ref;
    }

    public Method ResolvedMethod(){
        if (null == this.method){
            this.resolveMethodRef();
        }
        return this.method;
    }

    //就是在自己或者父类中找到 目标方法
    private void resolveMethodRef() {
        Class d = runTimeConstantPool.getClazz();
        Class c = resolvedClass();

        if (c.isInterface()) {
            throw new IncompatibleClassChangeError();
        }

        Method method = lookupMethod(c, this.name, this.descriptor);
        if (null == method){
            throw new NoSuchMethodError();
        }

        if (!method.isAccessibleTo(d)){
            throw new IllegalAccessError();
        }

        this.method = method;
    }

    public Method lookupMethod(Class clazz, String name, String descriptor) {
        Method method = MethodLookup.lookupMethodInClass(clazz, name, descriptor);
        if (null == method) {
            method = MethodLookup.lookupMethodInInterfaces(clazz.interfaces, name, descriptor);
        }
        return method;
    }
}
