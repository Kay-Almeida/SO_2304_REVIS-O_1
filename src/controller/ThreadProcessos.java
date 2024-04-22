package controller;

import java.util.concurrent.Semaphore;

public class ThreadProcessos extends Thread {
	
	int id; 
	Semaphore semaforo; 
	
	public ThreadProcessos (int id, Semaphore semaforo) {
		this.id = id; 
		this.semaforo = semaforo;
	}
	public void run () {
		int tempo = (int) ((Math.random()*116)+4);		
		try {
			semaforo.acquire();
			execução(tempo); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	}
	public void execução(int tempo) {
		System.out.println("O processo "+ id+ " está em execução por "+ tempo+ " segundos");
		int tempmili = tempo*1000; 
		try {
			sleep(tempmili);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O processo "+ id+ " terminou a execução ");
	}
}
