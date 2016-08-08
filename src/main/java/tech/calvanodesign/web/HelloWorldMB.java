package tech.calvanodesign.web;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import tech.calvanodesign.business.HelloWorldBo;
import tech.calvanodesign.object.RSS;

import java.io.Serializable;

/**
 * 
 * @author Eric
 *
 */
@ManagedBean
@SessionScoped
public class HelloWorldMB implements Serializable {
	
	@ManagedProperty(value = "#{helloWorldBo}")
	private HelloWorldBo helloWorldBo;
	
	//This managed property is not set and cannot be used
	//@ManagedProperty(value = "#{RSS}")
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
	}
	
	public void setRss() {
		System.out.println(">> RefreshRSS");
		// Call the business object and perform action for retrieving RSS feed
		helloWorldBo.setRssUrl(rssFeed);
		
		rssObj = helloWorldBo.readRssFeed();
		System.out.println("<< Returned RSS title; " + rssObj.title);
		System.out.println("<< Returned RSS summary;" + rssObj.summary);
		// Set the message here
        //FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "rssObj", rssObj.getTitle());  
        //FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void displayRss(RSS rssObj){
		System.out.println(">> DisplayRSS");
	}
	
    // Set the registrationBo attribute used by Spring
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
	
    private String message;
    
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
     
    public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful", message) );
        context.addMessage(null, new FacesMessage("Folder move was a okay", "That's cool"));
    }
}