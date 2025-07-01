
package Implmentacion;
import Interfaz.ConjuntoEspecialTDA;
//Ejercicio 1

public class ConjuntoEspecial implements ConjuntoEspecialTDA {

    int[] a;
    int cant;

    @Override
    public void inicializarConjunto() {
        a = new int[100];
        cant = 0;
    }

    @Override
    public Respuesta agregar(int valor) {

        Respuesta res = new Respuesta();

        if (!this.pertenece(valor)) {
            a[cant] = valor;
            cant++;
            res.error = false;
        } else {
            res.error = true;
        }
        return res;
    }

    @Override
    public Respuesta sacar(int valor) {
        Respuesta res = new Respuesta();

        int i = 0;
        while (i < cant && a[i] != valor) {
            i++;
        }
        if (i < cant){ //elemento encontrado
            a[i] = a[cant-1];
            cant--;
            res.error = false;
        } else{
            res.error = true;
        }

        return res;
    }

    @Override
    public Respuesta elegir() {
        Respuesta res = new Respuesta();

        if (!this.conjuntoVacio()){
            int max = cant-1;
            int min = 0;
            int pos = (int)(Math.random() * (max-min+1) + min);
            res.error = false;
            res.rta = a[pos];
        } else {
            res.error = true;
        }
        return res;
    }

    @Override
    public boolean pertenece(int valor) {
        int i = 0;
        while (i < cant && a[i] != valor) {
            i++;
        }
        return (i < cant);
    }

    @Override
    public boolean conjuntoVacio() {
        return (cant == 0);
    }
}
