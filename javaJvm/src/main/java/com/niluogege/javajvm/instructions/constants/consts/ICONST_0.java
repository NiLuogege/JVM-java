package com.niluogege.javajvm.instructions.constants.consts;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

public class ICONST_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        //将 0 压入 操作数栈顶
        frame.operandStack().pushInt(0);
    }
}
