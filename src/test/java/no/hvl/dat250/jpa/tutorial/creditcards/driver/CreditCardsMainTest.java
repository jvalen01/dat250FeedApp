package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import no.hvl.dat250.jpa.tutorial.creditcards.*;
import org.junit.Before;
import org.junit.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Optional;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreditCardsMainTest {

    private EntityManagerFactory factory;

    @Before
    public void setUp() {
        factory = Persistence.createEntityManagerFactory(CreditCardsMain.PERSISTENCE_UNIT_NAME);
    }

    @Test
    public void testDomainModelPersistence() {
        // Run the main class to persist the objects.
        CreditCardsMain.main(new String[]{});

        EntityManager em = factory.createEntityManager();

        // Load customer
        Customer customer = em.find(Customer.class, 1L);

        // Test person data
        assertThat(customer.getName(), is("Max Mustermann"));

        // Test address
        assertThat(customer.getAddresses().size(), is(1));
        Address address = customer.getAddresses().iterator().next();

        assertThat(address.getStreet(), is("Inndalsveien"));
        assertThat(address.getNumber(), is(28));
        assertThat(address.getOwners(), is(Set.of(customer)));

        // Test credit cards
        assertThat(customer.getCreditCards().size(), is(2));
        CreditCard firstCard = getCardWithNumber(customer, 12345);
        CreditCard secondCard = getCardWithNumber(customer, 123);

        assertThat(firstCard.getNumber(), is(12345));
        assertThat(firstCard.getBalance(), is(-5000));
        assertThat(firstCard.getCreditLimit(), is(-10000));

        assertThat(secondCard.getNumber(), is(123));
        assertThat(secondCard.getBalance(), is(1));
        assertThat(secondCard.getCreditLimit(), is(2000));

        // Test pincode
        Pincode firstCardPincode = firstCard.getPincode();

        assertThat(firstCardPincode.getId(), is(secondCard.getPincode().getId())); // Pincode objects of the two cards are identical!
        assertThat(firstCardPincode.getCode(), is("123"));
        assertThat(firstCardPincode.getCount(), is(1));

        // Test bank
        Bank bank = firstCard.getOwningBank();
        assertThat(bank.getId(), is(secondCard.getOwningBank().getId())); // Bank objects of the two cards are identical!
        assertThat(bank.getName(), is("Pengebank"));
        assertThat(bank.getOwnedCards(), is(Set.of(firstCard, secondCard)));
    }

    private CreditCard getCardWithNumber(Customer customer, int cardNumber) {
        Optional<CreditCard> optionalCard = customer.getCreditCards().stream()
                .filter(creditCard -> creditCard.getNumber() == cardNumber)
                .findFirst();
        if (optionalCard.isEmpty()) {
            throw new RuntimeException(
                    String.format("Card with number %s was not found for the person %s!",
                            cardNumber,
                            customer.getName()));
        }
        return optionalCard.get();
    }
}