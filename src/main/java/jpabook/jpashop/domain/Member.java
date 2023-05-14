package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded   // 내장타입
    private Address address;

    @OneToMany(mappedBy = "member") // 나는 order 테이블에 있는 member에 의해 매핑된 거울일 뿐이야.
    // 때문에 여기 값이 변경되어도 order 테이블의 member는 변경되지 않음
    private List<Order> orders = new ArrayList<>();
}
