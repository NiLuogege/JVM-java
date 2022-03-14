package com.niluogege.javajvm.instructions.math.iinc;


import com.niluogege.javajvm.instructions.base.BytecodeReader;
import com.niluogege.javajvm.instructions.base.Instruction;
import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.LocalVars;

//int 增加指定量 如 （i++,i--,i+=2 等）
public class IINC implements Instruction {

    public int idx;
    public int constVal;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.idx = reader.readByte();
        this.constVal = reader.readByte();

//        System.out.println("IINC idx="+idx+" constVal="+constVal);
    }

    /**
     * 局部变量表 idx 位置上的数 加上 constVal 再设置回去
     * @param frame
     */
    @Override
    public void execute(Frame frame) {
        LocalVars vars = frame.localVars();
        int val = vars.getInt(this.idx);
        val += this.constVal;
        vars.setInt(this.idx, val);
    }
}
