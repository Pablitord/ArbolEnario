package aEnario;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    public String nombre;
    public String apellido;
    public String fechaNacimiento;
    public String parentezco;
    public List<Persona> hijos;

    public Persona(String nombre, String apellido, String fechaNacimiento, String parentezco) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.parentezco = parentezco;
        this.hijos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + parentezco + ", Nacimiento: " + fechaNacimiento + ")";
    }
}

