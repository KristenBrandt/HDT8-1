public class Paciente implements Comparable<Paciente> {

    String nombre;
    String problema;
    String prioridad;

    public Paciente(String nombre, String problema, String prioridad) {
        this.nombre = nombre;
        this.problema = problema;
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return  "\n"+nombre + '\'' + problema + '\'' + prioridad + '\'' ;
    }

    @Override
    public int compareTo(Paciente num) {
        return this.prioridad.compareTo(((Paciente)num).prioridad);
    }
}