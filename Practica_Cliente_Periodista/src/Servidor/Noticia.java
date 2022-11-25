package Servidor;

public class Noticia {
	String nombrePeriodista;
	String noticia;
	
	public String codificarNoticia(String noticia) {
		StringBuilder noticiaCodificada=new StringBuilder();
		
		for (int i = 0; i < noticia.length(); i++) {
			noticiaCodificada.append(Character.toString(noticia.charAt(i) + 1));
		}
			return noticiaCodificada.toString();
		}
		
		public String decodificarNoticia(String noticia) {
			StringBuilder noticiaDecodificada=new StringBuilder();
			for (int i = 0; i < noticia.length(); i++) {
				noticiaDecodificada.append(Character.toString(noticia.charAt(i) -1));
			}
				return noticiaDecodificada.toString();
		}
		public String toString() {
			return nombrePeriodista+" manda noticia:\n - Codificada: " + 
				   codificarNoticia(noticia) + "\n - Descodificada: " + noticia;
		}
}
	
