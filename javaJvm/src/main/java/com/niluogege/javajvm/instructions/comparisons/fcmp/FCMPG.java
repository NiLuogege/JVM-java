package com.niluogege.javajvm.instructions.comparisons.fcmp;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

public class FCMPG extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _fcmp(frame, true);
    }

}
