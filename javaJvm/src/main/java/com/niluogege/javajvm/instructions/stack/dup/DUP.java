package com.niluogege.javajvm.instructions.stack.dup;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;
import com.niluogege.javajvm.rtda.Slot;

//复制栈定数值应将其复制值压入栈顶
/*
bottom -> top
[...][c][b][a]
             \_
               |
               V
[...][c][b][a][a]
*/
public class DUP extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        Slot slot = stack.popSlot();
        stack.pushSlot(slot);
        stack.pushSlot(slot);
    }

}
