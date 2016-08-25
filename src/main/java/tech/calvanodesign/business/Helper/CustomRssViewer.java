package tech.calvanodesign.business.Helper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import tech.calvanodesign.object.RSS;

public class CustomRssViewer {
	public List<RSS> readStream(String url)
	{
		List<RSS> rssList = new ArrayList<RSS>();
	
		try {
			URL rssUrl = new URL (url);

	        SyndFeedInput input = new SyndFeedInput();
	
			SyndFeed feed = input.build(new XmlReader(rssUrl));
			
			readFeedToRssList(rssList, feed);
			
			return rssList;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rssList;
	}

	/**
	 * Reads a SyndFeed and casts the entries returned to a list of rss.
	 * @param rssList;
	 * @param feed;
	 */
	@SuppressWarnings("unchecked")
	private void readFeedToRssList(List<RSS> rssList, SyndFeed feed) {
		//SupressWarnings on the feed.getEntries being casted to a List<SyndEntry>
		for (SyndEntry entry : (List<SyndEntry>) feed.getEntries()) {
			RSS retRss = new RSS();
		    retRss.title = entry.getTitle();
		    SyndContent description = entry.getDescription();
		    if (description != null)
		    {
		    	String descriptionValue = description.getValue();
		    	String cleanDescription = descriptionValue.replaceAll("\\<.*?>","").replaceAll("\\s+", " ");
		    	retRss.summary = cleanDescription;
		    }
		    else
		    {
		    	retRss.summary = "No summary available.";
		    }
		    retRss.createdDate = entry.getPublishedDate();
		    retRss.url = entry.getUri();
		    rssList.add(retRss);
		}
	} 
}