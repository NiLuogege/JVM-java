package com.niluogege.javajvm.instructions.constants.consts;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

public class DCONST_1 extends InstructionNoOperands {
    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushDouble(1.0);
    }
}
