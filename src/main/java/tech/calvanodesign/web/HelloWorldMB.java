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
	
	private RSS rssObj;

	private static final long serialVersionUID = 1L;
	
	private String rssFeed;
	
	private List<RSS> rssObjs;
	
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
		rssObjs = new ArrayList<RSS>();
	}
	
	public void fetchRss() {
		System.out.println(">> RefreshRSS");
		// Call the business object and perform action for retrieving RSS feed
		helloWorldBo.setRssUrl(rssFeed);
		
		rssObjs = helloWorldBo.readRssFeed();
		System.out.println("<< RefreshRSS finished");
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
	
	public List<RSS> getRssObjs() {
		return rssObjs;
	}
	
	public void setRssObjs(List<RSS> rssObjs) {
		this.rssObjs = rssObjs;
	}
}