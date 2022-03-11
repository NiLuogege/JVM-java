package com.niluogege.javajvm.instructions.stores.lstore;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

public class LSTORE_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _lstore(frame, 0);
    }

}
