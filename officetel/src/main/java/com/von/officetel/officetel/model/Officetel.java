package com.von.officetel.officetel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@ToString(exclude = "id")
public class Officetel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long ownerType; // 중개사 1 개인 2
    private String buildingName;
    private String address;
    private Long propertyType; // 매매 1 월세 2 전세 3
    private Long price; // 월세는 보증금으로 적용
    private Long monthlyRent; // 월세만 존재
    private Long area;
    private String floor;
    private String direction;
    private String description;
    private String owner;
    private LocalDate listingDate;

}
