package com.niluogege.javajvm.instructions.stores.istore;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

public class ISTORE_3 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _istore(frame, 3);
    }

}

