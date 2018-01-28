package com.designpattern.decorator;

/**
 * @author wangjf
 * @date 2018/1/28 0028.
 */
public class PacketHTTPHeaderCreator extends PacketDecorator {

    public PacketHTTPHeaderCreator(IPacketCreator component) {
        super(component);
    }

    public String handleContent() {
        StringBuffer sb = new StringBuffer();
        sb.append("cache-control:no-cache\n");
        sb.append("Date:Mon,31Dec");
        sb.append(component.handleContent());
        return sb.toString();
    }
}
