package org.acme;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.Set;

@Path("/test")
public class TestResource {
	
	@Inject
	Validator validator;

    @GET
    @Path("/timestamp")
    @Produces (MediaType.APPLICATION_JSON)
    public Uni<TestEntity> createTimestamp() {
		
        Log.info("Received request");
		final TestEntity testEntity = new TestEntity();
		Log.infof("Created test entity [%s]", testEntity);
		
		final Set<ConstraintViolation<TestEntity>> violations = validator.validate(testEntity);
		if (violations.isEmpty()) {
			Log.infof("No constraint violations found");
			return Uni.createFrom().item(testEntity);
		} else {
			Log.errorf("Found constraint violation(s): [%s]", violations);
			throw new InternalServerErrorException("Constraint violation");
		}
		
    }
}