package tech.calvanodesign.business;

import java.util.List;

import javax.inject.Named;

import tech.calvanodesign.object.RSS;
import tech.calvanodesign.business.Helper.CustomRssViewer;

/**
 * HelloWorld Business Object Implementation
 * @author Eric
 *
 */
@Named("helloWorldBo")
public class HelloWorldBoImpl implements HelloWorldBo {

	public RSS retRss;
	

	/**
	 * get RSS Feed  
	 */
	public void setRssUrl(String rssUrl) {
		System.out.println("~~ HelloWorldBOImpl.setRssUrl; " + rssUrl);
		retRss = new RSS();
		retRss.setURL(rssUrl);
	}

	public List<RSS> readRssFeed() {
		System.out.println("~~ HelloWorldBOImpl.readRssFeed;");
		if (retRss == null) {
			System.out.println("retRSS is null. Nothing to read.");
			retRss.setTitle("Error no url is present.");
			return null;
		}
		CustomRssViewer rssViewer = new CustomRssViewer();
		 
		
		return rssViewer.readStream(retRss.url);
	}
	
	public void getRetRSS(RSS rssObj){
		this.retRss = rssObj;
	}
	
	public RSS setRetRss(){
		return this.retRss;
	}
}