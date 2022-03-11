package com.niluogege.javajvm.instructions.stores.astore;


import com.niluogege.javajvm.instructions.base.InstructionIndex8;
import com.niluogege.javajvm.rtda.Frame;

//store reference into local variable
public class ASTORE extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _astore(frame, this.idx);
    }

}
