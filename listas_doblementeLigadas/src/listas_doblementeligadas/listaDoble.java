
package listas_doblementeligadas;

// Lista doblemente ligada.
public class listaDoble {

    private int tamanio;
    private nodoD cabeza;
    private nodoD cola;

    // Constructor.
    public listaDoble() {
        tamanio = 0;
        cabeza = null;
        cola = null;
    }

    // Verifica si está vacía.
    public boolean estaVacia() {
        return tamanio == 0;
    }

    // Obtiene el tamaño.
    public int getTamanio() {
        return tamanio;
    }

    // Inserta al inicio.
    public void insertarAlInicio(int dato) {

        nodoD nuevo = new nodoD(dato, cabeza, null);

        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
        }

        tamanio++;
    }

    // Inserta al final.
    public void insertarAlFinal(int dato) {

        nodoD nuevo = new nodoD(dato, null, cola);

        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            cola = nuevo;
        }

        tamanio++;
    }

    // Obtiene un nodo por su posición.
    public nodoD obtenerNodo(int pos) {

        if (pos < 0 || pos >= tamanio) {
            throw new IndexOutOfBoundsException(
                "Posición fuera de rango: " + pos
            );
        }

        nodoD aux;

        if (pos < tamanio / 2) {
            aux = cabeza;

            for (int i = 0; i < pos; i++) {
                aux = aux.getSiguiente();
            }

        } else {
            aux = cola;

            for (int i = tamanio - 1; i > pos; i--) {
                aux = aux.getAnterior();
            }
        }

        return aux;
    }

    // Inserta en una posición específica.
    public void insertarEnPosicion(int pos, int dato) {

        if (pos < 0 || pos > tamanio) {
            throw new IndexOutOfBoundsException(
                "Posición fuera de rango: " + pos
            );
        }

        if (pos == 0) {
            insertarAlInicio(dato);

        } else if (pos == tamanio) {
            insertarAlFinal(dato);

        } else {

            nodoD actual = obtenerNodo(pos);
            nodoD anterior = actual.getAnterior();

            nodoD nuevo = new nodoD(dato, actual, anterior);

            anterior.setSiguiente(nuevo);
            actual.setAnterior(nuevo);

            tamanio++;
        }
    }

    // Inserta manteniendo el orden ascendente.
    public void insertarOrdenado(int dato) {

        if (estaVacia() || dato <= cabeza.getDato()) {
            insertarAlInicio(dato);

        } else if (dato >= cola.getDato()) {
            insertarAlFinal(dato);

        } else {

            nodoD actual = cabeza;

            while (actual.getSiguiente() != null
                    && actual.getSiguiente().getDato() < dato) {

                actual = actual.getSiguiente();
            }

            nodoD siguiente = actual.getSiguiente();

            nodoD nuevo = new nodoD(dato, siguiente, actual);

            actual.setSiguiente(nuevo);
            siguiente.setAnterior(nuevo);

            tamanio++;
        }
    }

    // Busca un elemento.
    public boolean buscar(int dato) {

        nodoD actual = cabeza;

        while (actual != null) {

            if (actual.getDato() == dato) {
                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    // Actualiza un elemento.
    public void actualizar(int pos, int nuevoDato) {

        nodoD actual = obtenerNodo(pos);
        actual.setDato(nuevoDato);
    }

    // Elimina el primer elemento.
    public int eliminarInicio() {

        if (estaVacia()) {
            throw new IllegalStateException(
                "La lista está vacía"
            );
        }

        int dato = cabeza.getDato();

        if (cabeza == cola) {
            cabeza = null;
            cola = null;

        } else {

            nodoD eliminada = cabeza;

            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);

            eliminada.setSiguiente(null);
        }

        tamanio--;

        return dato;
    }

    // Elimina el último elemento.
    public boolean eliminarUltimo() {

        if (estaVacia()) {
            return false;
        }

        if (cabeza == cola) {
            cabeza = null;
            cola = null;

        } else {

            nodoD eliminada = cola;

            cola = cola.getAnterior();
            cola.setSiguiente(null);

            eliminada.setAnterior(null);
        }

        tamanio--;

        return true;
    }

    // Elimina por posición.
    public int eliminarEnPosicion(int pos) {

        if (pos < 0 || pos >= tamanio) {
            throw new IndexOutOfBoundsException(
                "Posición fuera de rango: " + pos
            );
        }

        if (pos == 0) {
            return eliminarInicio();
        }

        if (pos == tamanio - 1) {

            int dato = cola.getDato();
            eliminarUltimo();

            return dato;
        }

        nodoD objetivo = obtenerNodo(pos);

        int dato = objetivo.getDato();

        nodoD anterior = objetivo.getAnterior();
        nodoD siguiente = objetivo.getSiguiente();

        anterior.setSiguiente(siguiente);
        siguiente.setAnterior(anterior);

        objetivo.setAnterior(null);
        objetivo.setSiguiente(null);

        tamanio--;

        return dato;
    }

    // Elimina la primera aparición de un valor.
    public boolean eliminarPorValor(int x) {

        nodoD actual = cabeza;

        while (actual != null) {

            if (actual.getDato() == x) {

                if (actual == cabeza) {
                    eliminarInicio();

                } else if (actual == cola) {
                    eliminarUltimo();

                } else {

                    nodoD anterior = actual.getAnterior();
                    nodoD siguiente = actual.getSiguiente();

                    anterior.setSiguiente(siguiente);
                    siguiente.setAnterior(anterior);

                    actual.setAnterior(null);
                    actual.setSiguiente(null);

                    tamanio--;
                }

                return true;
            }

            actual = actual.getSiguiente();
        }

        return false;
    }

    // Imprime de cabeza a cola.
    @Override
    public String toString() {

        if (estaVacia()) {
            return "Lista vacía";
        }

        StringBuilder resultado = new StringBuilder();

        nodoD actual = cabeza;

        resultado.append("null <-> ");

        while (actual != null) {

            resultado.append(actual.getDato());

            if (actual.getSiguiente() != null) {
                resultado.append(" <-> ");
            }

            actual = actual.getSiguiente();
        }

        resultado.append(" <-> null");

        return resultado.toString();
    }

    // Imprime de cola a cabeza.
    public String toStringInverso() {

        if (estaVacia()) {
            return "Lista vacía";
        }

        StringBuilder resultado = new StringBuilder();

        nodoD actual = cola;

        resultado.append("null <-> ");

        while (actual != null) {

            resultado.append(actual.getDato());

            if (actual.getAnterior() != null) {
                resultado.append(" <-> ");
            }

            actual = actual.getAnterior();
        }

        resultado.append(" <-> null");

        return resultado.toString();
    }
}
