package com.designpattern.decorator;

/**
 * @author wangjf
 * @date 2018/1/28 0028.
 */
public class DecoratorClient {

    public static void main(String[] args) {
        IPacketCreator pc = new PacketHTTPHeaderCreator(new PacketHTMLHeaderCreator(new PacketBodyCreator()));
        System.out.println(pc.handleContent());
    }

}
