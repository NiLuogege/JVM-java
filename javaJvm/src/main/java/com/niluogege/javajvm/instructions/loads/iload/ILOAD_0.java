package com.niluogege.javajvm.instructions.loads.iload;

import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

/**
 * 读取本地变量表的 第0个 并 推到 操作数栈中
 */
public class ILOAD_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        int val = frame.localVars().getInt(0);
        frame.operandStack().pushInt(val);
    }
}
