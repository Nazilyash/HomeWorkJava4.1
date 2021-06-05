package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {
    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductManager manager;
    private Product first = new Book(1, "Cien anos de soledad Ку-ку", 1740, "Маркес Габриэль Гарсиа");
    private Product second = new Book(2, "El doble", 880, "Достоевский Федор Михайлович Ку-ку");
    private Product third = new Smartphone(1, "Redmi 9C Ку-ку", 9690, "Xiaomi");
    private Product fourth = new Smartphone(2, "Blade A3", 5390, "ZTE Ку-ку");
    private Product fifth = new Book(3, "Blade", 999, "Marvel Comics");

    @Test
    public void shouldCheckAddToRepo() {
        doNothing().when(repository).save(first);
        manager.addToRepo(first);
        verify(repository).save(first);
    }

    @Test
    public void shouldCheckSearchByIfSmartphoneAndBookExist() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("Ку-ку");
        Product[] expected = new Product[]{first, second, third, fourth};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void shouldCheckSearchByIfSmartphoneNameExist() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("Red");
        Product[] expected = new Product[]{third};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void shouldCheckSearchByIfSmartphoneManufacturerExist() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("Z");
        Product[] expected = new Product[]{fourth};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void shouldCheckSearchByIfBookAuthorExist() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("Федор");
        Product[] expected = new Product[]{second};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void shouldCheckSearchByIfBookNameExist() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("soledad");
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    public void shouldCheckSearchByIfProductNotExist() {
        Product[] returned = new Product[]{first, second, third, fourth, fifth};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searchBy("sony");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }
}