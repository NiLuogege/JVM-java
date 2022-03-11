package com.niluogege.javajvm.instructions.loads.lload;


import com.niluogege.javajvm.instructions.base.InstructionIndex8;
import com.niluogege.javajvm.rtda.Frame;

public class LLOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        Long val = frame.localVars().getLong(this.idx);
        frame.operandStack().pushLong(val);
    }

}
