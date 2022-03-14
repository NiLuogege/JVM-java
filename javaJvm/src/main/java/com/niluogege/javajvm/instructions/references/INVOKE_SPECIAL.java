package com.niluogege.javajvm.instructions.references;


import com.niluogege.javajvm.instructions.base.InstructionIndex16;
import com.niluogege.javajvm.rtda.Frame;

public class INVOKE_SPECIAL extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        frame.operandStack().popRef();
    }

}