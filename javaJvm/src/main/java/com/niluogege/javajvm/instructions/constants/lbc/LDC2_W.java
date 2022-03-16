package com.niluogege.javajvm.instructions.constants.lbc;

import com.niluogege.javajvm.instructions.base.InstructionIndex16;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;
import com.niluogege.javajvm.rtda.heap.constantpool.RunTimeConstantPool;

/**
 * //将long 或 double 类型数值 从常量池中推送至栈顶
 */
public class LDC2_W extends InstructionIndex16 {
    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        RunTimeConstantPool runTimeConstantPool = frame.method().clazz.constantPool();
        Object c = runTimeConstantPool.getConstants(idx);
        if (c instanceof Long){
            stack.pushLong((Long) c);
            return;
        }

        if (c instanceof Double){
            stack.pushDouble((Double) c);
        }

        throw new ClassFormatError();
    }
}
