package com.niluogege.javajvm.instructions.loads.lload;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
//局部变量表中获取第一个 long 类型的值 并 推到操作栈中
public class LLOAD_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Long val = frame.localVars().getLong(0);
        frame.operandStack().pushLong(val);
    }

}
