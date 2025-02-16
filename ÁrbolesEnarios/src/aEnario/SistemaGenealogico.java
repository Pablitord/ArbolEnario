package aEnario;

import java.util.Scanner;

public class SistemaGenealogico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolGenealogico arbol = new ArbolGenealogico();

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar persona");
            System.out.println("2. Editar persona");
            System.out.println("3. Eliminar persona");
            System.out.println("4. Mostrar árbol genealógico");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
                    String fecha = scanner.nextLine();
                    System.out.print("Parentezco (Padre/Madre, Hijo/Hija, Abuelo/Abuela, Nieto/Nieta, Hermano/Hermana, Tío/Tía, Sobrino/Sobrina, Primo/Prima): ");
                    String parentezco = scanner.nextLine();
                    System.out.print("Nombre del padre (dejar vacío si es la raíz): ");
                    String nombrePadre = scanner.nextLine();
                    System.out.print("Apellido del padre: ");
                    String apellidoPadre = scanner.nextLine();

                    Persona padre = arbol.buscar(nombrePadre, apellidoPadre, arbol.raiz);
                    System.out.println(arbol.insertar(nombre, apellido, fecha, parentezco, padre));
                    break;

                case 2:
                    System.out.print("Nombre actual: ");
                    String nombreActual = scanner.nextLine();
                    System.out.print("Apellido actual: ");
                    String apellidoActual = scanner.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nuevo apellido: ");
                    String nuevoApellido = scanner.nextLine();
                    System.out.print("Nueva fecha de nacimiento (dd/mm/aaaa): ");
                    String nuevaFecha = scanner.nextLine();
                    System.out.print("Nuevo parentezco: ");
                    String nuevoParentezco = scanner.nextLine();
                    if (arbol.editar(nombreActual, apellidoActual, nuevoNombre, nuevoApellido, nuevaFecha, nuevoParentezco, arbol.raiz)) {
                        System.out.println("Datos actualizados correctamente.");
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Nombre: ");
                    String nombreEliminar = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoEliminar = scanner.nextLine();
                    if (arbol.eliminar(nombreEliminar, apellidoEliminar)) {
                        System.out.println("Persona eliminada correctamente.");
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("\nÁrbol Genealógico:");
                    arbol.mostrarArbol(arbol.raiz, "");
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}

