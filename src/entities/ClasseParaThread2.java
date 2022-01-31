package entities;

public class ClasseParaThread2 implements Runnable{
	//Vantagem: como Java não permite Herança multipla, implementar a Interface não
	// irá "consumir" a herança da classe - muitas Interfaces podem ser implementadas.
	//Desvantagem: mais uma linha no código principal, pela necessidade de criar instância
	// da classe Thread e passar uma instância da classe que implementa Runnable.
	
	private int idThread; //não necessário, apenas para identificar a Thread ao printar
		
	public ClasseParaThread2(int idThread) {
		this.idThread = idThread;
	}

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(idThread + " Thread - counter: " + i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
