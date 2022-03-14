package com.niluogege.javajvm.instructions.base;

import com.niluogege.javajvm.rtda.Frame;

/**
 * 指令
 */
public interface Instruction {

    //获取操作数
    void fetchOperands(BytecodeReader reader);

    //执行
    void execute(Frame frame);

    //分支 ，如 if else ,for 循环等 都需要 切换分支
    //其实就是通过 offset 来移动 角标
    static void branch(Frame frame,int offset){
        int pc = frame.thread().getPc();
        int nextPc= pc + offset;
        frame.setNextPc(nextPc);
    }
}
