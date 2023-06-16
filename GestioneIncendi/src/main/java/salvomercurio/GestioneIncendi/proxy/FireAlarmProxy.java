package salvomercurio.GestioneIncendi.proxy;

import salvomercurio.GestioneIncendi.interfaces.FireAlarm;
import salvomercurio.GestioneIncendi.util.FireAlarmLevelImpl;

public class FireAlarmProxy implements FireAlarm {
	private FireAlarm fireAlarm;

	public FireAlarmProxy() {
		this.fireAlarm = new FireAlarmLevelImpl();
	}

	@Override
	public void triggerAlarm(Long id, double latitude, double longitude, double smokeLevel) {
		if (smokeLevel > 5) {
			fireAlarm.triggerAlarm(id, latitude, longitude, smokeLevel);
		}

	}
}
