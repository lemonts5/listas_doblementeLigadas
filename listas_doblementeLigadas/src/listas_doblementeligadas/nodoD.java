
package listas_doblementeligadas;

public class nodoD {

    private int dato;
    private nodoD siguiente;
    private nodoD anterior;

    // Constructor
    public nodoD(int dato, nodoD siguiente, nodoD anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public nodoD getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoD siguiente) {
        this.siguiente = siguiente;
    }

    public nodoD getAnterior() {
        return anterior;
    }

    public void setAnterior(nodoD anterior) {
        this.anterior = anterior;
    }
}
