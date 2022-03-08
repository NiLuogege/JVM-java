package com.niluogege.javajvm.rtda;

/**
 * 局部变量表：里面要有 数据（Slot）
 */
public class LocalVars {
    private Slot[] slots;

    public LocalVars(int maxLocal) {
        if (maxLocal > 0) {
            slots = new Slot[maxLocal];
            for (int i = 0; i < maxLocal; i++) {
                slots[i] = new Slot();
            }
        }
    }

    //数据槽记录int 值
    public void setInt(int idx, int val) {
        slots[idx].num = val;
    }

    public int getInt(int idx) {
        return slots[idx].num;
    }


    public void setFloat(int idx, float val) {
        this.slots[idx].num = (Float.valueOf(val)).intValue();
    }

    public Float getFloat(int idx) {
        int num = this.slots[idx].num;
        return (float) num;
    }

    //long 数据 用两个int值来存
    public void setLong(int idx, long val) {
        slots[idx].num = (int) val;
        slots[idx + 1].num = (int) (val >> 32);
    }

    public Long getLong(int idx) {
        int low = slots[idx].num;
        int high = slots[idx + 1].num;
        return ((long) high << 32) | (long) low;
    }

    public void setDouble(int idx, double val) {
        setLong(idx, (long) val);
    }

    public Double getDouble(int idx) {
        return Double.valueOf(getLong(idx));
    }

    public void setRef(int idx, Object ref) {
        slots[idx].ref = ref;
    }

    public Object getRef(int idx) {
        return slots[idx].ref;
    }

    public Slot[] getSlots() {
        return slots;
    }

}
