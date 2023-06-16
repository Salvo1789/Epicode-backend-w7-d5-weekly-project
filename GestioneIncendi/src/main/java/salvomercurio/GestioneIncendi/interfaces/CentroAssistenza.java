package salvomercurio.GestioneIncendi.interfaces;

import salvomercurio.GestioneIncendi.exceptions.CommunicationErrorException;

public interface CentroAssistenza {

	void registerObserver(ObserverSmokeLevel o);

	void removeObserver(ObserverSmokeLevel o);

	void notifyObservers() throws CommunicationErrorException;
}
