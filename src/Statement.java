import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

class Statement {
    public static void main(String[] args) {
        /*
        * 1. Buat Scanner
        * 2. Buat perulangan untuk input object person
        * 3. Print hasil input person
        * 4. buat fitur pencarian dengan java stream
        * */

        Scanner sc = new Scanner(System.in);
        List<Person> person = new ArrayList<Person>();
        String nextCode = "y";

        while (nextCode.equalsIgnoreCase("y")) {
            System.out.print("Masukkan Nama Anda: ");
            String name = sc.nextLine();

            System.out.print("Masukkan Umur Anda: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Masukkan Alamat Anda: ");
            String address = sc.nextLine();

            person.add(new Person(name, age, address));

            System.out.print("Tambah orang lagi? (y/n): ");
            nextCode = sc.nextLine();
        }

        IntStream.range(0, person.size())
                .forEach(i -> {
                    Person data = person.get(i);
                    System.out.printf("%d. %s   |   %d  |  %s  |\n", i+1, data.name, data.age, data.address);
                });

        System.out.print("Masukkan nama orang yang ingin anda cari: ");
        String targetName = sc.nextLine();

        List<Person> foundedPerson = person.stream()
                .filter(data -> data.name.toLowerCase().contains(targetName.toLowerCase()))
                .toList();

        if (foundedPerson.isEmpty()) {
            System.out.println("Data tidak ditemukan!");
            return;
        }

        System.out.printf("Berikut adalah hasil pencarian anda dengan kata kunci ($s)\n", targetName);
        foundedPerson.forEach(data -> {
            System.out.println("Name: "+data.name);
            System.out.println("Umur: "+data.age);
            System.out.println("Alamat: "+data.address);
        });
    }
}