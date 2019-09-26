package com.devglan.domain;

public class Event {
    String name;
    String serviceName;
    String className;
    boolean isEnabled;

    public Event(String name, String serviceName, String className, boolean isEnabled) {
        this.name = name;
        this.serviceName = serviceName;
        this.className = className;
        this.isEnabled = isEnabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        if (isEnabled != event.isEnabled) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (serviceName != null ? !serviceName.equals(event.serviceName) : event.serviceName != null) return false;
        return className != null ? className.equals(event.className) : event.className == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (serviceName != null ? serviceName.hashCode() : 0);
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (isEnabled ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", className='" + className + '\'' +
                ", isEnabled=" + isEnabled +
                '}';
    }
}
