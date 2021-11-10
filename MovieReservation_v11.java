import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.stream.XMLInputFactory;


public class MovieReservation_v11 {

	String[][] seat = new String[8][12];
	char rn;
	int cnt, row_int, col, system, crow_int, ccol;
	String con_char, name, c_name, m_name, row, q;
	String pw = "admin";
	Boolean confirm;
	
	
	public void Interface() {
		System.out.println("=== 영화관 좌석 예약 시스템입니다. ===");
		System.out.println("메뉴 번호를 선택하세요");
		System.out.print("예약(1) 취소(2) 좌석조회(3) 종료(4) 관리자(0) : ");
		
		Scanner scan = new Scanner(System.in);
		
		try {
			system = scan.nextInt();
			switch (system) {
			case 0:
				Admin();
				break;				
			case 1:
				Reservation();
				break;
			case 2:
				Cancel();
				break;
			case 3:
				Reference1();
				break;
			case 4:
				System.out.println("시스템을 종료 합니다.");
				break;
			default:
				System.out.println("잘못 누르셨습니다. 1~4번 중에서 선택해 주십시오.");
				System.out.println();
				Interface();
				
			}
		}
		catch(InputMismatchException e) {
			System.out.println("잘못 누르셨습니다. 1~4번 중에서 선택해 주십시오.");
			System.out.println();
		}		
	}
	
	
	public void Admin() {
		System.out.print("\n관리자 비밀번호를 입력하세요 : ");
		Scanner scan = new Scanner(System.in);
		if(scan.nextLine().equals(pw)) {
			System.out.println("※관리자 로그인 되었습니다.※");
			confirm = true;
			do {
				try {
					System.out.print("취소(1) 좌석조회(2) 종료(3) : ");
					system = new Scanner(System.in).nextInt();
					switch(system) {
					case 1:
						AdminCancel();
						break;
					case 2: 
						AdminRef();
						break;
					case 3:
						System.out.println("※관리자 모드 종료※");
						System.out.println();
						confirm = false;
						break;
					default:
						System.out.println("잘못 누르셨습니다. 1~3번 중에서 선택해 주십시오.");
						System.out.println();
					}
					
				}
				catch(InputMismatchException e) {
					System.out.println("잘못 누르셨습니다. 1~3번 중에서 선택해 주십시오.");
					System.out.println();
				}
			}while(confirm);
		}else {
			cnt++;
			System.out.println("비밀번호가 일치하지 않습니다. 비밀번호 틀린 횟수 (" +cnt+"/3)" );
			System.out.println();
			if(cnt==3) {
				System.out.println("비밀번호 시도 횟수 초과로 접속이 종료되었습니다.");
				System.exit(0);
			}
		}
	}
	
	
	public void Initialize() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<12; j++) {
				seat[i][j]="____";
			}
		}
	}
	
	
	public void AdminRef() {
		rn = 'A';		
		System.out.println();
		rn = 'A';
		System.out.print("   열 ");
		for(int j=0; j<9; j++) {			
			System.out.print((col+j+1)+"   ");			
		}
		for(int j=9; j<12; j++) {			
			System.out.print((col+j+1)+"  ");			
		}
		System.out.println();		
		
		for(int i=0; i<8; i++) {
			System.out.println(rn + "행 ");;
			col = 1;
			rn++;
			for(int j=0; j<12; j++) {
				System.out.println((col+j) + seat[i][j] + " ");				
			}			
			System.out.println();
		}
	}
	
	
	public void Reference1() {
		System.out.println();
		rn = 'A'; 
		col = 0;		
		System.out.print("   열 ");
		for(int j=0; j<9; j++) {			
			System.out.print((col+j+1)+"   ");			
		}
		for(int j=9; j<12; j++) {			
			System.out.print((col+j+1)+"  ");			
		}
		System.out.println();
			
		for(int i=0; i<8; i++) {
			System.out.print(rn + "행  ");		
			rn++;						
			for(int j=0; j<12; j++) {
				q = seat[i][j].equals("____")?" □ ":" ■ ";
				System.out.print(q + " ");				
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public void Reservation() {
		Reference1();		
		do {
			confirm = true;
			System.out.print("예약자 성함을 입력해 주세요 : ");
			Scanner scan = new Scanner(System.in);
			name = scan.nextLine();		
			if(name == "") {
				System.out.println("잘못 입력하셨습니다.");
			}
			else {
				System.out.print(name+"님이 맞으면 Y, 틀리면 X : ");
				con_char = scan.next();
				confirm = (con_char.equals("Y") || con_char.equals("y"))?false:true;					
			}							 
		}while(confirm);
		
		do {
			confirm = true;
			System.out.print("열을 선택하세요(A~H) : ");
			Scanner scan = new Scanner(System.in);
			try {
				row = scan.next();
			}catch(Exception e) {
				System.out.println("A~H만 입력하세요");
			}			
			if(row.equals("A")||row.equals("a")){
				row_int = 0;
				confirm = false;				
			}
			else if(row.equals("B")||row.equals("b")) {
				row_int = 1;
				confirm = false;
			}
			else if(row.equals("C")||row.equals("c")) {
				row_int = 2;
				confirm = false;
			}
			else if(row.equals("D")||row.equals("d")) {
				row_int = 3;
				confirm = false;
			}
			else if(row.equals("E")||row.equals("e")) {
				row_int = 4;
				confirm = false;
			}
			else if(row.equals("F")||row.equals("F")) {
				row_int = 5;
				confirm = false;
			}
			else if(row.equals("G")||row.equals("g")) {
				row_int = 6;
				confirm = false;
			}
			else if(row.equals("H")||row.equals("h")) {
				row_int = 7;
				confirm = false;
			}			
			else {
				System.out.println("A~H만 입력하세요");
			}
		}while(confirm);
		
		do {
			confirm = true;
			Scanner scan = new Scanner(System.in);
			try {
				System.out.print("좌석 번호를 선택해주세요. 1~12 : ");
				col = scan.nextInt();
				if(col>=1 && col<=12) {
					if(seat[row_int][col-1].equals("____")) {
						seat[row_int][col-1] = name;
						confirm = false;
					}
					else {
						System.out.println("이미 예약된 자리입니다.");
					} 
				}
				else {
					System.out.println("좌석은 1~12번 까지 입니다.");
				}
			}catch(Exception e) {
				System.out.println("좌석은 1~12번 까지 입니다.");
			}
		}while(confirm);
		System.out.println(seat[row_int][col-1]+"님 " + row +col + "석으로 예약이 완료 되었습니다.");
		Reference1();
	}
		
	
	public void Cancel() {
		System.out.print("이름을 입력하세요 : ");
		Scanner scan = new Scanner(System.in);
		cnt = 0;
		c_name = scan.nextLine();
		for(int i=0; i<8; i++) {
			for(int j=0; j<12; j++) {
				if(seat[i][j].equals(c_name)) {
					seat[i][j] = "____";
					cnt++;
					System.out.println(c_name + "님 취소가 완료되었습니다.");
					Reference1();					
				}
			}
		}
		if(cnt==0) {
			System.out.println(c_name + "님의 예약 내역이 존재하지 않습니다.");							
		}				
	}
	
	
	public void AdminCancel(){
		System.out.print("이름을 입력하세요 : ");
		Scanner scan = new Scanner(System.in);
		c_name = scan.nextLine();
		for(int i=0; i<5; i++) {
			for(int j=0; j<10; j++) {
				if(seat[i][j].equals(c_name)) {
					seat[i][j] = "____";
					System.out.println(c_name + "님 취소가 완료되었습니다.");
					AdminRef();
				}
			}			
		}		
	}
	
	
	public static void main(String[] args) {
		MovieReservation_v11 movie = new MovieReservation_v11();
		movie.Initialize();
		while(true) {
			movie.Interface();
			if(movie.system == 4)
				break;
		}		
	}	
}







