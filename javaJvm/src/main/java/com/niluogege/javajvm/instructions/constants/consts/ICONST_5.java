package com.niluogege.javajvm.instructions.constants.consts;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

/**
 * 操作数栈 入栈一个 5
 */
public class ICONST_5 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushInt(5);
    }
}
