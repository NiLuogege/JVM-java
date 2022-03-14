package com.niluogege.javajvm.instructions.math.sh;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

// Arithmetic shift right long
public class LSHR  extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int v2 = stack.popInt();
        long v1 = stack.popLong();
        long s = v2 & 0x3f;
        long res = v1 >> s;
        stack.pushLong(res);
    }

}

