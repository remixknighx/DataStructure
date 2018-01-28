package com.designpattern.decorator;

/**
 * Decorator 维护核心组件component对象
 * 负责告知其子类，其核心业务逻辑应该全权委托component完成
 *
 * @author wangjf
 * @date 2018/1/28 0028.
 */
public abstract class PacketDecorator implements IPacketCreator{

    IPacketCreator component;

    public PacketDecorator(IPacketCreator component){
        this.component = component;
    }

}
