import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.io.*;
public class S1513 {
	/*Exercici 3. Executi l'exercici anterior guardant a un fitxer txt el resultat.*/

	public static void main(String[] args)throws FileNotFoundException {


		//C:/Users/Marcos/Desktop/Undertale/
		String profundidad = "";	 
		String s = pideString("Introdueix path, tiene que acabar en '/', que si no no rula: ");			
		PrintStream o = new PrintStream(new File("C:/Users/Marcos/Desktop/A.txt"));

		System.setOut(o);


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
