package ru.aston.homework.proxy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FirewallTest {

    @Test
    public void shouldAllowConnectionToCleanHost() {
	Firewall firewall = new Firewall(new CommonConnection("MainConnection"));

	String result = firewall.connect("google.com");
	assertEquals("\"MainConnection\": connection established to \"google.com\"", result);
    }

    @Test
    public void shouldBlockConnectionToBadHostAndAllowToCleanHost() {
        Firewall firewall = new Firewall(new CommonConnection("MainConnection"));
        firewall.blockHost("badsite.com");

        assertEquals("Firewall: connection blocked to \"badsite.com\"", firewall.connect("badsite.com"));
        assertEquals("\"MainConnection\": connection established to \"safe-site.org\"", firewall.connect("safe-site.org"));
    }
}
