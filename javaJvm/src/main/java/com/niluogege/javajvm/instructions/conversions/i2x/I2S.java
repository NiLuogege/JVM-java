package com.niluogege.javajvm.instructions.conversions.i2x;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

//convert int to short
public class I2S extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int i = stack.popInt();
        short s = (short) i;
        stack.pushInt(s);
    }

}
