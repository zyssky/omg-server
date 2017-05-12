package rest;

import java.util.List;

import javax.security.auth.login.LoginContext;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import entity.User;
import model.UserApi;

@Path("/user")
public class UserService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers(){
		return new UserApi().getUsers();
	}
	
	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public String login(@FormParam("username") String username,
			@FormParam("password") String password){
		JSONObject jsonObject = new JSONObject();
		String token = new UserApi().login(username,password);
		
		try {
			if(token!=null){
				jsonObject.put("status", 1);
				jsonObject.put("token", token);
			}else{
				jsonObject.put("status", 0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return jsonObject.toString();
	}
	
	@POST
	@Path("register")
	@Produces(MediaType.APPLICATION_JSON)
	public String addUser(@FormParam("username") String username , @FormParam("password") String password){
		User user  = new User();
		user.setPassword(password);
		user.setUsername(username);
		String token = new UserApi().add(user);
		JSONObject jsonObject = new JSONObject();
		try {
			if(token!=null){
				jsonObject.put("status", 1);
				jsonObject.put("token", token);
			}else{
				jsonObject.put("status", 0);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@FormParam("token") String token){
		long userId = new UserApi().getUserIdFromToken(token);
		User user = null;
		if(userId>0)
		    user = new UserApi().getUser(userId);
		return user;
	}
}
