package views;

import java.util.List;

import org.h2.mvstore.MVMap;

import model.Animal;
import model.Comment;
import model.User;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class EditAccountPage extends DynamicWebPage
{
		MVMap<Integer, Signup> database = db.s.openMap("user");
		private Signup user =  database.get(1);
		
	public EditAccountPage(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("EditAccountPage.html"))
		{

			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<!doctype html>\n";
			stringToSendToWebBrowser += "<html>\n";
			stringToSendToWebBrowser += "<head>\n";
			stringToSendToWebBrowser += "  <meta charset=\"utf-8\">\n";
			stringToSendToWebBrowser += "  <meta http-equiv=\"Content-Type\" content=\"text/html\">\n";
			stringToSendToWebBrowser += "  <title>My Account</title>\n";
			stringToSendToWebBrowser += "  <link rel=\"shortcut icon\" type=\"image/png\" href=\"plant.png\">\n";
			stringToSendToWebBrowser += "  <link rel=\"stylesheet\" type=\"text/css\" media=\"all\" href=\"styles.css\">\n";
			stringToSendToWebBrowser += "  <script type=\"text/javascript\" src=\"jquery-1.10.2.min.js\"></script>\n";
			stringToSendToWebBrowser += "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
			stringToSendToWebBrowser += "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "  <link href=\"https://fonts.googleapis.com/css?family=Titillium+Web\" rel=\"stylesheet\">\n";
			stringToSendToWebBrowser += "  <script src=\"main.js\"></script>\n";
			stringToSendToWebBrowser += "</head>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<body>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<!-- Side bar navigation menu -->\n";
			stringToSendToWebBrowser += "<div id=\"mySidenav\" class=\"sidenav\">\n";
			stringToSendToWebBrowser += "  <a href=\"index.html\"><i class=\"fa fa-home\"></i>Home</a>  \n";
			stringToSendToWebBrowser += "  <a href=\"editaccountpage.html\"><i class=\"fa fa-user-circle\"></i>My Account</a>\n";
			stringToSendToWebBrowser += "  <a href=\"AddAnimal.html\"><i class=\"fa fa-pagelines\"></i>Add EcoSystem</a>\n";
			stringToSendToWebBrowser += "  <a href=\"searchpage.html\"><i class=\"fa fa-globe\"></i>Search</a>\n";
			stringToSendToWebBrowser += "  <a href=\"contactpage.html\"><i class=\"fa fa-envelope\"></i>Contact Us</a>\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "  <script>\n";
			stringToSendToWebBrowser += " if(document.cookie.split(\";\")[0].split(\"=\")[1].length > 0){\n";
			stringToSendToWebBrowser += " document.getElementById(\"mySidenav\").innerHTML += \"<a href='logout.html'><i class='fa fa-sign-out'></i>Logout</a>\";\n";
			stringToSendToWebBrowser += " }else{\n";
			stringToSendToWebBrowser += " document.getElementById(\"mySidenav\").innerHTML += \"<a href='login.html'><i class='fa fa-sign-in'></i>Login</a>\";\n}";
			stringToSendToWebBrowser += "  </script>\n";
			stringToSendToWebBrowser += "<!-- The white box in the middle -->\n";
			stringToSendToWebBrowser += "<div id=\"main\">\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<span style=\"font-size:25px; cursor:pointer; color: black; position: fixed\" onclick=\"openNav()\">&#9776; Menu</span>\n";
			stringToSendToWebBrowser += "  <h1 style=\"text-align:center; margin-top: 150px\">WikiEcoSystem</h1>\n";
			stringToSendToWebBrowser += "</div>\t\n";
			stringToSendToWebBrowser += "  <div id=\"w\">\n";
			stringToSendToWebBrowser += "    <div id=\"content\" class=\"clearfix\">\n";
			stringToSendToWebBrowser += "      <div id=\"userphoto\"><img src=\"avatar.png\" alt=\"default avatar\"></div>\n";
			stringToSendToWebBrowser += "      <h1>User Profile</h1>\n";
			stringToSendToWebBrowser += "      <nav id=\"profiletabs\">\n";
			stringToSendToWebBrowser += "        <ul class=\"clearfix\">\n";
			stringToSendToWebBrowser += "          <li><a href=\"#bio\" class=\"sel\">Bio</a></li>\n";
			stringToSendToWebBrowser += "          <li><a href=\"#settings\">Settings</a></li>\n";
			stringToSendToWebBrowser += "        </ul>\n";
			stringToSendToWebBrowser += "      </nav>\n";
			stringToSendToWebBrowser += "      \n";
			stringToSendToWebBrowser += "      <section id=\"bio\">\n";
			stringToSendToWebBrowser += "\t<div>\n";
			stringToSendToWebBrowser += "\t\t<h3>Recent comments</h3>\n";
			
			MVMap<Integer, Comment> database = db.s.openMap("Comment");
			List<Integer> keys = database.keyList();
			for(int i : keys) {
				stringToSendToWebBrowser += " <div class='comment'><div class='user'><img src=\"avatar.png\" alt=\"default avatar\"><p>"+database.get(i).getComment()+"</p></div><p>"+database.get(i).getUser()+"</p></div>\n";
			}
			
			stringToSendToWebBrowser += "\t</div>\t\t\n";			
			stringToSendToWebBrowser += "      </section>\n";
			stringToSendToWebBrowser += "      \n";
			stringToSendToWebBrowser += "      <section id=\"settings\" class=\"hidden\">\n";
			stringToSendToWebBrowser += "\t\t\n";
			stringToSendToWebBrowser += "<form class=\"form-horizontal setting\" method=\"GET\" action=\"EditAccountPage.html/submit\" role=\"form\">\n";
			stringToSendToWebBrowser += "\t\t<h3>Change user settings</h3>\n";
			stringToSendToWebBrowser += "<p>Username: <input name=\"username\" id=\"username\" type=\"text\" value=\"\"/></p>\n";
			stringToSendToWebBrowser += "<p>Password: <input name=\"password\" id=\"password\" type=\"password\" value=\"\"/></p>\n";
			stringToSendToWebBrowser += "<input type=\"hidden\" name=\"oldUsername\" id=\"oldUsername\" type=\"password\" value=\"\"/>\n";
			stringToSendToWebBrowser += "<input type=\"submit\" />\n";
			stringToSendToWebBrowser += "\t\t</form>\n";
			stringToSendToWebBrowser += "<script>\n";
			stringToSendToWebBrowser += "document.getElementById('oldUsername').value = document.cookie.split(\";\")[0].split(\"=\")[1];\n";
			stringToSendToWebBrowser += "document.getElementById('username').value = document.cookie.split(\";\")[0].split(\"=\")[1];\n";
			stringToSendToWebBrowser += "document.getElementById('password').value = document.cookie.split(\";\")[1].split(\"=\")[1];\n";
			stringToSendToWebBrowser += "</script>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "      </section>\n";
			stringToSendToWebBrowser += "    </div>\n";
			stringToSendToWebBrowser += "  </div>\n";
			stringToSendToWebBrowser += "</form>\n"; 
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "\t\n";
			stringToSendToWebBrowser += "<div class=\"footer\">\n";
			stringToSendToWebBrowser += " <img src=\"world-globe.gif\" alt=\"Tree\" height=\"100\" width=\"100\">\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "  \n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<script type=\"text/javascript\">\n";
			stringToSendToWebBrowser += "$(function(){\n";
			stringToSendToWebBrowser += "  $('#profiletabs ul li a').on('click', function(e){\n";
			stringToSendToWebBrowser += "    e.preventDefault();\n";
			stringToSendToWebBrowser += "    var newcontent = $(this).attr('href');\n";
			stringToSendToWebBrowser += "    \n";
			stringToSendToWebBrowser += "    $('#profiletabs ul li a').removeClass('sel');\n";
			stringToSendToWebBrowser += "    $(this).addClass('sel');\n";
			stringToSendToWebBrowser += "    \n";
			stringToSendToWebBrowser += "    $('#content section').each(function(){\n";
			stringToSendToWebBrowser += "      if(!$(this).hasClass('hidden')) { $(this).addClass('hidden'); }\n";
			stringToSendToWebBrowser += "    });\n";
			stringToSendToWebBrowser += "    \n";
			stringToSendToWebBrowser += "    $(newcontent).removeClass('hidden');\n";
			stringToSendToWebBrowser += "  });\n";
			stringToSendToWebBrowser += "});\n";
			stringToSendToWebBrowser += "</script>\n";
			stringToSendToWebBrowser += "</body>\n";
			stringToSendToWebBrowser += "</html>\n";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}else if(toProcess.path.equalsIgnoreCase("EditAccountPage.html/submit")) {
			String username = toProcess.params.get("username");
			String password = toProcess.params.get("password");
			String oldUsername = toProcess.params.get("oldUsername");
			System.out.println(username);
			System.out.println(oldUsername);
			
			MVMap<String, User> users = db.s.openMap("Users");
			if(users.containsKey(username) && !username.equals(oldUsername)) {
				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, "<html><head><script> alert('Error: Name already exists'); </script><meta http-equiv=\"refresh\" content=\"0; url=../EditAccountPage.html\" /></head></html>" );
				return true;
			} else {
				User user = new User();
				user.username = username;
				user.password = password;
				users.put(username, user);
				users.remove(oldUsername);
				db.commit();
			}
			
			String stringToSendToWebBrowser = "<html><head><meta http-equiv=\"refresh\" content=\"0; url=../EditAccountPage.html\" />\n";
			stringToSendToWebBrowser += "<script>\n";
			stringToSendToWebBrowser += "          document.cookie = \"username = "+username+";\";\n";
			stringToSendToWebBrowser += "          document.cookie = \"password = "+password+";\";\n";
			stringToSendToWebBrowser += "</script></head></html>\n";
			System.out.println(stringToSendToWebBrowser);
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser);
		}
		return false;
	}

}
