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

    protected void _astore(Frame frame, int idx) {
        Object ref = frame.operandStack().popRef();
        frame.localVars().setRef(idx, ref);
    }

    protected void _dstore(Frame frame, int idx) {
        double val = frame.operandStack().popDouble();
        frame.localVars().setDouble(idx, val);
    }

    protected void _fstore(Frame frame, int idx) {
        float val = frame.operandStack().popFloat();
        frame.localVars().setFloat(idx, val);
    }

    /**
     * 操作数栈顶数据 存放到 局部变量表idx 位置
     */
    protected void _istore(Frame frame,int idx){
        int val = frame.operandStack().popInt();
        frame.localVars().setInt(idx,val);
    }

    protected void _lstore(Frame frame, int idx) {
        long val = frame.operandStack().popLong();
        frame.localVars().setLong(idx, val);
    }

}
