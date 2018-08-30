package views;

import org.h2.mvstore.MVMap;

import model.User;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class SignUpSubmit extends DynamicWebPage
{

	public SignUpSubmit(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("SignUpSubmit.html"))
		{
			User anythingYouLike = new User();
			anythingYouLike.username = toProcess.params.get("username");
			anythingYouLike.password = toProcess.params.get("password");
			boolean hasUppercase = !anythingYouLike.password.equals(anythingYouLike.password.toLowerCase());
			boolean hasLowercase = !anythingYouLike.password.equals(anythingYouLike.password.toUpperCase());
			boolean hasNumber   =  anythingYouLike.password.matches(".*\\d+.*");
			boolean hasSpecial   = !anythingYouLike.password.matches("[A-Za-z0-9 ]*");
			System.out.println(hasUppercase);
			System.out.println(hasLowercase);
			System.out.println(hasNumber);
			System.out.println(hasSpecial);

			MVMap<String, User> users = db.s.openMap("Users");
			
			if(users.containsKey(anythingYouLike.username))
			{
				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, "<html><head><script> alert('Error: Username already taken'); </script><meta http-equiv=\"refresh\" content=\"0; url=signup.html\" /></head></html>" );
				return true;
			} else if(anythingYouLike.password.length() <= 8 || !hasNumber || !hasLowercase || !hasUppercase || !hasSpecial) {
				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, "<html><head><script> alert('Error: Password too weak'); </script><meta http-equiv=\"refresh\" content=\"0; url=signup.html\" /></head></html>" );
				return true;
			}
			users.put(anythingYouLike.username, anythingYouLike);
			//Commit the changes to save to disk
			db.commit();
			
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, 
			"<html><head><script> alert('Account created'); </script><meta http-equiv=\"refresh\" content=\"0; url=login.html\" /></head></html>" );
			return true;
		}
		return false;
	}

}
