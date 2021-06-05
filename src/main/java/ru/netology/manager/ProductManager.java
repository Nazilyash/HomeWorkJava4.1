package ru.netology.manager;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void addToRepo(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] products = repository.findAll();
        Product[] findedProducts = new Product[0];
        for (Product product : products) {
            if (matches(product, text)) {
                int length = findedProducts.length + 1;
                Product[] tmp = new Product[length];
                System.arraycopy(findedProducts, 0, tmp, 0, findedProducts.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = product;
                findedProducts = tmp;
            }
        }
        return findedProducts;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().contains(search)) {
                return true;
            }
            if (book.getAuthor().contains(search)) {
                return true;
            }
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().contains(search)) {
                return true;
            }
            if (smartphone.getManufacturer().contains(search)) {
                return true;
            }
        }
        return false;
    }
}
