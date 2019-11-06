

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileReader;


public class MergeJSONObjects {

    public static void main(String[] args) {

      JSONParser parser = new JSONParser();
      JSONObject json1 = new JSONObject();
      JSONObject json2 = new JSONObject();
      JSONObject json3 = new JSONObject();

try {
  Object obj1 = parser.parse (new FileReader ("/home/fauzan/Desktop/jsonnn/data1.txt"));
  json1 = (JSONObject) obj1 ;

  Object obj2 = parser.parse (new FileReader ("/home/fauzan/Desktop/jsonnn/data1.txt"));
  json2 = (JSONObject) obj2 ;

  Object obj3 = parser.parse (new FileReader ("/home/fauzan/Desktop/jsonnn/data1.txt"));
  json3 = (JSONObject) obj3 ;

}catch(Exception e){
  e.printStackTrace ();
}


      System.out.println("json1: " + json1);
      System.out.println("json2: " + json2);
      System.out.println ("json3" +json3 );

      JSONObject mergedJSON = mergeJSONObjects(json1, json2, json3);
      System.out.println("\nmergedJSON: " + mergedJSON);
    }

  public static JSONObject mergeJSONObjects(JSONObject json1, JSONObject json2, JSONObject json3) {
    JSONObject mergedJSON = new JSONObject();
    try {
      mergedJSON = new JSONObject(json1, JSONObject.getNames(json1));
      for (String Key : JSONObject.getNames(json2)) {
        mergedJSON.put(Key, json2.get(Key));
      }

      for (String Key : JSONObject.getNames(json3)) {
        mergedJSON.put(Key, json3.get(Key));
      }

    } catch (JSONException e) {
      throw new RuntimeException("JSON Exception" + e);
    }
    return mergedJSON;
  }
}
