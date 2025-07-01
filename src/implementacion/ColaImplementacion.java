package implementacion;

import tda.ColaTDA;

public class ColaImplementacion implements ColaTDA {

	int []a; 
	 int indice; 
	  
	 public void inicializarCola() { 
	 
	  a = new int [100]; 
	  indice = 0; 
	 } 
	public void acolar(int x) { 
	  for (int i = indice - 1; i >= 0; i--) {
	   a[i +1] = a[i]; 
	  }  
	  a[0] = x; 
	  indice++; 
	 } 
	 public void desacolar() { 
	  indice--; 
	 } 
	 public boolean colaVacia() { 
	  return (indice == 0); 
	 } 
	 public int primero() { 
	  return a[indice - 1]; 
	 }
	 
}
