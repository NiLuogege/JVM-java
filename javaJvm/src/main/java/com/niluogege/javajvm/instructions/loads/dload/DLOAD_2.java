package com.niluogege.javajvm.instructions.loads.dload;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

public class DLOAD_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        double val = frame.localVars().getDouble(2);
        frame.operandStack().pushDouble(val);
    }

}

