import java.util.Scanner;
import java.io.File;
public class S1511 {
	/*Exercici 1. Creu una classe Java que llisti el contingut
	 * d'un directori rebut per paràmetre ordenat alfabèticament.*/
	public static void main(String[] args) {
		String[] pathnames;

		String s = pideString("Introdueix path, tiene que acabar en '\', que si no no rula: ");
		File f = new File(/*"C:/"*/s);
		pathnames = f.list();

		for (String pathname : pathnames) {
			System.out.println(pathname);
		}

	}
	public static String pideString(String mensaje) {
		Scanner sc  =  new Scanner(System.in);
		System.out.print(mensaje);
		return sc.nextLine();
	}
}
