import java.io.*;

public class S1515 {
	/*Exercici 5. Mostri com serialitzar un Objecte Java a un fitxer .ser i deserialícelo després.*/
	public static void main(String[] args){   
		Coche objetoJava = new Coche(95, "ibiza");
		String filename = "coche.ser";

		try	{   
			FileOutputStream file = new FileOutputStream(filename);//creamos el .ser  para recibir datos
			ObjectOutputStream out = new ObjectOutputStream(file);//lo preparamos para escribirlo

			//escribimos la instancia de coche
			out.writeObject(objetoJava);

			out.close();//cerramos la escritura
			file.close();//cerramos el .ser

		}catch(IOException ex){
			System.out.println("IOException is caught");
		}


		Coche otroObjetoJava = null;//vacio
		try	{   
			FileInputStream file = new FileInputStream(filename);//creamos el .ser  para extrer datos
			ObjectInputStream in = new ObjectInputStream(file);//nos preparamos para leerlo

			otroObjetoJava = (Coche)in.readObject();//rellenamos el otroObjetoJava con lo leido.

			in.close();//cerramos la lectura
			file.close();//cerramos el .ser

			System.out.println("cv = " + otroObjetoJava.cv);
			System.out.println("model = " + otroObjetoJava.model);
		}

		catch(IOException ex){
			System.out.println("IOException is caught");
		}

		catch(ClassNotFoundException ex){
			System.out.println("ClassNotFoundException is caught");
		}

	}
}

class Coche implements java.io.Serializable
{
	public int cv;
	public String model;

	// Default constructor
	public Coche(int cv, String model){
		this.cv = cv;
		this.model = model;
	}

}
