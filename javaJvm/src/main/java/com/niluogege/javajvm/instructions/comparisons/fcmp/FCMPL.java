package com.niluogege.javajvm.instructions.comparisons.fcmp;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

public class FCMPL extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _fcmp(frame, false);
    }

}
