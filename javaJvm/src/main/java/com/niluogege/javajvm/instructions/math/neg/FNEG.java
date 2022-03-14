package com.niluogege.javajvm.instructions.math.neg;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

//negate float
public class FNEG extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        float val = stack.popFloat();
        stack.pushDouble(-val);
    }

}
