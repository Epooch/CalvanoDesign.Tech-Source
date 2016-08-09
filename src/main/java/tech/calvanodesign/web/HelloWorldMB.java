package tech.calvanodesign.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import tech.calvanodesign.business.HelloWorldBo;
import tech.calvanodesign.object.RSS;

import java.io.Serializable;

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
	
	private RSS rssObj;

	private static final long serialVersionUID = 1L;
	
	private String rssFeed;
	
	@PostConstruct
	public void init () {
		System.out.println("HelloWorldMB.init()");
		if (helloWorldBo == null)
		{
			System.out.println("helloWorldBo is null");
			return;
		}
		rssObj = new RSS();
		rssFeed = new String();
	}
	
	public void fetchRss() {
		System.out.println(">> RefreshRSS");
		// Call the business object and perform action for retrieving RSS feed
		helloWorldBo.setRssUrl(rssFeed);
		
		rssObj = helloWorldBo.readRssFeed();
		System.out.println("<< Returned RSS title; " + rssObj.title);
		System.out.println("<< Returned RSS summary;" + rssObj.summary);
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
	
	public RSS getRssObj() {
		return rssObj;
	}
	
	public void setRssObj(RSS rssObj){
		this.rssObj = rssObj;
	}
}