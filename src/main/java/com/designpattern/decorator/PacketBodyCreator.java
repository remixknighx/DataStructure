package com.designpattern.decorator;

/**
 * ConcreteComponent 返回数据包的核心数据
 *
 * @author wangjf
 * @date 2018/1/28 0028.
 */
public class PacketBodyCreator implements IPacketCreator{

    public String handleContent() {
        return "Content of Packet";
    }
}
