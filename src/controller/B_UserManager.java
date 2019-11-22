package controller;

import java.util.ArrayList;
import java.util.Comparator;

import model.dao.B_UserDao;
import model.vo.User;

public class B_UserManager {
	private B_UserDao ud = new B_UserDao();

	//새 유저 등록용 메소드 (회원가입 페이지에서 사용)
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

	//사용 예시)
	//B_UserManager um = new B_UserManager();
	//um.printAll();
	//파일에 들어있는 모든 유저의 값 출력
	public void printAll() {
		ArrayList<User> list = ud.readUserList();
		if(list == null) {
			//조회 내역이 없는 경우 새로운 리스트 생성
			list = new ArrayList<User>();
			System.out.println(list);
			//유저 번호를 1로 변경
		}
		System.out.println(list);
		
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

	//아이디 찾기용 (이름)
	public boolean checkUserName(String Id) {

		ArrayList<User> list = ud.readUserList();

		User selectedUser = null;

		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName().equals(Id)) {
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



	
	//이메일 찾기용 (정보 수정 페이지 사용)
	public String selectEmail(String Id) {
		ArrayList<User> list = ud.readUserList();
		
		User selectedUser = null;
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getId().equals(Id)) {
					selectedUser = list.get(i);
				}
			}
		}
		return selectedUser.geteMail();
	}
	
	//네임 찾기용 (메인페이지 사용) 
	public String selectName(String Id) {
		ArrayList<User> list = ud.readUserList();
		
		User selectedUser = null;
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getId().equals(Id)) {
					selectedUser = list.get(i);
					break;
				}
			}
		}
		return selectedUser.getName();
	}
	
	//LoginCount 찾기용 (count = 0일시 반배정화면 count=1일시 메인화면), 로그인 후 인트로비디오페이지영상에서 사용
	public int selectLoginCount(String Id) {
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
		System.out.println("count 값 :" + selectedUser.getLoginCount());
		return selectedUser.getLoginCount();
	}

	//사용 예시)
	//UserManager um = new UserManager();
	//String[] result = um.selectUserScore(User.playerId);
	//result[0] -> 현재 유저의 score1값
	//result[1] -> 현재 유저의 score2값
	//현재 유저의 score1, score2, score3, total, 이름, 기숙사값 반환 (랭킹에서 사용)
	public String[] selectUserScore(String Id) {
		String[] userScore = new String[6];
		
		ArrayList<User> list = ud.readUserList();
		User selectedUser = null;
		if(list != null) {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getId().equals(Id)) {
					selectedUser = list.get(i);
					break;
				}
			}
		}
		userScore[0] = Integer.toString(selectedUser.getScore1());
		userScore[1] = Integer.toString(selectedUser.getScore2());
		userScore[2] = Integer.toString(selectedUser.getScore3());
		userScore[3] = Integer.toString(selectedUser.getTotal());
		userScore[4] = selectedUser.getName();
		userScore[5] = selectedUser.getDormitory();
		
		return userScore;
	}

	//LoginCount 변경(반배정 페이지에서 활용, 카운트 1 증가)
	public void updateLoginCount(String Id) {
		ArrayList<User> list = ud.readUserList();

		int result = 0;

		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(Id)) {
				list.get(i).setLoginCount(list.get(i).getLoginCount()+1);
				result = ud.writeUserList(list);
				System.out.println("변경된 count 값 : " + list.get(i).getLoginCount());
				break;
			}
		}


	}
	
	// 임시 비밀번호 변경
	public void updatePw(String id, String Pw) {
		// 전체 리스트 조회
		ArrayList<User> list = ud.readUserList();
		// 결과를 컨트롤할 변수 선언
		int result = 0;

		// id와 일치하는 유저 탐색
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				// 탐색 결과가 있는 경우 score1 수정
				list.get(i).setPw(Pw);
				// 수정 후 다시 파일에 리스트 저장
				result = ud.writeUserList(list);
				break;
			}
		}

		// 결과에 따른 화면 연결
		if (result > 0) {
			System.out.println("비밀번호 변경");
		}
	}


	//	Score1, Score2, Score3 변경 사용 예시)
	//	UserManager um = new UserManager();
	//	um.updateScore1(User.playerid, 700);
	
	//Score1 변경용 메소드 (Stage1 게임에서 사용)
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
				//Score1 값이 변경되서 Total 값 다시 설정
				list.get(i).setTotal(list.get(i).getScore1()+list.get(i).getScore2() + list.get(i).getScore3());
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

	//Score2 변경용 메소드(Stage2 게임에서 사용)
	public void updateScore2(String id, int score2) {
		//전체 리스트 조회
		ArrayList<User> list = ud.readUserList();
		//결과를 컨트롤할 변수 선언
		int result = 0;

		//id와 일치하는 유저 탐색
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				//탐색 결과가 있는 경우 score2 수정
				list.get(i).setScore2(score2);
				//Score2 값이 변경되서 Total 값 다시 설정
				list.get(i).setTotal(list.get(i).getScore1()+list.get(i).getScore2() + list.get(i).getScore3());
				//수정 후 다시 파일에 리스트 저장
				result = ud.writeUserList(list);
				break;
			}
		}

		//결과에 따른 화면 연결
		if(result > 0) {
			System.out.println("updateScore2");
		}
	}
	
	
	//Score3 변경용 메소드(Stage 3 게임에서 사용)
	public void updateScore3(String id, int score3) {
		//전체 리스트 조회
		ArrayList<User> list = ud.readUserList();
		//결과를 컨트롤할 변수 선언
		int result = 0;

		//id와 일치하는 유저 탐색
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				//탐색 결과가 있는 경우 score3 수정
				list.get(i).setScore3(score3);
				//Score3 값이 변경되서 Total 값 다시 설정
				list.get(i).setTotal(list.get(i).getScore1()+list.get(i).getScore2() + list.get(i).getScore3());
				//수정 후 다시 파일에 리스트 저장
				result = ud.writeUserList(list);
				break;
			}
		}

		//결과에 따른 화면 연결
		if(result > 0) {
			System.out.println("updateScore3");
		}
	}

	//사용예시)
	//B_UserManager um = new B_UserManager();
	//um.updateDormitory(User.playerId, "그리핀도르")
	//배정된 기숙사 입력 메소드 (기숙사 배정 페이지에서 사용)
	public void updateDormitory(String id, String dormitory) {
		ArrayList<User> list = ud.readUserList();
		
		int result = 0;
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				list.get(i).setDormitory(dormitory);
				result = ud.writeUserList(list);
				break;
			}
		}
		
		if(result > 0) {
			System.out.println("updateDormitory");
		}
	}
	
	//사용 예시)
	//UserManager um = new UserManager();
	//String[][] result = um.sortList(new DescUserTotal());
	//result[0][0]의 의미 => total값 1위  User 객체의 score1 점수 값
	//result[0][1]의 의미 => total값 1위  User 객체의 score2 점수 값
	//result[1][5]의 의미 => total값 2위 User 객체의  dormitory(기숙사) 값 (예) 그리핀도르, 슬리데린...)
	//정렬 처리용 메소드 (랭킹 페이지에서 사용)
	public String[][] sortList(Comparator c) {
		//리스트 전체 조회
		ArrayList<User> list = ud.readUserList();
		//정렬
		list.sort(c);
		String[][] sortList = new String[list.size()][6];
		for(int i = 0; i < list.size(); i++) {
			//System.out.println(list.get(i).getTotal());
			sortList[i][0] = Integer.toString(list.get(i).getScore1());
			sortList[i][1] = Integer.toString(list.get(i).getScore2());
			sortList[i][2] = Integer.toString(list.get(i).getScore3());
			sortList[i][3] = Integer.toString(list.get(i).getTotal());
			sortList[i][4] = list.get(i).getName();
			sortList[i][5] = list.get(i).getDormitory();
		}

		return sortList;

		//System.out.println(list.get(0).getTotal());
	}


}
