package com.niluogege.javajvm.instructions.comparisons.ifcond;


import com.niluogege.javajvm.instructions.base.Instruction;
import com.niluogege.javajvm.instructions.base.InstructionBranch;
import com.niluogege.javajvm.rtda.Frame;

public class IFNE extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        int val = frame.operandStack().popInt();
        if (val != 0) {
            Instruction.branch(frame, this.offset);
        }
    }
}