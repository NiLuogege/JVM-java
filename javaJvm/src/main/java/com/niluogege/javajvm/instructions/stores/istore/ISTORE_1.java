package com.niluogege.javajvm.instructions.stores.istore;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

/**
 * 将操作数栈的第一个数据 存放到 局部变量表的  第二个位置上（index 从 0 开始）
 */
public class ISTORE_1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _istore(frame, 1);
    }

}

