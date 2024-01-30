package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 * Main app donde se interacciona con el archivo
 */
public class App {
    
    public static void main(String[] args){
        boolean start = true;
        Scanner scanner = new Scanner(System.in);
        while (start) {
            System.out.println("------------------MENU_PRINCIPAL--------------------");
            System.out.println("1. Calculadora POSFIX");
            System.out.println("2. Salir");
            System.out.println("Ingrese la opcion: ");
            int opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    
                    try {

                        System.out.println("Ingrese el nombre del archivo: ");
                        String fileName = scanner.next();
                        System.out.println("------------------RESULTADO--------------------");
                        String fileText = leerArchivo(fileName);
                        String line = "";
                        MyPFCalc calculator = new MyPFCalc();
                        int lineCounter = 1;

                        // Recorrer el texto del archivo
                        for (int i = 0; i < fileText.length(); i++) {
                            char caracter = fileText.charAt(i);
                            //Validar que no haya un salto de linea, de lo contrario ya termino la primero operacion y se corta
                            if(caracter != '\n'){
                                line += caracter;
                            }else{
                                int result = calculator.evaluate(line);
                                System.out.println("Resultado " + lineCounter + " = " + result );
                                line = "";
                                lineCounter++;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                case 2:
                    start = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("Saliendo del programa");
        scanner.close();
    }


    
    /**
     * Metodo para leer archivo
     * @param nombreArchivo El nombre de archivo a leer
     * @return contenido del string
     */
    public static String leerArchivo(String nombreArchivo) throws IOException{
        StringBuilder contenido = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

        } catch (IOException e) {
            throw new IOException(e);
        }

        return contenido.toString();
    }


}
