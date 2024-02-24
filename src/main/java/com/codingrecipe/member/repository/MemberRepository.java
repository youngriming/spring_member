package com.codingrecipe.member.repository;

import com.codingrecipe.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository { //mybatis 사용

    private final SqlSessionTemplate sql;
    public int save(MemberDTO memberDTO) {
        System.out.println("memberDTO = "+memberDTO);
        return sql.insert("Member.save",memberDTO);
                         //mapper에서 namespace가 Member, id가 save 그래서 "Member.save" ,넘기는 객체는 DTO
    }
}
