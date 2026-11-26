
package listas_doblementeligadas;

public class Listas_doblementeLigadas {

    public static void main(String[] args) {

        listaDoble lista = new listaDoble();

        System.out.println("==================================");
        System.out.println("   LISTA DOBLEMENTE LIGADA");
        System.out.println("==================================");

        // 1. Insertar al inicio.
        System.out.println("\n1. INSERTAR AL INICIO");

        lista.insertarAlInicio(20);
        lista.insertarAlInicio(10);

        System.out.println("Lista: " + lista);

        // 2. Insertar al final.
        System.out.println("\n2. INSERTAR AL FINAL");

        lista.insertarAlFinal(40);
        lista.insertarAlFinal(50);

        System.out.println("Lista: " + lista);

        // 3. Insertar en una posición.
        System.out.println("\n3. INSERTAR EN POSICION");

        lista.insertarEnPosicion(2, 30);

        System.out.println("Lista: " + lista);

        // 4. Recorrer en ambos sentidos.
        System.out.println("\n4. RECORRIDO EN AMBOS SENTIDOS");

        System.out.println("Adelante: " + lista);
        System.out.println("Atras: " + lista.toStringInverso());

        // 5. Buscar.
        System.out.println("\n5. BUSCAR ELEMENTO");

        System.out.println("¿Existe el 30? " + lista.buscar(30));
        System.out.println("¿Existe el 90? " + lista.buscar(90));

        // 6. Actualizar.
        System.out.println("\n6. ACTUALIZAR ELEMENTO");

        lista.actualizar(2, 35);

        System.out.println("Lista: " + lista);

        // 7. Eliminar por valor.
        System.out.println("\n7. ELIMINAR POR VALOR");

        System.out.println("¿Se elimino el 35? "
                + lista.eliminarPorValor(35));

        System.out.println("Lista: " + lista);

        // 8. Eliminar por posición.
        System.out.println("\n8. ELIMINAR EN POSICION");

        System.out.println("Dato eliminado: "
                + lista.eliminarEnPosicion(1));

        System.out.println("Lista: " + lista);

        // 9. Eliminar último.
        System.out.println("\n9. ELIMINAR ULTIMO");

        System.out.println("¿Se elimino? "
                + lista.eliminarUltimo());

        System.out.println("Lista: " + lista);

        // 10. Eliminar inicio.
        System.out.println("\n10. ELIMINAR INICIO");

        System.out.println("Dato eliminado: "
                + lista.eliminarInicio());

        System.out.println("Lista: " + lista);

        // 11. Insertar ordenadamente.
        System.out.println("\n11. INSERTAR ORDENADO");

        listaDoble ordenada = new listaDoble();

        ordenada.insertarOrdenado(40);
        ordenada.insertarOrdenado(10);
        ordenada.insertarOrdenado(30);
        ordenada.insertarOrdenado(20);
        ordenada.insertarOrdenado(50);
        ordenada.insertarOrdenado(30);

        System.out.println("Lista ordenada: " + ordenada);

        System.out.println("Recorrido inverso: "
                + ordenada.toStringInverso());

        // 12. Consultar tamaño.
        System.out.println("\n12. CONSULTAR TAMANO");

        System.out.println("Cantidad de elementos: "
                + ordenada.getTamanio());

        // 13. Probar eliminación de un valor inexistente.
        System.out.println("\n13. ELIMINAR VALOR INEXISTENTE");

        System.out.println("¿Se elimino el 100? "
                + ordenada.eliminarPorValor(100));

        // 14. Comprobar lista vacía.
        System.out.println("\n14. COMPROBAR LISTA VACIA");

        listaDoble vacia = new listaDoble();

        System.out.println("¿Esta vacia? " + vacia.estaVacia());

        System.out.println("Eliminar ultimo: "
                + vacia.eliminarUltimo());

        System.out.println("\n==================================");
        System.out.println("       FIN DE LAS PRUEBAS");
        System.out.println("==================================");
    }
}
