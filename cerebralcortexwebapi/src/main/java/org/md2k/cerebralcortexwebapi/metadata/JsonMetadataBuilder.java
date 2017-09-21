package org.md2k.cerebralcortexwebapi.metadata;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ali on 9/21/17.
 */

public class JsonMetadataBuilder {

    /*default_metadata = {
        "identifier": "0bf18489-bc04-42d9-8ded-dc54e686a67a",
                "name": "string",
                "data_descriptor": [
        {
            "unit": "string",
                "type": "string"
        }
    ],
        "owner": "7547cb22-c1a9-42ca-ac73-a7ddcc8a0a30",
                "execution_context": {}
    }*/
    public static String buildJsonMetadata(){
        //JSONObject json = new JSONObject();

        Gson gson1 = new Gson();
        String jsonStr = "{'keyww': 'valuedd'}";
        JSONObject json1 = gson1.fromJson(jsonStr, JSONObject.class);


        /*try{
            json.put("identifier", "student");
            json.put("name", "student");
            json.put("owner", "student");

            JSONArray array = new JSONArray();
            JSONObject data_descriptor = new JSONObject();
            data_descriptor.put("unit", "test");
            data_descriptor.put("type", "dd");
            array.put(data_descriptor);
            json.put("data_descriptor", array);

            JSONObject execution_context = new JSONObject();
            execution_context.put("execution_context", array);
            json.put("execution_context", execution_context);

        }catch (JSONException je){

        }*/
        return json1.toString();
    }
}
