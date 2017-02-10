package com.company;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public class Main {

    static final OkHttpClient client = new OkHttpClient();
    static final Gson gson = new Gson();

    public static void main(String[] args)
    {

        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void run() throws Exception {
        Request request = new Request.Builder()
                .url("http://words.bighugelabs.com/api/2/58606b9276def31b50024d96dc811976/awesome/json")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!response.isSuccessful()) try {
            throw new IOException("Unexpected code " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(response.toString());
        System.out.println(response.body().string());

        Gisty gist = gson.fromJson(response.body().charStream(), Gisty.class);
        for (Map.Entry<String, GistFile> entry : gist.files.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue().content);
        }
    }
    class Gisty {
        Map<String, GistFile> files;
    }

    class GistFile {
        String content;
    }
}
