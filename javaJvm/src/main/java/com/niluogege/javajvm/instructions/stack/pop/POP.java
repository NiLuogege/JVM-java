package com.niluogege.javajvm.instructions.stack.pop;

import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

/**
 * 将栈顶数值弹出（数值不能是long or double类型的）
 */
public class POP extends InstructionNoOperands {
    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        stack.popSlot();
    }
}
