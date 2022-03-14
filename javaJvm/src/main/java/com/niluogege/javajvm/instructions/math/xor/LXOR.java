package com.niluogege.javajvm.instructions.math.xor;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

//boolean xor long
public class LXOR extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        long v1 = stack.popLong();
        long v2 = stack.popLong();
        long res = v1 ^ v2;
        stack.pushLong(res);
    }

}

