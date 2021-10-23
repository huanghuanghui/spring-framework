package org.hhh.proxy.simple1;

import java.util.Random;

public class Leader implements IWork {

    @Override
    public void meeting() {
        System.out.println("领导早上要组织会议");
    }

    @Override
    public int evaluate(String name) {
        int score = new Random(System.currentTimeMillis()).nextInt(20) + 80;
        System.out.println(String.format("领导给%s的考评为%s分", name, score));
        return score;
    }
}