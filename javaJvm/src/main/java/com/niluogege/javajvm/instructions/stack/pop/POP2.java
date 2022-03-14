package com.niluogege.javajvm.instructions.stack.pop;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

/**
 * 将栈顶  long or double or 2个数值 弹出
 */
public class POP2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        stack.popSlot();
        stack.popSlot();
    }

}
