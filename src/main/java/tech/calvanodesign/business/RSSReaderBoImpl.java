package tech.calvanodesign.business;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import tech.calvanodesign.object.RSS;
import tech.calvanodesign.business.Helper.CustomRssViewer;

/**
 * RSSReader Business Object Implementation
 * @author Eric
 *
 */
@Named("rSSReaderBo")
public class RSSReaderBoImpl implements RSSReaderBo {

	public CustomRssViewer rssViewer;
	
	/**
	 * Initialize 
	 */
	public void init() {
		System.out.println("~~ RSSReaderBoImpl.init()");
		rssViewer = new CustomRssViewer();
	}

	public List<RSS> readRssFeed(List<String> rssUrls) {
		System.out.println("~~ RSSReaderBoImpl.readRssFeed;");	
		List<RSS> retRss = new ArrayList<RSS>();
		for (String rssUrl : rssUrls)
		{
			retRss.addAll(rssViewer.readStream(rssUrl));
		}
		return retRss;
	}
}