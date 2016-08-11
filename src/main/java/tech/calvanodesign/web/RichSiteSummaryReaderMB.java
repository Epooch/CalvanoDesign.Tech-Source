package tech.calvanodesign.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tech.calvanodesign.business.RSSReaderBo;
import tech.calvanodesign.object.RSS;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Eric
 *
 */
@ManagedBean
@ViewScoped
public class RichSiteSummaryReaderMB implements Serializable {
	
	@ManagedProperty(value = "#{rSSReaderBo}")
	private RSSReaderBo rssReaderBo;

	private static final long serialVersionUID = 1L;
	
	private String rssFeed;
	
	private List<RSS> rssObjs;
	
	private List<String> rssUrls;
	
	@PostConstruct
	public void init () {
		System.out.println("RSSReaderMB.init()");
		if (rssReaderBo == null)
		{
			System.out.println("**[ERROR]**RSSReaderBo is null");
			return;
		}
		
		rssReaderBo.init();
		System.out.println("<< RSSReaderBoImpl.init()");
		rssFeed = new String();
		rssObjs = new ArrayList<RSS>();
		rssUrls = new ArrayList<String>();
	}
	
	public void pullRss() {
		System.out.println(">> RSSReaderMB.pullRss");
		
		if (!rssFeed.isEmpty())//Not empty
		{
			rssUrls.add(rssFeed);
		}
		rssObjs = rssReaderBo.readRssFeed(rssUrls);
		System.out.println("<< RSSReaderMB.pullRss");
	}
	
	public void refreshRss() {
		System.out.println(">> RSSReaderMB.refreshRss");
		rssObjs = rssReaderBo.readRssFeed(rssUrls);
		System.out.println("<< RSSReaderMB.refreshRss");
	}
	
	public void addRssUrlToList() {
		System.out.println(">> RSSReaderMB.addRssUrlToList");
		rssUrls.add(rssFeed);
		clearRssFeedInput();
		System.out.println("<< RSSReaderMB.addRssUrlToList");
	}
	
    public void setRssReaderBo(RSSReaderBo rSSReaderBo) {
        this.rssReaderBo = rSSReaderBo;
    }
    
    public RSSReaderBo getRssReaderBo() {
    	return rssReaderBo;
    }

	public String getRssFeed() {
		return rssFeed;
	}
	
	public void setRssFeed(String rssFeed) {
		this.rssFeed = rssFeed;
	}
	
	public List<String> getRssUrls() {
		return rssUrls;
	}
	
	public void setRssUrls(List<String> rssUrls) {
		this.rssUrls = rssUrls;
	}
	
	public List<RSS> getRssObjs() {
		return rssObjs;
	}
	
	public void setRssObjs(List<RSS> rssObjs) {
		this.rssObjs = rssObjs;
	}
	
	private void clearRssFeedInput() {
		System.out.println("--clearRssFeedInput();");
		rssFeed = "";
		System.out.println("//cleared for new input");
	}
}