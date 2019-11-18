package controller;

import java.util.ArrayList;

import model.dao.B_UserDao;
import model.vo.User;

public class B_UserManager {
	private B_UserDao ud = new B_UserDao();

	//새 유저 등록용 메소드
	public void insertUser(User u) {
		
		//파일에 기록된 리스트 조회
		ArrayList<User> list = ud.readUserList();
		//조회 내역이 있는지 확인
		if(list == null) {
			//조회 내역이 없는 경우 새로운 리스트 생성
			list = new ArrayList<User>();
			System.out.println(list);
			//유저 번호를 1로 변경
		}
		//리스트에 user객체 추가
		list.add(u);
		System.out.println(list);
		//리스트를 파일에 기록 후 결과값 정수로 리턴
		int result = ud.writeUserList(list);
		//성공 실패 여부에 따라 뷰 페이지 결정
		if(result > 0) {
			System.out.println("등록 성공");
		}else {
			System.out.println("등록 에러");
		}
		
	}
	
	public boolean checkUserId(String Id) {
		
		ArrayList<User> list = ud.readUserList();
		
		User selectedUser = null;
		
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getId().equals(Id)) {
					return true;
				}
			}
		}
		
		return false;
	}

	public void selectUserPw(String Id) {
		
		//전체 User을 조회
		ArrayList<User> list = ud.readUserList();
		
		//일치하는 user 정보를 담을 레퍼런스 변수 초기화
		User selectedUser = null;
		//조회에 성공하면 유저 아이디와 일치하는 비밀번호를 리스트에서 탐색
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getId().equals(Id)) {
					selectedUser = list.get(i);
					break;
				}
			}
		}
		
		System.out.println("비밀번호는 : " + selectedUser.getPw());
	}
	
	//Score1 변경용 메소드
	public void updateScore1(String id, int score1) {
		//전체 리스트 조회
		ArrayList<User> list = ud.readUserList();
		//결과를 컨트롤할 변수 선언
		int result = 0;
		
		//id와 일치하는 유저 탐색
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				//탐색 결과가 있는 경우 score1 수정
				list.get(i).setScore1(score1);
				//수정 후 다시 파일에 리스트 저장
				result = ud.writeUserList(list);
				break;
			}
		}
		
		//결과에 따른 화면 연결
		if(result > 0) {
			System.out.println("updateScore1");
		}
	}

}
