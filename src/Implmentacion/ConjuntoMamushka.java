package Implmentacion;

import Interfaz.ConjuntoMamushkaTDA;

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
       a[cant] = dato;
       cant++;
    }

    @Override
    public void sacar(int dato) {
        int i = 0;
        while (i < cant && a[i] != dato){
            i++;
        }
        if (i < cant){
            a[i] = a[cant -1];
            cant--;
        }
    }

    @Override
    public int elegir() {
        int max = cant-1;
        int min = 0;
        int pos = (int)(Math.random() * (max-min+1) + min);
        return a[pos];
    }

    @Override
    public int perteneceCant(int dato) {
        int i = 0;
        int pertenececant = 0;
        while (i < cant){
            if (a[i] == dato){
                pertenececant++;
            }
            i++;
        }
        return pertenececant;
    }

    @Override
    public boolean estaVacio() {
        return (cant == 0);
    }
}
