/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
          //
        if (inicio == null) {
            inicio = nuevo; 
            return;
        }
        // Insertar el nuevo nodo al final de la lista en la dirección horizontal (derecha)
        NodoVehiculo temp = inicio;
        while (temp.derecha != null) {
            temp = temp.derecha;
        }
        temp.derecha = nuevo;
        nuevo.izquierda = temp;
        // Insertar el nuevo nodo al final de la lista en la dirección vertical (abajo)
        temp = inicio;
        while (temp.abajo != null) {
            temp = temp.abajo;
        }
        temp.abajo = nuevo;
        nuevo.arriba = temp;
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

    public void eliminarVehiculo(String placa) {
        if (inicio == null) {
            System.out.println("La lista está vacía. No hay vehículos que eliminar.");
            return;
        }

        // Buscar el nodo del vehículo con la placa especificada
        NodoVehiculo vehiculoAEliminar = buscarVehiculo("placa", placa);

        if (vehiculoAEliminar == null) {
            System.out.println("El vehículo con la placa " + placa + " no está registrado.");
            return;
        }

        // Eliminar referencias al nodo del vehículo en las direcciones horizontal (derecha) y vertical (abajo)
        if (vehiculoAEliminar.izquierda != null) {
            vehiculoAEliminar.izquierda.derecha = vehiculoAEliminar.derecha;
        }
        if (vehiculoAEliminar.derecha != null) {
            vehiculoAEliminar.derecha.izquierda = vehiculoAEliminar.izquierda;
        }
        if (vehiculoAEliminar.arriba != null) {
            vehiculoAEliminar.arriba.abajo = vehiculoAEliminar.abajo;
        }
        if (vehiculoAEliminar.abajo != null) {
            vehiculoAEliminar.abajo.arriba = vehiculoAEliminar.arriba;
        }

        // Si el nodo a eliminar es el inicio de la lista, actualizar el inicio
        if (vehiculoAEliminar == inicio) {
            inicio = vehiculoAEliminar.derecha != null ? vehiculoAEliminar.derecha : vehiculoAEliminar.abajo;
        }
    }
}
