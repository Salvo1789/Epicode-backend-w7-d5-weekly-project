package salvomercurio.GestioneIncendi.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import salvomercurio.GestioneIncendi.exceptions.CommunicationErrorException;
import salvomercurio.GestioneIncendi.interfaces.CentroAssistenza;
import salvomercurio.GestioneIncendi.interfaces.ObserverSmokeLevel;

@Data
public class SmokeDetector implements CentroAssistenza {
	private double smokeLevel;
	public List<ObserverSmokeLevel> observers;

	public SmokeDetector() {
		this.observers = new ArrayList<>();
		this.smokeLevel = 0;
	}

	@Override
	public void registerObserver(ObserverSmokeLevel o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(ObserverSmokeLevel o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() throws CommunicationErrorException {
		for (ObserverSmokeLevel observer : observers) {
			observer.update(smokeLevel);
		}
	}

	public void setSmokeLevel(Sonda sonda, double smokeLevel) throws CommunicationErrorException {
		this.smokeLevel = smokeLevel;
		notifyObservers();
	}
}
