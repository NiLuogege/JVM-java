# JVM-java

使用java实现jvm

# 参考

- [例子](https://github.com/fuzhengwei/itstack-demo-jvm)
- [Java虚拟机规范_SE8版.pdf - 提取码 utrp](链接: https://pan.baidu.com/s/1M5mG7tsvN5CEdqXxPPOCIg)
- [jvm规范（直接翻译成中文）](https://docs.oracle.com/javase/specs/jvms/se8/html/index.html)

# 步骤

- 加载class文件(从文件夹，jar包，zip等不同地方)
- 解析class文件

# 调试

### 启动参数

* -Xjre "D:\soft\jre-8-8u171-64\jre" E:
  \111work\code\code_me\myGitHub\JVM-java\javaJvm\target\test-classes\com\niluogege\javajvm\HelloWorld
* -Xjre "D:\soft\jre-8-8u171-64\jre" java.lang.String

# class 文件结构

### 参考

- [例子](https://github.com/fuzhengwei/itstack-demo-jvm)
- [Java虚拟机规范_SE8版.pdf - 提取码 utrp](链接: https://pan.baidu.com/s/1M5mG7tsvN5CEdqXxPPOCIg)
- [jvm规范（直接翻译成中文）](https://docs.oracle.com/javase/specs/jvms/se8/html/index.html)

### ClassFile（class 文件）

```
ClassFile {
    u4             magic;  //魔术 ,class 文件默认为  0xCAFEBABE
    u2             minor_version; //副版本号
    u2             major_version; //主版本号
    u2             constant_pool_count; //常量池计数器（常量池大小+1）
    cp_info        constant_pool[constant_pool_count-1]; //常量池 ,详见 cp_info
    u2             access_flags;
    u2             this_class;
    u2             super_class;
    u2             interfaces_count;
    u2             interfaces[interfaces_count];
    u2             fields_count;
    field_info     fields[fields_count];
    u2             methods_count;
    method_info    methods[methods_count];
    u2             attributes_count;
    attribute_info attributes[attributes_count];
}
```

其中 u1、u2、u4三种数据类型来表示；1字节、2字节、4字节，无符号整数。

* 在如下实现中，用增位方式表示无符号类型：
* u1、u2可以用int类型存储，因为int类型是4字节
* u4 需要用long类型存储，因为long类型是8字节

### cp_info（常量池）

Constant Type |    Value | 简介
-------|----|----
CONSTANT_Class    |7 | 表示类或接口，可通过 name_index 在常量池中找到 全类名
CONSTANT_Fieldref    |9 | 表示 成员属性, 其中的 class_index 表示该属性所在的类，name_and_type_index 表示 属性名和类型
CONSTANT_Methodref    |10 | 表示 成员方法, 其中的 class_index 表示该方法所在的类，name_and_type_index 表示 方法名和方法签名
CONSTANT_InterfaceMethodref|    11 | 同 CONSTANT_Methodref
CONSTANT_String    |8 | 表示一个字符串 ，可通过 string_index 在常量池中找到 对应的字面量
CONSTANT_Integer    |3  | 表示一个int 数 ，
CONSTANT_Float    |4 | 表示一个 float 数
CONSTANT_Long    |5 | 表示一个 long 数
CONSTANT_Double    |6 | 表示一个 double 数
CONSTANT_NameAndType    |12 | 表示 名字 和 类型的映射，用于 CONSTANT_Fieldref ，CONSTANT_Methodref ，CONSTANT_InterfaceMethodref 等
CONSTANT_Utf8    |1 | 表示字符常量， CONSTANT_String 类型最终都是 通过 CONSTANT_Utf8来找到具体的字符串
CONSTANT_MethodHandle    |15 | 表示方法句柄，reference_kind 表示方法句柄类型 （范围是0-9，详见 方法句柄类型），reference_index表示 常量池中的索引 ，具体的值可为 CONSTANT_Fieldref，CONSTANT_Methodref 等 ，视 referenceKind 而定
CONSTANT_MethodType    |16  | 表示方法描述符
CONSTANT_InvokeDynamic    |18 | 表示 invokedynamic 指令所用到的 引导方法

### reference_kind（方法句柄类型）