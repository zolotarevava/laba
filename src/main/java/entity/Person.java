package entity;

import org.joda.time.LocalDate;

import java.util.Comparator;

public class Person implements Comparable<Person>{

    /*Поле фамилия*/
    private String surname;
    /*Поле дата рождения*/
    private LocalDate dateBirth;
    /*Поле идентификатор*/
    private int Id;
    private static int id = 0;

    /**
     * Конструктор класса Person
     * @param surname - фамилия
     * @param dateBirth - дата рождения
    */
    public Person(String surname, LocalDate dateBirth){
        this.surname = surname;
        this.dateBirth = dateBirth;
        id++;
        this.Id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateBirth;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    /**
     * Метод возвращает возраст человека
     * @return Возраст человека
     */
    public int getAge()
    {
        LocalDate current = LocalDate.now();
        int age = current.getYear() - dateBirth.getYear();
        if(current.getMonthOfYear() < dateBirth.getMonthOfYear()) age--;
        if(dateBirth.getMonthOfYear() == current.getMonthOfYear() && dateBirth.getDayOfMonth()<= current.getDayOfMonth()) age++;
        return age;
    }

    /**
     * Метод toString()
     * @return
     */
    public String toString(){
        return "ID: "+getId()+"\nSurname: "+getSurname()+"\nDate of birthday: " +getDateOfBirth();
    }

    public int compareTo(Person p){
        return (this.Id - p.Id);
    }
}
