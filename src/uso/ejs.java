package uso;
import imple.*;
import tda.*;


public class ejs {


    public ConjuntoTDA EjercicioNueve(PilaTDA pila, ColaTDA cola) {
        ConjuntoTDA conjuntoComunes = new Conjunto();
        conjuntoComunes.inicializarConjunto();

        ColaTDA colaAux = new Cola();
        colaAux.inicializarCola();
        PilaTDA pilaAux = new Pila();
        pilaAux.inicializarPila();

        // Usamos una pila auxiliar para no perder la pila original
        while (!pila.pilaVacia()) {
            int elementoPila = pila.tope();
            pilaAux.apilar(elementoPila);
            boolean existe = false;
            while (!cola.colaVacia()) {
                int elementoCola = cola.primero();
                if (elementoPila == elementoCola) {
                    existe = true;
                }
                colaAux.acolar(elementoCola);
                cola.desacolar();
            }
            if (existe) {
                conjuntoComunes.agregar(elementoPila);
            }
            // Restauramos la cola original desde la auxiliar
            while (!colaAux.colaVacia()) {
                int elem = colaAux.primero();
                cola.acolar(elem);
                colaAux.desacolar();
            }
            pila.desapilar();
        }

        // Restauramos la pila original desde la auxiliar
        while (!pilaAux.pilaVacia()) {
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }

        return conjuntoComunes;
    }

    public DiccionarioSimpleTDA ejercicioDiez(PilaTDA pila) {
        DiccionarioSimpleTDA diccionario = new DiccionarioSimple();
        diccionario.inicializarDiccionario();

        ConjuntoTDA elementosContados = new Conjunto();
        elementosContados.inicializarConjunto();

        PilaTDA pilaAux = new Pila();
        pilaAux.inicializarPila();

        // Copiamos pila sin perderla
        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pilaAux.apilar(elemento);
            pila.desapilar();
        }

        // Ahora procesamos la pila desde la auxiliar
        while (!pilaAux.pilaVacia()) {
            int elemento = pilaAux.tope();
            pila.apilar(elemento); // restauramos pila original

            // Check si el elemento de la pila ya fue agregado al dic
            if (!elementosContados.pertenece(elemento)) {
                int contador = 0;

                // Segunda pasada para contar todas las apariciones
                PilaTDA pilaContar = new Pila();
                pilaContar.inicializarPila();

                while (!pila.pilaVacia()) {
                    int elem = pila.tope();
                    pila.desapilar();
                    pilaContar.apilar(elem);

                    if (elem == elemento) {
                        contador++;
                    }
                }

                // Restauramos la pila original
                while (!pilaContar.pilaVacia()) {
                    pila.apilar(pilaContar.tope());
                    pilaContar.desapilar();
                }

                diccionario.agregar(elemento, contador);
                elementosContados.agregar(elemento);
            }
            pilaAux.desapilar();
        }
        return diccionario;
    }

    public ColaTDA ejercicioOnce(DiccionarioMultipleTDA dic){
        ColaTDA colaRespuesta = new Cola();
        colaRespuesta.inicializarCola();

        ConjuntoTDA conjuntoAux = new Conjunto();
        conjuntoAux.inicializarConjunto();

        ConjuntoTDA claves = dic.claves();

        while (!claves.conjuntoVacio()){
            int clave = claves.elegir();

            ConjuntoTDA valores = dic.recuperar(clave);

            while (!valores.conjuntoVacio()){
                int valor = valores.elegir();
                if (!conjuntoAux.pertenece(valor)){
                    colaRespuesta.acolar(valor);
                }
                conjuntoAux.agregar(valor);
                valores.sacar(valor);
            }
            claves.sacar(clave);
        }
        return colaRespuesta;
    }


    public int EjercicioDoce(ABBTDA arbol){
        int resultado = 0;
        if (!arbol.arbolVacio()) {
            int valorActual = arbol.raiz();
            if (valorActual % 2 != 0) {
                resultado += valorActual;
            }
            resultado += EjercicioDoce(arbol.hijoIzq());
            resultado += EjercicioDoce(arbol.hijoDer());
        }
        return resultado;
    }

}
