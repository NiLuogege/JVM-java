package com.niluogege.javajvm.instructions.base;


import com.niluogege.javajvm.rtda.Frame;

/**
 * 没有操作数的指令
 */
public class InstructionNoOperands implements Instruction {
    @Override
    public void fetchOperands(BytecodeReader reader) {
        //empty
    }

    @Override
    public void execute(Frame frame) {
        // nothing to do
    }

    /**
     * 操作数栈顶数据 存放到 局部变量表idx 位置
     */
    protected void _istore(Frame frame,int idx){
        int val = frame.operandStack().popInt();
        frame.localVars().setInt(idx,val);
    }
}
