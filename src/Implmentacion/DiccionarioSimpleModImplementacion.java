package Implmentacion;

import Interfaz.DiccionarioSimpleModTDA;
import tda.ConjuntoTDA;
import imple.*;

public class DiccionarioSimpleModImplementacion implements DiccionarioSimpleModTDA {

	class Elemento{
		int valor;
		int clave;
		int modificacion=0;
	}
	Elemento[] diccionario;
	int indice = 0;

	@Override
	public void inicializarDiccionario() {
		diccionario = new Elemento[100];
		indice = 0;

	}

	@Override
	public void agregar(int clave, int valor) {
		if(indice == 0) {
			diccionario[0].clave = clave;
			diccionario[0].valor=valor;
			indice++;
		}
		else if(!seEncuentra(clave)) {
			diccionario[indice].clave=clave;
			diccionario[indice].valor=valor;
			indice++;
		}
		else{
			for(int i=0; i<indice-1;i++) {
				if(diccionario[i].clave == clave) {
					diccionario[i].modificacion++;
				}
			}
		}

	}

	@Override
	public void eliminar(int clave) {
		for(int i=0;i<indice-1;i++) {
			if(diccionario[i].clave == clave) {
				diccionario[i] = diccionario[indice-1];
				indice--;
			}
		}

	}

	@Override
	public int recuperar(int clave) {
		for(int i=0; i<indice-1;i++) {
			if(diccionario[i].clave == clave) {
				return diccionario[i].valor;
			}
		}
		return 0;
	}

	@Override
	public int recuperarMod(int clave) {
		for(int i=0; i<indice-1;i++) {
			if(diccionario[i].clave == clave) {
				return diccionario[i].modificacion;
			}
		}
		return 0;
	}

	@Override
	public ConjuntoTDA claves() {
		ConjuntoTDA conjunto = new Conjunto();
		conjunto.inicializarConjunto();
		for(int i=0;i<indice-1;i++) {
			conjunto.agregar(diccionario[i].clave);
		}
		return conjunto;
	}


	private boolean seEncuentra(int clave) {
		for (int i = 0; i < indice-1; i++) {
			if(diccionario[i].clave == clave) {
				return true;
			}
		}
		return false;
	}
	
	
	
}
