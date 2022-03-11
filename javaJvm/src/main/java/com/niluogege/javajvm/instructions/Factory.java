package com.niluogege.javajvm.instructions;

import com.niluogege.javajvm.instructions.base.Instruction;
import com.niluogege.javajvm.instructions.constants.consts.*;
import com.niluogege.javajvm.instructions.constants.nop.NOP;
import com.sun.org.apache.bcel.internal.generic.BIPUSH;
import com.sun.org.apache.bcel.internal.generic.SIPUSH;

/**
 * 指令工厂
 */
public class Factory {

    public static Instruction newInstruction(byte opcode) {

        switch (opcode){
            case 0x00:
                return new NOP();
            case 0x01:
                return new ACONST_NULL();
            case 0x02:
                return new ICONST_M1();
            case 0x03:
                return new ICONST_0();
            case 0x04:
                return new ICONST_1();
            case 0x05: //操作数栈 入栈一个 2
                return new ICONST_2();
            case 0x06: //操作数栈 入栈一个 3
                return new ICONST_3();
            case 0x07:
                return new ICONST_4();
            case 0x08: //操作数栈 入栈一个 5
                return new ICONST_5();
            case 0x09:
                return new LCONST_0();
            case 0x0a:
                return new LCONST_1();
            case 0x0b:
                return new FCONST_0();
            case 0x0c:
                return new FCONST_1();
            case 0x0d:
                return new FCONST_2();
            case 0x0e:
                return new DCONST_0();
            case 0x0f:
                return new DCONST_1();
            case 0x10:
//                return new BIPUSH();
            case 0x11:
//                return new SIPUSH();
            default:
                return null;
        }
    }
}
