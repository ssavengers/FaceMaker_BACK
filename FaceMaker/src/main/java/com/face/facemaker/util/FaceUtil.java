package com.face.facemaker.util;

import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;

public class FaceUtil {
	// Replace <Subscription Key> with your valid subscription key.
	private static final String subscriptionKey = "b289648b9a6444878d72f8485e569fa0";
	private static final String uriBase = "https://westcentralus.api.cognitive.microsoft.com/face/v1.0/detect";
	//private static final String imageWithFaces = "{\"url\":\"file:///C:/Users/ELIJAH/Desktop/FaceMaker_BACK/FaceMaker/src/main/webapp/img/salah.JPG\"}";
	//private static final String imageWithFaces = "{\"url\":\"https://dimg.donga.com/wps/NEWS/IMAGE/2019/11/05/98221000.2.jpg\"}";
	//private static final String imageWithFaces = "{\"url\":\"http://127.0.0.1:9090/face/img/salah.JPG\"}";
	
	
	public static void main(String[] args) {
		CloseableHttpClient httpclient = HttpClients.createDefault();

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
			//File file = new File("C:\\Users\\ELIJAH\\Desktop\\FaceMaker_BACK\\FaceMaker\\src\\main\\webapp\\img\\salah.JPG");
			File file = new File("./src/main/webapp/img/salah.JPG");
			FileEntity reqEntity = new FileEntity(file, ContentType.APPLICATION_OCTET_STREAM);
			request.setEntity(reqEntity);
			
			HttpResponse response = httpclient.execute(request);
			HttpEntity entity = response.getEntity();
			System.out.println(response.getStatusLine());
			
			if(entity!= null) {
				System.out.println(EntityUtils.toString(entity));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
