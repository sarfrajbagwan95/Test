package com.example.sample.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "Id")
public int id;

@Column(name = "Name")
public String employeeName;
@Column(name = "Department")
public String department;

}
