package com.niluogege.javajvm.instructions.math.sub;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

//subtract float
public class FSUB extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        float v2 = stack.popFloat();
        float v1 = stack.popFloat();
        float res = v1 - v2;
        stack.pushFloat(res);
    }

}
