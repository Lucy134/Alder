package com.alder.locpol.scraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alder.locpol.model.CalItem;
import com.alder.locpol.repository.CalendarRepository;

@Service
public class CalenderScrape {

	@Autowired
	private CalendarRepository calendarRepository;

	public List<CalItem> calItem() throws IOException {
		String url = "https://www.stlouis-mo.gov/government/departments/aldermen/events/index.cfm";
		Document doc = Jsoup.connect(url).get();
		int x = 0;
		List<String> month = doc.select(".event-list-month").eachText();

		List<String> day = doc.select(".event-list-day").eachText();

		List<String> text = doc.select(".event-list-details").eachText();
		while (x < 11) {
			CalItem calTemp = new CalItem();
			calTemp.setDay(day.get(x));
			calTemp.setMonth(month.get(x));
			calTemp.setText(text.get(x));

			System.out.println(calTemp);

			calendarRepository.save(calTemp);
			System.out.println("SAVED");
			x++;

		}

		System.out.println("CALS SAVED");

		return calendarRepository.findAll();

	}
}
