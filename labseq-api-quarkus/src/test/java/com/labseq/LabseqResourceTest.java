package com.labseq;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class LabseqResourceTest {
    @Test
    void testEndpoint() {
        given()
          .when().get("/labseq/3")
          .then()
             .statusCode(200);
    }

}