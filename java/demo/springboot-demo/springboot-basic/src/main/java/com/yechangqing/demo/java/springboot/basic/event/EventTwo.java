package com.yechangqing.demo.java.springboot.basic.event;

public class EventTwo {
    private String name = "Two";
    private String msg = "EventTwo";

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
