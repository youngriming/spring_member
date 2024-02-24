package com.codingrecipe.member.repository;

import com.codingrecipe.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository { //mybatis 사용

    private final SqlSessionTemplate sql;
    public int save(MemberDTO memberDTO) {
        System.out.println("memberDTO = "+memberDTO);
        return sql.insert("Member.save",memberDTO);
                         //mapper에서 namespace가 Member, id가 save 그래서 "Member.save" ,넘기는 객체는 DTO
    }

    public MemberDTO login(MemberDTO memberDTO) {
        return sql.selectOne("Member.login",memberDTO); // 만약 조회결과가 여러개인데 selectOne을 쓰면 500 에러 발생
    }

    public List<MemberDTO> findAll() { //전체데이터를 가져오기때문에 굳이 매개변수를 둘 필요가 없음
        return sql.selectList("Member.findAll");
    }

    public MemberDTO findById(Long id) {
        return sql.selectOne("Member.findById",id);
    }

    public void delete(Long id) {
        sql.delete("Member.delete",id);
    }

    public MemberDTO findByMemberEmail(String loginEmail) {
        return sql.selectOne("Member.findByMemberEmail",loginEmail);
    }

    public int update(MemberDTO memberDTO) {
        return sql.update("Member.update",memberDTO); //update 하면 1, update한게 없으면 0
    }
}
