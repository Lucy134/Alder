package com.alder.locpol.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alder.locpol.model.Alderman;
import com.alder.locpol.model.BoardBill;
import com.alder.locpol.model.CalItem;
import com.alder.locpol.model.User;
import com.alder.locpol.repository.AlderRepository;
import com.alder.locpol.repository.BBRepository;
import com.alder.locpol.repository.CalendarRepository;
import com.alder.locpol.repository.UserRepository;
import com.alder.locpol.scraper.Alderscrape;
import com.alder.locpol.scraper.CalenderScrape;
import com.alder.locpol.scraper.Scraper;
import com.alder.locpol.scraper.ScraperTwo;

@RestController
@RequestMapping("/")
@CrossOrigin
public class AppController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private Scraper scraper;
	@Autowired
	private BBRepository bbRepository;
	@Autowired
	private AlderRepository alderRepository;
	@Autowired
	private Alderscrape alderscraper;
	@Autowired
	private ScraperTwo scraperTwo;
	@Autowired
	private CalendarRepository calendarRepository;
	@Autowired
	private CalenderScrape calScrape;
	
	

	@RequestMapping(value = "submitUserDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void submitUserDetails(@RequestBody User user) {
		this.userRepository.save(user);
	}

	@GetMapping("/scraper")
	public ResponseEntity<List<BoardBill>> scraper() {
		try {
			return new ResponseEntity<>(scraper.bbText(), HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/calscrape")
	public ResponseEntity<List<CalItem>> calItem() {
		try {
			return new ResponseEntity<>(calScrape.calItem(), HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/scrapertwo")
	public ResponseEntity<List<BoardBill>> scrapertwo() {
		try {
			return new ResponseEntity<>(scraperTwo.bbTextTwo(), HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/alderscraper")
	public ResponseEntity<List<Alderman>> alderscraper() {
		try {
			return new ResponseEntity<>(alderscraper.alderList(), HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/findAllBills", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<BoardBill>> findAllBills() {
		return new ResponseEntity<>(bbRepository.findAll(), HttpStatus.OK);
	}


	@RequestMapping(value ="/findAllCal", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<CalItem>> findAllCal(){
		return new ResponseEntity<>(calendarRepository.findAll(), HttpStatus.OK);
		
	}
	@RequestMapping(value = "/findAllAldermen", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Alderman>> findAllAldermen() {
		return new ResponseEntity<>(alderRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findUsersAldermen", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Alderman>> findUsersAldermen(@RequestParam String email) {
		return new ResponseEntity<>(alderRepository.searchAlderman(email), HttpStatus.OK);
	}

	@RequestMapping(value = "login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Optional<User>> login(@RequestBody User user) {
		Optional<User> user2 = this.userRepository.findById(user.getEmail());
		if (user2.isPresent()) {
			if (user2.get().getPassword().equals(user.getPassword())) {
				return new ResponseEntity<>(user2, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}

		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(value = "findUserByEmail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<User>> findUser(@RequestParam String email) {
		return new ResponseEntity<>(this.userRepository.findById(email), HttpStatus.OK);
	}


}
	