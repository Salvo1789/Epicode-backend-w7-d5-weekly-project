package salvomercurio.GestioneIncendi.interfaces;

public interface FireAlarm {

	void triggerAlarm(Long id, double latitude, double longitude, double smokeLevel);

}
