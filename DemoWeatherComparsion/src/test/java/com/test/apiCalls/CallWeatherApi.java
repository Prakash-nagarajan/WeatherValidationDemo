package com.test.apiCalls;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class CallWeatherApi {
	
    public static String getWeatherFromApi(String city) {
//    	System.out.println(call(city));
    	String temperature = null;
    	try {
			JSONObject json = new JSONObject(call(city));
			System.out.println("Temp from API..... "+((JSONObject) json.get("main")).get("temp").toString());
			temperature = ((JSONObject) json.get("main")).get("temp").toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
    	return temperature;
    	
            }
    
    public static String call(String city){
        String weatherJson = null;
    	try {

            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=7fe67bf08c80ded756e598d6f8fedaea");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
//                System.out.println(output);
            	weatherJson=output;
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
    	return weatherJson;

    }
}
