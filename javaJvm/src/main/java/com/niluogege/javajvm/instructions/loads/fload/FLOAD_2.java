package com.niluogege.javajvm.instructions.loads.fload;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

public class FLOAD_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Float val = frame.localVars().getFloat(2);
        frame.operandStack().pushFloat(val);
    }

}
