package org.acme;

import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@QuarkusTest
public class TestResourceTest {
	
	@Test
	public void testTimestampEndpoint() {
		final TestEntity testEntity = given()
				                              .when().get("/test/timestamp")
				                              .as(TestEntity.class);
		assertNotNull(testEntity);
		assertNotNull(testEntity.getTimestamp());
//		Log.infof("Received test entity: [%s]", testEntity);
	}
	
}