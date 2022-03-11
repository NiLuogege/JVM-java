package com.niluogege.javajvm.instructions.constants.nop;

import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

/**
 * 没有任何操作的指令
 */
public class NOP extends InstructionNoOperands {
    @Override
    public void execute(Frame frame) {
        //really do nothing
    }
}
