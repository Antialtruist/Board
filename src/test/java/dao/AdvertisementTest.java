package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Advertisement;

class AdvertisementTest {
	
	private AdvertisementDAO advDAO;

	@Test
	void testAddAdvertisement() {
		Advertisement expected = new Advertisement();
		expected.setTitle("first");
		expected.setDescription("raz dva");
		expected.setCreated(new LocalDate.now());
		expected.setUserID(1);
		advDAO.addAdvertisement(expected);
		
		Advertisement actual = advDAO.getAdvertisementByUserID(1);
        
        Assertions.assertEquals(expected, actual);
	}

	@Test
	void testDeleteAdvertisement() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateAdvertisement() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllAdvertisements() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAdvertisementByUserID() {
		fail("Not yet implemented");
	}

}
