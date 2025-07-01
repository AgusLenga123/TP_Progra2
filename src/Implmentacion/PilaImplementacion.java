package Implmentacion;

import Interfaz.PilaTDA;

public class PilaImplementacion implements PilaTDA {
	class Nodo {
		int valor;
		Nodo sig;
	}
	Nodo primero;

	@Override
	public void iniciarPila() {
		primero = null;
	}

	@Override
	public void apilar(int x) {
		Nodo aux = new Nodo();
		aux.valor = x;
		aux.sig = primero;
		primero= aux;
		
	}

	@Override
	public void desapilar() {
		primero = primero.sig;
	}

	@Override
	public int tope() {
		return primero.valor;
	}

	@Override
	public boolean pilaVacia() {
		return primero == null;
	}

}
