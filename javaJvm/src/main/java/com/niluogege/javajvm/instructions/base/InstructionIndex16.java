package com.niluogege.javajvm.instructions.base;

import com.niluogege.javajvm.rtda.Frame;

/**
 * 读一个 short（16位）类型的操作数
 */
public class InstructionIndex16 implements Instruction {
    public int idx;
    @Override
    public void fetchOperands(BytecodeReader reader) {
        idx = reader.readShort();
    }

    @Override
    public void execute(Frame frame) {

    }

}
