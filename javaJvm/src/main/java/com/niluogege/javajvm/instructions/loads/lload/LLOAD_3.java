package com.niluogege.javajvm.instructions.loads.lload;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

public class LLOAD_3 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Long val = frame.localVars().getLong(3);
        frame.operandStack().pushLong(val);
    }

}
