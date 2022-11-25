package Servidor;

import java.io.IOException;

public class Main {
	
	/**
	static void pruebaCodificacion() {
		Noticia noticia=new Noticia();
		String textoPrueba="ILERNAZ";
		
		System.out.println("Texto Sin Codificar: " + textoPrueba);
		System.out.println("Texto Codificado: " + noticia.codificarNoticia(textoPrueba));
		System.out.println("Texto Descodificado: " + noticia.decodificarNoticia(noticia.codificarNoticia(textoPrueba)));
		
	}
	
	public static void main(String[] args){
		pruebaCodificacion();
	}
	*/

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//definimos objeto
		
		Servidor serv = new Servidor();
		System.out.println("Iniciando servidor.......");
		
		
		//Iniciamos el servidor
		
		serv.iniciarServer();
	}

}
