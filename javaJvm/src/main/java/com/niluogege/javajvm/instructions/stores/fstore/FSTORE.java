package com.niluogege.javajvm.instructions.stores.fstore;


import com.niluogege.javajvm.instructions.base.InstructionIndex8;
import com.niluogege.javajvm.rtda.Frame;

public class FSTORE extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _fstore(frame, this.idx);
    }

}
