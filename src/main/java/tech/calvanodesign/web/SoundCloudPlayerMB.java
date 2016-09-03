package tech.calvanodesign.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

/**
 * Managed bean to handle the soundcloud player.
 * @author Eric
 *
 */
@ManagedBean
@ViewScoped
public class SoundCloudPlayerMB implements Serializable {

	private static final long serialVersionUID = -3069472561633582709L;
	
	final static Logger logger = Logger.getLogger(SoundCloudPlayerMB.class);
	
	private boolean loginShow;
	
	@PostConstruct
	public void init() {
		logger.debug("SoundCloudPlayerMB.init;");
		this.loginShow = false;
	}
	
	/**
	 * @return the loginShow
	 */
	public boolean getLoginShow() {
		return loginShow;
	}

	/**
	 * @param loginShow the loginShow to set
	 */
	public void setLoginShow(boolean loginShow) {
		this.loginShow = loginShow;
	}
	
	public void requestSoundCloudLogin() {
		logger.debug("SoundCloudPlayerMB.requestSoundCloudLogin;");
		loginShow = true;
	}
}