package com.adam.wodregister;

import com.adam.wodregister.enitity.Wod;
import com.adam.wodregister.repositories.WodRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.*;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class WodregisterApplicationTests {

    @Test
    void contextLoads() {

/*        RestAssured.baseURI="http://localhost:8081";
        given().header("Content-Type", "application/json").log().all()
                .body(
              "{\"name\" : \"Lora\"}"
        ).when().post("/wod").then().log().all().assertThat().statusCode(201);*/
    }

    @Autowired
    private WodRepository wodRepository;
    @Test
    public void testCreate(){
        Wod wod = new Wod();
        wod.setName("Lora");
        wodRepository.save(wod);
        assertNotNull(wodRepository.findById(wod.getId()));
    }

}
