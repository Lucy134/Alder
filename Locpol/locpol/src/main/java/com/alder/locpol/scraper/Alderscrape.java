package com.alder.locpol.scraper;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alder.locpol.model.Alderman;
import com.alder.locpol.repository.AlderRepository;

@Service
public class Alderscrape {
	@Autowired
	private AlderRepository alderRepository;
	
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
					System.out.println("Ward is: "+ward);
					
					Elements name = doc.select(".col-md-4");
					List<String> contact = name.select("p:nth-of-type(1)").eachText();
					if(contact.size() > 0) {
					String nameLong = contact.get(0);	
					String[] foo =nameLong.split(":");
					String barOne = foo[0].trim().substring(6, foo[0].length()-6);
					System.out.println(barOne);
					String barTwo = foo[1].trim().substring(0, foo[1].length()-5);
					System.out.println(barTwo);
					alderTemp.setName(barOne);
					alderTemp.setPhone(barTwo);
    				alderRepository.save(alderTemp);
								x++;
					}
				}
				catch (Exception e){
					e.printStackTrace();
				}
		}return alderRepository.findAll();
	}
	
	

}
