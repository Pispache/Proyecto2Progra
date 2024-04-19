package com.mycompany.proyecto2progra;
/**
 *
 * @author Cesar
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Proyecto2Progra {

    public static void main(String[] args) {
        ListaOrtogonal lista = new ListaOrtogonal();
        Scanner entrada = new Scanner(System.in);
        int criterio;

        String criterioBusqueda = null;

        int opcion;
        do {
            System.out.println("Menú Principal:");
            System.out.println("1. Insertar vehículo");
            System.out.println("2. Buscar vehículo");
            System.out.println("3. Eliminar vehículo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            // Leer la opción del menú
            if (entrada.hasNextInt()) {
                opcion = entrada.nextInt();
                entrada.nextLine(); // Consumir el carácter de nueva línea pendiente
            } else {
                System.out.println("Entrada inválida. Por favor, seleccione una opción válida.");
                entrada.nextLine(); // Limpiar el buffer de entrada
                opcion = 0; // Reiniciar la variable para repetir el bucle
                continue; // Ir directamente al siguiente ciclo de iteración
            }

            switch (opcion) {
                case 1:
                    // Insertar vehículo
                    System.out.println("Insertar Vehículo:");
                    System.out.print("Ingrese la placa del vehículo: ");
                    String placa = entrada.next();
                    System.out.print("Ingrese el color del vehículo: ");
                    String color = entrada.next();
                    System.out.print("Ingrese la línea del vehículo: ");
                    String linea = entrada.next();

//                    int modelo = entrada.nextInt(); 
                    int modelo = 0;
                    boolean modeloValido = false;
                    while (!modeloValido) {
                        try {
                            System.out.print("Ingrese el modelo del vehículo:");
                            modelo = entrada.nextInt();
                            modeloValido = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Error: ");
                            entrada.next();
                        }
                    }

                    entrada.nextLine();
                    System.out.print("Ingrese el propietario del vehículo: ");
                    String propietario = entrada.nextLine();
                    lista.insertarVehiculo(placa, color, linea, modelo, propietario);
                    System.out.println("Vehículo insertado exitosamente.");
                    break;
                case 2:
                    do {
                        System.out.println("Buscar Vehículo:");
                        System.out.println("Seleccione el criterio de búsqueda:");
                        System.out.println("1. Placa");
                        System.out.println("2. Color");
                        System.out.println("3. Línea");
                        System.out.println("4. Modelo");
                        System.out.println("5. Propietario");
                        System.out.print("Ingrese el número del criterio de búsqueda: ");

                        // Verificar si la entrada es un número entero
                        if (entrada.hasNextInt()) {
                            criterio = entrada.nextInt();
                            entrada.nextLine(); // Limpiar el buffer de entrada
                        } else {
                            System.out.println("Entrada inválida. Por favor, ingrese un número del 1 al 5.");
                            entrada.nextLine(); // Limpiar el buffer de entrada
                            criterio = 0; // Reiniciar la variable para repetir el bucle
                            continue; // Ir directamente al siguiente ciclo de iteración
                        }

                        switch (criterio) {
                            case 1:
                                criterioBusqueda = "placa";
                                break;
                            case 2:
                                criterioBusqueda = "color";
                                break;
                            case 3:
                                criterioBusqueda = "linea";
                                break;
                            case 4:
                                criterioBusqueda = "modelo";
                                break;
                            case 5:
                                criterioBusqueda = "propietario";
                                break;
                            default:
                                System.out.println("Criterio de búsqueda inválido.");
                                criterioBusqueda = null; // Reinicia el criterio de búsqueda para repetir el bucle
                        }
                    } while (criterioBusqueda == null);

                    System.out.print("Ingrese el valor a buscar: ");
                    String valorBusqueda = entrada.nextLine();

                    // Realizar la búsqueda y mostrar los vehículos encontrados
                    boolean encontrado = false; // Indica si se encontró al menos un vehículo que cumple con la condición

                    NodoVehiculo temp = lista.inicio;
                    while (temp != null) {
                        if (criterioBusqueda.equals("placa") && temp.getPlaca().equalsIgnoreCase(valorBusqueda)
                                || criterioBusqueda.equals("color") && temp.getColor().equalsIgnoreCase(valorBusqueda)
                                || criterioBusqueda.equals("linea") && temp.getLinea().equalsIgnoreCase(valorBusqueda)
                                || criterioBusqueda.equals("modelo") && String.valueOf(temp.getModelo()).equals(valorBusqueda)
                                || criterioBusqueda.equals("propietario") && temp.getPropietario().equalsIgnoreCase(valorBusqueda)) {
                            encontrado = true; // Se encontró al menos un vehículo que cumple con la condición

                            // Mostrar los detalles del vehículo encontrado
                            System.out.println("Vehículo encontrado:");
                            System.out.println("Placa: " + temp.getPlaca());
                            System.out.println("Color: " + temp.getColor());
                            System.out.println("Línea: " + temp.getLinea());
                            System.out.println("Modelo: " + temp.getModelo());
                            System.out.println("Propietario: " + temp.getPropietario());
                            System.out.println();
                        }
                        temp = temp.getAbajo(); // Avanzar al siguiente nodo en la dirección vertical (abajo)
                    }

                    // Si no se encontró ningún vehículo que cumpla con la condición, mostrar un mensaje
                    if (!encontrado) {
                        System.out.println("No se encontró ningún vehículo con los criterios especificados.");
                    }
                    break;
                case 3:
                    // Eliminar vehículo
                    System.out.println("Eliminar Vehículo:");
                    System.out.print("Ingrese la placa del vehículo a eliminar: ");
                    String placaEliminar = entrada.next();

                    lista.eliminarVehiculo(placaEliminar);
                    System.out.println("Vehiculo Eliminado");
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 4);

        entrada.close();
    }
}
