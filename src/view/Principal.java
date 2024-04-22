package view;

import java.util.concurrent.Semaphore;

import controller.ThreadProcessos;

public class Principal {
	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore (1); 
		
		for(int id = 1; id<21; id++) {
			ThreadProcessos tc = new ThreadProcessos(id, semaforo); 
			tc.start();
		}		
	}

}
