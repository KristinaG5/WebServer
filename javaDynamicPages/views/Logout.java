package views;

import storage.DatabaseInterface;
import storage.FileStoreInterface;
import web.WebRequest;
import web.WebResponse;

public class Logout extends DynamicWebPage
{

	public Logout(DatabaseInterface db,FileStoreInterface fs)
	{
		super(db,fs);
	}

	public boolean process(WebRequest toProcess)
	{
		if(toProcess.path.equalsIgnoreCase("Logout.html"))
		{
			String stringToSendToWebBrowser = "";
			stringToSendToWebBrowser += "<!DOCTYPE HTML>\n";
			stringToSendToWebBrowser += "<html>\n";
			stringToSendToWebBrowser += "<head>\n";
			stringToSendToWebBrowser += "<script>\n";
			stringToSendToWebBrowser += "document.cookie = \"username=;\";\n";
			stringToSendToWebBrowser += "document.cookie = \"password=;\";\n";
			stringToSendToWebBrowser += "</script>\n";
			stringToSendToWebBrowser += "<meta http-equiv=\"refresh\" content=\"0; url=login.html\" />\n";
			stringToSendToWebBrowser += "</head>\n";
			stringToSendToWebBrowser += "</html>\n";
			toProcess.r = new WebResponse( WebResponse.HTTP_OK, WebResponse.MIME_HTML, stringToSendToWebBrowser );
			return true;
		}
		return false;
	}

}