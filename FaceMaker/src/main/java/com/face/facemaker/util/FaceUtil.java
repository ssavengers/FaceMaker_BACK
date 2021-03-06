package com.face.facemaker.util;

import java.io.File;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

//detect face using Face API from MS
public class FaceUtil {
	// Replace <Subscription Key> with your valid subscription key.
	private static final String subscriptionKey = "b289648b9a6444878d72f8485e569fa0";
	private static final String uriBase = "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect";
	
	public static void main(String[] args) {
		//detectFace();
	}
	
	public static String detectFace(String src) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String jsonString = "";
		System.out.println("DETECT FACE METHOD");
		
		try {
			URIBuilder builder = new URIBuilder(uriBase);

			// Request parameters. All of them are optional.
			builder.setParameter("returnFaceId", "true");
			builder.setParameter("returnFaceLandmarks", "false");
			builder.setParameter("returnFaceAttributes", "age,emotion");

			// Prepare the URI for the REST API call.
			URI uri = builder.build();
			HttpPost request = new HttpPost(uri);

			// Request headers.
			request.setHeader("Content-Type", "application/octet-stream");
			request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);
			
			//Request Body
			//File file = new File("./src/main/webapp/img/salah.JPG");
			File file = new File(src);
			FileEntity reqEntity = new FileEntity(file, ContentType.APPLICATION_OCTET_STREAM);
			request.setEntity(reqEntity);
			
			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();
			System.out.println("[debug] " + response.getStatusLine());
			
			
		    if (entity != null)
            {
                // Format and display the JSON response.
                System.out.println("REST Response:\n");

                jsonString = EntityUtils.toString(entity).trim();
            }
		}
        catch (Exception e)
        {
            // Display error message.
            System.out.println(e.getMessage());
        }
		return jsonString;
    }
}
