package tech.calvanodesign.web;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

/**
 * Managed bean to handle the soundcloud player.
 * @author Eric
 *
 */
@ManagedBean
@SessionScoped
public class SoundCloudPlayerMB implements Serializable {

	private static final long serialVersionUID = -3069472561633582709L;
	
	final static Logger logger = Logger.getLogger(SoundCloudPlayerMB.class);
	
	private String helloWorld = "helloWorld";
	
	public void init() {
		logger.debug("SoundCloudPlayerMB.ini); " + helloWorld);
	}
}