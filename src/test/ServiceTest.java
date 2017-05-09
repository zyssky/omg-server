package test;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

public class ServiceTest {
	
//	@Test
//	public void testPostUser(){
//		Client client = Client.create();	
//		WebResource resource = client.resource("http://localhost:8080/omg/rest/user/register");
//		Form form = new Form();
//		form.add("username", "user_two");
//		form.add("password", "password2");
//		ClientResponse response = resource.type(MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.APPLICATION_JSON)
//				   .post(ClientResponse.class, form);
//		
//		System.out.println(response.getEntity(String.class));
//	}
	
//	@Test
//	public void testLoginUser(){
//		Client client = Client.create();	
//		WebResource resource = client.resource("http://localhost:8080/omg/rest/user/login");
//		Form form = new Form();
//		form.add("username", "user_two");
//		form.add("password", "password1");
//		ClientResponse response = resource.type(MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.APPLICATION_JSON)
//				   .post(ClientResponse.class, form);
//		
//		System.out.println(response.getEntity(String.class));
//	}
	
	@Test
	public void testGetByToken(){
		Client client = Client.create();	
		WebResource resource = client.resource("http://localhost:8080/omg/rest/user");
		Form form = new Form();
		form.add("token", "3f6fd659-f718-4d8c-8c70-96692efe040");
		ClientResponse response = resource.type(MediaType.APPLICATION_FORM_URLENCODED).accept(MediaType.APPLICATION_JSON)
				   .post(ClientResponse.class, form);
		
		System.out.println(response.getEntity(String.class));
	}
	
//	@Test
//	public void testGetUser(){
//
//		Client client = Client.create();	
//		WebResource resource = client.resource("http://localhost:8080/omg/rest/user");
//		try {
//			String ansString = resource.accept(MediaType.APPLICATION_JSON).get(String.class);
//		System.out.println(ansString);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//	}
}
