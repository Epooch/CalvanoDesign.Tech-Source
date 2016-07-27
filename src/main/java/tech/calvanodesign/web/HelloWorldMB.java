package tech.calvanodesign.web;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import tech.calvanodesign.business.HelloWorldBo;

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

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	@PostConstruct
	public void init () {
		System.out.println("HelloWorldMB.init()");
		//session = (HttpSession)FacesContext.getExternalContext().getSession(true);
		if (helloWorldBo != null)
			return;
		System.out.println("helloWorldBo is null");
	}
	
	public void springTest() {
		// Output some info
        System.out.println("HelloWorldBean:: Testing Spring imlementation - helloWorldBo.name : " + name);
		// Call the business object to register the user
		helloWorldBo.springTest(name);
        // Set the message here
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Spring test success", "success");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
    // Set the registrationBo attribute used by Spring
    public void setHelloWorldBo(HelloWorldBo helloWorldBo) {
    	System.out.println("setHelloWorldBo");
        this.helloWorldBo = helloWorldBo;
    }
    
    public HelloWorldBo getHelloWorldBo() {
    	return helloWorldBo;
    }

	public String getName() {
		System.out.println("getName");
		return name;
	}
	public void setName(String name) {
		System.out.println("setName");
		this.name = name;
	}
	
    private String message;
    
    public String getMessage() {
    	System.out.println("getMessage");
        return message;
    }
 
    public void setMessage(String message) {
    	System.out.println("setMessage");
        this.message = message;
    }
     
    public void saveMessage() {
    	System.out.println("saveMessage");
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful", message) );
        context.addMessage(null, new FacesMessage("Folder move was a okay", "That's cool"));
    }
}