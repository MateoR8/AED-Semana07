package semana_07;

public class ArregloTemperaturas {
	
	//  Atributos privados
	private double[] temperatura;
	private int indice;
	//  Constructor
	public ArregloTemperaturas() {
		temperatura = new double[10];
		indice = 0;
	}
	//  Operaciones públicas básicas
	public int tamanio() {
		return indice;
	}
	public double obtener(int i) {
		return temperatura[i];
	}
	public void adicionar(double numero) {
		if (indice == temperatura.length)
			ampliarArreglo();
		temperatura[indice] = numero;
		indice ++;
	}
	//  Operaciones públicas complementarias
	public void eliminarAlFinal() {
		indice --;
	}
	public void eliminarTodo() {
		indice = 0;
	}
	//  Operaciones privadas
	private void ampliarArreglo() {
		double[] aux = temperatura;
		temperatura = new double[indice + 10];
		for (int i=0; i<indice; i++)
			temperatura[i] = aux[i];
	}
	
	public double temperaturaPromedio() {
		double suma = 0;
		
		for(double valor:temperatura) {
			suma+=valor;
		}
		
		return suma/indice;
	}
	
	public int posPrimeraTemperaturaFebril() {
		for(int i = 0; i<indice; i++) {
			if(temperatura[i] > 37.2) {
				return i;
			}
		}
		return -1;
	}
	
	public int buscarUltimaTemperaturaFebril() {
		for(int i = indice-1; i>=0; i--) {
			if(temperatura[i] > 37.2) {
				return i;
			}
		}
		return -1;
	}
	
	public void remplazarPrimeraTemperaturaFebril() {
		int num1 = posPrimeraTemperaturaFebril();
		int num2 = buscarUltimaTemperaturaFebril();
		
		if(num1 !=-1 && num2 != -1) {
			temperatura[num1] = temperatura[num2];
		}
		
	}
	
	public void remplazarUltimaTemperaturaFebril() {
		
		int num1 = buscarUltimaTemperaturaFebril();
		
		if(num1 != -1) {
			temperatura[num1] = temperaturaPromedio();
		}
		
	}
	
	private void eliminar(int num1) {
		
		for(int i = num1; i<indice-1; i++) {
			temperatura[i] = temperatura[i+1];
		}
		
		indice--;
	}
	
	public void eliminarPrimeraTemperaturaFebril() {
		
		int num1 = posPrimeraTemperaturaFebril();
		
		if(num1 != -1) {
			eliminar(num1);
		}
	}
 	
}