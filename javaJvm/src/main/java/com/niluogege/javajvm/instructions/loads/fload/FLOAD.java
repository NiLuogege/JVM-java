package com.niluogege.javajvm.instructions.loads.fload;


import com.niluogege.javajvm.instructions.base.InstructionIndex8;
import com.niluogege.javajvm.rtda.Frame;

//load float from local variable
public class FLOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        Float val = frame.localVars().getFloat(this.idx);
        frame.operandStack().pushFloat(val);
    }

}
