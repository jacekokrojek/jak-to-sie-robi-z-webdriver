package providers;

import api.PetStoreClient;
import org.json.JSONArray;

import java.io.IOException;

public class OwnerProvider {

    static PetStoreClient petStoreClient;

    private static void seedData(){
        // delete or create required data
    }

    public static void prepareForTest() throws IOException {
        petStoreClient = new PetStoreClient();
        JSONArray searchResult = petStoreClient.findOwners("Dav");
        if (searchResult.length() != 2) {
            seedData();
        }
        //additional logic
    }
}
