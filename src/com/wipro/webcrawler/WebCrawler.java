package com.wipro.webcrawler;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 */

/**
 * @author KRISHNA
 *
 */
public class WebCrawler {

	/**
	* @param args
	* @throws ParserConfigurationException 
	* @throws IOException 
	* @throws IOException 
	*/
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		// load the document file from URL using JSOUP
		Document doc = Jsoup.connect("http://wiprodigital.com").get();
		
		//Extract the anchor attributes
		Elements links = doc.select("a[href]");
		
		//	//Extract the image attributes
		Elements media = doc.select("[src]");
		Set<String> hset = new LinkedHashSet<String>();
		
		//getting all links 
			for(Element s:links){
				
				// used linked hashset to add unique elements in ordered way.
				hset.add(s.attr("abs:href"));
				//System.out.println(s.attr("abs:href"));
				}
		
		// getting all images		
		   for (Element image : media) 
		   {
		   	if (image.tagName().equals("img")){
		   	
		       hset.add(image.attr("src"));
		     
		   	}
		   }
		
		   Iterator<String> it = hset.iterator();
		    while(it.hasNext()){
		       System.out.println(it.next());
		    }
	}

}


