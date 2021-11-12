import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ficherosTxt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Ejemplos-------------------------------------------------------------------
		
		
		String contenidoFicheros="";
		//El ultimo parametro es para machacar el texto existente o crear uno nuevo
		escribirFicheroTxt("./info/f1.txt","Hola caracola", false);
		escribirFicheroTxt("./info/f1.txt","adios caracola", true);
		escribirFicheroTxt("./info/f1.txt","tercera linea", true);

		contenidoFicheros= leerFicheroTxt("./info/f1.txt");
		System.out.println("El contenido del fichero es: "+ contenidoFicheros);
	}

	
	public static void escribirFicheroTxt(String url, String texto, boolean tipo) {
		FileWriter f = null;
		PrintWriter pw= null;
		
		try {
			f = new FileWriter (url, tipo);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		pw = new PrintWriter (f);//Escribir fichero 
		pw.print(texto);
		
		try {//Cerrar fichero
			f.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String leerFicheroTxt(String url) {
		String totalLineas="";
		String lineaTextoFichero="";
		File f2 = null;
		FileReader fr= null;
		BufferedReader br= null;
		
		f2 = new File(url);
		try {
			fr = new FileReader (f2);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		br = new BufferedReader(fr);
		
		try {
			while((lineaTextoFichero = br.readLine())!=null) {
				totalLineas = totalLineas + " " + lineaTextoFichero;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		try {//Cerrar fichero
			fr.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return totalLineas;
	}
	
	
}
