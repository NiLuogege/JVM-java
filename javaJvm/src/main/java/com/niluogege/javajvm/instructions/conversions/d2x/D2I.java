package com.niluogege.javajvm.instructions.conversions.d2x;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

public class D2I extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        double d = stack.popDouble();
        int i = (int) d;
        stack.pushInt(i);
    }

}
