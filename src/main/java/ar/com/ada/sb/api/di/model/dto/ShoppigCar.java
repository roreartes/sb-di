package ar.com.ada.sb.api.di.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class ShoppigCar {

    private Long id;
    private List<Product> products;

    public ShoppigCar(Long id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public ShoppigCar(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ShoppigCar{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }

    public  Boolean isNull(){
        return products.isEmpty();
    }
}
