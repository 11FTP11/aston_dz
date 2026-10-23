package ru.aston.homework.proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        System.out.println("------------------------");

        Firewall firewall = new Firewall(
	   new CommonConnection("MainConnection")
	);
	
	System.out.println("Firewall initialized");
	
        String res1 = firewall.connect("google.com");
        System.out.println("Request 1: " + res1);

        String blockedSite = "badsite.com";
        firewall.blockHost(blockedSite);
        System.out.println("blocking host: " + blockedSite);
 
        String res2 = firewall.connect(blockedSite);
        System.out.println("Request 2: " + res2);

        String safeSite = "safe-site.org";
        String res3 = firewall.connect(safeSite);
        System.out.println("Request 3: " + res3);
    }
}
