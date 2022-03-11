package com.niluogege.javajvm.instructions.loads.iload;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

/**
 * 第2个局部变量表的数据 推送到操作数栈的栈顶
 */
public class ILOAD_1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        int val = frame.localVars().getInt(1);
        frame.operandStack().pushInt(val);
    }
}

