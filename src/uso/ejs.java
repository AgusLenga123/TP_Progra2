package uso;
import ImplementacionPackage.ColaImplementacion;
import ImplementacionPackage.ConjuntoImplementacion;
import InterfazPackage.ColaTDA;
import InterfazPackage.ConjuntoTDA;
import InterfazPackage.PilaTDA;
import imple.*;
import tda.DiccionarioSimpleTDA;


public class ejs {


    public ConjuntoTDA EjercicioNueve(PilaTDA pila, ColaTDA cola) {
        ConjuntoTDA conjuntoComunes = new Conjunto();
        conjuntoComunes.inicializarConjunto();

        ColaTDA colaAux = new Cola();
        colaAux.inicializarCola();
        PilaTDA pilaAux = new Pila();
        pilaAux.iniciarPila();

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
    public float ejercicio6(PilaTDA pila) {
		int valoresPares = 0;
		int cantidadValores=0;
		while(!pila.pilaVacia()) {
			if(pila.tope()%2==0) valoresPares++;
			cantidadValores++;
			pila.desapilar();
		}
		return (valoresPares*cantidadValores)/100;
	}
	
	public ConjuntoTDA ejercicio7(PilaTDA pila) {
		ConjuntoTDA conjuntoReturn = new ConjuntoImplementacion();
		conjuntoReturn.inicializarConjunto();
		ConjuntoTDA conjuntoAux = new ConjuntoImplementacion();
		conjuntoAux.inicializarConjunto();
		
		while(!pila.pilaVacia()) {
			if(conjuntoAux.pertenece(pila.tope())) {
				conjuntoReturn.agregar(pila.tope());
			}
			else {
				conjuntoAux.agregar(pila.tope());
			}
			pila.desapilar();
		}
		return conjuntoReturn;
	}
	
	public ColaTDA ejercicio8 (ColaTDA cola) {
		ColaTDA colaReturn = new ColaImplementacion();
		colaReturn.inicializarCola();
		ColaTDA colaAux = new ColaImplementacion();
		colaAux.inicializarCola();
		while(!cola.colaVacia()) {
			int valorCola = cola.primero();
			cola.desacolar();
			copiarCola(cola, colaAux);
			if(!elementoEstaEnCola(valorCola, colaAux))colaReturn.acolar(valorCola);	
		}
		return colaReturn;
	}
	
	private boolean elementoEstaEnCola(int valor,ColaTDA cola) {
		while(!cola.colaVacia()) {
			if(cola.primero() == valor) return true;
		}
		return false;
	}
    public static int ejercicio15(GrafoTDA grafo, int verticeEntrada) {
        ConjuntoTDA conjuntoTDA = grafo.vertices();
        int grados=0;
        if (!conjuntoTDA.pertenece(verticeEntrada))return 0;
        conjuntoTDA.sacar(verticeEntrada);
        while(!conjuntoTDA.conjuntoVacio()){
            int verticeDelGrafo = conjuntoTDA.elegir();
            if(grafo.existeArista(verticeEntrada,verticeDelGrafo)){ grados++;}
            conjuntoTDA.sacar(verticeDelGrafo);
        }
        return grados;
    }
    
    public static int ejercicio13(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        if (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio()) {
            if (arbol.raiz() % 2 == 0) return 1;
            else return 0;
        }
        return contarHojasPares(arbol.hijoIzq()) + contarHojasPares(arbol.hijoDer());
    }
    
}
