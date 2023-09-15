package com.example.springboot3scheduledjobs.services;

import com.example.springboot3scheduledjobs.models.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class ProductInventoryJob {

    @Autowired
    ProductService productService;

    @Scheduled(fixedDelay = 5000)
    public void AddSaleProduct() throws InterruptedException {
        Product product = new Product();
        product.setName("sale product-" + new Random().nextInt(99));
        product.setDescription("a new sale product");
        product.setPrice(0.99);
        product.setQuantity(new Random().nextInt(50));
        product = productService.save(product);
        log.info("Added new Sale Product - {}", product);

        Long sleepTime = new Random().nextLong(6000);
        // log.info("Sleeping for {} milliseconds", sleepTime);
        Thread.sleep(sleepTime);
    }

    @Scheduled(fixedRate = 10000)
    @Async
    public void AddNewProduct() {
        Product product = new Product();
        product.setName("product-" + new Random().nextInt(99));
        product.setDescription("a new product");
        product.setPrice(4.99);
        product.setQuantity(new Random().nextInt(99));
        product = productService.save(product);
        log.info("Added new Product - {}", product);
    }


    // https://crontab.cronhub.io/ for cron help
    @Scheduled(cron = "*/15 * * * * *")
    public void ProductInventoryCount() {
        List<Product> products = productService.getAll();
        int count = 0;
        for (int i = 0; i < products.size(); i++) {
            count = count + products.get(i).getQuantity();
        }

        log.info("{} Products with a total inventory size of {}", products.size(), count);
    }


}
