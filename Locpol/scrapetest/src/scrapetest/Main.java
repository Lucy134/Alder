package scrapetest;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.alder.locpol.model.Alderman;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		public List<Alderman> alderList() throws IOException {
			int x=1;
			
			while (x <29) {
				Alderman alderTemp = new Alderman();
				String url= ("https://www.stlouis-mo.gov/government/departments/aldermen/ward-"+x+"/");
					try {
						Document doc = Jsoup.connect(url).get();
						Elements page =doc.select(".full-row-white.full.-row");
						String wardLong =(doc.title());
						char one =wardLong.charAt(5);
						char two =wardLong.charAt(6);
						String ward = one+""+two;
						alderTemp.setWard(ward);					
						
						Elements name = doc.select(".col-md-4");
						List<String> contact = doc.select(".a").eachText();
						if(contact.size() > 0) {
						String nameLong = contact.get(0);
						String tel = contact.get(1);
						alderTemp.setPhone(tel);
						alderTemp.setName(nameLong.substring(6));
						System.out.println(alderTemp);
									x++;
						}
					}
					catch (Exception e){
						e.printStackTrace();
					}
			}return alderRepository.findAll();
		}
		

	}

}
