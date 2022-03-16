package com.niluogege.javajvm.instructions.constants.consts;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
//将long类型1 推送至栈顶
public class LCONST_1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
         frame.operandStack().pushLong(1);
    }
}
