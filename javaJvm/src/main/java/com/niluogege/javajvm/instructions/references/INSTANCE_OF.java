package com.niluogege.javajvm.instructions.references;


import com.niluogege.javajvm.instructions.base.InstructionIndex16;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;
import com.niluogege.javajvm.rtda.heap.constantpool.ClassRef;
import com.niluogege.javajvm.rtda.heap.constantpool.RunTimeConstantPool;
import com.niluogege.javajvm.rtda.heap.methodarea.Class;
import com.niluogege.javajvm.rtda.heap.methodarea.Object;
public class INSTANCE_OF extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        Object ref = stack.popRef();
        if (null == ref){
            stack.pushInt(0);
            return;
        }
        RunTimeConstantPool cp = frame.method().clazz().constantPool();
        ClassRef classRef = (ClassRef) cp.getConstants(this.idx);
        Class clazz = classRef.resolvedClass();
        if (ref.isInstanceOf(clazz)){
            stack.pushInt(1);
        } else {
            stack.pushInt(0);
        }
    }

}
