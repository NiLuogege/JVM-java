package com.niluogege.javajvm.instructions.loads.iload;

import com.niluogege.javajvm.instructions.base.InstructionIndex8;
import com.niluogege.javajvm.rtda.Frame;

/**
 * 读一个 int 数到 操作数栈
 */
public class ILOAD extends InstructionIndex8 {
    @Override
    public void execute(Frame frame) {
        int val = frame.localVars().getInt(idx);
        frame.operandStack().pushInt(val);
    }
}
