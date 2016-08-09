package tech.calvanodesign.business;

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

	public RSS readRssFeed() {
		System.out.println("~~ HelloWorldBOImpl.readRssFeed;");
		if (retRss == null) {
			System.out.println("retRSS is null. Nothing to read.");
			retRss.setTitle("Error no url is present.");
			return retRss;
		}
		CustomRssViewer rssViewer = new CustomRssViewer();
		retRss = rssViewer.readStream(retRss.url);
		retRss.setTitle("testTitle");
		return retRss;
	}
	
	public void getRetRSS(RSS rssObj){
		this.retRss = rssObj;
	}
	
	public RSS setRetRss(){
		return this.retRss;
	}
}