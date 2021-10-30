import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Unidad 5 , Actividad Individual: Calculadora de Matrices
 * Lian Salmerón López
 * 19/11/2020
 */
public class Calculo_Matricial {
	
	public static int ofrecer_y_recoger_opcion() {
		int opcion = -1;
		Scanner teclado = new Scanner(System.in);
		System.out.print(
				"\n---Bienvenido a gestión de matrices---\n" +
				"Operaciones disponibles: \n" +
				"0. Salir"             + "\n" +
				"1. Introducir Matriz" + "\n" +
				"2. Listar Matriz"     + "\n" +
				"3. Comparar Matrices" + "\n" +
				"4. Sumar Matrices"    + "\n" +
				"5. Restar Matrices"   + "\n" +
				"6. Multiplicar por un escalar" + "\n" +
				"7. Transponer"        + "\n" +
				"8. Multiplicar Matrices" + "\n" +
				"9. Cargar matriz" + "\n" +
				"10. Guardar matriz" + "\n" +
				"Indique la operación que desea realizar: ");
		
		if (teclado.hasNextInt()) {
			opcion = teclado.nextInt();
		}
		return opcion;
	}
	// devuelve 1, 2 o 0 para errores
	public static int elegir_matriz() {
		int opcion = 0;
		Scanner teclado = new Scanner (System.in); 
		System.out.print("Elija matriz (1 / 2): ");
		if (teclado.hasNextInt()) {
			opcion = teclado.nextInt();
			
			//Forzamos que devuelva 0 si el usuario elige algo diferente de 1 o 2
			if (opcion !=1 & opcion != 2) {
				opcion = 0;
			}
		}
		else {
			teclado.next();
		}
		return opcion;
	} 
	
	
	
	public static double[][] introducirMatriz() {

		double matriz[][] = {{}};
		int filas = 0;
		int columnas = 0;
		Scanner teclado = new Scanner(System.in);
		
		//Solicitar nº de filas y columnas
		System.out.print("\tIntroduzca el número de filas: ");
		if (teclado.hasNextInt()) {
			filas = teclado.nextInt();
			
			System.out.print("\tIntroduzca el número de columnas: ");
			if (teclado.hasNextInt()) {
				columnas = teclado.nextInt();
			}
		}
		
		//Reservamos esacio para las dimensiones deseadas en matriz
		//Si ha habido errores las filas o las columnas ambos serán 0
		if (filas>0 & columnas>0 ) {
			matriz = new double [filas][columnas];
			//Ir solicitando cada uno de los elementos de la matriz
			
			for (int i=0; i<matriz.length; i++) {

			int j = 0; 
				while (j<matriz[i].length) {
					//Vamos a guaardar el valor que diga el usario.
					//Si se equivoca guardaremos un 0.
					//Insitir al usuario 
					System.out.print("\telemento (" + (i+1) + ", " + (j+1) + "): ");
					if (teclado.hasNextDouble()) {
						matriz[i][j] = teclado.nextDouble();
						j++;
					}
					else { //ha cometido un error con el valor
						System.out.println("ERROR. Introduzca un elemento válido.");
						teclado.next(); //Quitamos la basura
					}
				}
					
			}
		}	
		return matriz;
	}
	
	public static void listarMatriz(double matriz[][]) {
	System.out.println("\tFilas: " + matriz.length);
	if (matriz.length>0) {
	System.out.println("\tColumnas: " + matriz[0].length + "\n");
	}
	
	for (int i=0; i<matriz.length; i++) {
		for (int j=0; j<matriz[i].length; j++) {
			System.out.print("\t " + matriz[i][j]);
		}
		System.out.println();
		}
	System.out.println();
}
	
	
	public static boolean compararMatriz(double matriz1[][], double matriz2[][]) {
		if (Arrays.deepEquals(matriz1, matriz2)) { //Se comparan todos los elementos de las matrices
			return true; 
		}
		else {
			return false;
		}
	}
	
	
	public static double[][] sumarMatriz(double matriz1[][], double matriz2[][]) {
		
		double [][]suma_matrices = {};
		
		
		if (matriz1.length==0 | matriz2.length==0) { //Matrices sin inicializar
			System.out.println("Alguna matriz está sin inicializar.");
		}
		else if (matriz1.length != matriz2.length) { //Diferentes dimensiones
			System.out.println("NO se pueden sumar, tienen dimensiones diferentes.");
		}
		else { //
		suma_matrices = new double [matriz1.length][matriz1[0].length];
		for (int i=0; i<suma_matrices.length; i++) {
			for (int j=0; j<suma_matrices[i].length; j++) {
				suma_matrices[i][j] = matriz1[i][j] + matriz2[i][j];
			}
		}
		}
		
		return suma_matrices;
	}
	
	
	public static double[][] restarMatriz(double matriz1[][], double matriz2[][]) {
		 
		double [][]resta_matrices;
		resta_matrices = new double [matriz1.length][matriz1[0].length];
		
		if (matriz1.length==0 | matriz2.length==0) { //Matrices sin inicializar
			System.out.println("Alguna matriz está sin inicializar.");
		}
		else if (matriz1.length != matriz2.length) { //Diferentes dimensiones
			System.out.println("NO se pueden sumar, tienen dimensiones diferentes.");
		}
		else {
	    for (int i=0; i<resta_matrices.length; i++) {
	    	for (int j=0; j<resta_matrices[i].length; j++) {
				resta_matrices[i][j] = matriz1[i][j] - matriz2[i][j];
			}
		}
		}
		return resta_matrices;
	}
		
	
	public static double[][] MatrizPorEscalar(double[][] matriz) {
	
		Scanner teclado = new Scanner(System.in);
		double [][]escalar_matriz = new double [matriz.length][matriz[0].length];
		double escalar = 0;
		
		if (matriz.length==0) { //Matrices sin inicializar
			System.out.println("La matriz está sin inicializar.");
		}
		else {
		
		System.out.print("Introduzca el número por el que desea multipicar a la matriz: ");
		if (teclado.hasNextDouble()) {
			escalar = teclado.nextDouble();
			
			for (int i=0; i<escalar_matriz.length; i++) {
				for (int j=0; j<escalar_matriz[i].length;j++) {
					escalar_matriz[i][j] = escalar*matriz[i][j];
				}
			}
		}
		else {
			System.out.println("ESCALAR INTRODUCIDO INCORRECTO.");
		}
		
		}
		return escalar_matriz;
	}
	
	
	
	public static double [][] TransponerMatriz(double matriz[][]) {
		
		double[][] matriz_traspuesta = {}; 
		
		if (matriz.length>0) { //Matriz sin inicializar
			matriz_traspuesta = new double [matriz[0].length][matriz.length];
			
			for (int i=0; i<matriz.length; i++) {
				for (int j=0; j<matriz[i].length; j++)  {
					matriz_traspuesta[j][i] = matriz[i][j];
				
				}
		}
		}
		else {
			System.out.println("La mariz está sin inicializar");
		}
		
		return matriz_traspuesta;
	}
	
	public static double[][] MultiplicarMatrices(double matriz1[][], double matriz2[][]) {

		double matriz_multiplicada[][] = {};
		int matriz1_fila = matriz1.length;
		int matriz1_columna = matriz1[0].length;
		int matriz2_fila = matriz2.length;
		int matriz2_columna = matriz2[0].length;
		
		if (matriz1_columna != matriz2_fila) { //El número de columnas de la matriz1 no es igual al número de filas de la matriz2
			System.out.println("No se pueden multiplicar, el número de columnas de la mamtriz 1 "
					         + "no coincide con el número de filas de la matriz 2");
		}
		else {//Mismo número de columnas de matriz1 y mismo número de filas de matriz2
			matriz_multiplicada = new double [matriz1_fila][matriz2_columna];
			
			for (int i=0; i<matriz_multiplicada.length; i++) {
				for (int j=0; j<matriz_multiplicada[i].length; j++) {
					
					for (int t=0; t<matriz1_columna; t++) {
						matriz_multiplicada[i][j] += matriz1[i][t]*matriz2[t][j];
					}
				}
			}
		}
		
		return matriz_multiplicada;
	}
	
	
	
	//Guardar la matriz en ruta
    public static void guardar_matriz(double[][] matriz, String ruta) {
		
		FileWriter fichero;
    	try {
			fichero = new FileWriter(ruta);
			for (int i=0; i<matriz.length; i++) {
				for (int j=0; j<matriz[i].length; j++) {
					fichero.write("" + matriz[i][j]);
					if (j != matriz[i].length-1) {
						fichero.write(";");
					}
					
				}
				fichero.write("\n");
			} 
			fichero.close();
			
		} catch (IOException e) {
			System.out.println("ERROR en el guardado de la matriz.");
		}
	}
    
    
    
    //Lee la matriz de ruta y la devuelve
	public static double[][] leer_matriz(String ruta) {
		
		double[][] matriz = {};
		File fichero = new File(ruta);
		
		try {
			Scanner lectura = new Scanner(fichero);
			matriz = new double[contar_filas(ruta)][contar_columnas(ruta)];
			
			int i = 0;
			String fila;
			String[] array_fila;
			
			while(lectura.hasNextLine()) {
				fila = lectura.nextLine(); // "3;4;5"
				array_fila = fila.split(";");
				//array_fila = sc.nextLine().split(";");
				
				for (int j=0; j<array_fila.length; j++) {
					matriz[i][j] = Double.parseDouble(array_fila[j]);
				}
				i++;
			}
			lectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error, no se puede abrir el fichero.");
		}
		
		
		return matriz;
	}
	
	
	
    public static int contar_filas(String ruta) {
		
		int lineas = 0;
		File fichero = new File(ruta);
		try {
			Scanner lectura = new Scanner(fichero);
			
			while (lectura.hasNextLine()) {
				lectura.nextLine();
				lineas++;
			}
			lectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR. Fichero no encontrado.");
		}
		return lineas;
	}

    
	 
     public static int contar_columnas(String ruta) {
		
		int columnas = 0;
		String fila = "";
		File fichero = new File(ruta);
		try {
			Scanner lectura = new Scanner(fichero);
			
			if (lectura.hasNextLine()) {
				fila = lectura.nextLine();
			}
			lectura.close();
		} catch (FileNotFoundException e) {
			System.out.println("ERROR. Fichero no encontrado.");
		}
		
		columnas = fila.split(";").length;
		
		
		
		return columnas;
	}
	
     
     
	public static void main(String[] args) {
	    
		int opcion = -1;
	    double matriz1[][] = {};
	    double matriz2[][] = {};
	    double escalar = 0;
	    int id_matriz;
	    
	    double resultado[][] = {};
	    
		//Bucle principl - Se ofrece menú hasta que se desea salir
		while (opcion !=0) { //Salir es la opcion 0
			
			//Informar de las opciones
			opcion = ofrecer_y_recoger_opcion();
			
			switch (opcion) {
			case 0: //Salir
				System.out.println("Ha elegido salir. ¡Hasta pronto!");
				break;
			case 1: //INtroducir Matriz
				id_matriz = elegir_matriz();
			
				if (id_matriz==1) {
					matriz1 = introducirMatriz();
				}
				else if (id_matriz==2) {
					matriz2 = introducirMatriz();
				}
				else {
					System.out.println("MATRIZ INCORRECTA");
				}
				break;
			case 2: //Listar matriz
                id_matriz = elegir_matriz();
				
				if (id_matriz==1) {
					listarMatriz(matriz1);
				}
				else if (id_matriz==2) {
					listarMatriz(matriz2);
				}
				else {
					System.out.println("MATRIZ INCORRECTA");
				}
				break;
			case 3: //Comparar Matrices
				listarMatriz(matriz1);
				listarMatriz(matriz2);
				
				if (compararMatriz(matriz1, matriz2)) {
					System.out.println("Las dos matrices son iguales.");
				}
				else {
					System.out.println("Las dos matrices son distintas.");
				}
				break;
			case 4: //Sumar matrices
				resultado = sumarMatriz(matriz1, matriz2);
				listarMatriz(resultado);
				break;
			case 5: //Restar matrices
				resultado = restarMatriz(matriz1, matriz2);
				listarMatriz(resultado);
				break;
			case 6: //Multiplicar matriz por un escalar
				id_matriz = elegir_matriz();
				
				if (id_matriz==1 & matriz1.length>0) {
					resultado = MatrizPorEscalar(matriz1);
					listarMatriz(resultado);
				}
				else if (id_matriz==2 & matriz2.length>0) {
					resultado = MatrizPorEscalar(matriz2);
					listarMatriz(matriz2);
				}
				else {
					System.out.println("MATRIZ INCORRECTA.");
				}
				break;
			case 7: //Transponer matrices
				id_matriz = elegir_matriz();
				
				if (id_matriz==1 & matriz1.length>0) {
					resultado = TransponerMatriz(matriz1);
					listarMatriz(resultado);
				}
				else if (id_matriz==2 & matriz2.length>0) {
					resultado = TransponerMatriz(matriz2);
					listarMatriz(resultado);
				}
				else {
					System.out.println("MATRIZ INCORRECTA.");
				}
				break;
			case 8: //Multiplicar matrices
				if (matriz1.length>0 & matriz2.length>0) {
				resultado = MultiplicarMatrices(matriz1, matriz2);
				listarMatriz(resultado);
				}
				else {
					System.out.println("Alguna de las matrices está sin inicializar.");
				}
				break;
			case 9: //Cargar
                id_matriz = elegir_matriz();
				
				if (id_matriz==1) {
					matriz1 = leer_matriz("matriz1.csv");
				}
				else if (id_matriz==2) {
					matriz1 = leer_matriz("matriz2.csv");
				}
				else {
					System.out.println("MATRIZ INCORRECTA");
				}
				break;
			case 10: //Guardar
                id_matriz = elegir_matriz();
				
				if (id_matriz==1) {
					guardar_matriz(matriz1, "matriz1.csv");
				}
				else if (id_matriz==2) {
					guardar_matriz(matriz2, "matriz2.csv");
				}
				else {
					System.out.println("MATRIZ INCORRECTA");
				}
				break;
				default:
					System.out.println("OPCIÓN INCORRECTA");
				break;
			}	
		}


	}
	

}
