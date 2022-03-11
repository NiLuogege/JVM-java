package com.niluogege.javajvm.instructions.loads.dload;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

public class DLOAD_3 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        double val = frame.localVars().getDouble(3);
        frame.operandStack().pushDouble(val);
    }

}
