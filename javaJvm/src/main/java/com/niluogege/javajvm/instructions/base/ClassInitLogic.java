package com.niluogege.javajvm.instructions.base;

import com.niluogege.javajvm.rtda.Frame;
import com.niluogege.javajvm.rtda.Thread;
import com.niluogege.javajvm.rtda.heap.methodarea.Class;
import com.niluogege.javajvm.rtda.heap.methodarea.Method;

/**
 * 类初始化的逻辑
 */
public class ClassInitLogic {
    public static void initClass(Thread thread, Class clazz){
        clazz.startInit();
        //调用 clinit 方法初始化静态数据
        scheduleClinit(thread,clazz);
        //初始化父类
        initSuperClass(thread,clazz);
    }


    private static void scheduleClinit(Thread thread, Class clazz) {
        Method clinitMethod = clazz.getClinitMethod();
        if (null==clinitMethod)return;
        Frame newFrame = thread.newFrame(clinitMethod);
        thread.pushFrame(newFrame);

    }


    private static void initSuperClass(Thread thread, Class clazz) {
        if (clazz.isInterface())return;
        Class superClass = clazz.superClass;
        if (null!=superClass && !superClass.initStarted()){
            initClass(thread,superClass);
        }
    }
}
