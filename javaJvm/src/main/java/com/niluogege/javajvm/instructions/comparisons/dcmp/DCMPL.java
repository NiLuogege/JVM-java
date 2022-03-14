package com.niluogege.javajvm.instructions.comparisons.dcmp;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

public class DCMPL extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _dcmp(frame, false);
    }

}