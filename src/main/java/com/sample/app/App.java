package com.sample.app;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	public static void main(String[] args) throws Exception {

		SpringApplication.run(App.class, args);
		 URL url = new URL("https://jsonplaceholder.typicode.com/posts");
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        // Set the request method to POST.
	        connection.setRequestMethod("POST");
	        // Set the request headers.
	        connection.setRequestProperty("Content-Type", "application/json");
	        // Set the request body.
	        String body = "{\"title\": \"My first post\", \"body\": \"This is my first post on JSONPlaceholder.\"}";
	        connection.setDoOutput(true);
	      //  connection.getOutputStream().write(body.getBytes());
	        // Execute the request.
	        int statusCode = connection.getResponseCode();
	        System.out.println("Status code: " + statusCode);
	        // Get the response body.
	        String responseBody = new String(connection.getInputStream().readAllBytes());
	        System.out.println("Response body: " + responseBody);
	}
}