package rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entity.Comment;
import entity.User;
import model.CommentApi;
import model.UserApi;

@Path("/comment")
public class CommentService {
	@GET
	@Path("{court}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getComments (@PathParam("court") String courtTitle){
		return new CommentApi().getComments(courtTitle);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("publish")
	public String publishComment(@FormParam("token") String token , @FormParam("date") String dateString,
			@FormParam("content") String content ,@FormParam("id") String idString, @FormParam("courtTitle") String courtTitle){
		long userId = new UserApi().getUserIdFromToken(token);
		if(userId<0)
			return "{\"status\":0}";
		SimpleDateFormat simpleDateFormatForDay = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		long id = 0;
		try {
			id = Long.parseLong(idString);
			date = simpleDateFormatForDay.parse(dateString);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		User user = new UserApi().getUser(userId);
		if(null==user)
			return "{\"status\":0}";
		String username = user.getUsername();
		Comment comment = new Comment(id,username,courtTitle,content,date);
		int res = new CommentApi().addComment(comment);
		if(res == 1)
			return "{\"status\":1}";
		else {
			return "{\"status\":0}";
		}
	}
	
}
