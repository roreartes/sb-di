package ar.com.ada.sb.api.di.service;

import ar.com.ada.sb.api.di.component.UtilsComponent;
import ar.com.ada.sb.api.di.model.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("productService")
public class ProductService {

    @Autowired @Qualifier("utilsComponent")
    public UtilsComponent component;

    public Product saveNewProduct(Product product) throws Exception {
        if(product == null)
            throw new Exception("Product cant be null");

        long id = new Random().nextLong() % (100 - 10) + 10;
        product.setId(id);

        return product;
    }

}
