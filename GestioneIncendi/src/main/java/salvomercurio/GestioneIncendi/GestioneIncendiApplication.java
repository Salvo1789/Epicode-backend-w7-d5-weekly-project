package salvomercurio.GestioneIncendi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import salvomercurio.GestioneIncendi.entities.SmokeDetector;
import salvomercurio.GestioneIncendi.entities.Sonda;
import salvomercurio.GestioneIncendi.exceptions.CommunicationErrorException;
import salvomercurio.GestioneIncendi.exceptions.InvalidCoordinatesException;
import salvomercurio.GestioneIncendi.factory.SmokeDetectorFactory;

@SpringBootApplication
public class GestioneIncendiApplication {

	public static void main(String[] args) throws CommunicationErrorException {
		SpringApplication.run(GestioneIncendiApplication.class, args);

		SmokeDetector smokeDetector1 = SmokeDetectorFactory.createSmokeDetector();
		SmokeDetector smokeDetector2 = SmokeDetectorFactory.createSmokeDetector();
		SmokeDetector smokeDetector3 = SmokeDetectorFactory.createSmokeDetector();

		try {
			Sonda sonda1 = new Sonda(smokeDetector1, 100341, 32.1865, 17.9963);
			Sonda sonda2 = new Sonda(smokeDetector2, 100342, 15.0497, 86.0432);

			System.out.println("Sonda 1");
			System.out.println("Livello del fumo: 1");
			smokeDetector1.setSmokeLevel(sonda1, 1);
			System.out.println("Livello del fumo: 3");
			smokeDetector1.setSmokeLevel(sonda1, 3);
			System.out.println("Livello del fumo: 5");
			smokeDetector1.setSmokeLevel(sonda1, 5);
			System.out.println("Livello del fumo: 7");
			smokeDetector1.setSmokeLevel(sonda1, 7);
			System.out.println("Livello del fumo: 9");
			smokeDetector1.setSmokeLevel(sonda1, 9);

			System.out.println("Sonda 2");
			System.out.println("Livello del fumo: 1");
			smokeDetector2.setSmokeLevel(sonda2, 1);
			System.out.println("Livello del fumo: 3");
			smokeDetector2.setSmokeLevel(sonda2, 3);
			System.out.println("Livello del fumo: 5");
			smokeDetector2.setSmokeLevel(sonda2, 5);
			System.out.println("Livello del fumo: 7");
			smokeDetector2.setSmokeLevel(sonda2, 7);
			System.out.println("Livello del fumo: 9");
			smokeDetector2.setSmokeLevel(sonda2, 9);
		} catch (InvalidCoordinatesException e) {
			e.printStackTrace();
		}

	}
}
