public class Main {
    public static void main(String[] args) {

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);


        try {
            // Не хватает обяхательных полей
            new PersonBuilder()
//                    .setName("Нурлан")
//                    .setSurname("Каламбуров")
//                    .setAge(135)
//                    .setAddress("Новороссийск")
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder()
//                    .setName("Иван")
//                    .setSurname("Ванько")
                    .setAge(-100)
                    .build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
