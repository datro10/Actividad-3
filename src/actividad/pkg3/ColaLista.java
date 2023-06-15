/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad.pkg3;

import java.util.NoSuchElementException;

/**
 *
 * @author pbape
 */
public class ColaLista {

    int valor;
    ColaLista siguiente;

    public ColaLista(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

class PilaPersonalizada {

    ColaLista cabeza;

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void empujar(int valor) {
        ColaLista nuevoNodo = new ColaLista(valor);
        if (estaVacia()) {
            cabeza = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        }
    }

    public int desapilar() {
        if (estaVacia()) {
            throw new NoSuchElementException("La pila está vacía");
        }
        int valorDesapilado = cabeza.valor;
        cabeza = cabeza.siguiente;
        return valorDesapilado;
    }

    public void mostrar() {
        ColaLista actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PilaPersonalizada miPila = new PilaPersonalizada();
        miPila.empujar(10);
        miPila.empujar(20);
        miPila.empujar(30);
        miPila.mostrar(); // Salida: 30 20 10
        System.out.println(miPila.desapilar()); // Salida: 30
        miPila.mostrar(); // Salida: 20 10
    }
}
