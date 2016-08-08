package tech.calvanodesign.business;

import tech.calvanodesign.object.RSS;

/**
 * HelloWorld Business Object interface.
 * @author eric.calvano
 *
 */
public interface HelloWorldBo {
    
    public void setRssUrl(String rssUrl);
    
    public RSS readRssFeed();
}