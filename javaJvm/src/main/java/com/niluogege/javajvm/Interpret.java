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
        BytecodeReader reader = new BytecodeReader();

        while (true) {
            //获取线程栈顶 栈帧
            Frame frame = thread.currentFrame();
            //获取下一个指定
            int pc = frame.nextPc();
            //pc 记录到 Thread
            thread.setPc(pc);
            //重置reader
            reader.reset(frame.method().code, pc);
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

//            System.out.format("pc寄存器值 ：0x%x 对应的指令 %s => 当前Frame的局部变量表：%s 当前Frame的操作数栈：%s\n", opcode, inst.getClass().getSimpleName(), JSON.toJSONString(frame.localVars().getSlots()), JSON.toJSONString(frame.operandStack().getSlots()));
            logInstruction(frame, inst, opcode);

            if (thread.isStackEmpty()) {
                break;
            }
        }

    }

    private static void logInstruction(Frame frame, Instruction inst, byte opcode) {
        Method method = frame.method();
        String className = method.clazz().name;
        String methodName = method.name();
        String outStr = ("frame=" + frame + "  " + className + "." + methodName + "() \t") +
                "寄存器(指令)：" + byteToHexString(new byte[]{opcode}) + " -> " + inst.getClass().getSimpleName() + " => 局部变量表：" + JSON.toJSONString(frame.localVars().getSlots()) + " 操作数栈：" + JSON.toJSONString(frame.operandStack().getSlots());
        System.out.println(outStr);
    }

    private static String byteToHexString(byte[] codes) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        for (byte b : codes) {
            int value = b & 0xFF;
            String strHex = Integer.toHexString(value);
            if (strHex.length() < 2) {
                strHex = "0" + strHex;
            }
            sb.append(strHex);
        }
        return sb.toString();
    }
}
