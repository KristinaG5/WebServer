package views;

import org.h2.mvstore.MVMap;

import model.User;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class Signup extends DynamicWebPage
{

	public Signup(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("Signup.html"))
		{
			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<!DOCTYPE html>\n";
			stringToSendToWebBrowser += "<html>\n";
			stringToSendToWebBrowser += "<title>WikiEcoSystem Sign Up</title>\n";
			stringToSendToWebBrowser += "<head>\n";
			stringToSendToWebBrowser += "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"signUp.css\">\n";
			stringToSendToWebBrowser += "\t<link rel=\"shortcut icon\" type=\"image/png\" href=\"plant.png\">\n";
			stringToSendToWebBrowser += "</head>\n";
			stringToSendToWebBrowser += "<body>\n";
			stringToSendToWebBrowser += "<script>\n";
			stringToSendToWebBrowser += "\tfunction strength(){\n";
			stringToSendToWebBrowser += "\tvar password = document.getElementById(\"password\").value;\n";
			stringToSendToWebBrowser += "\tvar meter = document.getElementById(\"meter\");\n";
			stringToSendToWebBrowser += "\tvar strengthBar = document.getElementById(\"strength\")\n";
			stringToSendToWebBrowser += "\tvar strength = 0;\n";
			stringToSendToWebBrowser += "\t\tif(password.match(/[a-z]+/)){\n";
			stringToSendToWebBrowser += "\t\t\tstrength+=1;\n";
			stringToSendToWebBrowser += "\t\t}\n";
			stringToSendToWebBrowser += "\t\tif(password.match(/[A-Z]+/)){\n";
			stringToSendToWebBrowser += "\t\t\tstrength+=1;\n";
			stringToSendToWebBrowser += "\t\t}\n";
			stringToSendToWebBrowser += "\t\tif(password.match(/[0-9]+/)){\n";
			stringToSendToWebBrowser += "\t\t\tstrength+=1;\n";
			stringToSendToWebBrowser += "\t\t}\n";
			stringToSendToWebBrowser += "\t\tif(password.match(/[?!.,]+/)){\n";
			stringToSendToWebBrowser += "\t\t\tstrength+=1;\n";
			stringToSendToWebBrowser += "\t\t}\n";
			stringToSendToWebBrowser += "\t\tif(password.length > 8){\n";
			stringToSendToWebBrowser += "\t\t\tstrength+=1;\n";
			stringToSendToWebBrowser += "\t\t}\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "\tswitch(strength){\n";
			stringToSendToWebBrowser += "\t\tcase 0:\n";
			stringToSendToWebBrowser += "\t\tstrengthBar.value = 0;\n";
			stringToSendToWebBrowser += "\t\tbreak;\n";
			stringToSendToWebBrowser += "\t\tcase 1:\n";
			stringToSendToWebBrowser += "\t\tstrengthBar.value = 20;\n";
			stringToSendToWebBrowser += "\t\tbreak;\n";
			stringToSendToWebBrowser += "\t\tcase 2:\n";
			stringToSendToWebBrowser += "\t\tstrengthBar.value = 40;\n";
			stringToSendToWebBrowser += "\t\tbreak;\n";
			stringToSendToWebBrowser += "\t\tcase 3:\n";
			stringToSendToWebBrowser += "\t\tstrengthBar.value = 60;\n";
			stringToSendToWebBrowser += "\t\tbreak;\n";
			stringToSendToWebBrowser += "\t\tcase 4:\n";
			stringToSendToWebBrowser += "\t\tstrengthBar.value = 80;\n";
			stringToSendToWebBrowser += "\t\tbreak;\n";
			stringToSendToWebBrowser += "\t\tcase 5:\n";
			stringToSendToWebBrowser += "\t\tstrengthBar.value = 100;\n";
			stringToSendToWebBrowser += "\t\tbreak;\n";
			stringToSendToWebBrowser += "\t}\n";
			stringToSendToWebBrowser += "}\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "function validatePassword(){\n";
			stringToSendToWebBrowser += "  var password = document.getElementById('password').value;\n";
			stringToSendToWebBrowser += "  var passwordConfirm = document.getElementById('passwordConfirm').value;\n";
			stringToSendToWebBrowser += "  if(password !== passwordConfirm){\n";
			stringToSendToWebBrowser += "\talert(\"Password do not match!\");\n";
			stringToSendToWebBrowser += "\treturn false;\n";
			stringToSendToWebBrowser += "  } else {\n";
			stringToSendToWebBrowser += "    return true;\n";
			stringToSendToWebBrowser += "  }\n";
			stringToSendToWebBrowser += "}\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "</script>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "\t<div class=\"signup-box\">\n";
			stringToSendToWebBrowser += "\t<img src=\"avatar.png\" alt=\"Avatar\" class=\"avatar\">\n"; 
			stringToSendToWebBrowser += "\t\t<h1> Sign Up </h1>\n";
			stringToSendToWebBrowser += "\t\t<form onSubmit=\"return validatePassword();\" action=\"SignUpSubmit.html\">\n";
			stringToSendToWebBrowser += "\t\t<p>Username</p>\n";
			stringToSendToWebBrowser += "\t\t<input type=\"text\" name=\"username\" placeholder=\"Enter Username\" required>\n";
			stringToSendToWebBrowser += "\t\t<p>Password</p>\n";
			stringToSendToWebBrowser += "\t\t<input type=\"password\" onkeyup=\"return strength()\" id=\"password\" name=\"password\" placeholder=\"Enter Password\" required>\n";
			stringToSendToWebBrowser += "\t\t<meter class=\"meter\" max=\"100\" value=\"0\" id=\"strength\" style=\"width: 100%; margin-bottom: 15px;\" col></meter>\n";
			stringToSendToWebBrowser += "\t    <input type=\"password\" id=\"passwordConfirm\" name=\"confrim_password\" placeholder=\"Confirm Password\" required>\n";
			stringToSendToWebBrowser += "\t\t<input type=\"submit\" name=\"submit\" value=\"Sign Up\">\t\n";
			stringToSendToWebBrowser += "\t\t<div class=\"tooltip\">\n";
			stringToSendToWebBrowser += "\t\t<img src=\"http://www.pvhc.net/img242/emnxohxixheyqwdwyell.png\" alt=\"info\" style=\"width:25px; height:25px;\" class=\"info\">\n";
			stringToSendToWebBrowser += "\t\t\t<span class=\"tooltiptext\">For stronger password ensure you have the following:<br>1. Lower case<br>2. Upper case<br>3. Numbers<br>4. Special symbol (?!.,)<br>5. Must be over 8 letters long</span>\n";
			stringToSendToWebBrowser += "\t\t</div>\n";
			stringToSendToWebBrowser += "\t\t</form>\t\t\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "\t</div>\n";
			stringToSendToWebBrowser += "\t\n";
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
