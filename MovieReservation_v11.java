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
		System.out.println("=== ��ȭ�� �¼� ���� �ý����Դϴ�. ===");
		System.out.println("�޴� ��ȣ�� �����ϼ���");
		System.out.print("����(1) ���(2) �¼���ȸ(3) ����(4) ������(0) : ");
		
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
				System.out.println("�ý����� ���� �մϴ�.");
				break;
			default:
				System.out.println("�߸� �����̽��ϴ�. 1~4�� �߿��� ������ �ֽʽÿ�.");
				System.out.println();
				Interface();
				
			}
		}
		catch(InputMismatchException e) {
			System.out.println("�߸� �����̽��ϴ�. 1~4�� �߿��� ������ �ֽʽÿ�.");
			System.out.println();
		}		
	}
	
	
	public void Admin() {
		System.out.print("\n������ ��й�ȣ�� �Է��ϼ��� : ");
		Scanner scan = new Scanner(System.in);
		if(scan.nextLine().equals(pw)) {
			System.out.println("�ذ����� �α��� �Ǿ����ϴ�.��");
			confirm = true;
			do {
				try {
					System.out.print("���(1) �¼���ȸ(2) ����(3) : ");
					system = new Scanner(System.in).nextInt();
					switch(system) {
					case 1:
						AdminCancel();
						break;
					case 2: 
						AdminRef();
						break;
					case 3:
						System.out.println("�ذ����� ��� �����");
						System.out.println();
						confirm = false;
						break;
					default:
						System.out.println("�߸� �����̽��ϴ�. 1~3�� �߿��� ������ �ֽʽÿ�.");
						System.out.println();
					}
					
				}
				catch(InputMismatchException e) {
					System.out.println("�߸� �����̽��ϴ�. 1~3�� �߿��� ������ �ֽʽÿ�.");
					System.out.println();
				}
			}while(confirm);
		}else {
			cnt++;
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. ��й�ȣ Ʋ�� Ƚ�� (" +cnt+"/3)" );
			System.out.println();
			if(cnt==3) {
				System.out.println("��й�ȣ �õ� Ƚ�� �ʰ��� ������ ����Ǿ����ϴ�.");
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
		System.out.print("   �� ");
		for(int j=0; j<9; j++) {			
			System.out.print((col+j+1)+"   ");			
		}
		for(int j=9; j<12; j++) {			
			System.out.print((col+j+1)+"  ");			
		}
		System.out.println();		
		
		for(int i=0; i<8; i++) {
			System.out.println(rn + "�� ");;
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
		System.out.print("   �� ");
		for(int j=0; j<9; j++) {			
			System.out.print((col+j+1)+"   ");			
		}
		for(int j=9; j<12; j++) {			
			System.out.print((col+j+1)+"  ");			
		}
		System.out.println();
			
		for(int i=0; i<8; i++) {
			System.out.print(rn + "��  ");		
			rn++;						
			for(int j=0; j<12; j++) {
				q = seat[i][j].equals("____")?" �� ":" �� ";
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
			System.out.print("������ ������ �Է��� �ּ��� : ");
			Scanner scan = new Scanner(System.in);
			name = scan.nextLine();		
			if(name == "") {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
			else {
				System.out.print(name+"���� ������ Y, Ʋ���� X : ");
				con_char = scan.next();
				confirm = (con_char.equals("Y") || con_char.equals("y"))?false:true;					
			}							 
		}while(confirm);
		
		do {
			confirm = true;
			System.out.print("���� �����ϼ���(A~H) : ");
			Scanner scan = new Scanner(System.in);
			try {
				row = scan.next();
			}catch(Exception e) {
				System.out.println("A~H�� �Է��ϼ���");
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
				System.out.println("A~H�� �Է��ϼ���");
			}
		}while(confirm);
		
		do {
			confirm = true;
			Scanner scan = new Scanner(System.in);
			try {
				System.out.print("�¼� ��ȣ�� �������ּ���. 1~12 : ");
				col = scan.nextInt();
				if(col>=1 && col<=12) {
					if(seat[row_int][col-1].equals("____")) {
						seat[row_int][col-1] = name;
						confirm = false;
					}
					else {
						System.out.println("�̹� ����� �ڸ��Դϴ�.");
					} 
				}
				else {
					System.out.println("�¼��� 1~12�� ���� �Դϴ�.");
				}
			}catch(Exception e) {
				System.out.println("�¼��� 1~12�� ���� �Դϴ�.");
			}
		}while(confirm);
		System.out.println(seat[row_int][col-1]+"�� " + row +col + "������ ������ �Ϸ� �Ǿ����ϴ�.");
		Reference1();
	}
		
	
	public void Cancel() {
		System.out.print("�̸��� �Է��ϼ��� : ");
		Scanner scan = new Scanner(System.in);
		cnt = 0;
		c_name = scan.nextLine();
		for(int i=0; i<8; i++) {
			for(int j=0; j<12; j++) {
				if(seat[i][j].equals(c_name)) {
					seat[i][j] = "____";
					cnt++;
					System.out.println(c_name + "�� ��Ұ� �Ϸ�Ǿ����ϴ�.");
					Reference1();					
				}
			}
		}
		if(cnt==0) {
			System.out.println(c_name + "���� ���� ������ �������� �ʽ��ϴ�.");							
		}				
	}
	
	
	public void AdminCancel(){
		System.out.print("�̸��� �Է��ϼ��� : ");
		Scanner scan = new Scanner(System.in);
		c_name = scan.nextLine();
		for(int i=0; i<5; i++) {
			for(int j=0; j<10; j++) {
				if(seat[i][j].equals(c_name)) {
					seat[i][j] = "____";
					System.out.println(c_name + "�� ��Ұ� �Ϸ�Ǿ����ϴ�.");
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







