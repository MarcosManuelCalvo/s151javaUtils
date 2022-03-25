import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
/*Exercici 2. Afegeixi a la classe del nivell anterior la funcionalitat
 * de llistar un arbre de directoris amb el contingut de tots els
 * seus nivells (recursivament) de manera que s'imprimeixin en pantalla en
 * ordre alfabètic dins de cada nivell, indicant a més si és un directori (D)
 * o un fitxer (F), i la seva última data de modificació.*/
public class S1512 {

	public static void main(String[] args) {
		//C:/Users/Marcos/Desktop/
		String profundidad = "";	 
		String s = pideString("Introdueix path, tiene que acabar en '/', que si no no rula: ");			
		mostraCarpeta(s, profundidad);
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
}
