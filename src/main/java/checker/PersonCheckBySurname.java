package checker;

import entity.Person;

public class PersonCheckBySurname extends PersonCheck {
    @Override
    public boolean check(Object o, Person person) {
        return o.equals(person.getSurname());
    }
}
