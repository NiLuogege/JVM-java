package com.niluogege.javajvm.instructions.stores.istore;


import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;

/**
 * 将 操作数栈的第一个数据 存到 局部变量表的 第三个位置(index 从0 开始)
 */
public class ISTORE_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _istore(frame, 2);
    }

}

