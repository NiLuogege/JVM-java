package com.niluogege.javajvm.instructions.conversions.i2x;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

//convert int to double
public class I2D extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int i = stack.popInt();
        double d = i;
        stack.pushDouble(d);
    }

}