package ru.aston.homework.proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        System.out.println("------------------------");

        Firewall firewall = new Firewall(
	   new CommonConnection("MainConnection")
	);
	
	System.out.println("Firewall initialized");
	String target = "badsite.com";
        String res1 = firewall.connect(target);
        System.out.println("Request 1: " + res1);

        System.out.printf("blocking host \"%s\" ...\n", target);
        firewall.blockHost(target); 
	
        String res2 = firewall.connect(target);
        System.out.println("Request 2: " + res2);

        String safeSite = "safe-site.org";
        String res3 = firewall.connect(safeSite);
        System.out.println("Request 3: " + res3);
    }
}
