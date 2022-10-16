public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder setName(String name) throws IllegalArgumentException{
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Вы не указали имя.");
        } else this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Вы не указали фамилию.");
        } else this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException{
        if (age < 0 || age > 130) {
            throw new IllegalArgumentException("Возрасть не может быть отрицательным или больше 130 лет!");
        } else this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        Person person;
        if (name == null || surname == null) {
            throw new IllegalStateException("Фамилия или имя не указаны!");
        }
        if (age < 0) {
            person = new Person(name, surname);
        } else person = new Person(name, surname, age);
        person.setAddress(address);
        return person;
    }
}