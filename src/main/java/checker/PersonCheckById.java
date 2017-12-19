package checker;

import entity.Person;

public class PersonCheckById extends PersonCheck {

    @Override
    public boolean check(Object o, Person person) {
        return o.equals(person.getId());
    }
}
