package com.epam.scripps.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Iurii_Galias on 6/18/2015.
 */
public class AnvatoServices
{
    public boolean checkingMetadataOfflineService(String programTitle, String episodeName, String programDescription)
    {
        String response = "";
        HttpClient client = new DefaultHttpClient();
        HttpGet anvatoOfflineRequest = new HttpGet("http://tkx2-prod.anvato.net/rest/v2/now/cooking?anvack=anvato_scripps_app_web_prod_0837996dbe373629133857ae9eb72e740424d80a");
        try
        {
            HttpResponse execute = client.execute(anvatoOfflineRequest);
            InputStream content = execute.getEntity().getContent();

            BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
            String s;
            while ((s = buffer.readLine()) != null)
            {
                response += s;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JSONObject res = new JSONObject(response);
        Object anvatoProgramTitle = res.getJSONObject("schedule").getJSONObject("current_event").getString("title");
        Object anvatoEpisodeName = res.getJSONObject("schedule").getJSONObject("current_event").getJSONObject("custom_metadata").getJSONObject("22").getString("value");
        Object anvatoProgramDescription = res.getJSONObject("schedule").getJSONObject("current_event").getJSONObject("custom_metadata").getJSONObject("27").getString("value");
        //Object d = res.getJSONObject("schedule").getJSONObject("current_event").getJSONArray("custom_metadata");
        //System.out.println(response);
        //System.out.println(d);

        System.out.println("Show: "+ anvatoProgramTitle +"\n" +"Serial: " + anvatoEpisodeName +"\n"+ "Description: "+ anvatoProgramDescription);

        if (programTitle == anvatoProgramTitle && episodeName == anvatoEpisodeName && programDescription == anvatoProgramDescription)
        {
            return true;
        }
        return false;
    }
}
