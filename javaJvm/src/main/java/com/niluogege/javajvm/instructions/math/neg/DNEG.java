package com.niluogege.javajvm.instructions.math.neg;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

//negate double
public class DNEG extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        double val = stack.popDouble();
        stack.pushDouble(-val);
    }

}