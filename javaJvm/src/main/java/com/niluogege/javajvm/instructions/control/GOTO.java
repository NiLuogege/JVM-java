package com.niluogege.javajvm.instructions.control;

import com.niluogege.javajvm.instructions.base.Instruction;
import com.niluogege.javajvm.instructions.base.InstructionBranch;
import com.niluogege.javajvm.rtda.Frame;

/**
 * 无条件跳转，其实就是（offset = 0）
 */
public class GOTO extends InstructionBranch {
    @Override
    public void execute(Frame frame) {
        Instruction.branch(frame,offset);
    }
}
