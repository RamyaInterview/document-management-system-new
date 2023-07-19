package com.sample.app.controller;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.sample.app.dto.PostDocument;
import com.sample.app.entity.Document;
import com.sample.app.service.DocumentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @ApiOperation(value = "Upload a document")
    @PostMapping("/{userId}")
	public Document uploadDocument(
            @ApiParam(value = "User ID") @PathVariable Long userId,
            @ApiParam(value = "Document file") @RequestParam("file") MultipartFile file
    ) {
        return documentService.uploadDocument(userId, file);
    }

    @ApiOperation(value = "Delete a document")
    @DeleteMapping("/{documentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDocument(
            @ApiParam(value = "Document ID") @PathVariable Long documentId
    ) {
        documentService.deleteDocument(documentId);
    }

    @ApiOperation(value = "Get all user documents")
    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Document> getUserDocuments(
            @ApiParam(value = "User ID") @PathVariable Long userId
    ) {
        return documentService.getUserDocuments(userId);
    }

	/*
	 * @RequestMapping(value = "/Posts", method = RequestMethod.POST) public String
	 * createPost() throws Exception { URL url = new
	 * URL("https://jsonplaceholder.typicode.com/posts"); HttpURLConnection
	 * connection = (HttpURLConnection) url.openConnection(); // Set the request
	 * method to POST. connection.setRequestMethod("POST"); // Set the request
	 * headers. connection.setRequestProperty("Content-Type", "application/json");
	 * // Set the request body. String body =
	 * "{\"title\": \"My first post\", \"body\": \"This is my first post on JSONPlaceholder.\"}"
	 * ; connection.setDoOutput(true);
	 * connection.getOutputStream().write(body.getBytes()); // Execute the request.
	 * int statusCode = connection.getResponseCode();
	 * System.out.println("Status code: " + statusCode); // Get the response body.
	 * String responseBody = new String(connection.getInputStream().readAllBytes());
	 * System.out.println("Response body: " + responseBody); return
	 * responseBody.toString(); }
	 */
    @ApiOperation(value = "Create a post")
    @RequestMapping(value="/posts", method=RequestMethod.POST)
   // @PostMapping("/posts/")
	public String postDocument(@PathVariable Long documentId, @PathVariable String TitleofPost, @PathVariable String BodyofPost) throws Exception {
		/*
		 * RestTemplate restTemplate = new RestTemplate(); URI uri = new
		 * URI("https://jsonplaceholder.typicode.com/posts"); PostDocument postdocu =
		 * new PostDocument(); postdocu.setBody("THis is body post");
		 * postdocu.setTitle("This is title"); postdocu.setDocumentId(documentId);
		 * ResponseEntity<PostDocument> result = restTemplate.postForEntity(uri,
		 * postdocu, PostDocument.class); return result;
		 */
    //	assertEquals(201, result.getStatusCodeValue());
    //	assertNotNull(result.getBody().getDocumentId());
    	// return new ResponseEntity<Object>(documentService.createPost(documentId), HttpStatus.CREATED);
    	//return documentService.createPost(documentId);
    	
    	
    	
	/*
	 * URL url = new
	 * URL("https://jsonplaceholder.typicode.com/posts?documentId=documentId");
	 * HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //
	 * Set the request method to POST. connection.setRequestMethod("POST"); // Set
	 * the request headers. connection.setRequestProperty("Content-Type",
	 * "application/json"); // Set the request body. String body =
	 * "{\"title\": \"My first post\", \"body\": \"This is my first post on JSONPlaceholder.\"}"
	 * ;
	 * 
	 * connection.setDoOutput(true);
	 * connection.getOutputStream().write(body.getBytes()); // Execute the request.
	 * int statusCode = connection.getResponseCode();
	 * System.out.println("Status code: " + statusCode); // Get the response body.
	 * String responseBody = new String(connection.getInputStream().readAllBytes());
	 * System.out.println("Response body: " + responseBody); return responseBody;
	 */
    	long docu = +documentId;
    	System.out.println("my dodfsdfsldfhsdlfhsd" +docu);
    	 final String POST_PARAMS = "{\n" + "\"userId\": 10,\r\n" +
    		        "    \"id\": 101,\r\n" +
    		        "    \"title\": \"Test Title\",\r\n" +
    		        "    \"body\": \"Test Body\"" + "\n}";
    		    System.out.println(POST_PARAMS);
    		    URL obj = new URL("https://jsonplaceholder.typicode.com/posts");
    		    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
    		    postConnection.setRequestMethod("POST");
    		    postConnection.setRequestProperty("userId", "1234");
    		    postConnection.setRequestProperty("Content-Type", "application/json");


    		    postConnection.setDoOutput(true);
    		    postConnection.getOutputStream().write(POST_PARAMS.getBytes()); // Execute the request.
    			 int statusCode = postConnection.getResponseCode();
    			 System.out.println("Status code: " + statusCode); // Get the response body.
    			 String responseBody = new String(postConnection.getInputStream().readAllBytes());	
    			 return responseBody;

    }
    
   
}
