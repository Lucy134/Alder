package com.alder.locpol.scraper;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.alder.locpol.model.BoardBill;
import com.alder.locpol.repository.BBRepository;

import jdk.internal.net.http.common.Log;

//@SpringBootApplication

@Service
public class ScraperTwo {

	@Autowired
	private BBRepository bbRepository;

	public List<BoardBill> bbTextTwo() throws IOException {

		int x = 13556;

		while (x < 13641) {
			BoardBill bbTemp = new BoardBill();
			String url = ("https://www.stlouis-mo.gov/government/city-laws/board-bills/boardbill.cfm?bbDetail=true&BBId="+ x);
			try {
				Document doc = Jsoup.connect(url).get();
				Elements links = doc.select(".full-row-white.full.-row");
				List<String> output = doc.select(".shortenText").eachText();
				if (output.size() > 0) {
					bbTemp.setText(output.get(0));
					String billNum = doc.title().substring(27, 31).trim();
					bbTemp.setBillNum(billNum);
					String title = doc.title().substring(38, doc.title().length()).trim();
					bbTemp.setTitle(title);
					System.out.println(billNum + " " + title);
					bbTemp.setBillLink(url);
					System.out.println("Got to URL");
				}
				x++;
				bbRepository.save(bbTemp);
			}

			catch (Exception e) {
				e.printStackTrace();
			}

			// System.out.println(text);

		}
		return bbRepository.findAll();
	}
}
