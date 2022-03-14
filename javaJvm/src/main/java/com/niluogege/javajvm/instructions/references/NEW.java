package com.niluogege.javajvm.instructions.references;

import com.niluogege.javajvm.rtda.heap.methodarea.Class;
import com.niluogege.javajvm.rtda.heap.methodarea.Object;
import com.niluogege.javajvm.instructions.base.InstructionIndex16;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.heap.constantpool.ClassRef;
import com.niluogege.javajvm.rtda.heap.constantpool.RunTimeConstantPool;

public class NEW extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        RunTimeConstantPool cp = frame.method().clazz().constantPool();
        ClassRef classRef = (ClassRef) cp.getConstants(this.idx);
        Class clazz = classRef.resolvedClass();
        if (clazz.isInterface() || clazz.isAbstract()) {
            throw new InstantiationError();
        }
        Object ref = clazz.newObject();
        frame.operandStack().pushRef(ref);
    }

}