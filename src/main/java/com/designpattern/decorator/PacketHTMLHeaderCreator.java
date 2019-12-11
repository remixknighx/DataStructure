package com.designpattern.decorator;

/**
 * @author wangjf
 * @date 2018/1/28 0028.
 */
public class PacketHTMLHeaderCreator extends PacketDecorator {

    public PacketHTMLHeaderCreator(IPacketCreator component) {
        super(component);
    }

    @Override
    public String handleContent() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append(component.handleContent());
        sb.append("</html>\n");
        return sb.toString();
    }
}
