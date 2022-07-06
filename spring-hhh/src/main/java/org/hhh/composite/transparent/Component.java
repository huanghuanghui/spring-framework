package org.hhh.composite.transparent;

import java.util.List;

public abstract class Component {
    /**
     * 打印组件自身的名称
     * @param preStr 前缀，用于实现缩进
     */
    public abstract void printStruct(String preStr);
    
    /**
     * 聚集管理方法，增加一个子构件对象
     * @param child 子构件对象
     */
    public void addChild(Component child) {
        /**
         * 缺省实现，抛出异常，因为树叶对象没有此功能
         * 或者子组件没有实现这个功能
         */
        throw new UnsupportedOperationException("对象不支持此功能");
    }
    
    /**
     * 聚集管理方法，删除一个子构件对象
     * @param index 子构件对象的下标
     */
    public void removeChild(int index) {
        /**
         * 缺省实现，抛出异常，因为树叶对象没有此功能
         * 或者子组件没有实现这个功能
         */
        throw new UnsupportedOperationException("对象不支持此功能");
    }
    
    /**
     * 聚集管理方法，返回所有子构件对象
     * @return 返回所有子构件对象
     */
    public List<Component> getChild() {
        /**
         * 缺省实现，抛出异常，因为树叶对象没有此功能
         * 或者子组件没有实现这个功能
         */
        throw new UnsupportedOperationException("对象不支持此功能");
    }
}