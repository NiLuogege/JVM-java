package com.niluogege.javajvm.instructions.stores.lstore;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

public class LSTORE_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _lstore(frame, 2);
    }

}
