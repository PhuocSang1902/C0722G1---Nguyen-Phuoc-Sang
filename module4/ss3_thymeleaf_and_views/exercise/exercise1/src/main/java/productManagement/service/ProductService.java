package productManagement.service;

import org.springframework.stereotype.Service;
import productManagement.model.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "FordTuner", 2000d, "Xe SUV 7 chỗ", "Toyota"));
        productList.add(new Product(2, "Ford Everest", 4000d, "Xe SUV 5 chỗ", "Ford"));
        productList.add(new Product(3, "C300", 5000d, "Xe sedan", "Mercedes"));
        productList.add(new Product(4, "CX-5", 1000d, "Xe SUV 5 chỗ", "Mazda"));
    }

    public List<Product> getList() {
        return productList;
    }

    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return productList.get(i);
            }
        }
        return null;
    }

    public void save(Product product) {
        productList.add(product);
    }

    public void edit(Product product, int id) {
        Product findProduct = findById(id);
        int index = productList.indexOf(findProduct);
        productList.set(index, product);
    }

    public void remove(int id) {
        Product product = findById(id);
        productList.remove(product);
    }

    public List<Product> search(String search) {
        List<Product> findProductList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(search)) {
                findProductList.add(product);
            }
        }
        return findProductList;
    }
}
