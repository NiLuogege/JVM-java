package com.niluogege.javajvm.instructions.extended.ifnull;


import com.niluogege.javajvm.instructions.base.Instruction;
import com.niluogege.javajvm.instructions.base.InstructionBranch;
import com.niluogege.javajvm.rtda.Frame;

public class IFNONNULL extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.operandStack().popRef();
        if (null != ref) {
            Instruction.branch(frame, this.offset);
        }
    }
}