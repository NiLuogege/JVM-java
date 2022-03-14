package com.niluogege.javajvm.instructions.conversions.l2x;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

//convert long to double
public class L2D extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        long l = stack.popLong();
        float f = l;
        stack.pushFloat(f);
    }

}
