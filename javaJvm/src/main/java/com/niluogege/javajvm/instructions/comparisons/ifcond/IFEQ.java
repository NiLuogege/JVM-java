package com.niluogege.javajvm.instructions.comparisons.ifcond;


import com.niluogege.javajvm.instructions.base.Instruction;
import com.niluogege.javajvm.instructions.base.InstructionBranch;
import com.niluogege.javajvm.rtda.Frame;

public class IFEQ extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        int val = frame.operandStack().popInt();
        if (0 == val) {
            Instruction.branch(frame, this.offset);
        }
    }
}
