package com.jlife.threads;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by chen on 2017/3/14.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
public class AtomicParm {
    private final AtomicLong atomicLong=new AtomicLong(1);

    public long getCount(){
        return atomicLong.get();
    }

    public void incrementAndGet(){
        atomicLong.incrementAndGet();
    }
}
