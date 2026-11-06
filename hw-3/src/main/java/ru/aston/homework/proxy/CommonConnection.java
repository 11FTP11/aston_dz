package ru.aston.homework.proxy;

public class CommonConnection implements Connection {
    public String name;

    public CommonConnection(String name) {
	this.name = name;
    }
    
    @Override 
    public String connect(String host) {
	return String.format("\"%s\": connection established to \"%s\"", this.name, host); 
    }
}
