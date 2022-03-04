package programming;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NetworkMask {


    public static boolean ipInNetwork(String ip, String network) {

        String[] networkElements = network.split("/");
        int maskLength = Integer.parseInt(networkElements[1]);
        String ipBinary = binary(ip)
                .substring(0, maskLength);
        String networkBinary = binary(networkElements[0])
                .substring(0, maskLength);

        return ipBinary.compareTo(networkBinary) == 0;
    }

    public static String binary(String ip) {
       return  Arrays.stream(ip.split("\\."))
                .map((String s) ->
                        String.format("%8s",Integer.toBinaryString(
                            Integer.parseInt(s)))
                        .replaceAll(" ", "0")
                )
                .collect(
                        Collectors.joining(""));

    }

    public static void main(String[] args) {
        String network = "192.168.1.128/25";
        String ip = "192.168.1.127";

        System.out.println(ipInNetwork(ip, network));
    }

}
