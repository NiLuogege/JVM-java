package com.niluogege.javajvm.instructions.stores.dstore;


import com.niluogege.javajvm.instructions.base.InstructionIndex8;
import com.niluogege.javajvm.rtda.Frame;

public class DSTORE extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _astore(frame, this.idx);
    }

}
