import java.io.File;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Objects;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashMap;
import java.util.Map;

public class Save {

    static class Person {
            String name;
            int age;
            int height;

            public Person(String name, int age, int height) {
                this.name = name;
                this.age = age;
                this.height = height;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return age == person.age && height == person.height && name.equals(person.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, age, height);
            }

            @Override
            public String toString() {
                return "Person{" +
                        "name='" + name + " " +
                ", age=" + age +
                        ", height=" + height +
                        '}';
            }
        }

        private static final String csv =
                "Drew, 37, 168n" +
                        "Bob, 30, 170";

        public static void main(String[] args) {
            Map<String, Person> map = new HashMap<>();
            try (Scanner scanner = new Scanner(csv)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] lineParts = line.split("\s*,\s*");
                    map.put(lineParts[0], new Person(lineParts[0], Integer.parseInt(lineParts[1]), Integer.parseInt(lineParts[2])));
                }
            }
            System.out.println(map);
        }


}