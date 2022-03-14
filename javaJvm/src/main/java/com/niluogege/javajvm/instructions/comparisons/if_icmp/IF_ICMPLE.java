package com.niluogege.javajvm.instructions.comparisons.if_icmp;


import com.niluogege.javajvm.instructions.base.Instruction;
import com.niluogege.javajvm.instructions.base.InstructionBranch;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

public class IF_ICMPLE extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int val2 = stack.popInt();
        int val1 = stack.popInt();
        if (val1 <= val2) {
            Instruction.branch(frame, this.offset);
        }
    }

}