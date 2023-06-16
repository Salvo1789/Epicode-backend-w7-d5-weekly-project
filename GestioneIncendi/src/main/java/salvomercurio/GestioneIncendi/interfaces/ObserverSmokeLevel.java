package salvomercurio.GestioneIncendi.interfaces;

import salvomercurio.GestioneIncendi.exceptions.CommunicationErrorException;

public interface ObserverSmokeLevel {

	void update(double smokeLevel) throws CommunicationErrorException;
}
