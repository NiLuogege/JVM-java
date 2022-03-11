package com.niluogege.javajvm.instructions.stores.lstore;


import com.niluogege.javajvm.instructions.base.InstructionIndex8;
import com.niluogege.javajvm.rtda.Frame;

public class LSTORE extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _lstore(frame, this.idx);
    }

}
