package pl.training.shop;

import lombok.extern.java.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.training.shop.orders.Order;
import pl.training.shop.payments.LocalMoney;
import pl.training.shop.products.Product;
import pl.training.shop.products.ProductType;
import pl.training.shop.users.User;

import java.util.List;

@Log
public class Application {

    private static final String BASE_PACKAGE = "pl.training.shop";
    private static final Product VIDEO_PRODUCT = Product.builder()
            .name("Spring masterclass")
            .description("Praktyczny kurs Spring framework")
            .type(ProductType.VIDEO)
            .price(LocalMoney.of(799))
            .build();
    private static final Product BOOK_PRODUCT = Product.builder()
            .name("Spring guide")
            .description("Praktyczne ćwiczenia do samodzielnego wykonania")
            .type(ProductType.BOOK)
            .price(LocalMoney.of(200))
            .build();
    private static final User USER_ONE = User.builder()
            .firstName("Vladimír")
            .lastName("Chvatil")
            .build();
    private static final User USER_TWO = User.builder()
            .firstName("Mariusz")
            .lastName("Chwaszczyński")
            .build();

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BASE_PACKAGE)) {
            var shopService = applicationContext.getBean(ShopService.class);
            shopService.addProduct(VIDEO_PRODUCT);
            shopService.addProduct(BOOK_PRODUCT);
            log.info(shopService.getProducts(0, 100).toString());

            var order = new Order(List.of(VIDEO_PRODUCT, BOOK_PRODUCT));
            shopService.placeOrder(order);
            var payment = shopService.payForOrder(order.getId());
            log.info(payment.toString());

            log.info(shopService.getProductByName("Spring").toString());
            log.info(shopService.getProductByName("Spring").toString());


            var user = shopService.addUser(USER_ONE);
            shopService.addUser(USER_TWO);
            log.info(shopService.getUserById(user.getId()).toString());
            log.info(shopService.findUsersByLastName("Ch", 10, 0).toString());
        }
    }

}
