/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad.pkg3;

import java.util.NoSuchElementException;

public class ModificarLista {

    
    int valor;
    ModificarLista siguiente;

    public ModificarLista(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

class ColaFIFO {
   ModificarLista cabeza;

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void ingresar(int valor) {
       ModificarLista nuevoNodo = new ModificarLista(valor);
        if (estaVacia()) {
            cabeza = nuevoNodo;
        } else {
            ModificarLista actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public int desencolar() {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        int valor = cabeza.valor;
        cabeza = cabeza.siguiente;
        return valor;
    }

    public void mostrar() {
        ModificarLista actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ColaFIFO miCola = new ColaFIFO();
        miCola.ingresar(10);
        miCola.ingresar(20);
        miCola.ingresar(30);
        miCola.mostrar();
        
        int elementoDesencolado = miCola.desencolar();
        System.out.println("Elemento desencolado: " + elementoDesencolado);
        
        miCola.mostrar();
    }}

