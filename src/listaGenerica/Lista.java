package listaGenerica;

public class Lista {
    private Nodo primero;

    public Lista() {
        primero = null;
    }

    public Nodo leerPrimero() {
        return primero;
    }

    public Lista insertarCabezaLista(Object entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;
        return this;
    }

    // inserta un elemento a partir de anterior
    public Lista insertarLista(Nodo anterior, Object entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;
        return this;
    }

    // elimina el elemento entrada
    public void eliminar(Object entrada) {
        Nodo actual, anterior;
        //boolean encontrado;
        actual = primero;
        anterior = null;
        //encontrado = false;
        // Bucle de búsqueda
        while ((actual != null) && !actual.dato.equals(entrada)) {
            if (!actual.dato.equals(entrada)) {
                anterior = actual;
                actual = actual.enlace;
            }
        }
        if (actual != null) {
            // Se distingue entre que el nodo sea el cabecera
            // o del resto de la lista
            if (actual == primero) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
            actual = null;
        }
    }

    // busca el elemento destino
    public Nodo buscarLista(Object destino) {
        Nodo indice;
        for (indice = primero; indice != null; indice = indice.enlace)
            if (indice.dato.equals(destino))
                return indice;
        return null;
    }

    // recorre la lista y muestra cada dato
    public void visualizar() {
        Nodo n;
        n = primero;
        while (n != null) {
            System.out.print(n.dato + " ");
            n = n.enlace;
        }
    }
}
