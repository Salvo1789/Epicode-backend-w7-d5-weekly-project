package salvomercurio.GestioneIncendi.entities;

import lombok.Data;
import salvomercurio.GestioneIncendi.exceptions.CommunicationErrorException;
import salvomercurio.GestioneIncendi.exceptions.InvalidCoordinatesException;
import salvomercurio.GestioneIncendi.interfaces.FireAlarm;
import salvomercurio.GestioneIncendi.interfaces.ObserverSmokeLevel;
import salvomercurio.GestioneIncendi.proxy.FireAlarmProxy;

@Data
public class Sonda implements ObserverSmokeLevel {
	private int id;
	private double latitude;
	private double longitude;
	private SmokeDetector smokeDetector;
	private FireAlarm fireAlarm;

	public Sonda(SmokeDetector smokeDetector, int id, double latitude, double longitude)
			throws InvalidCoordinatesException {

		if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180) {
			throw new InvalidCoordinatesException(
					"Coordinate non valide: latitudine = " + latitude + ", longitudine = " + longitude);
		}

		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.fireAlarm = new FireAlarmProxy();
		smokeDetector.registerObserver(this);
	}

	public void update(double smokeLevel) throws CommunicationErrorException {
		System.out.println("Resoconto della sonda num°" + id + ": livello di fumo = " + smokeLevel);
		fireAlarm.triggerAlarm(id, latitude, longitude, smokeLevel);

		if (smokeLevel >= 5) {
			System.out.println("Allarme sonda num° " + id + " :chiamata soccorsi in corso!");
		} else {
			System.out.println("Sonda num° " + id + " :nessun segnale di fumo.");
		}

	}
}
