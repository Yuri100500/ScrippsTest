package com.epam.scripps.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;

/**
 * Created by Iurii_Galias on 6/18/2015.
 */
public class AnvatoServices
{
    public static List<JSONObject> allMetadataOffline()
    {
        List<JSONObject> results = new ArrayList<JSONObject>();
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

        String eventId = new JSONObject(response).getJSONObject("schedule").getJSONObject("current_event").getString("event_id");
        String prepareEventId = "{\"name\":\"event\",\"value\":\"" + eventId + "\"}";
        JSONObject eventIdJSON = new JSONObject(prepareEventId);

        String programTitle = new JSONObject(response).getJSONObject("schedule").getJSONObject("current_event").getString("title");
        String prepareProgramTitle = "{\"name\":\"title\",\"value\":\"" + programTitle + "\"}";
        JSONObject programTitleJSON = new JSONObject(prepareProgramTitle);

        String upNextTitle = new JSONObject(response).getJSONObject("schedule").getJSONObject("next_event").getString("title");
        String prepareUpNextTitle = "{\"name\":\"next\",\"value\":\"" + upNextTitle + "\"}";
        JSONObject upNextTitleJSON = new JSONObject(prepareUpNextTitle);

        Iterator<String> res = new JSONObject(response).getJSONObject("schedule").getJSONObject("current_event").getJSONObject("custom_metadata").keys();
        JSONObject customMetaData = new JSONObject(response).getJSONObject("schedule").getJSONObject("current_event").getJSONObject("custom_metadata");

        while (res.hasNext())
        {
            String key = res.next();
            customMetaData.getJSONObject(key);
            JSONObject resultSet = customMetaData.getJSONObject(key);
            results.add(resultSet);
        }

        results.add(eventIdJSON);
        results.add(programTitleJSON);
        results.add(upNextTitleJSON);

        return results;
    }

    public static String getMetadataByName(List<JSONObject> results, String searchCriteria)
    {
        String result = StringUtils.EMPTY;
        ListIterator<JSONObject> listIterator = results.listIterator();
        JSONObject jsonObject;
        while (listIterator.hasNext())
        {
            jsonObject = listIterator.next();
            if (searchCriteria.equals(jsonObject.getString("name")))
            {
                result = jsonObject.getString("value");
            }
        }return result;
    }

    public static List<JSONObject> allMetadataOnline(String showName)
    {
        List<JSONObject> results = new ArrayList<JSONObject>();
        String response = "";
        HttpClient client = new DefaultHttpClient();
        HttpGet anvatoOnlineRequest = new HttpGet("http://tkx2-prod.anvato.net/rest/v2/mcp/events/" + showName + "/metadata?anvack=anvato_scripps_app_web_prod_0837996dbe373629133857ae9eb72e740424d80a");
        try
        {
            HttpResponse execute = client.execute(anvatoOnlineRequest);
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

        String programTitleOnline = new JSONObject(response).getJSONObject("event").getString("def_title");
        String prepareProgramTitle = "{\"name\":\"def_title\",\"value\":\"" + programTitleOnline + "\"}";
        JSONObject programTitleOnlineJSON = new JSONObject(prepareProgramTitle);
        results.add(programTitleOnlineJSON);

        JSONObject episodeNameOnline = new JSONObject(response).getJSONObject("event").getJSONObject("custom_metadata_map");

        if(episodeNameOnline.has("rovi_episode_title"))
        {
            episodeNameOnline.getString("rovi_episode_title");
            String prepareEpisodeName = "{\"name\":\"rovi_episode_title\",\"value\":\"" + episodeNameOnline + "\"}";
            JSONObject episodeNameOnlineJSON = new JSONObject(prepareEpisodeName);
            results.add(episodeNameOnlineJSON);
        }
        else
        {
            episodeNameOnline.getString("rovi_programming_show_type");
            String prepareEpisodeName = "{\"name\":\"rovi_programming_show_type\",\"value\":\"" + episodeNameOnline + "\"}";
            JSONObject episodeNameOnlineJSON = new JSONObject(prepareEpisodeName);
            results.add(episodeNameOnlineJSON);
        }

        // String episodeNameOnline = new JSONObject(response).getJSONObject("event").getJSONObject("custom_metadata_map").getString("rovi_episode_title");
        //String prepareEpisodeName = "{\"name\":\"rovi_episode_title\",\"value\":\"" + episodeNameOnline + "\"}";
        //JSONObject episodeNameOnlineJSON = new JSONObject(prepareEpisodeName);
        //results.add(episodeNameOnlineJSON);

        String episodeDescriptionOnline = new JSONObject("event").getJSONObject("custom_metadata_map").getString("rovi_long_description");
        String prepareDescription = "{\"name\":\"rovi_long_description\",\"value\":\"" + episodeDescriptionOnline + "\"}";
        JSONObject episodeDescriptionJSON = new JSONObject(prepareDescription);
        results.add(episodeDescriptionJSON);

        return results;
    }
}
