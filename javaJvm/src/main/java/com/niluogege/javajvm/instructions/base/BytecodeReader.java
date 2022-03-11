package com.niluogege.javajvm.instructions.base;

/**
 * 字节读取器
 */
public class BytecodeReader {

    private byte[] codes;
    protected int pc;

    public void reset(byte[] codes,int pc){
        this.codes=codes;
        this.pc=pc;
    }

    public int getPc() {
        return pc;
    }

    //读取操作指令  就是 pc寄存器 位置上的值，然后对 pc 寄存器进行+1
    public byte readByte(){
        byte code = codes[pc];
        pc++;
        return code;
    }

    //[go]int16 = [java]short
    public short readShort() {
        byte byte1 = readByte();
        byte byte2 = readByte();
        return (short) ((byte1 << 8) | byte2);
    }

    public int readInt() {
        int byte1 = this.readByte();
        int byte2 = this.readByte();
        int byte3 = this.readByte();
        int byte4 = this.readByte();
        return (byte1 << 24) | (byte2 << 16) | (byte3 << 8) | byte4;
    }

    //used by lookupswitch and tableswitch
    public int[] readInts(int n) {
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = this.readInt();
        }
        return ints;
    }

    //used by lookupswitch and tableswitcch
    public void skipPadding() {
        while (this.pc % 4 != 0) {
            this.readByte();
        }
    }
}
