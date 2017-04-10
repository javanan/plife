package com.jlife.pattern.subjecobserver;

/**
 * Created by chen on 2017/3/9.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 主题抽象类（接口）
 */
public interface Subject {

    /**
     * 添加观察者
     * @param oberver
     */
    void addObserver(Oberver oberver);

    /**
     * 移除观察者
     * @param oberver
     */
    void removeObserver(Oberver oberver);

    /**
     * 发送消息
     * @param msg
     */
    void sendMessage(String msg);
}
