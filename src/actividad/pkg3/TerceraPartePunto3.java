/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.pkg3;

import java.util.NoSuchElementException;

// Clase para representar un pasajero en un aeropuerto
class Pasajero {

    private String nombre;

    public Pasajero(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

// Clase para representar un cliente en un servicio al cliente
class Cliente {

    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

class ColaAeropuerto<T> {

    private NodoAeropuerto<T> cabeza;

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void ingresar(T elemento) {
        NodoAeropuerto<T> nuevoNodo = new NodoAeropuerto<>(elemento);
        if (estaVacia()) {
            cabeza = nuevoNodo;
        } else {
            NodoAeropuerto<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }
    public T desencolar() {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        T elemento = cabeza.elemento;
        cabeza = cabeza.siguiente;
        return elemento;
    }

    public void mostrar() {
        NodoAeropuerto<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.elemento + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}

// Nodo para la cola en un aeropuerto
class NodoAeropuerto<T> {

    T elemento;
    NodoAeropuerto<T> siguiente;

    public NodoAeropuerto(T elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }
}

// Cola LIFO modificada para representar una cola en un servicio al cliente
class ColaServicioCliente<T> {

    private NodoServicioCliente<T> cabeza;

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void apilar(T elemento) {
        NodoServicioCliente<T> nuevoNodo = new NodoServicioCliente<>(elemento);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    public T desapilar() {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        T elemento = cabeza.elemento;
        cabeza = cabeza.siguiente;
        return elemento;
    }

    public void mostrar() {
        NodoServicioCliente<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.elemento + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}

// Nodo para la cola en un servicio al cliente
class NodoServicioCliente<T> {

    T elemento;
    NodoServicioCliente<T> siguiente;

    public NodoServicioCliente(T elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }
}
class principal {
        public static void main(String[] args) {
        // Ejemplo de uso de la cola en un aeropuerto
        ColaAeropuerto<Pasajero> colaAeropuerto = new ColaAeropuerto<>();

        colaAeropuerto.ingresar(new Pasajero("Pasajero 1"));
        colaAeropuerto.ingresar(new Pasajero("Pasajero 2"));
        colaAeropuerto.ingresar(new Pasajero("Pasajero 3"));

        System.out.println("Atendiendo al siguiente pasajero: " + colaAeropuerto.desencolar());
        System.out.println("Atendiendo al siguiente pasajero: " + colaAeropuerto.desencolar());

        // Ejemplo de uso de la cola en un servicio al cliente
        ColaServicioCliente<Cliente> colaServicioCliente = new ColaServicioCliente<>();

        colaServicioCliente.apilar(new Cliente("Cliente 1"));
        colaServicioCliente.apilar(new Cliente("Cliente 2"));
        colaServicioCliente.apilar(new Cliente("Cliente 3"));

        System.out.println("Atendiendo al siguiente cliente: " + colaServicioCliente.desapilar());
        System.out.println("Atendiendo al siguiente cliente: " + colaServicioCliente.desapilar());
    }
}
