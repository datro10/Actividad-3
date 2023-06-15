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
public class AgregarCola {

    private NodoLIFO cabeza;

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void apilar(int valor) {
        NodoLIFO nuevoNodo = new NodoLIFO(valor);
        if (estaVacia()) {
            cabeza = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        }
    }

    public int desapilar() {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        int valor = cabeza.valor;
        cabeza = cabeza.siguiente;
        return valor;
    }

    public void mostrar() {
        NodoLIFO actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    class NodoLIFO {

        int valor;
        NodoLIFO siguiente;

        public NodoLIFO(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    public static void main(String[] args) {
        AgregarCola miCola = new AgregarCola();
        miCola.apilar(10);
        miCola.apilar(20);
        miCola.apilar(30);
        miCola.mostrar();

        int elementoDesapilado = miCola.desapilar();
        System.out.println("Elemento desapilado: " + elementoDesapilado);

        miCola.mostrar();
    }

}
