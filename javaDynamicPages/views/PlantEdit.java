package views;

import org.h2.mvstore.MVMap;

import model.Plant;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class PlantEdit extends DynamicWebPage
{
	MVMap<Integer, Plant> database = db.s.openMap("plant");
	private Plant plant =  database.get(1);
	private int id = 0;

	public PlantEdit(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("PlantEdit.html"))
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
			stringToSendToWebBrowser += "<img id=\"imagePrev\" onerror=\"this.onerror=null;this.src='placeholderImg.gif';\"\" style=\"width:300px; height:300px; display: block; margin-left:40%; margin:auto;\" src=\""+plant.getUrlImg()+"\"/>\n";
			stringToSendToWebBrowser += "\t\t\t<h3 class=\"animalname\">"+plant.getName()+"</h3>\n";
			stringToSendToWebBrowser += "\t\t</div>\n";
			stringToSendToWebBrowser += "\t\t<div class=\"animaldetails\"> <!-- card animal info  -->\n";
			stringToSendToWebBrowser += "\t\t\t<span class=\"beardescript\">Plant Description</span>\n";
			stringToSendToWebBrowser += "<form class=\"form-horizontal\" method=\"GET\" action=\"PlantEdit.html/submit\" role=\"form\">\n";
			stringToSendToWebBrowser += "\t\t\t<p class=\"animalintro\"><span>Fun Fact</span>: <textarea name=\"fact\" type=\"text\" style=\"color: black; font-family:'Titillium Web', sans-serif;\" placeholder=\""+plant.getFunfact()+"\"></textarea></p>\n";
			stringToSendToWebBrowser += "\t\t\t<ul>\n";
			stringToSendToWebBrowser += "\t\t\t\t<li><span>Family</span>: <input name=\"family\" type=\"text\" value=\""+plant.getFamily()+"\"/></li>\n";
			stringToSendToWebBrowser += "\t\t\t\t<li><span>Location</span>: <input name=\"location\" type=\"text\" value=\""+plant.getLocation()+"\"/></li>\n";
			stringToSendToWebBrowser += "\t\t\t</ul>\n";
			stringToSendToWebBrowser += "\t\t\t<p>\n";
			stringToSendToWebBrowser += "\t\t\t<span>Bio</span>:\n";
			stringToSendToWebBrowser += "\t\t\t\t <input type=\"text\" name=\"bio\" value=\""+plant.getBio()+"\"></inpue>\n";
			stringToSendToWebBrowser += "\t\t\t</p>\n";
			stringToSendToWebBrowser += "\t\t</div>\n";
			stringToSendToWebBrowser += "<input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Save\"\">\t\n";
			stringToSendToWebBrowser += "<a href=\"PlantEdit.html/delete/"+id+"\"><input type=\"button\" name=\"delete\" id=\"delete\" value=\"Delete\"\"></a>\t\n";
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
		}else if(toProcess.path.equalsIgnoreCase("PlantEdit.html/submit")) {
			MVMap<Integer, Plant> database = db.s.openMap("plant");
			Plant myPlant = database.get(id);

			myPlant.setFamily(toProcess.params.get("family"));
			myPlant.setLocation(toProcess.params.get("location"));
			myPlant.setBio(toProcess.params.get("bio"));
			myPlant.setFunfact(toProcess.params.get("fact"));
			
			database.put(id, myPlant);
			db.commit();
			
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML,  "<html><head><meta http-equiv=\"refresh\" content=\"0; url=../PlantCard.html/"+id+"\" /></head></html>" );
			return true;
		} else if(toProcess.path.contains("PlantEdit.html/delete")) {
			MVMap<Integer, Plant> database = db.s.openMap("plant");
			id = Integer.valueOf(toProcess.path.split("/")[2]);
			database.remove(id);
			db.commit();
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML,  "<html><head><meta http-equiv=\"refresh\" content=\"0; url=../../SearchPage.html\" /></head></html>" );
			return true;
		}else if(toProcess.path.contains("PlantEdit.html")) {
			try {
				MVMap<Integer, Plant> database = db.s.openMap("plant");
				id = Integer.valueOf(toProcess.path.split("/")[1]);
				plant = database.get(id);
			} catch (Exception e) {}
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML,  "<html><head><meta http-equiv=\"refresh\" content=\"0; url=../PlantEdit.html\" /></head></html>" );
			return true;
		}
		return false;
	}

}