package salvomercurio.GestioneIncendi.util;

import salvomercurio.GestioneIncendi.interfaces.FireAlarm;

public class FireAlarmLevelImpl implements FireAlarm {

	@Override
	public void triggerAlarm(Long id, double latitude, double longitude, double smokeLevel) {
		String url = "http://host/alarm?idsonda=" + id + "&lat=" + latitude + "&lon=" + longitude + "&smokelevel="
				+ smokeLevel;
	}
}
