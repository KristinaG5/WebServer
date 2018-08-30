package views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.h2.mvstore.MVMap;

import model.Animal;
import model.Plant;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class SearchPage extends DynamicWebPage
{
	private String dbName = "animal";
	private String search ="";
	private int pagenum = 1;

	public SearchPage(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("SearchPage.html"))
		{
			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<!DOCTYPE html>\n";
			stringToSendToWebBrowser += "<html>\n";
			stringToSendToWebBrowser += "<head>\n";
			stringToSendToWebBrowser += "<title>WikiEcoSystem</title>\n";
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
			stringToSendToWebBrowser += "  <span style=\"font-size:25px; cursor:pointer; color: black; position: fixed\" onclick=\"openNav()\">&#9776; Menu</span>\n";
			stringToSendToWebBrowser += "  <h1 style=\"text-align:center; margin-top: 150px\">WikiEcoSystem</h1>\n";
			stringToSendToWebBrowser += "  <form style=\"text-align: center\" id=\"searchForm\" class=\"searchForm\" method=\"post\" action=\"SearchPage.html/submit\">\n";
			stringToSendToWebBrowser += "  <input type=\"text\" id=\"search\" name=\"search\" placeholder=\"Search...\">\n";
			stringToSendToWebBrowser += "\t<select id=\"category\" name=\"category\" >\n";
			stringToSendToWebBrowser += "\t\t<option value=\"animal\">Animal</option>\n";
			stringToSendToWebBrowser += "\t\t<option value=\"plant\">Plants</option>\n";
			stringToSendToWebBrowser += "\t</select><br>\n";
			stringToSendToWebBrowser += "\t<input type=\"submit\" Placeholder=\"Submit\" > \n";		
			stringToSendToWebBrowser += "</form>\n";
			stringToSendToWebBrowser += "</div>\t\n";
			stringToSendToWebBrowser += "<div class=\"mainBox\" id=\"mainBox\" style=\"height:auto; width: auto; font-size:20px; background-color: transparent;\">\n";
			stringToSendToWebBrowser += "<section id=\"lab\">\n";
			stringToSendToWebBrowser += "    <article>\n";
			
			List<Integer> keys;
			MVMap<Integer, Animal> animalDatabase = db.s.openMap("animal");
			MVMap<Integer, Plant> plantDatabase = db.s.openMap("plant");
			
			if(dbName == "animal") {
				keys = animalDatabase.keyList();
			} else {
				keys = plantDatabase.keyList();
			}
			
			ArrayList<String> items = new ArrayList<String>();
			
			for(int i: keys) {
				if(search != null) {
					if(dbName == "plant" && plantDatabase.get(i).getName().toLowerCase().contains(search.toLowerCase())){
						items.add(plantDatabase.get(i).getName().toLowerCase()+","+i);
					}else if(dbName == "animal" && animalDatabase.get(i).getName().toLowerCase().contains(search.toLowerCase())) {
						items.add(animalDatabase.get(i).getName().toLowerCase()+","+i);
					}
				} else {
					if(dbName == "animal") {
						items.add(animalDatabase.get(i).getName().toLowerCase()+","+i);
					} else {
						items.add(plantDatabase.get(i).getName().toLowerCase()+","+i);
					}
				}
			}
			
			Collections.sort(items);
			
		    int	total = items.size();
			int i = (pagenum-1) * 18;
			int k = i + 18;
			for(;i < k; i++) {
				stringToSendToWebBrowser += "        <div class=\"lab_item\">\t\t\n";
				stringToSendToWebBrowser += "        <div class=\"hexagon hexagon2\">\n";
				stringToSendToWebBrowser += "            <div class=\"hexagon-in1\">\n";
				if(i >= total) {
					stringToSendToWebBrowser += "                <div class=\"hexagon-invisible\">\n";
					stringToSendToWebBrowser += "             </div>\n";
				} else {
					System.out.println(items.get(i).split(",")[0]);
					stringToSendToWebBrowser += "                <a href=\""+dbName.substring(0, 1).toUpperCase() + dbName.substring(1)+"Card.html/"+items.get(i).split(",")[1]+"\">\n";
					stringToSendToWebBrowser += "                <div class=\"hexagon-in2\" style=\"background-color: white;\">\n";
					stringToSendToWebBrowser += " 	  				 <div class=\"text\"><p>"+items.get(i).split(",")[0]+"</p>";
					stringToSendToWebBrowser += "                    </div>\n";
					stringToSendToWebBrowser += "                </div>\n";
					stringToSendToWebBrowser += "                </a>\n";
				}
				stringToSendToWebBrowser += "             </div>\n";
				stringToSendToWebBrowser += "        </div>\n";
				stringToSendToWebBrowser += "        </div>\n";
			}
			
			stringToSendToWebBrowser += "\t</article>\n";
			stringToSendToWebBrowser += "			<div class=\"pagination\">\n";
			System.out.println(items.size());
			System.out.println((double)items.size()/18.0);
			for(double j = 0; j < (double)items.size()/18.0; j++) {
				if(j + 1 == pagenum) {
					stringToSendToWebBrowser += "			  <a class=\"active\" href=\"SearchPage.html/"+(int)(j+1)+"\">"+(int)(j+1)+"</a>\n";
				}else {
					stringToSendToWebBrowser += "			  <a  href=\"SearchPage.html/"+(int)(j+1)+"\" >"+(int)(j+1)+"</a>\n";
				}
			}
			stringToSendToWebBrowser += "			</div>\n";
			stringToSendToWebBrowser += "</section>\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "\t\n";
			stringToSendToWebBrowser += "<button onclick=\"topFunction()\" id=\"myBtn\" title=\"Go to top\" class=\"fa fa-angle-double-up\" style=\"color:black; font-size: 30px;\"></button>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "</body>\n";
			stringToSendToWebBrowser += "</html>\n";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		} else if(toProcess.path.equalsIgnoreCase("SearchPage.html/submit")) {
			try {
				System.out.println(toProcess.params.get("category"));
				if(toProcess.params.get("category").equals("plant")) {
					dbName = "plant";
				} else {
					dbName = "animal";
				}
				search = toProcess.params.get("search");
				System.out.println(search);
			} catch (Exception e) {}
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML,  "<html><head><meta http-equiv=\"refresh\" content=\"0; url=../SearchPage.html\" /></head></html>" );
			return true;
		} else if(toProcess.path.contains("SearchPage.html/")) {
			try {
				pagenum = Integer.valueOf(toProcess.path.split("/")[1]);
			}catch(Exception e) {}

			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML,  "<html><head><meta http-equiv=\"refresh\" content=\"0; url=../SearchPage.html\" /></head></html>" );
			return true;
		}
		return false;
	}

}