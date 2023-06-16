package salvomercurio.GestioneIncendi.interfaces;

public interface FireAlarm {

	void triggerAlarm(int id, double latitude, double longitude, double smokeLevel);

}
