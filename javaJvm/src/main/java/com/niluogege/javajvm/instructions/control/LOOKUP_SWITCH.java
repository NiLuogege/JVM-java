package com.niluogege.javajvm.instructions.control;

import com.niluogege.javajvm.instructions.base.BytecodeReader;
import com.niluogege.javajvm.instructions.base.Instruction;
import com.niluogege.javajvm.rtda.Frame;

/**
 * 用于switch条件跳转，case值不连续（变长指令）
 */
public class LOOKUP_SWITCH implements Instruction {

    private int defaultOffset;
    private int npairs;//多少对儿
    private int[] matchOffsets;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        reader.skipPadding();
        defaultOffset = reader.readInt();
        npairs = reader.readInt();//多少对儿
        matchOffsets = reader.readInts(npairs * 2);
    }

    @Override
    public void execute(Frame frame) {
        int key = frame.operandStack().popInt();
        for (int i = 0; i < npairs * 2; i += 2) {
            if (this.matchOffsets[i] == key) {
                int offset = matchOffsets[i + 1];
                Instruction.branch(frame, offset);
            }
        }
        Instruction.branch(frame, this.defaultOffset);
    }
}
