package com.jlife.pattern.subjecobserver;

/**
 * Created by chen on 2017/3/9.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
public class OberverImpl implements Oberver {

    private String name;

    public OberverImpl(String name,Subject subject) {

        this(subject);

        this.name = name;


    }

    public OberverImpl(Subject subject) {
        super();
        subject.addObserver(this);
    }

    public OberverImpl(String name) {
        super();
        this.name = name;
    }

    @Override
    public void update(Object msg) {
        System.out.println(this.name + "============" + msg);
    }
}
