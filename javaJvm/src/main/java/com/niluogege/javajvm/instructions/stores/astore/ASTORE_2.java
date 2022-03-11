package com.niluogege.javajvm.instructions.stores.astore;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

public class ASTORE_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _astore(frame, 2);
    }

}

