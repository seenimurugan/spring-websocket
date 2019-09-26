package com.devglan.domain;

public class MessageWrapper {

    private String type;
    private Object EVENT;

    public MessageWrapper() {
    }

    public MessageWrapper(String type, Object event) {
        this.type = type;
        this.EVENT = event;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getMessage() {
        return EVENT;
    }

    public void setMessage(Object message) {
        this.EVENT = message;
    }
}
