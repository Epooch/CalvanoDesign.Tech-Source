package tech.calvanodesign.business;

import java.util.List;

import tech.calvanodesign.object.RSS;

/**
 * RSSReader Business Object interface.
 * @author eric.calvano
 *
 */
public interface RSSReaderBo {
	
	public void init();
    
    public List<RSS> readRssFeed(List<String> rssUrls);
}