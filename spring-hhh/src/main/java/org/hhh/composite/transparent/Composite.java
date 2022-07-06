package org.hhh.composite.transparent;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {
    /**
     * 用来存储对象中包含的子构件对象
     */
    private List<Component> childComponents = new ArrayList<Component>();
    
    /**
     * 组合对象的名称
     */
    private String name;
    
    /**
     * 构造方法，传入组合对象的名称
     * @param name 组合对象的名称
     */
    public Composite(String name) {
        this.name = name;
    }

    /**
     * 聚集管理方法，增加一个子构件对象
     * @param child 子构件对象
     */
    @Override
    public void addChild(Component child) {
        childComponents.add(child);
    }

    /**
     * 聚集管理方法，删除一个子构件对象
     * @param index 子构件对象的下标
     */
    @Override
    public void removeChild(int index) {
        childComponents.remove(index);
    }

    /**
     * 聚集管理方法，返回所有子构件对象
     * @return 返回所有子构件对象
     */
    @Override
    public List<Component> getChild() {
        return childComponents;
    }

    @Override
    public void printStruct(String preStr) {
        //首先输出自身
        System.out.println(preStr + '+' + this.name);
        
        //如果还包含有子组件，那么就输出这些子组件对象
        if (this.childComponents != null) {
            //添加前缀空格，表示向后缩进
            preStr += "  ";
            
            //循环递归输出每个子对象
            for (Component component : childComponents) {
                component.printStruct(preStr);
            }
        }
    }
}