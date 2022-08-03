
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ProductManagerTest {
    ProductManager manager = new ProductManager();
    Book book1 = new Book(1, "July", 25, "Sidorov");
    Book book2 = new Book(2, "August", 26, "Ivanov");
    Book book3 = new Book(3, "September", 27, "Petrov");
    Smartphone smartphone1 = new Smartphone(4, "Sansung", 28, "Japan");
    Smartphone smartphone2 = new Smartphone(5, "Siemens", 29, "Germany");


    @Test

    public void findAllTest() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);


        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveById() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        manager.removeById(1);


        Product[] actual2 = manager.findAll();

        Product[] expected2 = {book2, book3, smartphone1, smartphone2};

        assertArrayEquals(expected2, actual2);

    }

    @Test
    public void shouldFind2Elements() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);


        Product[] actual3 = manager.searchBy("ro");

        Product[] expected3 = {book1, book3};

        assertArrayEquals(expected3, actual3);

    }

    @Test
    public void shouldFind2Elements1() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);


        Product[] actual4 = manager.searchBy("Ger");

        Product[] expected4 = {smartphone2};

        assertArrayEquals(expected4, actual4);

    }


    @Test
    public void shouldFind2Elements2() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);


        Product[] actual5 = manager.searchBy("Sie");

        Product[] expected5 = {smartphone2};

        assertArrayEquals(expected5, actual5);

    }

    @Test
    public void shouldFind2Elements3() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);


        Product[] actual6 = manager.searchBy("Jul");

        Product[] expected6 = {book1};

        assertArrayEquals(expected6, actual6);

    }

    @Test
    public void shouldRemoveById1() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);


        manager.removeById(2);


        Product[] actual7 = manager.findAll();

        Product[] expected7 = {book1, book3, smartphone1, smartphone2};

        assertArrayEquals(expected7, actual7);

    }

    @Test
    public void shouldRemoveById2() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);


        assertThrows(NotFoundException.class, () -> {
            manager.removeById(-3);

        });

    }

    @Test
    public void shouldAddExistId() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);


        assertThrows(AlreadyExistsException.class, () -> {
            manager.add(book1);

        });

    }


}

