package ar.com.ada.sb.api.di.service;

import ar.com.ada.sb.api.di.component.UtilsComponent;
import ar.com.ada.sb.api.di.model.dto.ShoppigCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("shoopingCarService")
public class ShoppingCarService {
    @Autowired @Qualifier("utilsComponent")
    private UtilsComponent component;

    public ShoppigCar saveShoppingCar( ShoppigCar shoppigCar) throws Exception {

        if(shoppigCar == null)
            throw new Exception("ShoppingCar cant be null");

        long id = component.generateId();
        shoppigCar.setId(id);

        return shoppigCar;
    }

}
