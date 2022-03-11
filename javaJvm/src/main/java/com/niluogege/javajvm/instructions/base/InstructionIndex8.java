package com.niluogege.javajvm.instructions.base;

import com.niluogege.javajvm.rtda.Frame;

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


}
