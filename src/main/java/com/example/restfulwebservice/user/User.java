package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password", "ssn"})
//@JsonFilter("UserInfo")// UserInfo : 필터이름
@ApiModel(description = "사용자 상세 정보 도메인 객체")
@Entity //해당 클래스 이름으로 DB에 테이블 생성, 클래스 필드 정보로 테이블 생성에 필요한 컬럼 정보로 사용
public class User {

    @Id //기본 키
    @GeneratedValue //자동 생성되는 키 값
    private Integer id;

    @Size(min = 2, message = "Name은 2글자 이상")
    @ApiModelProperty(notes = "사용자 이름 입력")
    private String name;
    @Past
    @ApiModelProperty(notes = "사용자 등록일 입력")
    private Date joinDate;

    @ApiModelProperty(notes = "사용자 패스워드 입력")
    private String password;
    @ApiModelProperty(notes = "사용자 주민번호 입력")
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User(int id, String name, Date joinDate, String password, String ssn) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.ssn = ssn;
    }
}
