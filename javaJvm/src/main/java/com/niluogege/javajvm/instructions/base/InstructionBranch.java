package com.niluogege.javajvm.instructions.base;

import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.OperandStack;

public class InstructionBranch implements Instruction{
    //偏移量
    protected int offset;

    @Override
    public void fetchOperands(BytecodeReader reader) {
         offset = reader.readShort();
    }

    @Override
    public void execute(Frame frame) {

    }

    protected boolean _acmp(Frame frame){
        OperandStack stack = frame.operandStack();
        Object ref2 = stack.popRef();
        Object ref1 = stack.popRef();
        return ref1.equals(ref2);
    }
}
