/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlparser;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 *
 * @author HP
 */
public class PARSING {

    public String parsing() throws IOException{
            String data ="";
            Document doc = Jsoup.connect("http://bursakerjadepnaker.com/").get();
            	Elements links = doc.select("a[href]");
		for (Element link : links) {

			// get the value from href attribute
			System.out.println("\nlink : " + link.attr("title"));
                
//			System.out.println("text : " + link.text());

		}
            return data;    
    }
    
    public String gettitle() throws IOException {
        String data="";
        Document doc = Jsoup.connect("http://bursakerjadepnaker.com/").get();
            	Elements links = doc.select("[class]");
                int i=1;
		for (Element link : links) {

			// get the value from href attribute
                        if(link.attr("title") != ("") && link.attr("title").contains("Lowongan")){
                           System.out.println(i+". "+ link.attr("title")); 
                        i++;
                        }
//			System.out.println("text : " + link.text());

		}       
        return data;
    }
    public String getextlink() throws IOException{
        String data="";
         Document doc = Jsoup.connect("http://bursakerjadepnaker.com/lowongan-kerja-pt-adira-dinamika-multi-finance.html").get();
         String text=doc.body().text();
         if(text.contains("usia")||text.contains("umur")||text.contains("S1")){
             char temp;
             String searchtext="";
             String cleantext=text.replaceAll("'", " ");
          
             for(int i=0;i<text.length();i++){
               temp=text.charAt(i);
                 System.out.println(""+temp); 
            }
         }
        return data;
    }    
    
        public String getULli() throws IOException{
        String data="";
        Document doc = Jsoup.connect("http://bursakerjadepnaker.com/lowongan-kerja-pt-adira-dinamika-multi-finance.html").get();
        Element sok=Jsoup.parse(doc.body().select("div#the_content_").toString());
        String result=sok.text();
            System.out.println(""+result);
//        System.out.println(""+doc.select("[color=#ff0000]"));
//        Elements links = doc.select("[color=#ff0000]");
            
//        Elements links = sok.select("div#the_content_");
//        System.out.println(""+sok.select("div#the_content_").toString());
//        for (Elements link : sok) {
//           System.out.println(""+links.attr("[color=#ff0000]"));
//        }
        return data;
        }  
    
    
    public String geturl() throws IOException {
    String data="";
        Document doc = Jsoup.connect("http://bursakerjadepnaker.com/").get();
            	Elements links = doc.select("[href]");
                int i=1;
                String linktemp="";
		for (Element link : links) {
			// get the value from href attribute
                       if(link.attr("href") != (" ") && link.attr("href").contains("lowongan-kerja")){ 
                           if(linktemp.equals(link.attr("href"))){
//                               boolean s=linktemp.toLowerCase().equals(linktemp);
//                               System.out.println(""+s);                              
                           }
                           else{
//                               System.out.println("not equal");
//                               System.out.println("link temp = "+linktemp);
                               System.out.println("link yang ke = "+i);
                               System.out.println(link.attr("href"));
                               //mengunjungi link
                               //parse link
                                Document doc2 = Jsoup.connect(link.attr("href")).get();
            	                Elements links2 = doc2.select("a[href]");
                                for (Element linkin : links2) {
                                    // get the value from href attribute
                                }
                                i++;
                           }
                           linktemp=link.attr("href");
//                           System.out.println("link = "+linktemp);			
//			System.out.println("text : " + link.text());
		}       
    }
       return data;
}
    
}
