package com.jlife.controller;

import java.util.UUID;

/**
 * Created by chenjianan on 2017/1/18-15:13.
 * <p>
 * Describe:
 */
public class UTest {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        String ui="";
        System.out.println(ui=uuid.toString().replace("-",""));
        System.out.println(ui);
        System.out.println(ui.length());
    }
}
