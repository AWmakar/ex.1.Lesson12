import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class ShopRepositoryTest {

    Product product1 = new Product(1, "Orange", 100);
    Product product2 = new Product(2, "Lemon", 200);
    Product product3 = new Product(3, "Mango", 500);
    Product product4 = new Product(4, "Pineapple", 650);

    @Test
    public void shouldPerformNotFound() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(6));
    }

    @Test
    public void shouldRemove() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        repo.remove(3);
        Product[] expected = {product1, product2, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
//    @Test
//    public void shouldRemoveNotExist() {
//        ShopRepository repo = new ShopRepository();
//        repo.add(product1);
//        repo.add(product2);
//
//        repo.remove(3);
//        Product[] expected = {product1, product2};
//        Product[] actual = repo.findAll();
//
//        Assertions.assertArrayEquals(expected, actual);
//
//    }
//}