package ro.fasttrackit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonService {
    private final List<Person> persons = new ArrayList<>();

    public PersonService(List<Person> persons) {
        this.persons.addAll(persons);
    }


    public List<String> getFirstAndLastName() {
        List<String> result = persons.stream()
                .map(person -> person.firstName() + " " + person.lastName())
                .toList();
        return result;
    }

    public List<Person> getMajor() {
        List<Person> result = persons.stream()
                .filter(person -> person.age() >= 18)
                .toList();
        return result;
    }

    public List<Person> getPersonsFromOradea() {
        List<Person> result = persons.stream()
                .filter(person -> "oradea".equalsIgnoreCase(person.city()))
                .toList();
        return result;
    }

    public List<Person> getPersonsFromOradeaOrCluj() {
        List<Person> result = persons.stream()
                .filter(person -> "oradea".equalsIgnoreCase(person.city()) ||
                        "cluj".equalsIgnoreCase(person.city()))
                .toList();
        return result;
    }

    public List<String> getFirstNameCapitalized() {
        List<String> result = persons.stream()
                .map(person -> person.firstName().toUpperCase())
                .toList();
        return result;
    }

    public List<String> getFirstNameAndFirstLetterFromLastName() {
        List<String> result = persons.stream()
                .map(person -> person.firstName() + " " + person.lastName().charAt(0) + ".")
                .toList();
        return result;
    }

    public List<Person> getPersonsWithAgeBetweenEighteenAndSixty() {
        List<Person> result = persons.stream()
                .filter(person -> person.age() > 18 && person.age() < 60)
                .toList();
        return result;
    }

    public List<Person> getPersonsHavingFirstNameStartingWithA() {
        List<Person> result = persons.stream()
                .filter(person -> person.firstName().toLowerCase().charAt(0) == 'a')
                .toList();
        return result;
    }

    public List<String> getUniqueFirstNames() {
        Set<String> resultSet = persons.stream()
                .map(person -> person.firstName())
                .collect(Collectors.toSet());
        List<String> result = new ArrayList<>(resultSet);
        return result;
    }

    public List<Person> getSortedByFirstNameReversed() {
        List<Person> result = persons.stream()
                .sorted(Comparator.comparing(Person::firstName).reversed())
                .toList();
        return result;
    }

    public List<Person> getSortedByLastName() {
        List<Person> result = persons.stream()
                .sorted(Comparator.comparing(Person::lastName))
                .toList();
        return result;
    }

    public List<Person> getSortedByFirstNameLastNameAndAge() {
        List<Person> result = persons.stream()
                .sorted(Comparator.comparing(Person::firstName)
                        .thenComparing(Person::lastName)
                        .thenComparingInt(Person::age))
                .toList();
        return result;
    }

    public void addPerson(Person p) {
        persons.add(p);
    }

}
