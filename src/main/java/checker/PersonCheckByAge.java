package checker;

import entity.Person;

import org.joda.time.LocalDate;

public class PersonCheckByAge extends PersonCheck {
    @Override
    public boolean check(Object o, Person person) {
        return o.equals(person.getAge());
    }
}
