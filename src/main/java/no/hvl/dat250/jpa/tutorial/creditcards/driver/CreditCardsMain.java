package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    // Create and persist a customer
    Customer customer = new Customer();
    customer.setName("Max Mustermann");
    em.persist(customer);

    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);

    // Managing the bi-directional relationship between Customer and Address
    customer.getAddresses().add(address);
    address.getOwners().add(customer);

    em.persist(address);

    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);
    em.persist(pincode);

    Bank bank = new Bank();
    bank.setName("Pengebank");
    em.persist(bank);  // It's often beneficial to persist entities early, especially if they're referenced by others

    // Create first credit card
    CreditCard creditCard1 = new CreditCard();
    creditCard1.setNumber(12345);
    creditCard1.setBalance(-5000);
    creditCard1.setCreditLimit(-10000);
    creditCard1.setPincode(pincode);
    creditCard1.setBank(bank);
    em.persist(creditCard1);

    // Create second credit card
    CreditCard creditCard2 = new CreditCard();
    creditCard2.setNumber(123);
    creditCard2.setBalance(1);
    creditCard2.setCreditLimit(2000);
    creditCard2.setPincode(pincode);
    creditCard2.setBank(bank);
    em.persist(creditCard2);

    Set<CreditCard> creditCards = new HashSet<>(List.of(creditCard1, creditCard2));
    bank.setOwnedCards(creditCards);

    // Managing the uni-directional relationship between Customer and CreditCard
    customer.getCreditCards().add(creditCard1);
    customer.getCreditCards().add(creditCard2);
    em.merge(customer);
  }


}
