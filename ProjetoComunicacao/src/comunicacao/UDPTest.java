package comunicacao;

import java.util.Scanner;
import java.io.*;
import java.net.*;
public class UDPTest {

	public static void main(String[] args) throws SocketException, UnknownHostException {
		
		Scanner in = new Scanner (System.in);
		in.nextLine();
		DatagramSocket sock = new DatagramSocket();
		InetAddress.getByName("localhost");
		InetAddress ipdestino;
	}

}