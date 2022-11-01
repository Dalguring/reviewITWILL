package com.itwillbs.mvc_board.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itwillbs.mvc_board.vo.MemberVO;

// Service 객체에서 사용할(호출할) 메서드 형태를 추상메서드로 정의(DAO 클래스 대신 사용)
// => 정의된 추상메서드는 XML 파일(XXXMapper.xml)에서 연결되어 활용됨
// => 주의! 추상메서드 이름과 XML 파일에서의 id 속성명이 같아야 함!
public interface MemberMapper {
	// 1. 회원 가입에 필요한 insertMember() 메서드 정의
	// => 파라미터 : MemberVO 객체(member)	리턴타입 : int
	public int insertMember(MemberVO member);
	
	// 2. 로그인에 필요한 loginMember() 메서드 정의
	public MemberVO loginMember(MemberVO member);
	
	// 3. 회원 정보 조회 작업에 필요한 selectMemberInfo() 메서드 정의
	public MemberVO selectMemberInfo(String id);
	
	// 4. 전체 회원 목록 조회에 필요한 selectMemberList() 메서드 정의
	// => 파라미터 : 없음,	리턴타입 : List<MemberVO>
	public List<MemberVO> selectMemberList();
	
	// 5. 회원 삭제에 필요한 deleteMember() 메서드 정의
	public int deleteMember(String id);
	
	// 6. 회원 정보 수정에 필요한 updateMember() 메서드 정의
	// => *단, 복수개의 파라미터가 전달될 경우 각 파라미터를 Mapper에서 구별하기 위해
	//	  @Param 어노테이션을 사용하여 해당 파라미터의 이름을 지정해줘야 한다!
	//	  ex) @Param("member") MemberVO member, @Param("newPasswd") String newPasswd
	//	  또는 Map 객체에 모두 넣은 후 한개만 전달하는 방법도 있음(이 방법이 좋음)
	public int updateMember(@Param("member") MemberVO member, @Param("newPasswd") String newPasswd);

}
