package com.niluogege.javajvm.instructions.math.sh;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

//lo
public class LSHL extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int v2 = stack.popInt();
        long v1 = stack.popLong();
        int s = v2 & 0x3f;
        long res = v1 << s;
        stack.pushLong(res);

    }

}

