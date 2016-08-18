package tech.calvanodesign.business;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.apache.log4j.Logger;

import tech.calvanodesign.object.RSS;
import tech.calvanodesign.business.Helper.CustomRssViewer;

/**
 * RSSReader Business Object Implementation
 * @author Eric
 *
 */
@Named("rSSReaderBo")
public class RSSReaderBoImpl implements RSSReaderBo {
	final static Logger logger = Logger.getLogger(RSSReaderBoImpl.class);

	public CustomRssViewer rssViewer;
	
	/**
	 * Initialize 
	 */
	public void init() {
		logger.debug("~~ RSSReaderBoImpl.init()");
		rssViewer = new CustomRssViewer();
	}

	public List<RSS> readRssFeed(List<String> rssUrls) {
		logger.debug("~~ RSSReaderBoImpl.readRssFeed;");	
		List<RSS> retRss = new ArrayList<RSS>();
		for (String rssUrl : rssUrls)
		{
			retRss.addAll(rssViewer.readStream(rssUrl));
		}
		return retRss;
	}
}