package com.niluogege.javajvm.instructions.base;

import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.heap.methodarea.Object;
/**
 * 读一个 byte（8位）类型的操作数
 */
public class InstructionIndex8 implements Instruction {
    public int idx;
    @Override
    public void fetchOperands(BytecodeReader reader) {
        idx = reader.readByte();
    }

    @Override
    public void execute(Frame frame) {

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

    protected void _istore(Frame frame, int idx) {
        int val = frame.operandStack().popInt();
        frame.localVars().setInt(idx, val);
    }

    protected void _lstore(Frame frame, int idx) {
        long val = frame.operandStack().popLong();
        frame.localVars().setLong(idx, val);
    }

}
