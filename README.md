# Proyecto 2 de Programación

## Integrantes

- **Cesar Alberto Tecun Leiva 7690-22-11766**
- **Victor Isaias Quino Quino 7690-17-6433**
- **Pablo Antonio Ispache Arriaga 7690-17-940**

### Descripción del Proyecto

Este proyecto consiste en un sistema de gestión de vehículos que permite realizar operaciones como insertar, buscar y eliminar vehículos de una lista ortogonal.

### Funcionalidades del Código

- **Insertar Vehículo:** Permite al usuario ingresar los detalles de un vehículo, como la placa, color, línea, modelo y propietario, y lo inserta en la lista ortogonal.
- **Buscar Vehículo:** Permite al usuario buscar un vehículo en la lista según diferentes criterios como placa, color, línea, modelo o propietario.
- **Eliminar Vehículo:** Permite al usuario eliminar un vehículo de la lista ortogonal proporcionando la placa del vehículo a eliminar.
- **Salir:** Permite al usuario salir del programa.

## Funciones Principales

- `main`: Función principal del programa donde se maneja la interacción con el usuario y se llaman a las funciones correspondientes para realizar las operaciones.
- `insertarVehiculo`: Permite insertar un vehículo en la lista ortogonal.
- `buscarVehiculo`: Permite buscar un vehículo en la lista ortogonal según un criterio especificado por el usuario.
- `eliminarVehiculo`: Permite eliminar un vehículo de la lista ortogonal proporcionando su placa.

### Clases

#### `Proyecto2Progra`

- **Descripción:** Clase principal que contiene el método `main` y maneja la interfaz de usuario.
- **Funciones:**
  - `main`: Maneja el flujo principal del programa y llama a las funciones correspondientes según la opción seleccionada por el usuario.

#### `ListaOrtogonal`

- **Descripción:** Clase que representa la lista ortogonal donde se almacenan los vehículos.
- **Funciones:**
  - `insertarVehiculo`: Inserta un vehículo en la lista ortogonal.
  - `buscarVehiculo`: Busca un vehículo en la lista ortogonal según un criterio especificado.
  - `eliminarVehiculo`: Elimina un vehículo de la lista ortogonal.

#### `NodoVehiculo`

- **Descripción:** Clase que representa un nodo en la lista ortogonal, que contiene los datos de un vehículo.
- **Funciones:**
  - `getPlaca`: Retorna la placa del vehículo.
  - `setPlaca`: Establece la placa del vehículo.
  - `getColor`: Retorna el color del vehículo.
  - `setColor`: Establece el color del vehículo.
  - `getLinea`: Retorna la línea del vehículo.
  - `setLinea`: Establece la línea del vehículo.
  - `getModelo`: Retorna el modelo del vehículo.
  - `setModelo`: Establece el modelo del vehículo.
  - `getPropietario`: Retorna el propietario del vehículo.
  - `setPropietario`: Establece el propietario del vehículo.

### Ejecución del Programa

Para ejecutar el programa, asegúrate de tener Java instalado y compilar los archivos. Una vez compilados, puedes ejecutar el archivo `Proyecto2Progra` para iniciar el programa.

Este manual proporciona una descripción detallada de las funciones, clases y operaciones disponibles en el código del Proyecto 2 de Programación, facilitando su comprensión y uso.
