package implementacion;

import tda.ConjuntoTDA;
import tda.DiccionarioSimpleModTDA;

public class DiccionarioSimpleModImplementacionInteractiva implements DiccionarioSimpleModTDA {
	
	class Nodo{
		int clave;
		int valor;
		int mod = 0;
		Nodo siguiente;
	}
	Nodo origen;

	@Override
	public void inicializarDiccionario() {
		origen = null;
	}

	@Override
	public void agregar(int clave, int valor) {
		Nodo aux = dameNodo(clave);
		if(aux != null) {
			aux.valor = valor;
			aux.mod++;
			return;
		}
		aux.clave = clave;
		aux.valor = valor;
		aux.siguiente = origen;
		origen = aux;
		
	}

	@Override
	public void eliminar(int clave) {
		if (origen.clave == clave) {
			origen = origen.siguiente;
		}
		else {
			Nodo aux = origen;
			while(aux.siguiente != null && aux.siguiente.clave != clave) {
				aux = aux.siguiente;
			}
			if(aux.siguiente != null) {
				aux.siguiente = aux.siguiente.siguiente;
			}
		}
		
	}

	@Override
	public int recuperar(int clave) {
		Nodo nodoReturn = dameNodo(clave);
		return nodoReturn.valor;
	}

	@Override
	public int recuperarMod(int clave) {
		Nodo nodoReturn = dameNodo(clave);
		return nodoReturn.mod;
	}

	@Override
	public ConjuntoTDA claves() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Nodo dameNodo(int clave) {
		Nodo aux = origen;
		while(aux != null && aux.clave != clave) {
			aux = aux.siguiente;
		}
		return aux;
	}
	
	
	
}


/*
 * public void agregar(int clave, int valor) {
		Nodo aux = dameNodo(clave);
		Nodo backUp = origen;
		if(aux != null) {
			if(aux.clave == clave) {
				aux.valor = valor;
				aux.mod++;
			}
			else {
				while(aux.siguiente != null && aux.clave != clave) {
					aux = aux.siguiente;
				}
				aux.mod++;
				while(backUp.siguiente != null) {
					
				}
			}
			origen = aux;
		}
		
	}
 * 
 * */
