import java.util.Random;

public class CocheNorte extends Thread{
		
	private Carretera carretera;
	
	public CocheNorte(Carretera carretera) {
		this.carretera = carretera;
		start();
	}
	
	public int PasaCocheNorte() {
		
		Random rdm = new Random();
		int idCoche = rdm.nextInt(1000 + 1);
		int sleepTime = rdm.nextInt(250 - 25 + 1) + 25;
		try {
			sleep (sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("El coche del Norte " + idCoche + " ha entrado en el puente.");
		return idCoche;
	}
	
	public int SaleCocheNorte(int idCoche) {
		
		Random rdm = new Random();
		int sleepTime = rdm.nextInt(250 - 25 + 1) + 25;
		try {
			sleep (sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("El coche del Norte " + idCoche + " ha salido del puente.");
		return idCoche;
	}
	
	public void run() {
		while (true) {
			synchronized (carretera) {
				if (carretera.getcarretera().size() == 0) {
					int idCoche;
					idCoche = PasaCocheNorte();
					carretera.add(idCoche, "Norte");
				} else {
					int idCoche;
					idCoche = carretera.poll("Norte");
					SaleCocheNorte(idCoche);
				}
			}
		}
	}
}
