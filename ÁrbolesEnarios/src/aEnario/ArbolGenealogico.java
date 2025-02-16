package aEnario;

public class ArbolGenealogico {
    public Persona raiz;

    public ArbolGenealogico() {
        this.raiz = null;
    }

    public String insertar(String nombre, String apellido, String fechaNacimiento, String parentezco, Persona padre) {
        Persona nuevaPersona = new Persona(nombre, apellido, fechaNacimiento, parentezco);
        if (raiz == null) {
            raiz = nuevaPersona;
            return "Nueva persona agregada como raíz.";
        }
        if (padre != null) {
            padre.hijos.add(nuevaPersona);
            return "Persona agregada correctamente.";
        }
        return "No se encontró al padre.";
    }

    public Persona buscar(String nombre, String apellido, Persona nodo) {
        if (nodo != null) {
            if (nodo.nombre.equalsIgnoreCase(nombre) && nodo.apellido.equalsIgnoreCase(apellido)) {
                return nodo;
            }
            for (Persona hijo : nodo.hijos) {
                Persona encontrado = buscar(nombre, apellido, hijo);
                if (encontrado != null) return encontrado;
            }
        }
        return null;
    }

    public boolean editar(String nombre, String apellido, String nuevoNombre, String nuevoApellido, String nuevaFecha, String nuevoParentezco, Persona nodo) {
        Persona persona = buscar(nombre, apellido, nodo);
        if (persona != null) {
            persona.nombre = nuevoNombre;
            persona.apellido = nuevoApellido;
            persona.fechaNacimiento = nuevaFecha;
            persona.parentezco = nuevoParentezco;
            return true;
        }
        return false;
    }

    public boolean eliminar(String nombre, String apellido) {
        if (raiz == null) return false;
        if (raiz.nombre.equalsIgnoreCase(nombre) && raiz.apellido.equalsIgnoreCase(apellido)) {
            if (raiz.hijos.isEmpty()) {
                raiz = null;
            } else {
                Persona primogenito = raiz.hijos.get(0);
                primogenito.hijos.addAll(raiz.hijos.subList(1, raiz.hijos.size()));
                raiz = primogenito;
            }
            return true;
        }
        return borrarNodo(raiz, nombre, apellido);
    }

    private boolean borrarNodo(Persona nodo, String nombre, String apellido) {
        for (int i = 0; i < nodo.hijos.size(); i++) {
            Persona hijo = nodo.hijos.get(i);
            if (hijo.nombre.equalsIgnoreCase(nombre) && hijo.apellido.equalsIgnoreCase(apellido)) {
                nodo.hijos.remove(i);
                nodo.hijos.addAll(hijo.hijos);
                return true;
            } else {
                if (borrarNodo(hijo, nombre, apellido)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void mostrarArbol(Persona nodo, String prefijo) {
        if (nodo != null) {
            System.out.println(prefijo + nodo);
            for (Persona hijo : nodo.hijos) {
                mostrarArbol(hijo, prefijo + "   ");
            }
        }
    }
}

