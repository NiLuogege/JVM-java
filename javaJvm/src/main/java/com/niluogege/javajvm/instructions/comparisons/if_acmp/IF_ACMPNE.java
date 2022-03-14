package com.niluogege.javajvm.instructions.comparisons.if_acmp;


import com.niluogege.javajvm.instructions.base.Instruction;
import com.niluogege.javajvm.instructions.base.InstructionBranch;
import com.niluogege.javajvm.rtda.Frame;

public class IF_ACMPNE extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        if (!_acmp(frame)) {
            Instruction.branch(frame, this.offset);
        }
    }

}