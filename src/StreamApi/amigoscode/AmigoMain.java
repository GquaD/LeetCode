package StreamApi.amigoscode;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Behzod on 21, March, 2021
 */
public class AmigoMain {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        //Filter
        System.out.println("females");
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        females.forEach(System.out::println);

        //Sort
        System.out.println("Sorted");
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender))
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);

        //All match
        System.out.println("All match");
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 5);
        System.out.println(allMatch);

        //Any match
        System.out.println("Any match");
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 100);

        System.out.println(anyMatch);

        //non match
        System.out.println("None match");
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));
        System.out.println(noneMatch);

        //max
        System.out.println("Max");
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        //min
        System.out.println("Min");
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        //group
        System.out.println("Grouping: ");
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

/*        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
        });*/
        System.out.println("Oldest female: ");
        Optional<String> oldestFemaleName = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        oldestFemaleName.ifPresent(System.out::println);

        System.out.println("Queue: ");
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 10; i > 0; i--) {
            queue.add(i);
        }
        System.out.println("queue size: " + queue.size());
        while (!queue.isEmpty()) System.out.println(queue.poll());
    }

    private static List<Person> getPeople() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("James Bond", 33, Gender.MALE));
        persons.add(new Person("Alina Smith", 33, Gender.FEMALE));
        persons.add(new Person("Helen White", 57, Gender.FEMALE));
        persons.add(new Person("Alex Boz", 14, Gender.MALE));
        persons.add(new Person("Jamie Goa", 99, Gender.MALE));
        persons.add(new Person("Anna Cook", 7, Gender.FEMALE));
        persons.add(new Person("Zelda Brown", 120, Gender.FEMALE));
        return persons;
    }
}
