package tech.calvanodesign.business;


import java.util.ArrayList;
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

	public List<String> rssUrls;
	public CustomRssViewer rssViewer;
	
	/**
	 * Initialize 
	 */
	public void init() {
		System.out.println("~~ HelloWorldBOImpl.init()");
		rssViewer = new CustomRssViewer();
		rssUrls = new ArrayList<String>();
	}

	/**
	 * Sets rss feed url  
	 */
	public void setRssUrl(String rssUrl) {
		System.out.println("~~ HelloWorldBOImpl.setRssUrl; " + rssUrl);
		rssUrls.add(rssUrl);
		for (String testRssUrl : rssUrls)
		{
			System.out.println("## Test RSS URL list: " + testRssUrl);
		}
	}

	public List<RSS> readRssFeed() {
		System.out.println("~~ HelloWorldBOImpl.readRssFeed;");	
		List<RSS> retRss = new ArrayList<RSS>();
		for (String rssUrl : rssUrls)
		{
			retRss.addAll(rssViewer.readStream(rssUrl));
		}
		return retRss;
	}
	
	public void getRssUrls(List<String> rssUrls){
		this.rssUrls = rssUrls;
	}
	
	public List<String> setRssUrls(){
		return this.rssUrls;
	}
}