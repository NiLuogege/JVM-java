package com.niluogege.javajvm.instructions;

import com.niluogege.javajvm.instructions.base.Instruction;
import com.niluogege.javajvm.instructions.constants.consts.*;
import com.niluogege.javajvm.instructions.constants.ipush.BIPUSH;
import com.niluogege.javajvm.instructions.constants.ipush.SIPUSH;
import com.niluogege.javajvm.instructions.constants.nop.NOP;
import com.niluogege.javajvm.instructions.loads.aload.*;
import com.niluogege.javajvm.instructions.loads.dload.*;
import com.niluogege.javajvm.instructions.loads.fload.*;
import com.niluogege.javajvm.instructions.loads.iload.*;
import com.niluogege.javajvm.instructions.loads.lload.*;
import com.niluogege.javajvm.instructions.stores.astore.*;
import com.niluogege.javajvm.instructions.stores.dstore.*;
import com.niluogege.javajvm.instructions.stores.fstore.*;
import com.niluogege.javajvm.instructions.stores.istore.*;
import com.niluogege.javajvm.instructions.stores.lstore.*;

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
                return new BIPUSH();
            case 0x11:
                return new SIPUSH();
            // case 0x12:
            // 	return &LDC{}
            // case 0x13:
            // 	return &LDC_W{}
            // case 0x14:
            // 	return &LDC2_W{}
            case 0x15:
                return new ILOAD();
            case 0x16:
                return new LLOAD();
            case 0x17:
                return new FLOAD();
            case 0x18:
                return new DLOAD();
            case 0x19:
                return new ALOAD();
            case 0x1a:
                return new ILOAD_0();
            case 0x1b: //第2个局部变量表的数据 推送到操作数栈的栈顶
                return new ILOAD_1();
            case 0x1c://第三个局部变量表的数据 推送到操作数栈的栈顶
                return new ILOAD_2();
            case 0x1d:
                return new ILOAD_3();
            case 0x1e:
                return new LLOAD_0();
            case 0x1f:
                return new LLOAD_1();
            case 0x20:
                return new LLOAD_2();
            case 0x21:
                return new LLOAD_3();
            case 0x22:
                return new FLOAD_0();
            case 0x23:
                return new FLOAD_1();
            case 0x24:
                return new FLOAD_2();
            case 0x25:
                return new FLOAD_3();
            case 0x26:
                return new DLOAD_0();
            case 0x27:
                return new DLOAD_1();
            case 0x28:
                return new DLOAD_2();
            case 0x29:
                return new DLOAD_3();
            case 0x2a:
                return new ALOAD_0();
            case 0x2b:
                return new ALOAD_1();
            case 0x2c:
                return new ALOAD_2();
            case 0x2d:
                return new ALOAD_3();
            // case 0x2e:
            // 	return iaload
            // case 0x2f:
            // 	return laload
            // case 0x30:
            // 	return faload
            // case 0x31:
            // 	return daload
            // case 0x32:
            // 	return aaload
            // case 0x33:
            // 	return baload
            // case 0x34:
            // 	return caload
            // case 0x35:
            // 	return saload
            case 0x36:
                return new ISTORE();
            case 0x37:
                return new LSTORE();
            case 0x38:
                return new FSTORE();
            case 0x39:
                return new DSTORE();
            case 0x3a:
                return new ASTORE();
            case 0x3b:
                return new ISTORE_0();
            case 0x3c: //将操作数栈的第一个数据 存放到 局部变量表的  第二个位置上（index 从 0 开始）
                return new ISTORE_1();
            case 0x3d: //将 操作数栈的第一个数据 存到 局部变量表的 第三个位置(index 从0 开始)
                return new ISTORE_2();
            case 0x3e:
                return new ISTORE_3();
            case 0x3f:
                return new LSTORE_0();
            case 0x40:
                return new LSTORE_1();
            case 0x41:
                return new LSTORE_2();
            case 0x42:
                return new LSTORE_3();
            case 0x43:
                return new FSTORE_0();
            case 0x44:
                return new FSTORE_1();
            case 0x45:
                return new FSTORE_2();
            case 0x46:
                return new FSTORE_3();
            case 0x47:
                return new DSTORE_0();
            case 0x48:
                return new DSTORE_1();
            case 0x49:
                return new DSTORE_2();
            case 0x4a:
                return new DSTORE_3();
            case 0x4b:
                return new ASTORE_0();
            case 0x4c:
                return new ASTORE_1();
            case 0x4d:
                return new ASTORE_2();
            case 0x4e:
                return new ASTORE_3();
            //case 0x4f:
            //	return new IASTORE();
            // case 0x50:
            // 	return lastore
            // case 0x51:
            // 	return fastore
            // case 0x52:
            // 	return dastore
            // case 0x53:
            // 	return aastore
            // case 0x54:
            // 	return bastore
            // case 0x55:
            // 	return castore
            // case 0x56:
            // 	return sastore
            default:
                return null;
        }
    }
}
