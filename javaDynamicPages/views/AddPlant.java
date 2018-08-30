package views;

import java.util.List;

import org.h2.mvstore.MVMap;

import model.Plant;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class AddPlant extends DynamicWebPage
{
	String imgSrc = "";

	public AddPlant(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("AddPlant.html"))
		{
			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<!DOCTYPE html>\n";
			stringToSendToWebBrowser += "<html>\n";
			stringToSendToWebBrowser += "<head>\n";
			stringToSendToWebBrowser += "<title>Add EcoSystem</title>\n";
			stringToSendToWebBrowser += "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
			stringToSendToWebBrowser += "<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "<link rel=\"shortcut icon\" type=\"image/png\" href=\"plant.png\">\n";
			stringToSendToWebBrowser += "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "<link href=\"https://fonts.googleapis.com/css?family=Titillium+Web\" rel=\"stylesheet\">\n";
			stringToSendToWebBrowser += "<script src=\"main.js\"></script>\n";
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
			stringToSendToWebBrowser += " document.getElementById(\"mySidenav\").innerHTML += \"<a href='login.html'><i class='fa fa-sign-in'></i>Login</a>\";\n";
			stringToSendToWebBrowser += "}  </script>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<!-- The white box in the middle -->\n";
			stringToSendToWebBrowser += "<div id=\"main\">\n";
			stringToSendToWebBrowser += "<span style=\"font-size:25px; cursor:pointer; color: black; position: fixed\" onclick=\"openNav()\">&#9776; Menu</span>\n";
			stringToSendToWebBrowser += "<h1 style=\"text-align:center; margin-top: 150px\">WikiEcoSystem</h1>\n";
			stringToSendToWebBrowser += "</div>\t\n";
			stringToSendToWebBrowser += "<div class=\"mainBox\" id=\"mainBox\" style=\"height: 1000px;font-size:20px;width:700px\">\n";
			stringToSendToWebBrowser += "<div class=\"container\">\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<section class=\"panel panel-default\">\n";
			stringToSendToWebBrowser += "<div class=\"panel-heading\"> \n";
			stringToSendToWebBrowser += "<h3 class=\"panel-title\">Add to Eco System</h3> \n";
			stringToSendToWebBrowser += "</div> \n";
			stringToSendToWebBrowser += "<div class=\"panel-body\">\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<form class=\"form-horizontal\" method=\"GET\" action=\"AddPlant.html/submitImg\" role=\"form\">\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<div class=\"col-sm-3\" >\n";
			stringToSendToWebBrowser += "<hr />\n";
			stringToSendToWebBrowser += "<b>Image Preview</b>\n";
			stringToSendToWebBrowser += "<br />\n";
			stringToSendToWebBrowser += "<input name=\"src\" type=\"text\" placeholder=\"Image URL\" required>\n";
			stringToSendToWebBrowser += "<img id=\"imagePrev\" onerror=\"this.onerror=null;this.src='placeholderImg.gif';\"\" style=\"width:128px; height:128px; display: block; margin-left:40%; margin:auto;\" src=\""+imgSrc+"\"/><br>\n";
			stringToSendToWebBrowser += "<input type=\"submit\" value=\"Upload\">\n";
			stringToSendToWebBrowser += "</div><br><hr>\n";
			stringToSendToWebBrowser += "</form>\n";
			stringToSendToWebBrowser += "<input type=\"radio\" onclick=\"window.location.href = 'addanimal.html';\">Animal\n";
			stringToSendToWebBrowser += "<input type=\"radio\" onclick=\"window.location.href = 'addplant.html';\" checked=\"checked\">Plant\n";
			stringToSendToWebBrowser += "<form class=\"form-horizontal\" method=\"GET\" action=\"AddPlant.html/submit\" role=\"form\">\n";
			stringToSendToWebBrowser += "<div class=\"form-group\">\n";
			stringToSendToWebBrowser += "<label for=\"name\" class=\"col-sm-3 control-label\"><b>Species</b></label>\n";
			stringToSendToWebBrowser += "<div class=\"col-sm-9\">\n";
			stringToSendToWebBrowser += "<input type=\"text\" class=\"form-control\" name=\"name\" id=\"name\" placeholder=\"Name...\" style=\"width: 15%\" required>\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "</div>\n";

			stringToSendToWebBrowser += "<div><b>Plant Family</b>\n";
			stringToSendToWebBrowser += "<select name=\"Plantfamily\" required>\n";
			stringToSendToWebBrowser += "<option value=\"\">Select...</option>;\n";
			stringToSendToWebBrowser += "<option value=\"plant\">Flowering Plant</option>;\n";
			stringToSendToWebBrowser += "<option value=\"moss\">Mosses</option>;\n";
			stringToSendToWebBrowser += "<option value=\"fern\">Ferns</option>;\n";
			stringToSendToWebBrowser += "<option value=\"fungi\">Fungi</option>;\n";
			stringToSendToWebBrowser += "<option value=\"tree\">Trees</option>;\n";
			stringToSendToWebBrowser += "</select>\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "<div class=\"form-group\">\n";
			stringToSendToWebBrowser += "<label for=\"tech\" class=\"col-sm-3 control-label\"><b>Location/Habitat</b></label> \n";
			stringToSendToWebBrowser += "<div class=\"col-sm-3\">\n";
			stringToSendToWebBrowser += "<select class=\"form-control\" style=\"width: 20%;\" name=\"region\" required>\n";
			stringToSendToWebBrowser += "<option value=\"\">Select...</option>\n";
			stringToSendToWebBrowser += "<option value=\"Africa\" title=\"Africa\">Africa</option>\n";
			stringToSendToWebBrowser += "<option value=\"Asia\" title=\"Asia\">Asia</option>\n";
			stringToSendToWebBrowser += "<option value=\"Antarctica\" title=\"Antarctica\">Antarctica</option>\n";
			stringToSendToWebBrowser += "<option value=\"Australia\" title=\"Australia\">Australia</option>\n";
			stringToSendToWebBrowser += "<option value=\"Europe\" title=\"Europe\">Europe</option>\n";
			stringToSendToWebBrowser += "<option value=\"North America\" title=\"North America\">North America</option>\n";
			stringToSendToWebBrowser += "<option value=\"South America\" title=\"South America\">South America</option>\n";
			stringToSendToWebBrowser += "</select>\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<div class=\"form-group\">\n";
			stringToSendToWebBrowser += "<label for=\"name\" class=\"col-sm-3 control-label\"><b>Bio</b></label>\n";
			stringToSendToWebBrowser += "<div class=\"col-sm-9\">\n";
			stringToSendToWebBrowser += "<textarea class=\"form-control\" placeholder=\"Description...\" style=\"width: 60%; font-family:  'Titillium Web', sans-serif;\" name=\"bio\" required></textarea>\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<div class=\"form-group\">\n";
			stringToSendToWebBrowser += "<label for=\"about\" class=\"col-sm-3 control-label\"><b>Fun Fact</b></label>\n";
			stringToSendToWebBrowser += "<div class=\"col-sm-9\">\n";
			stringToSendToWebBrowser += "<textarea class=\"form-control\" placeholder=\"Description...\" style=\"width: 60%; font-family:  'Titillium Web', sans-serif;\" name=\"fact\" required></textarea>\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "</div> \n";
			stringToSendToWebBrowser += "<hr>\n";
			stringToSendToWebBrowser += "<br>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "<input type=\"submit\" name=\"submit\" id=\"submit\" value=\"Add\"/>\t\n";
			stringToSendToWebBrowser += "</form>\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "</section>\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "<div class=\"footer\">\n";
			stringToSendToWebBrowser += "<img src=\"world-globe.gif\" alt=\"Tree\" height=\"100\" width=\"100\">\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "<button onclick=\"topFunction()\" id=\"myBtn\" title=\"Go to top\" class=\"fa fa-angle-double-up\" style=\"color:black; font-size: 30px;\"></button>\n";
			stringToSendToWebBrowser += "</body>\n";
			stringToSendToWebBrowser += "</html>\n";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}else if(toProcess.path.equalsIgnoreCase("AddPlant.html/submit")) {		
			
			String image = imgSrc;
			String name = toProcess.params.get("name");
			String PlantFamily = toProcess.params.get("PlantFamily");
			String region = toProcess.params.get("region");
			String bio = toProcess.params.get("bio");
			String fact = toProcess.params.get("fact");

			boolean exists = false;
			int id = -1;
			
			MVMap<Integer, Plant> database = db.s.openMap("plant");
			List<Integer> plantKey = database.keyList();
			for(int i : plantKey) {
				if(database.get(i).getName().equalsIgnoreCase(name)) {
					exists = true;
					break;
				}
			}
			if(!exists) {
				Plant myPlant = new Plant(name, fact, PlantFamily, region, bio, image);
				id = plantKey.size() + 1;
				database.put(id, myPlant);
				db.commit();
			}
		if(exists) {
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, "<html><head><script> alert('Error: Name already exists'); </script><meta http-equiv=\"refresh\" content=\"0; url=../AddPlant.html\" /></head></html>" );
		} else {
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, "<html><head><meta http-equiv=\"refresh\" content=\"0; url=../PlantCard.html/"+id+"\" /></head></html>" );
		}
	} else if(toProcess.path.equalsIgnoreCase("AddPlant.html/submitImg")) {
		imgSrc = toProcess.params.get("src");
		toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, "<html><head><meta http-equiv=\"refresh\" content=\"0; url=../AddPlant.html\" /></head></html>" );
	}
		return false;
	}

}
