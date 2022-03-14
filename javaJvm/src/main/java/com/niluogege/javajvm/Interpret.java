package com.niluogege.javajvm;

import com.alibaba.fastjson.JSON;
import com.niluogege.javajvm.instructions.Factory;
import com.niluogege.javajvm.instructions.base.BytecodeReader;
import com.niluogege.javajvm.instructions.base.Instruction;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.Thread;
import com.niluogege.javajvm.rtda.heap.methodarea.Method;

/**
 * 解析器
 */
public class Interpret {

    public Interpret(Method method) {
        Thread thread = new Thread();
        Frame frame = thread.newFrame(method);
        thread.pushFrame(frame);
        loop(thread, method.code);
    }

    private void loop(Thread thread, byte[] byteCode) {
        //一个方法一个frame,同一个方法里的frame是共享的
        Frame frame = thread.popFrame();

        BytecodeReader reader = new BytecodeReader();

        while (true) {
            //获取下一个指定
            int pc = frame.nextPc();
            //pc 记录到 Thread
            thread.setPc(pc);
            //重置reader
            reader.reset(byteCode, pc);
            //读取操作指令代码
            byte opcode = reader.readByte();
            //将 指令代码 转换为 真正的指令
            Instruction inst = Factory.newInstruction(opcode);
            if (null == inst) {
                System.out.format("Unsupported opcode：0x%x\n", opcode);
                break;
            }

            //获取操作数
            inst.fetchOperands(reader);

            //设置下一个pc寄存器
            frame.setNextPc(reader.getPc());

            //执行
            inst.execute(frame);

            System.out.format("pc寄存器值 ：0x%x 对应的指令 %s => 当前Frame的局部变量表：%s 当前Frame的操作数栈：%s\n", opcode, inst.getClass().getSimpleName(), JSON.toJSONString(frame.localVars().getSlots()), JSON.toJSONString(frame.operandStack().getSlots()));
        }

    }
}
