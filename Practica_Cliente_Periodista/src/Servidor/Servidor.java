package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private final int Port = 9876;
	private ServerSocket serverSocket;
	private Socket socket;
	
	public Servidor() throws IOException {
		serverSocket = new ServerSocket(Port); //Definimos conexión
		socket = new Socket(); //iniciamos el cliente
	}
		//Función para iniciar la conexión
		
		public void iniciarServer() throws IOException {
			
			//aceptamos datos que llegan del cliente
			
			while (true) {
				System.out.println("Esperando la conexión del cliente");
				socket = serverSocket.accept();//guardamos la petición que llegue al servidor en socket
				//El servidor se queda a la espera de recibir una petición
				
				System.out.println("Periodista conectado.");
				
				DataOutputStream emisor = new DataOutputStream(socket.getOutputStream());
				DataInputStream receptor = new DataInputStream(socket.getInputStream());
				
				emisor.writeUTF("Servidor: Dime tu nombre");
				String nombreCliente = receptor.readUTF();
				System.out.println("Periodista logueado como: " + nombreCliente);
				
				
				String noticiaDecodificada, noticiaCodificada;
				Noticia noticia = new Noticia();
				
				do {
					emisor.writeUTF("Servidor: Hola" + nombreCliente + ", escribe la noticia: escribir FIN DE COMUNICACION para cerrar conexión.");
					noticiaCodificada = receptor.readUTF();
					noticiaDecodificada = noticia.decodificarNoticia(noticiaCodificada);
					
					System.out.println("-----------------------------------------------------------");
					System.out.println("Periodista: " + nombreCliente);
					System.out.println("Noticia Codificada: " + noticiaCodificada);
					System.out.println("Noticia Decodificada: " + noticiaDecodificada);
					System.out.println("-----------------------------------------------------------");
				}while (!noticiaDecodificada.equalsIgnoreCase("FIN DE COMUNICACIÓN"));
				socket.close();
				System.out.println("periodista desconectado.");
				receptor.close();
				emisor.close();
					
			}
	}
}
