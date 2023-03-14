package com.dawapal.epcr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.Patient;

@SpringBootApplication
public class DawapalECprHapiFhirClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DawapalECprHapiFhirClientApplication.class, args);
        
        // Create a context
      FhirContext ctx = FhirContext.forR4();

      // Create a client
      IGenericClient client = ctx.newRestfulGenericClient("https://hapi.fhir.org/baseR4");

      // Read a patient with the given ID
      Patient patient = client.read().resource(Patient.class).withId("example").execute();

      // Print the output
      String string = ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(patient);
      System.out.println(string);
	}

}
