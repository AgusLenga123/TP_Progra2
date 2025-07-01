package implementacion;

import tda.MultiPilaTDA;
import tda.PilaTDA;

public class MultiPilaImplementacion implements MultiPilaTDA{
	private PilaTDA pila;
	@Override
	public void apilar(PilaTDA valores) {
		while(!valores.pilaVacia()) {
			pila.apilar(valores.tope());
			valores.desapilar();
		}
		
	}

	@Override
	public void desapilar(PilaTDA valores) {
		PilaTDA pilaBackUp = new PilaImplementacion();
		pilaBackUp.iniciarPila();
		copiarPila(pila,pilaBackUp);
		while(!valores.pilaVacia()) {
			if(pila.tope() != valores.tope()) {
				copiarPila(pilaBackUp, pila);
				System.out.print("las pilas no son iguales");
				return;
			}
			pila.desapilar();
			valores.desapilar();
		}
		
	}

	@Override
	public PilaTDA tope(int cantidad) {
		PilaTDA pilaReturn = new PilaImplementacion();
		pilaReturn.iniciarPila();
		PilaTDA pilaCopia = new PilaImplementacion();
		pilaCopia.iniciarPila();
		copiarPila(pila, pilaCopia);
		while(!pilaCopia.pilaVacia()) {
			pilaReturn.apilar(pilaCopia.tope());
			pilaCopia.desapilar();
		}
		return pilaReturn;
	}

	@Override
	public void inicializarPila() {
		pila.iniciarPila();
	}

	@Override
	public boolean pilaVacia() {
		return pila.pilaVacia();
	}
	
	private void copiarPila(PilaTDA pilaOriginal, PilaTDA pilaCopia) {
		PilaTDA pilaAux = new PilaImplementacion();
		pilaAux.iniciarPila();
		while(!pilaOriginal.pilaVacia()) {
			pilaAux.apilar(pilaOriginal.tope());
			pilaOriginal.desapilar();
		}
		while(!pilaAux.pilaVacia()) {
			pilaOriginal.apilar(pilaAux.tope());
			pilaCopia.apilar(pilaAux.tope());
			pilaAux.desapilar();
		}
	}

}
