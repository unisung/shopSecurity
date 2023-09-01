package com.shop.service;


import com.shop.dto.ItemDto;
import com.shop.entity.Item;
import com.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public void saveItem(Item itemDto) throws Exception{
        //상품등록
       itemRepository.save(itemDto);
    }

}
