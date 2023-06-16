package salvomercurio.GestioneIncendi.entities;

import lombok.Data;
import salvomercurio.GestioneIncendi.interfaces.FireAlarm;
import salvomercurio.GestioneIncendi.interfaces.ObserverSmokeLevel;
import salvomercurio.GestioneIncendi.proxy.FireAlarmProxy;

@Data
public class Sonda implements ObserverSmokeLevel {
	private Long id;
	private double latitude;
	private double longitude;
	private SmokeDetector smokeDetector;
	private FireAlarm fireAlarm;

	public Sonda(SmokeDetector smokeDetector, String idSonda, double latitudine, double longitudine) {

		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.fireAlarm = new FireAlarmProxy();
		smokeDetector.registerObserver(this);
	}

	public void update(double smokeLevel) {
		System.out.println("Ricevuto aggiornamento dalla " + id + ": livello di fumo = " + smokeLevel);
		fireAlarm.triggerAlarm(id, latitude, longitude, smokeLevel);

		if (smokeLevel >= 5) {
			System.out.println("Allarme sonda num° " + id + " :chiamata soccorsi in corso!");
		} else {
			System.out.println("Sonda num° " + id + " :nessun segnale di fumo.");
		}

	}
}
