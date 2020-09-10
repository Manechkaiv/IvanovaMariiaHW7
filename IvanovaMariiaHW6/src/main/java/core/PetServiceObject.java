package core;

import beans.PetModel;
import beans.PetNotFoundModel;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import java.net.URI;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;
import static java.util.Locale.ENGLISH;

public class PetServiceObject {

    public static URI petStore_Uri;
    private static ResourceBundle resourceBundle;
    private RequestSpecification requestSpecification;
    private PetModel pet;

    private PetServiceObject() {
    }

    static {
        resourceBundle = ResourceBundle.getBundle("api", ENGLISH);
        petStore_Uri = URI.create("https://petstore.swagger.io/v2/swagger.json");
    }


        public PetServiceObject(PetModel pet) {
            requestSpecification = new RequestSpecBuilder()
                    .addHeader("api_key", resourceBundle.getString("key"))
                    .setBaseUri("https://petstore.swagger.io")
                    .setBasePath("/v2/pet")
                    .setContentType(ContentType.JSON)
                    .log(LogDetail.ALL).build();
            RestAssured.responseSpecification = new ResponseSpecBuilder()
                    .expectContentType(ContentType.JSON)
                    .expectResponseTime(Matchers.lessThan(15000L))
                    .build();
            RestAssured.defaultParser = Parser.JSON;
            this.pet = pet;
        }

        public PetModel addNewPet() {
            return given(requestSpecification)
                    .body(pet)
                    .post().as(PetModel.class);
        }

        public void deletePet() {
            given(requestSpecification)
                    .delete(String.valueOf(pet.getId()));
        }

        public PetModel updatePet() {
            return given(requestSpecification)
                    .body(pet)
                    .put().as(PetModel.class);
        }

        public Object getPet() {
            Response response = given(requestSpecification).get(String.valueOf(pet.getId()));
            if (response.statusCode() == 200) {
                return response.as(PetModel.class);
            } else {
                return response.as(PetNotFoundModel.class);
            }
        }

        public PetNotFoundModel getDeletedPet() {
            return given(requestSpecification)
                    .get(String.valueOf(pet.getId()))
                    .then()
                    .statusCode(404)
                    .and()
                    .extract().response().as(PetNotFoundModel.class);
        }

    }