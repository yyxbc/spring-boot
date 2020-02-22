package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionTest {
    public static void main(String[] args) throws Exception {
        String url = "http://localhost:8000/hello/getall";
        URL serverUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) serverUrl.openConnection();
        connection.setRequestMethod("GET");
        if (connection.getResponseCode() != 200) {
            throw new RuntimeException(
                    "HTTP GET Request Failed with Error code : "
                            + connection.getResponseCode());
        }
        BufferedReader responseBuffer = new BufferedReader(
                new InputStreamReader((connection.getInputStream())));
        String output;
        System.out.println("Output from Server:  \n");
        while ((output = responseBuffer.readLine()) != null) {
            System.out.println(output);
        }
        connection.disconnect();
    }

}
