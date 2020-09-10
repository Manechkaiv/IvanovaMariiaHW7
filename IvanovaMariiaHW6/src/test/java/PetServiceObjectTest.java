
import beans.PetModel;
import beans.PetNotFoundModel;
import core.PetServiceObject;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PetServiceObjectTest {

    @Test
    public void petTest() {

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://petstore.swagger.io")
                .setContentType(ContentType.JSON)
                .addHeader("api_key", "hfjkhf").build();
    }

    @Test
    public void testAddNewPet() {

        PetModel pet1 = new PetModel(1, "Murzik", null, new ArrayList<>(), new ArrayList<>(), PetModel.Status.AVAILABLE.name());
        PetModel petResponse1 = new PetServiceObject(pet1).addNewPet();

        PetModel pet2 = new PetModel(2, "Sharik", null, new ArrayList<>(), new ArrayList<>(), PetModel.Status.AVAILABLE.name());
        PetModel petResponse2 = new PetServiceObject(pet2).addNewPet();

        Assert.assertEquals(petResponse1, pet1);
        Assert.assertEquals(petResponse2, pet2);

    }


    @Test
    public void testUpdatePet() {

        PetModel pet1 = new PetModel(1, "Misha", null, new ArrayList<>(), new ArrayList<>(), PetModel.Status.AVAILABLE.name());
        PetServiceObject petServiceObject = new PetServiceObject(pet1);
        petServiceObject.addNewPet();

        pet1.setStatus(PetModel.Status.UNAVAILABLE.name());

        PetModel petResponse = petServiceObject.updatePet();

        Assert.assertEquals(petResponse, pet1);

    }

    @Test
    public void testDeletePet() {

        PetModel pet1 = new PetModel(1, "Murzik", null, new ArrayList<>(), new ArrayList<>(), PetModel.Status.AVAILABLE.name());
        PetServiceObject petServiceObject = new PetServiceObject(pet1);
        petServiceObject.addNewPet();
        petServiceObject.deletePet();
        PetNotFoundModel petModel = (PetNotFoundModel) petServiceObject.getPet();

        Assert.assertEquals(petModel, new PetNotFoundModel.Builder()
                .withCode(1)
                .withMessage("Pet not found")
                .withType("error")
                .build());
    }

}


