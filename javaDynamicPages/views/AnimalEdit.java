package views;

import org.h2.mvstore.MVMap;

import model.Animal;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class AnimalEdit extends DynamicWebPage
{
	MVMap<Integer, Animal> database = db.s.openMap("animal");
	private Animal animal =  database.get(1);
	private int id = 0;
	
	public AnimalEdit(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("AnimalEdit.html"))
		{
			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<!DOCTYPE html>\n";
			stringToSendToWebBrowser += "<html>\n";
			stringToSendToWebBrowser += "<head>\n";
			stringToSendToWebBrowser += "<title>Eco System</title>\n";
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
			stringToSendToWebBrowser += "<!-- The white box in the middle -->\n";
			stringToSendToWebBrowser += "<div id=\"main\">\n";
			stringToSendToWebBrowser += "<span style=\"font-size:25px; cursor:pointer; color: black; position: fixed\" onclick=\"openNav()\">&#9776;</span>\n";
			stringToSendToWebBrowser += "<h1 style=\"text-align:center; margin-top: 150px\">WikiEcoSystem</h1>\n";
			stringToSendToWebBrowser += "</div>\t\n";
			stringToSendToWebBrowser += "<div class=\"mainBox\" id=\"mainBox\" style=\"height:auto;font-size:20px;background-color: transparent;\">\n";
			stringToSendToWebBrowser += "\t<div class=\"wholecard\">\n";
			stringToSendToWebBrowser += "\t\t<div class=\"animalpicture\">\n";
			stringToSendToWebBrowser += "<img id=\"imagePrev\" name=\"urlIMG\" onerror=\"this.onerror=null; this.src='placeholderImg.gif';\" style=\"width:300px; height:300px; display: block; margin-left:40%; margin:auto;\" src=\""+animal.getUrlImg()+"\"/>\n";
			stringToSendToWebBrowser += "\t\t\t<h3 class=\"animalname\">"+animal.getName()+"</h3>\n";
			stringToSendToWebBrowser += "\t\t</div>\n";
			stringToSendToWebBrowser += "\t\t<div class=\"animaldetails\">\n";
			stringToSendToWebBrowser += "\t\t\t<span class=\"beardescript\">Animal Description</span>\n";
			stringToSendToWebBrowser += "<form class=\"form-horizontal\" method=\"GET\" action=\"AnimalEdit.html/submit\" role=\"form\">\n";
			stringToSendToWebBrowser += "\t\t\t<p class=\"animalintro\"><span>Fun Fact</span>: <textarea name=\"fact\" type=\"text\" style=\"color: black; font-family:'Titillium Web', sans-serif;\" placeholder=\""+animal.getFunfact()+"\"></textarea></p>\n";
			stringToSendToWebBrowser += "\t\t\t<ul>\n";
			stringToSendToWebBrowser += "\t\t\t\t<li><span>Family</span>: <input name=\"family\" type=\"text\" value=\""+animal.getFamily()+"\"/></li>\n";
			stringToSendToWebBrowser += "\t\t\t\t<li><span>Location</span>: <input name=\"location\" type=\"text\" value=\""+animal.getLocation()+"\"/></li>\n";
			stringToSendToWebBrowser += "\t\t\t\t<li><span>Endangered Scale</span>: <input name=\"endangered\" type=\"text\" value=\""+animal.getEndangered()+"\"/></li>\n";
			stringToSendToWebBrowser += "\t\t\t\t<li><span>Feeding Behaviours</span>: <input name=\"behaviour\" type=\"text\" value=\""+animal.getBehaviours()+"\"/></li>\n";
			stringToSendToWebBrowser += "\t\t\t</ul>\n";
			stringToSendToWebBrowser += "\t\t\t<p>\n";
			stringToSendToWebBrowser += "\t\t\t<span>Bio</span>:\n";
			stringToSendToWebBrowser += "\t\t\t\t <input name=\"bio\" type=\"text\" value=\""+animal.getBio()+"\"></input>\n";
			stringToSendToWebBrowser += "\t\t\t</p>\n";
			stringToSendToWebBrowser += "\t\t</div>\n";
			stringToSendToWebBrowser += "<input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Save\"\">\t\n";
			stringToSendToWebBrowser += "<a href=\"AnimalEdit.html/delete/"+id+"\"><input type=\"button\" name=\"delete\" id=\"delete\" value=\"Delete\"\"></a>\t\n";
			stringToSendToWebBrowser += "\t</div>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "</form>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<div class=\"footer\">\n";
			stringToSendToWebBrowser += "<img src=\"world-globe.gif\" alt=\"Tree\" height=\"100\" width=\"100\">\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<button onclick=\"topFunction()\" id=\"myBtn\" title=\"Go to top\" class=\"fa fa-angle-double-up\" style=\"color:black; font-size: 30px;\"></button>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "</body>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "</html>\n";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		} else if(toProcess.path.equalsIgnoreCase("AnimalEdit.html/submit")) {
			MVMap<Integer, Animal> database = db.s.openMap("animal");
			Animal myAnimal = database.get(id);
			
			
			myAnimal.setFamily(toProcess.params.get("family"));
			myAnimal.setLocation(toProcess.params.get("location"));
			myAnimal.setBio(toProcess.params.get("bio"));
			myAnimal.setFunfact(toProcess.params.get("fact"));
			myAnimal.setEndangered(toProcess.params.get("endangered"));
			
			database.put(id, myAnimal);
			db.commit();
			
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML,  "<html><head><meta http-equiv=\"refresh\" content=\"0; url=../AnimalCard.html/"+id+"\" /></head></html>" );
			return true;
		} else if(toProcess.path.contains("AnimalEdit.html/delete")) {
			MVMap<Integer, Animal> database = db.s.openMap("animal");
			id = Integer.valueOf(toProcess.path.split("/")[2]);
			database.remove(id);
			db.commit();
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML,  "<html><head><meta http-equiv=\"refresh\" content=\"0; url=../../SearchPage.html\" /></head></html>" );
			return true;
		} else if(toProcess.path.contains("AnimalEdit.html")) {
			try {
				MVMap<Integer, Animal> database = db.s.openMap("animal");
				id = Integer.valueOf(toProcess.path.split("/")[1]);
				System.out.println("ID +++ "+id);
				animal = database.get(id);
			} catch (Exception e) {}
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML,  "<html><head><meta http-equiv=\"refresh\" content=\"0; url=../AnimalEdit.html\" /></head></html>" );
			return true;
		}
		return false;
	}

}