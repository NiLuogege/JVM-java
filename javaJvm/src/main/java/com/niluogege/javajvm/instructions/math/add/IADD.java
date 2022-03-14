package com.niluogege.javajvm.instructions.math.add;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

// 操作数栈顶两个数相加 并在压入操作数栈顶
public class IADD extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int v2 = stack.popInt();
        int v1 = stack.popInt();
        int res = v1 + v2;
        stack.pushInt(res);
    }

}
