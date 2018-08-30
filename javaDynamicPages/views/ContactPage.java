package views;

import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class ContactPage extends DynamicWebPage
{

	public ContactPage(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("ContactPage.html"))
		{
			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<!DOCTYPE html>\n";
			stringToSendToWebBrowser += "<html>\n";
			stringToSendToWebBrowser += "<head>\n";
			stringToSendToWebBrowser += "<title>Contact Us</title>\n";
			stringToSendToWebBrowser += "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
			stringToSendToWebBrowser += "<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "<link rel=\"shortcut icon\" type=\"image/png\" href=\"plant.png\">\n";
			stringToSendToWebBrowser += "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "<link href=\"https://fonts.googleapis.com/css?family=Titillium+Web\" rel=\"stylesheet\">\n";
			stringToSendToWebBrowser += "<script src=\"main.js\"></script>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "</head>\n";
			stringToSendToWebBrowser += "<body>\n";
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
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<div id=\"main\">\n";
			stringToSendToWebBrowser += "  <span style=\"font-size:25px; cursor:pointer; color: black; position: fixed\" onclick=\"openNav()\">&#9776; Menu</span>\n";
			stringToSendToWebBrowser += "  <h1 style=\"text-align:center; margin-top: 150px\">WikiEcoSystem</h1>\n";
			stringToSendToWebBrowser += "</div>\t\n";
			stringToSendToWebBrowser += "<div class=\"mainBox\" id=\"mainBox\" style=\"height:auto;font-size:20px\">\n";
			stringToSendToWebBrowser += "\n";

			stringToSendToWebBrowser += "<div class=\"containerContact\">\n";
			stringToSendToWebBrowser += "  <form method=\"post\" action=\"contactPage.html/submit\">\n";
			stringToSendToWebBrowser += "\t\t<label for=\"email\">Email</label>\n";
			stringToSendToWebBrowser += "\t\t<input type=\"email\" name=\"email\" placeholder=\"example@gmail.com\" pattern=\"[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$\" required>\n";
			stringToSendToWebBrowser += "    <label for=\"subject\">Subject</label>\n";
			stringToSendToWebBrowser += "    <select id=\"subject\" name=\"subject\" required>\n";
			stringToSendToWebBrowser += "\t<option value=\"\">Select...</option>\n";
			stringToSendToWebBrowser += "\t\t<option value=\"Animal\">Animal</option>\n";
			stringToSendToWebBrowser += "\t\t<option value=\"Plants\">Plants</option>\n";
			stringToSendToWebBrowser += "\t\t<option value=\"General\">General Customer Service</option>\n";
			stringToSendToWebBrowser += "\t\t<option value=\"Other\">Other Queries</option>\n";
			stringToSendToWebBrowser += "</select>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<label for=\"message\">Message</label>\n";
			stringToSendToWebBrowser += "<input type=\"text\" name=\"body\" id=\"body\" placeholder=\"Your message..\"  required/>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += " <input type=\"submit\" value=\"Submit\">\n";
			stringToSendToWebBrowser += "  </form>\n";
			stringToSendToWebBrowser += "</div>\n";
			
			/*	This is the code that i used that would open up mail and automatically fill in the values in the mail app
			stringToSendToWebBrowser += "<div class=\"containerContact\">\n";
			stringToSendToWebBrowser += "  <form action=\"mailto:example@gmail.com\" enctype=\"text/plain\" method=\"GET\">\n";
			stringToSendToWebBrowser += "\t\t<label for=\"email\">Email</label>\n";
			stringToSendToWebBrowser += "\t\t<input type=\"email\" name=\"email\" placeholder=\"example@gmail.com\" pattern=\"[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$\" required>\n";
			stringToSendToWebBrowser += "    <label for=\"subject\">Subject</label>\n";
			stringToSendToWebBrowser += "    <select id=\"subject\" name=\"subject\" required>\n";
			stringToSendToWebBrowser += "\t<option value=\"\">Select...</option>\n";
			stringToSendToWebBrowser += "\t\t<option value=\"Animal\">Animal</option>\n";
			stringToSendToWebBrowser += "\t\t<option value=\"Plants\">Plants</option>\n";
			stringToSendToWebBrowser += "\t\t<option value=\"General\">General Customer Service</option>\n";
			stringToSendToWebBrowser += "\t\t<option value=\"Other\">Other Queries</option>\n";
			stringToSendToWebBrowser += "</select>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<label for=\"message\">Message</label>\n";
			stringToSendToWebBrowser += "<input type=\"text\" name=\"body\" id=\"body\" placeholder=\"Your message..\"  required/>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += " <input type=\"submit\" value=\"Submit\" onclick=\"document.getElementById(\"body\").split(\"+\")[0];>\n";
			stringToSendToWebBrowser += "  </form>\n";
			stringToSendToWebBrowser += "</div>\n";*/
			
			
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "<div class=\"footer\">\n";
			stringToSendToWebBrowser += " <img src=\"world-globe.gif\" alt=\"Tree\" height=\"100\" width=\"100\">\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "</body>\n";
			stringToSendToWebBrowser += "</html>\n";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		} else if(toProcess.path.equalsIgnoreCase("contactPage.html/submit")) {
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, "<html><head><script> alert('Message sent successfully: Thank you for your message and we will make sure to get back to you as soon as possible.'); </script><meta http-equiv=\"refresh\" content=\"0; url=../index.html\" /></head></html>" );
		}
		return false;
	}

}
