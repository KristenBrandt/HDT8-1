// Kristen Brandt 171482
// HDT8
//Colas con prioridad + Heap
// Este es el programa hecho utilizando el Java Colection FrameWork

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void print(PriorityQueue<Paciente> v){
         while (!v.isEmpty()){
            System.out.println(v.remove().toString());
        }
    }

    static String pacientesmenu = "\n Lectura de archivo de pacientes : \n" +
            "\t Ingresar la direccion del archivo de pacientes que quiere:\n" +
            "\t La direccion del archivo tiene que ser en formato C:\\\\Users\\\\try\\\\Desktop\\\\intento.txt\n" +
            "\t Si la direccion no es aceptada al primer intento ponga la direccion de nuevo, es por un problema de cache ";

    static String siguientemenu = "\n Desea ir con el siguiente paciente?(y/n) :" ;

    public static void main(String[] args) {
        boolean deleviaje = true;
        boolean siga = false;
        Scanner input = new Scanner(System.in);
        PriorityQueue<Paciente> orden = new PriorityQueue<>();
        PriorityQueue<Paciente> quitar = new PriorityQueue<>();

        do {
            System.out.print(pacientesmenu);
            System.out.println("\n");
            String archivo = input.nextLine();
            if (!archivo.equals("2")) {
                File archivoUsuarios = new File(archivo);
                //El codigo de buffered reader es tomado de la siguiente pagina.
                //https://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
                try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
                    String line;
                    System.out.print("Se esta guardando la lista de los pacientes... \n");
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(", ");
                        // este es el nombre del paciente
                        String part1 = parts[0];
                        String part2 = parts[1];
                        String part3 = parts[2];
                        Paciente paciente = new Paciente(part1,part2,part3);
                        //System.out.print(paciente.nombre);
                        //System.out.print(paciente.problema);
                        //System.out.print(paciente.prioridad);
                        orden.add(paciente);
                        quitar.add(paciente);

                    }
                    System.out.println("Se guardaron los pacientes");
                } catch (Exception e) {
                    System.out.println("Intente ingresando la direccion del archivo de nuevo porque no se encontro");
                }
                print(orden);
                siga = true;
                deleviaje = false;
            }
        } while (deleviaje);

        do {
            System.out.print(siguientemenu);
            System.out.println("\n");
            String respuesta = input.nextLine();
            switch (respuesta){
                case "y":
                    quitar.remove();
                    System.out.print(quitar);
                    break;
                case "n":
                    siga = false;
                    break;
                 default:
                     siga = false;

            }
        }while(siga);
        System.out.print("\nSe esta apagando el programa...");
    }
}
