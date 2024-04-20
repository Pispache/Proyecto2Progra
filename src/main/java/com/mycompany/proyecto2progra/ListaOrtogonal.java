package com.mycompany.proyecto2progra;

/**
 *
 * @author Victor
 */
public class ListaOrtogonal {

    NodoVehiculo inicio;

    //constructor
    public ListaOrtogonal() {
        inicio = null;
    }
    //Metodo para isertar un vehiculo en la lista ortogonal

    public void insertarVehiculo(String placa, String color, String linea, int modelo, String propietario) {
        NodoVehiculo nuevo = new NodoVehiculo(placa, color, linea, modelo, propietario);

        // Si la lista está vacía, el nuevo nodo se convierte en el inicio
        if (inicio == null) {
            inicio = nuevo;
            return;
        }

        // Inicialmente, nos movemos hacia abajo desde el inicio para encontrar la posición de inserción
        NodoVehiculo tempVertical = inicio;
        NodoVehiculo ultimoVertical = null;
        while (tempVertical != null) {
            ultimoVertical = tempVertical;
            tempVertical = tempVertical.abajo;
        }

        // Ahora, nos movemos hacia la derecha desde el último nodo en la fila para encontrar la posición de inserción
        NodoVehiculo tempHorizontal = ultimoVertical;
        NodoVehiculo ultimoHorizontal = null;
        while (tempHorizontal != null) {
            ultimoHorizontal = tempHorizontal;
            tempHorizontal = tempHorizontal.derecha;
        }

        // El nuevo nodo se inserta a la derecha del último nodo horizontal y debajo del último nodo vertical
        nuevo.izquierda = ultimoHorizontal;
        nuevo.arriba = ultimoVertical;
        if (ultimoHorizontal != null) {
            ultimoHorizontal.derecha = nuevo;
        }
        if (ultimoVertical != null) {
            ultimoVertical.abajo = nuevo;
        }
    }

    public NodoVehiculo buscarVehiculo(String criterioBusqueda, String valorBusqueda) {
        if (inicio == null) {
            return null; // La lista está vacía, por lo que no se puede encontrar ningún vehículo
        }

        // Iniciar la búsqueda desde el primer nodo en la lista
        NodoVehiculo temp = inicio;

        // Realizar un recorrido por la lista ortogonal para buscar el vehículo
        while (temp != null) {
            // Verificar si el valor de búsqueda coincide con alguna propiedad del vehículo
            if (criterioBusqueda.equalsIgnoreCase("placa") && temp.placa.equalsIgnoreCase(valorBusqueda)) {
                return temp; // Se encontró un vehículo con la placa especificada
            } else if (criterioBusqueda.equalsIgnoreCase("color") && temp.color.equalsIgnoreCase(valorBusqueda)) {
                return temp; // Se encontró un vehículo con el color especificado
            } else if (criterioBusqueda.equalsIgnoreCase("linea") && temp.linea.equalsIgnoreCase(valorBusqueda)) {
                return temp; // Se encontró un vehículo con la línea especificada
            } else if (criterioBusqueda.equalsIgnoreCase("modelo") && Integer.toString(temp.modelo).equals(valorBusqueda)) {
                return temp; // Se encontró un vehículo con el modelo especificado
            } else if (criterioBusqueda.equalsIgnoreCase("propietario") && temp.propietario.equalsIgnoreCase(valorBusqueda)) {
                return temp; // Se encontró un vehículo con el propietario especificado
            }

            // Avanzar al siguiente nodo en la dirección vertical (abajo)
            temp = temp.abajo;
        }

        return null; // No se encontró ningún vehículo con el valor de búsqueda especificado
    }

    public void eliminarVehiculo(String criterio, String valor) {
        boolean encontrado = false; // Indica si se encontró al menos un vehículo para eliminar

        NodoVehiculo temp = inicio;
        while (temp != null) {
            if ((criterio.equals("placa") && temp.getPlaca().equalsIgnoreCase(valor))
                    || (criterio.equals("color") && temp.getColor().equalsIgnoreCase(valor))
                    || (criterio.equals("linea") && temp.getLinea().equalsIgnoreCase(valor))
                    || (criterio.equals("modelo") && String.valueOf(temp.getModelo()).equals(valor))
                    || (criterio.equals("propietario") && temp.getPropietario().equalsIgnoreCase(valor))) {
                encontrado = true; // Se encontró al menos un vehículo para eliminar

                // Eliminar referencias al nodo del vehículo en las direcciones horizontal (derecha) y vertical (abajo)
                if (temp.izquierda != null) {
                    temp.izquierda.derecha = temp.derecha;
                }
                if (temp.derecha != null) {
                    temp.derecha.izquierda = temp.izquierda;
                }
                if (temp.arriba != null) {
                    temp.arriba.abajo = temp.abajo;
                }
                if (temp.abajo != null) {
                    temp.abajo.arriba = temp.arriba;
                }

                // Si el nodo a eliminar es el inicio de la lista, actualizar el inicio
                if (temp == inicio) {
                    inicio = temp.derecha != null ? temp.derecha : temp.abajo;
                }

                // Avanzar al siguiente nodo en la dirección vertical (abajo)
                temp = temp.getAbajo();
            } else {
                // Avanzar al siguiente nodo en la dirección horizontal (derecha)
                temp = temp.getDerecha();
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún vehículo que coincida con el criterio de búsqueda.");
        }
    }

    public void listarVehiculos() {
        NodoVehiculo temp = inicio;
        if (temp == null) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        System.out.println("Vehículos registrados:");
        while (temp != null) {
            System.out.println("Placa: " + temp.getPlaca());
            System.out.println("Color: " + temp.getColor());
            System.out.println("Línea: " + temp.getLinea());
            System.out.println("Modelo: " + temp.getModelo());
            System.out.println("Propietario: " + temp.getPropietario());
            System.out.println();
            temp = temp.getAbajo(); // Avanzar al siguiente nodo en la dirección vertical (abajo)
        }
    }

}
