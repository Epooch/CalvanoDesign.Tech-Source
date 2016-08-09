package tech.calvanodesign.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import tech.calvanodesign.business.HelloWorldBo;
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
public class HelloWorldMB implements Serializable {
	
	@ManagedProperty(value = "#{helloWorldBo}")
	private HelloWorldBo helloWorldBo;

	private static final long serialVersionUID = 1L;
	
	private String rssFeed;
	
	private List<RSS> rssObjs;
	
	private List<String> rssUrls;
	
	@PostConstruct
	public void init () {
		System.out.println("HelloWorldMB.init()");
		if (helloWorldBo == null)
		{
			System.out.println("**[ERROR]**helloWorldBo is null");
			return;
		}
		
		helloWorldBo.init();
		System.out.println("<< HelloWorldBo.init()");
		rssFeed = new String();
		rssObjs = new ArrayList<RSS>();
		rssUrls = new ArrayList<String>();
	}
	
	public void pullRss() {
		System.out.println(">> HelloWorldMB.pullRss");
		if(rssUrls.size() > 0)
		{
			rssObjs = helloWorldBo.readRssFeed();
		}
		else
		{
			rssUrls.add(rssFeed);
			helloWorldBo.setRssUrl(rssFeed);
			rssObjs = helloWorldBo.readRssFeed();
		}
		
		System.out.println("<< HelloWorldMB.pullRss");
	}
	
	public void refreshRss() {
		System.out.println(">> HelloWorldMB.refreshRss");
		rssObjs = helloWorldBo.readRssFeed();
		System.out.println("<< HelloWorldMB.refreshRss");
	}
	
	public void addRssUrlToList() {
		System.out.println(">> HelloWorldMB.addRssUrlToList");
		//TODO: I do not want to have to add urls to list in MB and list in HelloWorldBO.
		rssUrls.add(rssFeed);
		helloWorldBo.setRssUrl(rssFeed);
		System.out.println("## HelloWorldMB.rssFeed is being cleared for new input.");
		rssFeed = "";
		System.out.println("<< HelloWorldMB.addRssUrlToList");
	}
	
    public void setHelloWorldBo(HelloWorldBo helloWorldBo) {
        this.helloWorldBo = helloWorldBo;
    }
    
    public HelloWorldBo getHelloWorldBo() {
    	return helloWorldBo;
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
}