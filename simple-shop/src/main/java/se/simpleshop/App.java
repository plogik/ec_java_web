package se.simpleshop;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManager;

import se.simpleshop.domain.entities.Person;
import se.simpleshop.domain.entities.Pet;
import se.simpleshop.domain.PersistenceManager;

public class App {
    public static void main(String[] args) {
        basicUserDemo();
    }

    public static void basicUserDemo() {
        Person kalle = new Person().setName("Kalle Andreasson");
        Person lisa = new Person().setName("Lisa Svensson");

        Pet fido = new Pet().setBreed("Dog").setName("Fido");
        Pet missan = new Pet().setBreed("Cat").setName("Missan");
        List<Pet> pets = new ArrayList<Pet>() {{
            add(fido);
            add(missan);
        }};
        kalle.setPets(pets);
        fido.setPerson(kalle);
        missan.setPerson(kalle);

        EntityManager em = PersistenceManager.getInstance().getEntityManager();
        em.getTransaction().begin();
        em.persist(kalle);
        em.persist(lisa);
        em.getTransaction().commit();
        em.close();

        em = PersistenceManager.getInstance().getEntityManager();
        List<Person> persons = em
            .createQuery("SELECT p FROM Person p")
            .getResultList();
        for(Person p : persons) {
            System.out.println(p);
        }
        em.close();

        PersistenceManager.getInstance().close();
    }
}
