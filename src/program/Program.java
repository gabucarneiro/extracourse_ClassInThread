package program;

import entities.ClasseParaThread;
import entities.ClasseParaThread2;

public class Program {

	public static void main(String[] args) {
		
		for(int i = 1; i<3; i++) {
			ClasseParaThread classeParaThread = new ClasseParaThread(i);
			classeParaThread.start();
			
		}
		for(int i = 7; i<10; i++) {
			ClasseParaThread2 classeParaThread2 = new ClasseParaThread2(i);
			Thread thread = new Thread(classeParaThread2);
			thread.start();
			
			/*Ao chamar o método .join() na instância de Thread, o sistema aguardará
			 * concluir a thread para então dar seguimento aos processos restantes.
			 *Ao chamar o método .isAlive() na instância de Thread, o sistema retornará
			 * true caso a Thread ainda */
			 try { 
				 if(i == 9) {
					 thread.join(); 
					 System.out.println(thread.isAlive());
				 } 
			 }
			 catch (InterruptedException e) {
				 e.printStackTrace();
			 }			 
		}
		
		/*Outra forma de criar uma thread e já passar o código inline é instanciar
		 * a classe Thread, e dentro do chamado já criar um Runnable sobreescrevendo
		 * o método run().
		 *Não deve esquecer de chamar a instância de Thread com o método .start();
		 **/
		Thread td = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.println("Thread inline: " + i);
					try {
						Thread.sleep(i*500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		td.start();
	}
}
