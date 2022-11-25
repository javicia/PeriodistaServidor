package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;



public class Cliente {

	 private final String Host = "localhost";
	    private final int Port = 9876;
	    private final Socket socket;


	    public Cliente() throws IOException {
	        socket = new Socket(Host, Port);
	    }

	    public void iniciarCliente() throws IOException {

	        DataInputStream receptor = new DataInputStream(socket.getInputStream());
	        DataOutputStream emisor = new DataOutputStream(socket.getOutputStream());

	        Scanner scanIn = new Scanner(System.in);
	        // SERVIDOR -> emisor.writeUTF("Servidor: Dime tu nombre");
	        System.out.println(receptor.readUTF());
	        emisor.writeUTF(scanIn.nextLine());
	        String noticiaDecodificada, noticiaCodificada;
			Noticia noticia = new Noticia();

			do {
				// SERVIDOR -> escribe noticia
				System.out.println(receptor.readUTF());
				noticiaDecodificada=scanIn.nextLine();
				noticiaCodificada=noticia.codificarNoticia(noticiaDecodificada);
		        emisor.writeUTF(noticiaCodificada);
			} while (!noticiaDecodificada.equalsIgnoreCase("FIN_COMUNICACION"));

	        socket.close();
	        receptor.close();
	        emisor.close();
	        System.out.println("Fin, Desconectado del servidor");
	        scanIn.close();

	    }


	}
