package entities;

public class ClasseParaThread extends Thread{
	//Vantagem: menos uma linha no código principal.
	//Desvantagem: Java não permite Herança multipla.
	
	private int idThread; //não necessário, apenas para identificar a Thread ao printar
		
	public ClasseParaThread(int idThread) {
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
