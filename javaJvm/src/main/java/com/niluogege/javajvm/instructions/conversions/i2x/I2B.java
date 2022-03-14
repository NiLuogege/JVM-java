package com.niluogege.javajvm.instructions.conversions.i2x;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

//Convert int to byte
public class I2B extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int i = stack.popInt();
        int b = (byte) i;
        stack.pushInt(b);
    }

}
