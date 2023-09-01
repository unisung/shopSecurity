package com.shop.controller;

import com.shop.dto.ItemDto;
import com.shop.entity.Item;
import com.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/thymeleaf")
@RequiredArgsConstructor
public class ThymeleafExController {

    private final ItemService service;

    @GetMapping(value = "/ex01")
    public String thymeleafExample01(Model model) {
        model.addAttribute("data", "타입리프예제 입니다.");
        return "thymeleafEx/thymeleafEx01";
    }

    @GetMapping("/ex02")
    public String thymeleafExample02(Model model) {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("상품 상세 설명");
        itemDto.setItemNm("테스트 상품1");
        itemDto.setPrice(10000);
        itemDto.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDto", itemDto);
        return "thymeleafEx/thymeleafEx02";
    }

    @GetMapping("/ex02_01")
    public @ResponseBody ItemDto thymeleafExample02() {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("상품 상세 설명");
        itemDto.setItemNm("테스트 상품1");
        itemDto.setPrice(10000);
        itemDto.setRegTime(LocalDateTime.now());
        return itemDto;
    }

    @GetMapping("/ex03")
    public String thymeleafExample03(Model model) {

        List<ItemDto> itemDtoList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {

            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setItemNm("테스트 상품" + i);
            itemDto.setPrice(1000 * i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }

        model.addAttribute("itemDtoList", itemDtoList);
        return "thymeleafEx/thymeleafEx03";
    }

    @GetMapping("/ex04")
    public String thymeleafExample04(Model model) {

        List<ItemDto> itemDtoList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {

            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setItemNm("테스트 상품" + i);
            itemDto.setPrice(1000 * i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }

        model.addAttribute("itemDtoList", itemDtoList);
        return "thymeleafEx/thymeleafEx04";
    }

    @GetMapping("/ex04_01")
    public @ResponseBody List<ItemDto> thymeleafExample0401() {

        List<ItemDto> itemDtoList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {

            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setItemNm("테스트 상품" + i);
            itemDto.setPrice(1000 * i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }

        return itemDtoList;
    }

    @GetMapping("/ex05")
    public String thymeleafExample05(Model model) {

        List<ItemDto> itemDtoList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {

            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setItemNm("테스트 상품" + i);
            itemDto.setPrice(1000 * i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }

        model.addAttribute("itemDtoList", itemDtoList);
        return "thymeleafEx/thymeleafEx05";
    }

    @GetMapping("/ex05_01")
    public  @ResponseBody List<ItemDto> thymeleafExample0501() {

        List<ItemDto> itemDtoList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {

            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setItemNm("테스트 상품" + i);
            itemDto.setPrice(1000 * i);
            itemDto.setRegTime(LocalDateTime.now());

            itemDtoList.add(itemDto);
        }
       return itemDtoList;
    }


    @GetMapping("/ex06")
    public String thymeleafExample06() {
        return "thymeleafEx/thymeleafEx06";
    }

    @GetMapping("/ex07")
    public String thymeleafExample07(String p1, String p2, Model model) {
        String param1 = p1;
        String param2=p2;
        model.addAttribute("param1",param1);
        model.addAttribute("param2",param2);
        return "thymeleafEx/thymeleafEx07";
    }

    /*@PostMapping("/ex07")
    public @ResponseBody ItemDto thymeleafPostExample0701(@RequestBody ItemDto itemDto, Model model) throws Exception {
        //model.addAttribute("itemDto",itemDto);
         System.out.println(itemDto);

         Item item = new Item();
         item.setId(itemDto.getId());
         item.setItemNm(itemDto.getItemNm());
         item.setPrice(itemDto.getPrice());
         item.setItemSellStatus(ItemSellStatus.valueOf(itemDto.getSellStatCd()));//"SELL" -> SELL
         item.setRegTime(itemDto.getRegTime());
         item.setUpdateTime(itemDto.getUpdateTime());
         item.setItemDetail(itemDto.getItemDetail());


         service.saveItem(item);
        return itemDto;
        //return "thymeleafEx/thymeleafEx07_01";
    }*/

    @PostMapping("/ex07")
    public @ResponseBody Item thymeleafPostExample0701(@RequestBody Item itemDto, Model model) throws Exception {
        System.out.println(itemDto);
        service.saveItem(itemDto);
        return itemDto;
    }

    @GetMapping("/ex08")
    public String thymeleafExample08(){
        return "thymeleafEx/thymeleafEx08";
    }

}