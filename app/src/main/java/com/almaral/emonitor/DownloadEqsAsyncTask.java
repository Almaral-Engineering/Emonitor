package com.almaral.emonitor;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class DownloadEqsAsyncTask extends AsyncTask<URL, Void, String> {

    public DownloadEqsInterface delegate;

    public interface DownloadEqsInterface {
        void onEqsDownloaded(String eqsData);
    }

    @Override
    protected String doInBackground(URL... urls) {
        String eqData = "";

        try {
            eqData = downloadData(urls[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return eqData;
    }

    @Override
    protected void onPostExecute(String eqData) {
        super.onPostExecute(eqData);

        delegate.onEqsDownloaded(eqData);
    }

    private String downloadData(URL url) throws IOException {
        String jsonResponse = "";
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.connect();

            inputStream = urlConnection.getInputStream();
            jsonResponse = readFromStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }

            if (inputStream != null) {
                inputStream.close();
            }
        }

        return jsonResponse;
    }

    private String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader
                    = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }

        return output.toString();
    }
}
