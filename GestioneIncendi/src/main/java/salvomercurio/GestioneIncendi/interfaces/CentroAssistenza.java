package salvomercurio.GestioneIncendi.interfaces;

public interface CentroAssistenza {

	void registerObserver(ObserverSmokeLevel o);

	void removeObserver(ObserverSmokeLevel o);

	void notifyObservers();
}
