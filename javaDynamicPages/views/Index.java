package views;

import java.util.ArrayList;
import java.util.List;

import org.h2.mvstore.MVMap;

import model.Comment;
import model.User;
import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class Index extends DynamicWebPage
{
	private int pagenum = 0;

	public Index(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("Index.html"))
		{
			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<!DOCTYPE html>\n";
			stringToSendToWebBrowser += "<html>\n";
			stringToSendToWebBrowser += "<head>\n";
			stringToSendToWebBrowser += "<title>WikiEcoSystem</title>\n";
			stringToSendToWebBrowser += "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n";
			stringToSendToWebBrowser += "<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "<link rel=\"shortcut icon\" type=\"image/png\" href=\"images/plant.png\">\n";
			stringToSendToWebBrowser += "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">\n";
			stringToSendToWebBrowser += "<link href=\"https://fonts.googleapis.com/css?family=Titillium+Web\" rel=\"stylesheet\">\n";
			stringToSendToWebBrowser += "<script src=\"main.js\"></script>\n";
			stringToSendToWebBrowser += "\t<script src=\"https://code.jquery.com/jquery-3.1.0.min.js\"></script>\n";
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
			stringToSendToWebBrowser += "</div>\t\n";
			stringToSendToWebBrowser += "<div class=\"mainBox\" id=\"mainBox\" style=\"height:auto;font-size:20px\">\n";
			stringToSendToWebBrowser += "\t<section id=\"section01\" class=\"demo\">\n";
			stringToSendToWebBrowser += "  <h1>About Us</h1>  \n";
			stringToSendToWebBrowser += "  \n";
			stringToSendToWebBrowser += "  <script>\n";
			stringToSendToWebBrowser += "  function aboutUpdate(opt){\n";
			stringToSendToWebBrowser += "\tif(opt == 1){\n";
			stringToSendToWebBrowser += "\tdocument.getElementById('aboutUs').innerHTML = \"<p><b>Feeding Relationships In An Ecosystem</b><br>Ecology is the study of living organisms in their environment. An ecosystem is a distinctarea within earth's environment and it includes organisms living there and interacting with one another as well as with the background non-living parts of the environment.</p>\"";
			stringToSendToWebBrowser += "  }\n";
			stringToSendToWebBrowser += "\telse if(opt == 2){\n";
			stringToSendToWebBrowser += "\tdocument.getElementById('aboutUs').innerHTML = \"<p><b>Insects In An Ecosystem</b><br>Insects play significant roles in the ecology of the world due to their vast diversity of form, function and life-style; their considerablebiomass; and their interaction with plant life, other organisms and the environment. Insects contribute to nutrient recycling by degrading or consuming leaf litter, wood, carrion and dung and by dispersal of fungi.</p>\"";
			stringToSendToWebBrowser += "  }\n";
			stringToSendToWebBrowser += "\telse if(opt == 3){\n";
			stringToSendToWebBrowser += "\tdocument.getElementById('aboutUs').innerHTML = \"<p><b>Plants In An Ecosystem</b><br>Plants take in carbon dioxide and, through the process of photosynthesis, return oxygen to the environment of an ecosystem. This is the opposite of what animals do. Therefore, they end up being one half of the Oxygen/Carbon Dioxide Cycle necessary for most terrestrial ecosystems.</p>\"";
			stringToSendToWebBrowser += "  }\n";
			stringToSendToWebBrowser += "\telse{\n";
			stringToSendToWebBrowser += "\tdocument.getElementById('aboutUs').innerHTML = \"<p><b>Animals In An Ecosystem</b><br>Most animals live in areas with very specific climate conditions, such as temperature and rainfall patterns, that enable them to thrive. Any change in the climate of an area can affect the animals living there, as well as the makeup of the entire ecosystem. Some species are already responding to a warmer climate by moving to cooler locations. Climate change also alters the life cycles of animals.</p>\"";
			stringToSendToWebBrowser += "  }\n";
			stringToSendToWebBrowser += "  }\n";
			stringToSendToWebBrowser += "  </script>\n";
			stringToSendToWebBrowser += "  \n";
			stringToSendToWebBrowser += "  <div class=\"containerHexIndex\">\n";
			stringToSendToWebBrowser += "  <div class=\"hex hex2 a rowOne\"><div class=\"hex-in1\"><div class=\"hex-in2 image1 changeColor3\" onmouseover=\"aboutUpdate(1)\"></div></div></div>\n";
			stringToSendToWebBrowser += "  <div class=\"hex hex2 d rowTwo\"><div class=\"hex-in1\"><div class=\"hex-in2 image2 changeColor4\" onmouseover=\"aboutUpdate(2)\"></div></div></div>\n";
			stringToSendToWebBrowser += "  <div class=\"hex hex2 e rowThree\"><div class=\"hex-in1\"><div class=\"hex-in2 image3 changeColor3\" onmouseover=\"aboutUpdate(3)\"></div></div></div>\n";
			stringToSendToWebBrowser += "  <div class=\"hex hex2 b rowFour\"><div class=\"hex-in1\"><div class=\"hex-in2 image4 changeColor4\" onmouseover=\"aboutUpdate(4)\"></div></div></div>\n";
			stringToSendToWebBrowser += "  </div>\n";
			stringToSendToWebBrowser += "    <div class=\"containerText\">\n";
			stringToSendToWebBrowser += "  <p id=\"aboutUs\" style=\"text-align: center;\">Welcome to WikiEcoSystem!<br><b>About Us</b><br>WikiEcoSystem was created for users around the world to share their findings and research online.<br>"
					+ "This is a place where users, like you, who are interested in the eco system, to be able to communicate with other like minded people and maybe even learn something new!</p> <img src=\"wildlife.png\" style=\"width: 400px;\">\n";
			stringToSendToWebBrowser += "  </div>\n";
			stringToSendToWebBrowser += "  <a href=\"#section02\"><span></span></a>\n";
			stringToSendToWebBrowser += "</section>\n";
			stringToSendToWebBrowser += "<hr><br>\n";
			stringToSendToWebBrowser += "<section id=\"section02\" class=\"demo\">\n";
			stringToSendToWebBrowser += "  <h1>Comment Thread</h1><br><br>\n";
			stringToSendToWebBrowser += "  <h3>Add comment</h3>\n";
			stringToSendToWebBrowser += "\t<h5>Subject</h5>\n";
			stringToSendToWebBrowser += "\t<div style=\"width:30%;margin:auto;\">\n";
			stringToSendToWebBrowser += "<form class=\"form-horizontal\" method=\"GET\" action=\"index.html/submit\" role=\"form\">\n";
			stringToSendToWebBrowser += "\t<select id=\"category\" name=\"category\">\n";
			stringToSendToWebBrowser += "\t\t<option value=\"animal\">Animal</option>\n";
			stringToSendToWebBrowser += "\t\t<option value=\"plant\">Plants</option>\n";
			stringToSendToWebBrowser += "\t</select><br>\n";
			stringToSendToWebBrowser += "\t<input type=\"text\" id=\"commentText\" name=\"commentText\"><br>\n";
			stringToSendToWebBrowser += "<input name=\"user\" id=\"user\" type=\"hidden\" value=\"\"/>\n";
			stringToSendToWebBrowser += "\t<input type=\"submit\" value=\"Submit\"><br>\n";
			stringToSendToWebBrowser += "</form>\n";
			stringToSendToWebBrowser += "\t</div><br>\n";
			stringToSendToWebBrowser += "\t<hr>\n";
			stringToSendToWebBrowser += "\t<script>\n";
			stringToSendToWebBrowser += "document.getElementById('user').value = document.cookie.split(\";\")[0].split(\"=\")[1];\n";
			stringToSendToWebBrowser += "\t</script>\n";
			stringToSendToWebBrowser += "\t<div id=\"animal\" style=\"display:inline-block;width:45%;\">\n";
			stringToSendToWebBrowser += "\t\t<h3>Animal</h3>\n";
			MVMap<Integer, Comment> database = db.s.openMap("Comment");
			List<Integer> keys = database.keyList();
			
			ArrayList<Comment> animals = new ArrayList<Comment>();
			ArrayList<Comment> plants = new ArrayList<Comment>();
			
			for(int i : keys) {
				if(database.get(i).getType().equals("animal")) {
					animals.add(database.get(i));
				} else if(database.get(i).getType().equals("plant")) {
					plants.add(database.get(i));
				}
			}			

			for(int i =  6 * pagenum; i < Math.min(i+6, animals.size()); i++) {
				stringToSendToWebBrowser += " <div class='comment'><div class='user'><img src=\"avatar.png\" alt=\"default avatar\"><p>"+animals.get(i).getComment()+"</p></div><p>"+animals.get(i).getUser()+"</p></div>\n";
			}
			
			stringToSendToWebBrowser += "\t</div>\n";
			stringToSendToWebBrowser += "\t<div id=\"plant\" style=\"display:inline-block;width:45%;\">\n";
			stringToSendToWebBrowser += "\t\t<h3>Plants</h3>\n";
			
			for(int i =  6 * pagenum; i < Math.min(i+6, plants.size()); i++) {
					stringToSendToWebBrowser += " <div class='comment'><div class='user'><img src=\"avatar.png\" alt=\"default avatar\"><p>"+plants.get(i).getComment()+"</p></div><p>"+plants.get(i).getUser()+"</p></div>\n";
			}
			
			stringToSendToWebBrowser += "\t</div>\t\t\n";

			stringToSendToWebBrowser += "</section>\n";
			stringToSendToWebBrowser += "<hr>\n";
			stringToSendToWebBrowser += "</div>\n";
			stringToSendToWebBrowser += "<script>\n";
			stringToSendToWebBrowser += "$(function() {\n";
			stringToSendToWebBrowser += "  $('a[href*=#]').on('click', function(e) {\n";
			stringToSendToWebBrowser += "    e.preventDefault();\n";
			stringToSendToWebBrowser += "    $('html, body').animate({ scrollTop: $($(this).attr('href')).offset().top}, 500, 'linear');\n";
			stringToSendToWebBrowser += "  });\n";
			stringToSendToWebBrowser += "});\n";
			stringToSendToWebBrowser += "</script>\n";
			stringToSendToWebBrowser += "\n";
			stringToSendToWebBrowser += "\t\n";
			stringToSendToWebBrowser += "<div class=\"footer\">\n";
			stringToSendToWebBrowser += " <img src=\"world-globe.gif\" alt=\"Tree\" height=\"100\" width=\"100\">\n";
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
		}else if(toProcess.path.equalsIgnoreCase("index.html/submit")) {
			System.out.println("RUN");
			String commentText = toProcess.params.get("commentText");
			String category = toProcess.params.get("category");
			String user = toProcess.params.get("user");
			System.out.println(commentText+","+category+","+user);
			if(user.length() == 0) {
				toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, "<html><head><meta http-equiv=\"refresh\" content=\"0; url=../index.html\" /><script>alert('You must be signed in first');</script></head></html>" );
				return true;
			}
			
			Comment comment = new Comment(user, commentText, category);
			MVMap<Integer, Comment> database = db.s.openMap("Comment");
			int key = database.keyList().size()+1;
			database.put(key, comment);
			
			db.commit();
			System.out.println("RUN");
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, "<html><head><meta http-equiv=\"refresh\" content=\"0; url=../index.html\" /></head></html>" );
			return true;
		}
		return false;
	}

}