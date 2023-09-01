package com.shop;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;
import com.shop.repository.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

@SpringBootTest
@TestPropertySource(locations ="classpath:application.properties" )
class ShopApplicationTests {
    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품저장테스트")
    public void creteItemTest(){
     Item item = new Item();
     item.setItemNm("테스트 상품");
     item.setPrice(10000);
     item.setItemDetail("테스트 상품 상세 설명");
     item.setItemSellStatus(ItemSellStatus.SELL);
     item.setStockNumber(100);
     item.setRegTime(LocalDateTime.now());
     item.setUpdateTime(LocalDateTime.now());
     Item savedItem = itemRepository.save(item);
     System.out.println(savedItem.toString());
    }

}
