package views;

import model.User;

import org.h2.mvstore.MVMap;

import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class LoginSubmit extends DynamicWebPage
{

	public LoginSubmit(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("LoginSubmit.html"))
		{
			String username = toProcess.params.get("username");
			String password = toProcess.params.get("password");

			MVMap<String, User> users = db.s.openMap("Users");
			
			if(!users.containsKey(username))
			{
				String stringToSendToWebBrowser = "";
				stringToSendToWebBrowser += "<!DOCTYPE html>\n";
				stringToSendToWebBrowser += "<html>\n";
				stringToSendToWebBrowser += "  <head>\n";
				stringToSendToWebBrowser += " <script> alert('Unknown username');</script>"
						+ "<meta http-equiv=\"refresh\" content=\"0; url=login.html\" />\n";
				stringToSendToWebBrowser += "  </head>\n";
				stringToSendToWebBrowser += "</html>\n";
				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
				return true;
			}
			
			User user = users.get(username);
			
			//if(user.password==password)
			if(!user.password.contentEquals(password))
			{
				String stringToSendToWebBrowser = "";
				stringToSendToWebBrowser += "<!DOCTYPE html>\n";
				stringToSendToWebBrowser += "<html>\n";
				stringToSendToWebBrowser += "  <head>\n";
				stringToSendToWebBrowser += " <script> alert('Incorrect details. Please try again.');</script>"
						+ "<meta http-equiv=\"refresh\" content=\"0; url=login.html\" />\n";
				stringToSendToWebBrowser += "  </head>\n";
				stringToSendToWebBrowser += "</html>\n";
				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
				return true;
			}
			
			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<!DOCTYPE html>\n";
			stringToSendToWebBrowser += "<html>\n";
			stringToSendToWebBrowser += "  <head>\n";
			stringToSendToWebBrowser += "  <script>\n";
			stringToSendToWebBrowser += "      function setCookie(cname, cvalue, exdays)\n";
			stringToSendToWebBrowser += "      {\n";
			stringToSendToWebBrowser += "          var d = new Date();\n";
			stringToSendToWebBrowser += "          d.setTime(d.getTime() + (exdays*24*60*60*1000));\n";
			stringToSendToWebBrowser += "          var expires = 'expires='+d.toUTCString();\n";
			stringToSendToWebBrowser += "          document.cookie = cname + '=' + cvalue + ';' + expires + ';path=/';\n";
			stringToSendToWebBrowser += "      }\n";
			stringToSendToWebBrowser += "      setCookie('username','"+username+"',365);\n";
			stringToSendToWebBrowser += "      setCookie('password','"+password+"',365);\n";			
			stringToSendToWebBrowser += "  </script>\n";
			stringToSendToWebBrowser += "<meta http-equiv=\"refresh\" content=\"0; url=index.html\"/>\n";
			stringToSendToWebBrowser += "  </head>\n";
			stringToSendToWebBrowser += "</html>\n";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		return false;
	}

}
