package com.hemalatha.jcg.json;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonPatch;
import javax.json.JsonReader;

public class JsonPatchTest {

    public static void main(String[] args) {
         JsonPatchTest test = new JsonPatchTest();
         test.testJsonDiff();
    }

    public void testJsonDiff() {
        JsonObject actual = Json.createObjectBuilder().add("a", 21)
                .add("b", 1).build();

        try (JsonReader reader = Json.createReader(this.getClass().getResourceAsStream("/expected.json"))) {
            JsonObject expected = reader.readObject();
            JsonPatch diff = Json.createDiff(expected, actual);
            System.out.println(diff.toString());
            System.out.println(diff.toJsonArray().isEmpty());
        }
    }
}
