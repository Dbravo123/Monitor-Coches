import java.util.LinkedList;
import java.util.Queue;

public class Carretera {
	
	private final int CarreteraSize = 1;
	private Queue<Integer> carretera= new LinkedList<Integer>();
	public Queue<Integer> getcarretera() {
		return carretera;
	}
	public synchronized void add(int idCoche, String dirección) {
		
		while (carretera.size() == CarreteraSize) {
			System.out.println("El puente está ocupado por un coche.");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		carretera.add(idCoche);
		System.out.println("El coche " + idCoche + " está recorriendo el puente desde el " + dirección + ".");
		notifyAll();
	}
	
	public synchronized int poll(String dirección) {
		
		while (carretera.size() == 0) {
			System.out.println("El puente está vacío actualmente.");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		int idCoche = carretera.poll();
		System.out.println("El coche " + idCoche + " va a salir del puente desde el " + dirección + ".");
		notifyAll();
		return idCoche;
	}
}
