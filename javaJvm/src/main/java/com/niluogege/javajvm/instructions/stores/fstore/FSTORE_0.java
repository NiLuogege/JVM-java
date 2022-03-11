package com.niluogege.javajvm.instructions.stores.fstore;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

public class FSTORE_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _fstore(frame, 0);
    }

}