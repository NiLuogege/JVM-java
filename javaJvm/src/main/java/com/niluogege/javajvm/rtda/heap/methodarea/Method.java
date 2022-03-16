package com.niluogege.javajvm.rtda.heap.methodarea;

import com.niluogege.javajvm.classfile.MemberInfo;
import com.niluogege.javajvm.classfile.attributes.impl.CodeAttribute;
import com.niluogege.javajvm.rtda.heap.constantpool.AccessFlags;

import java.util.List;

public class Method extends ClassMember{
    public int maxStack;//本地方法栈 最大栈长
    public int maxLocals;//本地变量表最大长度
    public byte[] code; //操作码字节流
    private int argSlotCount;

    public Method[] newMethods(Class clazz, MemberInfo[] cfMethods) {
        Method[] methods  = new Method[cfMethods.length];
        for (int i = 0; i < cfMethods.length; i++) {
            methods[i] = new Method();
            methods[i].clazz = clazz;
            methods[i].copyMemberInfo(cfMethods[i]);
            methods[i].copyAttributes(cfMethods[i]);
            methods[i].calcArgSlotCount();
        }
        return methods;
    }

    /**
     * 计算方法新参占用的数据格数， long 和 double 类型占两个
     *
     * 不是静态方法也要多占一个数据位，现在不知道为啥
     */
    private void calcArgSlotCount() {
        MethodDescriptor methodDescriptor = MethodDescriptorParser.parseMethodDescriptorParser(descriptor);
        List<String> parameterTypes = methodDescriptor.parameterTypes;
        for (String parameterType : parameterTypes) {
            argSlotCount++;
            if ("J".equals(parameterType) || "D".equals(parameterType)) {
                this.argSlotCount++;
            }
        }

        //不是静态方法也要多占一个数据位
        if (!isStatic()){
            argSlotCount++;
        }

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

    public int argSlotCount() {
        return this.argSlotCount;
    }
}
