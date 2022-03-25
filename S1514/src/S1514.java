
import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
public class S1514 {
	/*Exercici 4. Afegeixi la funcionalitat de llegir qualsevol fitxer txt i mostrar per consola el seu contingut.*/
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//C:/Users/Marcos/Desktop/Undertale/
		//C:/Users/Marcos/Desktop/patron.txt
		String profundidad = "";	 
		String s = pideString("Introdueix path, tiene que acabar en '/', que si no no rula: ");			

		if(s.substring(s.length() - 4).equals(".txt") ) {
			muestraContenido(s); 
		}
		else {

			PrintStream o = new PrintStream(new File("C:/Users/Marcos/Desktop/A.txt"));
			System.setOut(o);
			mostraCarpeta(s, profundidad);
		}
	}

	public static void mostraCarpeta(String espais, String profundidad) {
		profundidad = profundidad+"   ";
		File f = new File(espais);
		String[] pathnames = f.list();
		for (String pathname : pathnames) {
			f= new File(espais+pathname);
			if(f.isDirectory()==true) {
				System.out.println(profundidad+pathname+" (D)");
				String s =espais+pathname+'/';
				mostraCarpeta(s , profundidad);
			}
			else {
				try {
					String fileName = espais+pathname;
					Path fila = Paths.get(fileName);
					BasicFileAttributes attr = Files.readAttributes(fila, BasicFileAttributes.class);
					System.out.println(profundidad+pathname+" (F) "+attr.lastModifiedTime());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static String pideString(String mensaje) {
		Scanner sc  =  new Scanner(System.in);
		System.out.print(mensaje);
		return sc.nextLine();
	}



	static void muestraContenido(String archivo) throws FileNotFoundException, IOException { 

		try {
			String cadena; 
			FileReader f = new FileReader(archivo); 
			BufferedReader b = new BufferedReader(f); 
			while((cadena = b.readLine())!=null) { 
				System.out.println(cadena); 
			} 
			b.close(); 
		}
		finally {}
	}
}