package programming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NetworkMaskTest {

    @Test
    void ipInNetwork() {
        String network = "192.168.1.128/25";
        String ip = "192.168.1.127";
        String ip2 = "192.168.1.128";

        assertFalse(NetworkMask.ipInNetwork(ip, network));
        assertTrue(NetworkMask.ipInNetwork(ip2, network));
    }

    @Test
    void binary() {
        String ip = "192.168.1.127";
        assertEquals(NetworkMask.binary(ip).substring(0, 25), "1100000010101000000000010");
        assertEquals(NetworkMask.binary(ip).substring(0, 25).length(), 25);

    }
}
