package com.niluogege.javajvm.instructions;

import com.niluogege.javajvm.instructions.base.Instruction;
import com.niluogege.javajvm.instructions.comparisons.dcmp.DCMPG;
import com.niluogege.javajvm.instructions.comparisons.dcmp.DCMPL;
import com.niluogege.javajvm.instructions.comparisons.fcmp.FCMPG;
import com.niluogege.javajvm.instructions.comparisons.fcmp.FCMPL;
import com.niluogege.javajvm.instructions.comparisons.if_acmp.IF_ACMPEQ;
import com.niluogege.javajvm.instructions.comparisons.if_acmp.IF_ACMPNE;
import com.niluogege.javajvm.instructions.comparisons.if_icmp.*;
import com.niluogege.javajvm.instructions.comparisons.if_icmp.IF_ICMPEQ;
import com.niluogege.javajvm.instructions.comparisons.if_icmp.IF_ICMPGE;
import com.niluogege.javajvm.instructions.comparisons.if_icmp.IF_ICMPGT;
import com.niluogege.javajvm.instructions.comparisons.if_icmp.IF_ICMPLE;
import com.niluogege.javajvm.instructions.comparisons.if_icmp.IF_ICMPLT;
import com.niluogege.javajvm.instructions.comparisons.if_icmp.IF_ICMPNE;
import com.niluogege.javajvm.instructions.comparisons.ifcond.*;
import com.niluogege.javajvm.instructions.comparisons.ifcond.IFEQ;
import com.niluogege.javajvm.instructions.comparisons.ifcond.IFGE;
import com.niluogege.javajvm.instructions.comparisons.ifcond.IFGT;
import com.niluogege.javajvm.instructions.comparisons.ifcond.IFLE;
import com.niluogege.javajvm.instructions.comparisons.ifcond.IFLT;
import com.niluogege.javajvm.instructions.comparisons.ifcond.IFNE;
import com.niluogege.javajvm.instructions.comparisons.lcmp.LCMP;
import com.niluogege.javajvm.instructions.constants.consts.*;
import com.niluogege.javajvm.instructions.constants.consts.ACONST_NULL;
import com.niluogege.javajvm.instructions.constants.ipush.BIPUSH;
import com.niluogege.javajvm.instructions.constants.ipush.SIPUSH;
import com.niluogege.javajvm.instructions.constants.lbc.LDC2_W;
import com.niluogege.javajvm.instructions.constants.nop.NOP;
import com.niluogege.javajvm.instructions.control.GOTO;
import com.niluogege.javajvm.instructions.control.LOOKUP_SWITCH;
import com.niluogege.javajvm.instructions.control.TABLE_SWITCH;
import com.niluogege.javajvm.instructions.control.rtn.*;
import com.niluogege.javajvm.instructions.conversions.d2x.D2F;
import com.niluogege.javajvm.instructions.conversions.d2x.D2I;
import com.niluogege.javajvm.instructions.conversions.d2x.D2L;
import com.niluogege.javajvm.instructions.conversions.f2x.F2D;
import com.niluogege.javajvm.instructions.conversions.f2x.F2I;
import com.niluogege.javajvm.instructions.conversions.f2x.F2L;
import com.niluogege.javajvm.instructions.conversions.i2x.*;
import com.niluogege.javajvm.instructions.conversions.i2x.I2B;
import com.niluogege.javajvm.instructions.conversions.i2x.I2C;
import com.niluogege.javajvm.instructions.conversions.i2x.I2D;
import com.niluogege.javajvm.instructions.conversions.i2x.I2F;
import com.niluogege.javajvm.instructions.conversions.i2x.I2L;
import com.niluogege.javajvm.instructions.conversions.i2x.I2S;
import com.niluogege.javajvm.instructions.conversions.l2x.L2D;
import com.niluogege.javajvm.instructions.conversions.l2x.L2F;
import com.niluogege.javajvm.instructions.conversions.l2x.L2I;
import com.niluogege.javajvm.instructions.extended.GOTO_W;
import com.niluogege.javajvm.instructions.extended.WIDE;
import com.niluogege.javajvm.instructions.extended.ifnull.IFNONNULL;
import com.niluogege.javajvm.instructions.extended.ifnull.IFNULL;
import com.niluogege.javajvm.instructions.loads.aload.*;
import com.niluogege.javajvm.instructions.loads.aload.ALOAD;
import com.niluogege.javajvm.instructions.loads.dload.*;
import com.niluogege.javajvm.instructions.loads.dload.DLOAD;
import com.niluogege.javajvm.instructions.loads.fload.*;
import com.niluogege.javajvm.instructions.loads.fload.FLOAD;
import com.niluogege.javajvm.instructions.loads.iload.*;
import com.niluogege.javajvm.instructions.loads.iload.ILOAD;
import com.niluogege.javajvm.instructions.loads.lload.*;
import com.niluogege.javajvm.instructions.loads.lload.LLOAD;
import com.niluogege.javajvm.instructions.references.*;
import com.niluogege.javajvm.instructions.stack.dup.DUP;
import com.niluogege.javajvm.instructions.stack.dup.DUP2;
import com.niluogege.javajvm.instructions.stack.dup.DUP2_X1;
import com.niluogege.javajvm.instructions.stack.dup.DUP2_X2;
import com.niluogege.javajvm.instructions.stack.dup.DUP_X1;
import com.niluogege.javajvm.instructions.stack.dup.DUP_X2;
import com.niluogege.javajvm.instructions.math.add.DADD;
import com.niluogege.javajvm.instructions.math.add.FADD;
import com.niluogege.javajvm.instructions.math.add.IADD;
import com.niluogege.javajvm.instructions.math.add.LADD;
import com.niluogege.javajvm.instructions.math.and.IAND;
import com.niluogege.javajvm.instructions.math.and.LAND;
import com.niluogege.javajvm.instructions.math.div.DDIV;
import com.niluogege.javajvm.instructions.math.div.FDIV;
import com.niluogege.javajvm.instructions.math.div.IDIV;
import com.niluogege.javajvm.instructions.math.div.LDIV;
import com.niluogege.javajvm.instructions.math.iinc.IINC;
import com.niluogege.javajvm.instructions.math.mul.DMUL;
import com.niluogege.javajvm.instructions.math.mul.FMUL;
import com.niluogege.javajvm.instructions.math.mul.IMUL;
import com.niluogege.javajvm.instructions.math.mul.LMUL;
import com.niluogege.javajvm.instructions.math.neg.DNEG;
import com.niluogege.javajvm.instructions.math.neg.FNEG;
import com.niluogege.javajvm.instructions.math.neg.INEG;
import com.niluogege.javajvm.instructions.math.neg.LNEG;
import com.niluogege.javajvm.instructions.math.or.IOR;
import com.niluogege.javajvm.instructions.math.or.LOR;
import com.niluogege.javajvm.instructions.math.rem.DREM;
import com.niluogege.javajvm.instructions.math.rem.FREM;
import com.niluogege.javajvm.instructions.math.rem.IREM;
import com.niluogege.javajvm.instructions.math.rem.LREM;
import com.niluogege.javajvm.instructions.math.sh.ISHL;
import com.niluogege.javajvm.instructions.math.sh.ISHR;
import com.niluogege.javajvm.instructions.math.sh.IUSHR;
import com.niluogege.javajvm.instructions.math.sh.LSHL;
import com.niluogege.javajvm.instructions.math.sh.LSHR;
import com.niluogege.javajvm.instructions.math.sh.LUSHR;
import com.niluogege.javajvm.instructions.math.sub.DSUB;
import com.niluogege.javajvm.instructions.math.sub.FSUB;
import com.niluogege.javajvm.instructions.math.sub.ISUB;
import com.niluogege.javajvm.instructions.math.sub.LSUB;
import com.niluogege.javajvm.instructions.math.xor.IXOR;
import com.niluogege.javajvm.instructions.math.xor.LXOR;
import com.niluogege.javajvm.instructions.stack.pop.POP;
import com.niluogege.javajvm.instructions.stack.pop.POP2;
import com.niluogege.javajvm.instructions.stack.swap.SWAP;
import com.niluogege.javajvm.instructions.stores.astore.*;
import com.niluogege.javajvm.instructions.stores.astore.ASTORE;
import com.niluogege.javajvm.instructions.stores.dstore.*;
import com.niluogege.javajvm.instructions.stores.dstore.DSTORE;
import com.niluogege.javajvm.instructions.stores.fstore.*;
import com.niluogege.javajvm.instructions.stores.fstore.FSTORE;
import com.niluogege.javajvm.instructions.stores.istore.*;
import com.niluogege.javajvm.instructions.stores.istore.ISTORE;
import com.niluogege.javajvm.instructions.stores.lstore.*;
import com.niluogege.javajvm.instructions.stores.lstore.LSTORE;


/**
 * ????????????
 */
public class Factory {

    public static Instruction newInstruction(byte opcode) {

        switch (opcode) {
            case 0x00:
                return new NOP();
            case 0x01://???null????????????
                return new ACONST_NULL();
            case 0x02:
                return new ICONST_M1();
            case 0x03: //???????????? ???????????? 0
                return new ICONST_0();
            case 0x04: //???????????? ???????????? 1
                return new ICONST_1();
            case 0x05: //???????????? ???????????? 2
                return new ICONST_2();
            case 0x06: //???????????? ???????????? 3
                return new ICONST_3();
            case 0x07: //???????????? ???????????? 4
                return new ICONST_4();
            case 0x08: //???????????? ???????????? 5
                return new ICONST_5();
            case 0x09:
                return new LCONST_0();
            case 0x0a://???long??????1 ???????????????
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
            case 0x10: //???????????????????????????
                return new BIPUSH();
            case 0x11:
                return new SIPUSH();
            // case 0x12:
            // 	return &LDC{}
            // case 0x13:
            // 	return &LDC_W{}
            case 0x14: //???long ??? double ???????????? ??????????????????????????????
                return new LDC2_W();
            case 0x15: //????????? int ?????? ????????????
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
            case 0x1b: //???2??????????????????????????? ??????????????????????????????
                return new ILOAD_1();
            case 0x1c://????????????????????????????????? ??????????????????????????????
                return new ILOAD_2();
            case 0x1d:
                return new ILOAD_3();
            case 0x1e://????????????????????????????????? long ???????????? ??? ??????????????????
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
            case 0x2a://??????1??????????????????????????????????????????
                return new ALOAD_0();
            case 0x2b://???????????????????????????????????????????????????
                return new ALOAD_1();
            case 0x2c:
                return new ALOAD_2();
            case 0x2d:
                return new ALOAD_3();
            // case 0x2e: //???int?????????????????????????????????
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
            case 0x36: //?????????????????????idx?????????????????? ?????? ??????????????????
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
            case 0x3c: //????????????????????????????????? ????????? ??????????????????  ?????????????????????index ??? 0 ?????????
                return new ISTORE_1();
            case 0x3d: //??? ?????????????????????????????? ?????? ?????????????????? ???????????????(index ???0 ??????)
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
            //case 0x4f://?????????int???????????????????????????????????????????????????
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
            case 0x57:
                return new POP();
            case 0x58:
                return new POP2();
            case 0x59://????????????????????????????????????????????????
                return new DUP();
            case 0x5a:
                return new DUP_X1();
            case 0x5b:
                return new DUP_X2();
            case 0x5c:
                return new DUP2();
            case 0x5d:
                return new DUP2_X1();
            case 0x5e:
                return new DUP2_X2();
            case 0x5f:
                return new SWAP();
            case 0x60: //?????????????????????????????? ???????????????????????????
                return new IADD();
            case 0x61:
                return new LADD();
            case 0x62:
                return new FADD();
            case 0x63:
                return new DADD();
            case 0x64: //???????????????????????????????????????
                return new ISUB();
            case 0x65://???????????????long?????????????????????????????????
                return new LSUB();
            case 0x66:
                return new FSUB();
            case 0x67:
                return new DSUB();
            case 0x68:
                return new IMUL();
            case 0x69:
                return new LMUL();
            case 0x6a:
                return new FMUL();
            case 0x6b:
                return new DMUL();
            case 0x6c:
                return new IDIV();
            case 0x6d:
                return new LDIV();
            case 0x6e:
                return new FDIV();
            case 0x6f:
                return new DDIV();
            case 0x70:
                return new IREM();
            case 0x71:
                return new LREM();
            case 0x72:
                return new FREM();
            case 0x73:
                return new DREM();
            case 0x74:
                return new INEG();
            case 0x75:
                return new LNEG();
            case 0x76:
                return new FNEG();
            case 0x77:
                return new DNEG();
            case 0x78:
                return new ISHL();
            case 0x79:
                return new LSHL();
            case 0x7a:
                return new ISHR();
            case 0x7b:
                return new LSHR();
            case 0x7c:
                return new IUSHR();
            case 0x7d:
                return new LUSHR();
            case 0x7e:
                return new IAND();
            case 0x7f:
                return new LAND();
            case (byte) 0x80:
                return new IOR();
            case (byte) 0x81:
                return new LOR();
            case (byte) 0x82:
                return new IXOR();
            case (byte) 0x83:
                return new LXOR();
            case (byte) 0x84: //int ??????????????? ??? ???i++,i--,i+=2 ??????
                return new IINC();
            case (byte) 0x85:
                return new I2L();
            case (byte) 0x86:
                return new I2F();
            case (byte) 0x87:
                return new I2D();
            case (byte) 0x88:
                return new L2I();
            case (byte) 0x89:
                return new L2F();
            case (byte) 0x8a:
                return new L2D();
            case (byte) 0x8b:
                return new F2I();
            case (byte) 0x8c:
                return new F2L();
            case (byte) 0x8d:
                return new F2D();
            case (byte) 0x8e:
                return new D2I();
            case (byte) 0x8f:
                return new D2L();
            case (byte) 0x90:
                return new D2F();
            case (byte) 0x91:
                return new I2B();
            case (byte) 0x92:
                return new I2C();
            case (byte) 0x93:
                return new I2S();
            case (byte) 0x94://????????????long???????????????????????????????????????1,0???-1???????????????
                return new LCMP();
            case (byte) 0x95:
                return new FCMPL();
            case (byte) 0x96:
                return new FCMPG();
            case (byte) 0x97:
                return new DCMPL();
            case (byte) 0x98:
                return new DCMPG();
            case (byte) 0x99://?????????int?????? ?????? 0 ??? ??????
                return new IFEQ();
            case (byte) 0x9a:
                return new IFNE();
            case (byte) 0x9b:
                return new IFLT();
            case (byte) 0x9c:
                return new IFGE();
            case (byte) 0x9d://?????????int????????????0?????????
                return new IFGT();
            case (byte) 0x9e:
                return new IFLE();
            case (byte) 0x9f:
                return new IF_ICMPEQ();
            case (byte) 0xa0:
                return new IF_ICMPNE();
            case (byte) 0xa1:
                return new IF_ICMPLT();
            case (byte) 0xa2://?????????????????? int ????????????????????????????????????????????????
                return new IF_ICMPGE();
            case (byte) 0xa3: //?????????????????? int ??????????????????????????????????????????
                return new IF_ICMPGT();
            case (byte) 0xa4:
                return new IF_ICMPLE();
            case (byte) 0xa5:
                return new IF_ACMPEQ();
            case (byte) 0xa6:
                return new IF_ACMPNE();
            case (byte) 0xa7: //??????????????? ???????????????offset = 0???
                return new GOTO();
            // case 0xa8:
            // 	return &JSR{}
            // case 0xa9:
            // 	return &RET{}
            case (byte) 0xaa:
                return new TABLE_SWITCH();
            case (byte) 0xab:
                return new LOOKUP_SWITCH();
            case (byte) 0xac:
                return new IRETURN();
            case (byte) 0xad://?????????????????????long
                return new LRETURN();
            case (byte) 0xae:
                return new FRETURN();
            case (byte) 0xaf:
                return new DRETURN();
            case (byte) 0xb0:
                return new ARETURN();
            case (byte) 0xb1:
                return new RETURN();
            case (byte) 0xb2: //??????????????????????????????????????????????????????
                return new GET_STATIC();
            case (byte) 0xb3:
                return new PUT_STATIC();
            case (byte) 0xb4:
                return new GET_FIELD();
            case (byte) 0xb5:
                return new PUT_FIELD();
            case (byte) 0xb6://?????? ????????????
                return new INVOKE_VIRTUAL();
            case (byte) 0xb7:
                return new INVOKE_SPECIAL();
            case (byte) 0xb8://invokestatic??????static??????
                return new INVOKE_STATIC();
            // case 0xb9:
            // 	return &INVOKE_INTERFACE{}
            // case 0xba:
            // 	return &INVOKE_DYNAMIC{}
            case (byte) 0xbb:
                return new NEW();
            // case 0xbc: //????????????
            // 	return &NEW_ARRAY{}
            // case 0xbd:
            // 	return &ANEW_ARRAY{}
            // case 0xbe: //?????????????????????????????????
            // 	return ARRAY_LENGTH
            // case 0xbf:
            // 	return athrow
            case (byte) 0xc0:
                return new CHECK_CAST();
            case (byte) 0xc1:
                return new INSTANCE_OF();
            // case 0xc2:
            // 	return monitorenter
            // case 0xc3:
            // 	return monitorexit
            case (byte) 0xc4:
                return new WIDE();
            // case 0xc5:
            // 	return &MULTI_ANEW_ARRAY{}
            case (byte) 0xc6:
                return new IFNULL();
            case (byte) 0xc7:
                return new IFNONNULL();
            case (byte) 0xc8:
                return new GOTO_W();
            // case 0xc9:
            // 	return &JSR_W{}
            // case 0xca: breakpoint
            // case 0xfe: impdep1
            // case 0xff: impdep2
            default:
                return null;
        }
    }
}
