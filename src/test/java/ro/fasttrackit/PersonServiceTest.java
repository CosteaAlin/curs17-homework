package ro.fasttrackit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonServiceTest {
    PersonService persons;
    Person p1;
    Person p2;

    @BeforeEach
    void setup() {
        p1 = new Person("Alin", "Costea", 22, "Oradea");
        p2 = new Person("Bogdan", "Pop", 13, "Cluj");
        persons = new PersonService(List.of(p1, p2));
    }

    @Test
    void testGetFirstAndLastName() {
        assertThat(persons.getFirstAndLastName()).isEqualTo(List.of("Alin Costea", "Bogdan Pop"));
    }

    @Test
    void testGetMajor() {
        assertThat(persons.getMajor()).isEqualTo(List.of(p1));
    }

    @Test
    void testGetPersonsFromOradea() {
        assertThat(persons.getPersonsFromOradea()).isEqualTo(List.of(p1));
    }

    @Test
    void testGetPersonsFromOradeaOrCluj() {
        assertThat(persons.getPersonsFromOradeaOrCluj()).isEqualTo(List.of(p1, p2));
    }

    @Test
    void testGetFirstNameCapitalized() {
        assertThat(persons.getFirstNameCapitalized()).isEqualTo(List.of("ALIN", "BOGDAN"));
    }

    @Test
    void testGetFirstNameAndFirstLetterFromLastName() {
        assertThat(persons.getFirstNameAndFirstLetterFromLastName()).isEqualTo(List.of("Alin C.", "Bogdan P."));
    }

    @Test
    void testGetPersonsWithAgeBetweenEighteenAndSixty() {
        assertThat(persons.getPersonsWithAgeBetweenEighteenAndSixty()).isEqualTo(List.of(p1));
    }

    @Test
    void testGetPersonsHavingFirstNameStartingWithA() {
        assertThat(persons.getPersonsHavingFirstNameStartingWithA()).isEqualTo(List.of(p1));
    }

    @Test
    void testGetUniqueFirstNames() {
        Person p3 = new Person("Alin", "Ardelean", 35, "Iasi");
        persons.addPerson(p3);
        assertThat(persons.getUniqueFirstNames()).isEqualTo(List.of("Bogdan", "Alin"));
    }

    @Test
    void testGetSortedByFirstNameReversed() {
        assertThat(persons.getSortedByFirstNameReversed()).isEqualTo(List.of(p2, p1));
    }

    @Test
    void testGetSortedByLastName() {
        assertThat(persons.getSortedByLastName()).isEqualTo(List.of(p1, p2));
    }

    @Test
    void testGetSortedByFirstNameLastNameAndAge() {
        Person p3 = new Person("Alin", "Ardelean", 5, "Iasi");
        persons.addPerson(p3);
        assertThat(persons.getSortedByFirstNameLastNameAndAge()).isEqualTo(List.of(p3, p1, p2));
    }
}
