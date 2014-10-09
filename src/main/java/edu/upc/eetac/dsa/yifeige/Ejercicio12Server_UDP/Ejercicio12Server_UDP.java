package edu.upc.eetac.dsa.yifeige.Ejercicio12Server_UDP;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ejercicio12Server_UDP 
{
    public static void main( String[] args )throws IOException
    {
    	try
    	{
    		DatagramSocket socket=new DatagramSocket(9876);
    		System.out.print("Socket construido esperando una conexion");     	
        	byte[] receivebuff=new byte[256];
        	byte[] sendbuff=new byte[256];
        	Date fecha=new Date();
        	SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
        	
        	DatagramPacket receivepacket=new DatagramPacket(receivebuff,receivebuff.length);
        	socket.receive(receivepacket);
        	String opcion1=new String(receivepacket.getData());
        	int opcion=Integer.parseInt(opcion1);
        	
        	if(opcion==0)
        	{
        	    String hora=formato.format(fecha);
        	    sendbuff=hora.getBytes();
        	    InetAddress IP=receivepacket.getAddress();
        	    int port=receivepacket.getPort();
        	    DatagramPacket sendpacket=new DatagramPacket(sendbuff,sendbuff.length,IP,port);
        	    socket.send(sendpacket);
        	}
        	else
        	{
        		System.exit(1);
        	}
    	}
    	
    	catch(SocketException e)
    	{
    		System.out.println("Port 7002 Ocupado");
    		System.exit(1);
    	}
    	
    	
        
    }
}
