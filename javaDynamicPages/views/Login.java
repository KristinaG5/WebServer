package views;

import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class Login extends DynamicWebPage
{

	public Login(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("Login.html"))
		{
			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<!DOCTYPE html>\n";
			stringToSendToWebBrowser += "<html>\n";
			stringToSendToWebBrowser += "<title>WikiEcoSystem Login</title>\n";
			stringToSendToWebBrowser += "<head>\n";
			stringToSendToWebBrowser += "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"LoginStyle.css\">\n";
			stringToSendToWebBrowser += "\t<link rel=\"shortcut icon\" type=\"image/png\" href=\"images/plant.png\">\n";
			stringToSendToWebBrowser += "</head>\n";
			stringToSendToWebBrowser += "<body>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "\t<div class=\"login-box\">\n";
			stringToSendToWebBrowser += "\t<img src=\"https://cdn.onlinewebfonts.com/svg/img_180628.png\" alt=\"Avatar\" class=\"avatar\">\n";
			stringToSendToWebBrowser += "\t\t<h1> Login </h1>\n";
			stringToSendToWebBrowser += "\t\t<form  action=\"LoginSubmit.html\" name=\"loginForm\">\n";
			stringToSendToWebBrowser += "\t\t<p>Username</p>\n";
			stringToSendToWebBrowser += "\t\t<input type=\"text\" name=\"username\" placeholder=\"Enter Username\" required>\n";
			stringToSendToWebBrowser += "\t\t<p>Password</p>\n";
			stringToSendToWebBrowser += "\t\t<input type=\"password\" onkeyup=\"return strength()\" id=\"password\" name=\"password\" placeholder=\"Enter Password\" required>\n";
			stringToSendToWebBrowser += "\t\t<input type=\"submit\" name=\"submit\" value=\"Login\">\t\n";
			stringToSendToWebBrowser += "\t\t<a href=\"Signup.html\"><input type=\"button\" name=\"signup\" value=\"Sign Up Here\" style=\"margin-top: -5px;\"></a>\t\n";
			stringToSendToWebBrowser += "\t\t</form>\t\t\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "\t</div>\n";
			stringToSendToWebBrowser += "\t\n";
			stringToSendToWebBrowser += "\t\n";
			stringToSendToWebBrowser += "\t</body>\n";
			stringToSendToWebBrowser += "</html>\n";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		return false;
	}

}
