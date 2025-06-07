package implementacion;

import tda.ConjuntoMamushkaTDA;

public class ConjuntoMamushka implements ConjuntoMamushkaTDA {

    int[] a;
    int cant;

    // Creo que aca me esta faltando algo para poder contar la cantidad de veces que aparece el elemento en el conjunto
    @Override
    public void inicializar() {
        a = new int[100];
        cant = 0;
    }

    @Override
    public void guardar(int dato) {

    }

    @Override
    public void sacar(int dato) {

    }

    @Override
    public int elegir() {
        return 0;
    }

    @Override
    public int perteneceCant(int dato) {
        return 0;
    }

    @Override
    public boolean estaVacio() {
        return false;
    }
}
