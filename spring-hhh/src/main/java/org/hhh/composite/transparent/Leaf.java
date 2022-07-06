package org.hhh.composite.transparent;

public class Leaf extends Component {
    /**
     * 组合对象的名称
     */
    private String name;
    
    /**
     * 构造方法，传入组合对象的名称
     * @param name 组合对象的名称
     */
    public Leaf(String name) {
        this.name = name;
    }

    /**
     * 输出叶子对象，因为叶子对象没有字对象，也就是输出叶子对象的名称。
     * @param preStr 前缀，主要是按照层级进行拼接的空格，用于实现向后缩进
     */
    @Override
    public void printStruct(String preStr) {
        System.out.println(preStr + "-" + name);
    }
}