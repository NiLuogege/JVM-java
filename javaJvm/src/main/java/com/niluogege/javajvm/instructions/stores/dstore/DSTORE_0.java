package com.niluogege.javajvm.instructions.stores.dstore;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

public class DSTORE_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _dstore(frame, 0);
    }

}
