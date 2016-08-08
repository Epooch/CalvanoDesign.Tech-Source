package tech.calvanodesign.object;

import java.util.Date;

/**
 * 
 * @author Eric
 * RSS Object
 *
 */
public class RSS {
	
	public String title;
	
	public String url;
	
	public String summary;
	
	public Date createdDate;
	
	
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	
	public String getURL() {
		return url;
	}
	
	public void setURL(String url){
		this.url = url;
	}
	
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	
	public void setCreatedDate(Date createdDate){
		this.createdDate = createdDate;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
}