package ie.app.api;

import android.util.Log;

import java.lang.reflect.Type;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import ie.app.models.Donation;

public class DonationApi {

	public static List<Donation> getAll(String call) {
		String json = Rest.get(call);

		String result = null;
		try {
			JSONObject jobj = new JSONObject(json);
			result = jobj.getString("data");
		} catch (JSONException e) {
			e.printStackTrace();
		}


		Type collectionType = new TypeToken<List<Donation>>(){}.getType();

		return new Gson().fromJson(result, collectionType);
	}
	public static List<Donation> get(String call,String id) {
		String json = Rest.get(call + "/" + id);
		Log.v("donate", "JSON RESULT : " + json);

		String result = null;
		try {
			JSONObject jobj = new JSONObject(json);
			result = jobj.getString("data");
		} catch (JSONException e) {
			e.printStackTrace();
		}


		Type collectionType = new TypeToken<List<Donation>>(){}.getType();
		return new Gson().fromJson(result, collectionType);
	}

	public static String deleteAll(String call) {
		String result = Rest.delete(call);
		Log.v("delete donation result","response : " + result);
		return result;
	}

	public static String delete(String call, String id) {
		return Rest.delete(call + id);
	}

	public static String insert(String call,Donation donation) {		
		Type objType = new TypeToken<Donation>(){}.getType();
		String json = new Gson().toJson(donation, objType);
  
		return Rest.post(call,json);
	}
}
