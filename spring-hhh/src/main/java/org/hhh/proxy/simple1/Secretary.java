package org.hhh.proxy.simple1;

public class Secretary implements IWork {
    private Leader mLeader;

    /**
     * 将真实的需要被代理的类隐藏
     * @param mLeader
     */
    public Secretary(Leader mLeader) {
        this.mLeader = mLeader;
    }

    @Override
    public void meeting() {
        System.out.println("秘书先给老板准备材料");
        mLeader.meeting();
    }

    @Override
    public int evaluate(String name) {
        return mLeader.evaluate(name);
    }
}