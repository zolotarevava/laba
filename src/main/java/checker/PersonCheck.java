package checker;

import entity.Person;

public abstract class PersonCheck implements IChecker<Person> {

    public abstract boolean check(Object o, Person person);
}
