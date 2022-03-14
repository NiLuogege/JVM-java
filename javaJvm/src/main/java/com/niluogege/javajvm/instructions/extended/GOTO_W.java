package com.niluogege.javajvm.instructions.extended;


import com.niluogege.javajvm.instructions.base.BytecodeReader;
import com.niluogege.javajvm.instructions.base.Instruction;
import com.niluogege.javajvm.rtda.Frame;

//branch always(wide index)
public class GOTO_W implements Instruction {

    private int offset;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.offset = reader.readInt();
    }

    @Override
    public void execute(Frame frame) {
        Instruction.branch(frame, this.offset);
    }

}
