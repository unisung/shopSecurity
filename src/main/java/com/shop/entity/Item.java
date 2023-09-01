package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
//import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="item")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
public class Item {
    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //  @GeneratedValue(strategy = GenerationType.AUTO) //mysql - id 자동 발번상품코드
    @Column(nullable = false, length = 50)
    private String itemNm;//상품명
    @Column(nullable = false, name="price")
    private int price;//가격
    @Column(nullable = false, name="stockNumber")
    private int stockNumber;//재고수량
    @Lob
    @Column(nullable = false)
    private String itemDetail;//상품 상세 설명
    private ItemSellStatus itemSellStatus;//상품 판매 상태

    @CreatedDate
    private LocalDateTime regTime;//등록 시간
    @LastModifiedDate
    private LocalDateTime updateTime;//수정 시간
}
