package com.niluogege.javajvm.rtda.heap.methodarea;

import com.niluogege.javajvm.classfile.MemberInfo;
import com.niluogege.javajvm.classfile.attributes.impl.CodeAttribute;
import com.niluogege.javajvm.rtda.heap.constantpool.AccessFlags;

public class Method extends ClassMember{
    public int maxStack;//本地方法栈 最大栈长
    public int maxLocals;//本地变量表最大长度
    public byte[] code; //操作码字节流

    public Method[] newMethods(Class clazz, MemberInfo[] cfMethods) {
        Method[] methods  = new Method[cfMethods.length];
        for (int i = 0; i < cfMethods.length; i++) {
            methods[i] = new Method();
            methods[i].clazz = clazz;
            methods[i].copyMemberInfo(cfMethods[i]);
            methods[i].copyAttributes(cfMethods[i]);
        }
        return methods;
    }

    private void copyAttributes(MemberInfo cfMethod) {
        CodeAttribute codeAttr = cfMethod.codeAttribute();
        if (null!=codeAttr){
            maxStack = codeAttr.maxStack();
            maxLocals  = codeAttr.maxLocals();
            code = codeAttr.data();
        }
    }

    public boolean isSynchronized() {
        return 0 != (this.accessFlags & AccessFlags.ACC_SYNCHRONIZED);
    }

    public boolean isBridge() {
        return 0 != (this.accessFlags & AccessFlags.ACC_BRIDGE);
    }

    public boolean isVarargs() {
        return 0 != (this.accessFlags & AccessFlags.ACC_VARARGS);
    }

    public boolean isNative() {
        return 0 != (this.accessFlags & AccessFlags.ACC_NATIVE);
    }

    public boolean isAbstract() {
        return 0 != (this.accessFlags & AccessFlags.ACC_ABSTRACT);
    }

    public boolean isStrict() {
        return 0 != (this.accessFlags & AccessFlags.ACC_STRICT);
    }

    public int maxStack() {
        return this.maxStack;
    }

    public int maxLocals() {
        return this.maxLocals;
    }

    public byte[] code() {
        return this.code;
    }
}
