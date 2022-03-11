package com.niluogege.javajvm.instructions.stores.istore;

import com.niluogege.javajvm.instructions.base.InstructionNoOperands;
import com.niluogege.javajvm.rtda.Frame;
/**
 * 把操作数栈中的 0 下标的数 存到 本地变量表中
 */
public class ISTORE_0 extends InstructionNoOperands {
    @Override
    public void execute(Frame frame) {
        _istore(frame,0);
    }
}
