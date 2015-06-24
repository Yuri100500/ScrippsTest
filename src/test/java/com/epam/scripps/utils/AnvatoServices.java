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
import java.util.*;

/**
 * Created by Iurii_Galias on 6/18/2015.
 */
public class AnvatoServices
{
    private static String eventId;
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

        eventId = new JSONObject(response).getJSONObject("schedule").getJSONObject("current_event").getString("event_id");

        String programTitle = new JSONObject(response).getJSONObject("schedule").getJSONObject("current_event").getString("title");

        /*String upNextTitle = new JSONObject(response).getJSONObject("schedule").getJSONObject("next_event").getString("title");
        String prepareUpNextTitle = "{\"name\":\"next\",\"value\":\"" + upNextTitle + "\"}";
        JSONObject upNextTitleJSON = new JSONObject(prepareUpNextTitle);*/



        Iterator<String> res = new JSONObject(response).getJSONObject("schedule").getJSONObject("current_event").getJSONObject("custom_metadata").keys();
        JSONObject customMetaData = new JSONObject(response).getJSONObject("schedule").getJSONObject("current_event").getJSONObject("custom_metadata");

        while (res.hasNext())
        {
            String key = res.next();
            customMetaData.getJSONObject(key);
            JSONObject resultSet = customMetaData.getJSONObject(key);
            results.add(resultSet);
        }

        if(!programTitle.equals("Paid Programming") && "Paid For".equals(getMetadataByName(results,"rovi_programming_show_type")))
        {
            programTitle = "Paid Programming";
            String prepareProgramTitle = "{\"name\":\"title\",\"value\":\"" + programTitle + "\"}";
            JSONObject programTitleJSON = new JSONObject(prepareProgramTitle);
            results.add(programTitleJSON);
        }
        else
        {
            String prepareProgramTitle = "{\"name\":\"title\",\"value\":\"" + programTitle + "\"}";
            JSONObject programTitleJSON = new JSONObject(prepareProgramTitle);
            results.add(programTitleJSON);
        }
        if ("".equals(getMetadataByName(results,"rovi_episode_title")))
        {
            String episodeName = programTitle;
            String prepareEpisodeName = "{\"name\":\"rovi_episode_title\",\"value\":\"" + episodeName + "\"}";
            JSONObject episodeNameJSON = new JSONObject(prepareEpisodeName);
            results.add(episodeNameJSON);
        }
        String upNext = getUpNextMetadata(response);
        String prepareUpNextTitle = "{\"name\":\"next\",\"value\":\"" + upNext + "\"}";
        JSONObject upNextTitleJSON = new JSONObject(prepareUpNextTitle);
        results.add(upNextTitleJSON);

        //==========================================================================================================================================================


        //results.add(upNextTitleJSON);

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


//===============================================================================================


    public static List<JSONObject> allMetadataOnline()
    {
        List<JSONObject> results = new ArrayList<JSONObject>();
        String response = "";
        HttpClient client = new DefaultHttpClient();
        HttpGet anvatoOnlineRequest = new HttpGet("http://tkx2-prod.anvato.net/rest/v2/mcp/events/" + eventId + "/metadata?anvack=anvato_scripps_app_web_prod_0837996dbe373629133857ae9eb72e740424d80a");
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

        if(!programTitleOnline.equals("Paid Programming") && episodeNameOnline.has("rovi_programming_show_type") && "Paid For".equals(episodeNameOnline.getString("rovi_programming_show_type")))
        {
            programTitleOnline = "Paid Programming";
            String prepareEpisodeName = "{\"name\":\"def_title\",\"value\":\"Paid Programming\"}";
            JSONObject episodeNameOnlineJSON = new JSONObject(prepareEpisodeName);
            results.add(episodeNameOnlineJSON);
        }
        if (episodeNameOnline.has("rovi_episode_title"))
        {
            String episodeName = episodeNameOnline.getString("rovi_episode_title");
            String prepareEpisodeName = "{\"name\":\"rovi_episode_title\",\"value\":\"" + episodeName + "\"}";
            JSONObject episodeNameOnlineJSON = new JSONObject(prepareEpisodeName);
            results.add(episodeNameOnlineJSON);
        }
        else
        {
            String prepareEpisodeName = "{\"name\":\"rovi_episode_title\",\"value\":\"" + programTitleOnline + "\"}";
            JSONObject episodeNameOnlineJSON = new JSONObject(prepareEpisodeName);
            results.add(episodeNameOnlineJSON);
        }

        if (episodeNameOnline.has("rovi_long_description"))
        {
            String episodeDescriptionOnline = new JSONObject(response).getJSONObject("event").getJSONObject("custom_metadata_map").getString("rovi_long_description");
            String prepareDescription = "{\"name\":\"rovi_long_description\",\"value\":\"" + episodeDescriptionOnline + "\"}";
            JSONObject episodeDescriptionJSON = new JSONObject(prepareDescription);
            results.add(episodeDescriptionJSON);
        }
        else
        {
            String prepareDescription = "{\"name\":\"rovi_long_description\",\"value\":\"\"}";
            JSONObject episodeDescriptionJSON = new JSONObject(prepareDescription);
            results.add(episodeDescriptionJSON);
        }
        return results;
    }

    public static String getUpNextMetadata(String response)
    {
        List<JSONObject> upNextResults = new ArrayList<JSONObject>();
        Iterator<String> upNextRes = new JSONObject(response).getJSONObject("schedule").getJSONObject("next_event").getJSONObject("custom_metadata").keys();
        JSONObject upNextCustomMetaData = new JSONObject(response).getJSONObject("schedule").getJSONObject("next_event").getJSONObject("custom_metadata");

        while (upNextRes.hasNext())
        {
            String key = upNextRes.next();
            upNextCustomMetaData.getJSONObject(key);
            JSONObject resultSet = upNextCustomMetaData.getJSONObject(key);
            upNextResults.add(resultSet);
        }

        //String upNextTitle = new JSONObject(response).getJSONObject("schedule").getJSONObject("next_event").getString("title");
        String upNextTitle = "";
        if("Paid For".equals(getMetadataByName(upNextResults,"rovi_programming_show_type")))
        {
             upNextTitle = "Paid Programming";
/*            String prepareUpNextTitle = "{\"name\":\"next\",\"value\":\"" + upNextTitle + "\"}";
            JSONObject upNextTitleJSON = new JSONObject(prepareUpNextTitle);
            upNextResults.add(upNextTitleJSON);*/
        }
        else
        {
             upNextTitle = new JSONObject(response).getJSONObject("schedule").getJSONObject("next_event").getString("title");
/*            String prepareUpNextTitle = "{\"name\":\"next\",\"value\":\"" + upNextTitle + "\"}";
            JSONObject upNextTitleJSON = new JSONObject(prepareUpNextTitle);
            upNextResults.add(upNextTitleJSON);*/
        }
        return upNextTitle;
    }
}
