package semana_07;

public class ArregloCodigos {
	
	private int codigo[];
	private int indice;
	
	public ArregloCodigos() {
		codigo = new int[10];
		indice = 0;
	}
	
	public int tamanio() {
		return indice;
	}
	
	public int obtener(int i) {
		return codigo[i];
	}
	
	private void ampliarArreglo() {
		int aux[] = codigo;
		codigo = new int[indice + 10];
		for (int i=0; i<indice; i++)
			codigo[i] = aux[i];
	}
	
	public void adicionar(int num) {
		
		if (indice == codigo.length) {
			ampliarArreglo();
		}
		codigo[indice] = num;
		indice++;
	}
	
	private void intercambiar(int num1, int num2) {
		int aux = codigo[num1];
		codigo[num1] = codigo[num2];
		codigo[num2] = aux;
	}
	
	public void intercambiarSegPen() {
		int num1 = indice-2;
		int num2 = 1;
		intercambiar(num1, num2);
	}
	
	private void eliminar(int num) {
		for(int i = num; i<indice-1;i++) {
			codigo[i] = codigo[i+1];
		}
		indice--;
	}
	
	public void eliminarPrimero() {
		int num1 = 0;
		eliminar(num1);
	}
	
	public int posCodigo() {
		for(int i = indice-1; i >=0; i--) {
			if(codigo[i] >= 1000 && codigo[i] <= 1111) {
				return i;
			}
		}
		return -1;
	}
	
	public void intercambiarCodigo() {
		int num1 = posCodigo();
		int num2 = 2;
		
		if(num1 != -1) {
			intercambiar(num1, num2);
		}
	}
	
	public void eliminarCodigo() {
		int num1 = posCodigo();
		if(num1 != -1) {
			eliminar(num1);
		}
	}
}