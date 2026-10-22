package ru.aston.homework.proxy;

import java.util.HashSet;

public class Firewall implements Connection {
    private CommonConnection realCon;
    private HashSet<String> blackList = new HashSet<>(); 

    public Firewall(CommonConnection realCon) {
	this.realCon = realCon;
    }
    
    @Override
    public String connect(String host) {
	if (blackList.contains(host) {
		return String.format("Firewall: connection blocked to \"%s\"", host);
	}

	return realCon.connect(host);
    }

    public void blockHost(String host) {
	blackList.add(host);
    }
}
