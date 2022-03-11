package com.niluogege.javajvm.instructions.loads.fload;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

public class FLOAD_1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Float val = frame.localVars().getFloat(1);
        frame.operandStack().pushFloat(val);
    }

}
