package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.entity.Offers;
import com.exception.OffersNotFoundException;
import com.repository.OffersRepository;
import com.service.OffersDaoImpl;

@ExtendWith(MockitoExtension.class)
 class OffersTests {
	@Mock
	private OffersRepository offersRepo;

	@InjectMocks
	private OffersDaoImpl offersService;

	@Test
	 void createOffersTest() throws Exception {
		Offers offer1 = new Offers(1, 25, "25% off");
		Offers offer2 = new Offers(1, 30, "30% off");

		given(offersRepo.save(offer1)).willReturn(offer1);
		given(offersRepo.save(offer2)).willReturn(offer2);

		assertEquals(offersService.createOffer(offer1), offer1);
		assertEquals(offersService.createOffer(offer2), offer2);

	}

	@Test
	 void getOffersListTest() throws Exception {
		List<Offers> offersList = new ArrayList<>();
		Offers offers1 = new Offers(1, 25, "25% off");
		Offers offers2 = new Offers(1, 30, "30% off");
		offersList.add(offers1);
		offersList.add(offers2);

		given(offersRepo.findAll()).willReturn(offersList);

		assertEquals(offersService.getAllOffers(), offersList);
	}

	@Test
	 void getOffersByIdSuccessTest() throws Exception {
		Offers offer = new Offers(1, 25, "25% off");

		given(offersRepo.findById(1)).willReturn(Optional.of(offer));

		assertEquals(offersService.getOfferById(1), offer);
	}

	@Test
	 void getOffersByIdException() throws Exception {
		given(offersRepo.findById(1)).willReturn(Optional.empty());

		OffersNotFoundException except = assertThrows(OffersNotFoundException.class,
				() -> offersService.deleteOfferById(1));
		assertTrue(except.getMessage().contentEquals("Could not find the offer with id 1"));
	}

	@Test
	 void updateOfferSuccessTest() throws Exception {
		List<Offers> offersList = new ArrayList<>();
		Offers offer1 = new Offers(1, 25, "25% off");
		Offers offer2 = new Offers(2, 35, "35% off");
		offersList.add(offer1);
		offersList.add(offer2);

		given(offersRepo.findById(1)).willReturn(Optional.of(offer1));

		Offers offer3 = new Offers(1, 30, "30% off ends soon!");

		given(offersRepo.save(offer3)).willReturn(offer3);
		assertEquals(offersService.updateOffer(offer3), offer3);
	}

	@Test
	 void updateOfferNotFoundExceptionTest() throws Exception {
		Offers offer1 = new Offers(1, 25, "25% off");

		given(offersRepo.findById(1)).willReturn(Optional.empty());

		OffersNotFoundException except = assertThrows(OffersNotFoundException.class,
				() -> offersService.updateOffer(offer1));
		assertTrue(except.getMessage().contentEquals("Could not find the offer with id 1"));
	}

	@Test
	 void deleteOfferByIdSuccessTest() throws Exception {
		Offers offers1 = new Offers(1, 25, "25% off");
		Optional<Offers> ret = Optional.of(offers1);

		given(offersRepo.findById(1)).willReturn(ret);
		assertTrue(offersService.deleteOfferById(1));
	}

	@Test
	 void deleteOffersByIdExceptionTest() throws Exception {
		given(offersRepo.findById(1)).willReturn(Optional.empty());

		OffersNotFoundException except = assertThrows(OffersNotFoundException.class,
				() -> offersService.deleteOfferById(1));
		assertTrue(except.getMessage().contentEquals("Could not find the offer with id 1"));
	}

}
