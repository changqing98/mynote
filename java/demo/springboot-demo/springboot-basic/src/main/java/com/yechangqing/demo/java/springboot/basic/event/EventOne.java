package com.yechangqing.demo.java.springboot.basic.event;

public class EventOne {
    private String name = "One";
    private String msg = "EventOne";

    @Override
    public String
    toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\"name\": \"");
        builder.append(name);
        builder.append("\",\"msg\": \"");
        builder.append(msg);
        builder.append("\"}");
        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
