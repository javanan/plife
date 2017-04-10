package com.jlife.bootest;

import java.lang.annotation.*;

/**
 * Created by chen on 2017/3/28.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
@Documented //@Documented的目的就是让这一个Annotation类型的信息能够显示在javaAPI说明文档上;没有添加的话，使用javadoc生成API文档的时候就会找不到这一个类型生成的信息.
@Target(ElementType.METHOD)//作用：用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnoLog {
    //@interface是一个关键字，在设计annotations的时候必须把一 个类型定义为@interface，而不能用class或interface关键字

    /*
     etention(保留)注解说明,这种类型的注解会被保留到那个阶段. 有三个值:
     1.RetentionPolicy.SOURCE —— 这种类型的Annotations只在源代码级别保留,编译时就会被忽略
     2.RetentionPolicy.CLASS —— 这种类型的Annotations编译时被保留,在class文件中存在,但JVM将会忽略
     3.RetentionPolicy.RUNTIME —— 这种类型的Annotations将被JVM保留,所以他们能在运行时被JVM或其他使用反射机制的代码所读取和使用.
*/
    String after();
}
