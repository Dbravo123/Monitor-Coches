import java.util.Random;

public class CocheSur extends Thread {
	
	private Carretera carretera;
	
	public CocheSur(Carretera carretera) {
		this.carretera = carretera;
		start();
	}
	
	public int PasaCocheSur() {
		
		Random rdm = new Random();
		int idCoche = rdm.nextInt(1000 + 1);
		int sleepTime = rdm.nextInt(100 - 25 + 1) + 25;
		try {
			sleep (sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("El coche del Sur " + idCoche + " ha entrado en el puente.");
		return idCoche;
	}
	
	public int SaleCocheSur(int idCoche) {
		
		Random rdm = new Random();
		int sleepTime = rdm.nextInt(100 - 25 + 1) + 25;
		try {
			sleep (sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("El coche del Sur " + idCoche + " ha salido del puente.");
		return idCoche;
	}
	
	public void run() {
		while (true) {
			synchronized (carretera) {
				if (carretera.getcarretera().size() == 0) {
					int idCoche;
					idCoche = PasaCocheSur();
					carretera.add(idCoche, "Sur");
				} else {
					int idCoche;
					idCoche = carretera.poll("Sur");
					SaleCocheSur(idCoche);
				}
			}
		}
	}
}
