package com.niluogege.javajvm.instructions.conversions.f2x;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

//convert float to int
public class F2I extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        float f = stack.popFloat();
        int i = (int) f;
        stack.pushInt(i);
    }
}
