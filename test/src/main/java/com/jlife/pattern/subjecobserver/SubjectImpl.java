package com.jlife.pattern.subjecobserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen on 2017/3/9.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: 主题实现类
 */
public class SubjectImpl implements Subject {

    private List<Oberver> obervers = new ArrayList<Oberver>();

    @Override
    public void addObserver(Oberver oberver) {
        obervers.add(oberver);
    }

    @Override
    public void removeObserver(Oberver oberver) {
        obervers.remove(oberver);
    }

    @Override
    public void sendMessage(String msg) {
        if (obervers == null || obervers.size() == 0) {
            return;
        }
        for (Oberver oberver : obervers) {
            oberver.update(msg);
        }
    }
}
