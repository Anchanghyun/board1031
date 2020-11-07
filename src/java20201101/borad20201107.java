package java20201101;

import java.util.*;


public class borad20201107 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Article> articleList = new ArrayList<>();
		Map<Integer,String> map = new HashMap<>();
		int id = 1;
		String title;
		String body;
		
		while(true) {
			System.out.print("명령어를 입력해주세요 : ");
			String cmd = sc.nextLine();
			if(cmd.equals("exit")) {
				System.out.println("종료");
			}
			if(cmd.equals("add")) {
				System.out.print("제목을 입력해주세요 : ");
				title = sc.nextLine();
				System.out.print("내용을 입력해주세요 : ");
				body = sc.nextLine();
				System.out.println("게시물이 등록되었습니다.");
				map.put(id,title);
				Article a1 = new Article(id,title,body);
				articleList.add(a1);
				id++;
			}
			if(cmd.equals("list")) {
				for(int i = 0; i < articleList.size(); i++) {
					Article a = articleList.get(i);
					System.out.println("번호 : " + a.getId());
					System.out.println("제목 : " + a.getTitle());
					System.out.println("내용 : " + a.getBody());
					System.out.println("==========================");
				}
			}
			if(cmd.equals("update")) {
				System.out.print("수정할 번호 : ");
				
				String aid = sc.nextLine();
				int targetId = Integer.parseInt(aid);
				
				int existFlag = 1;
				
				for(int i = 0; i < articleList.size(); i++) {
					Article a = articleList.get(i);
					if(targetId == a.getId()); {
						existFlag = 2;
						
						System.out.print("제목 : ");
						title = sc.nextLine();
						System.out.print("내용 : ");
						body = sc.nextLine();
						
						Article article = new Article(a.getId(),title,body);
						
						articleList.set(i,article);
						break;
						}
					} 
				if(existFlag == 1) {
					System.out.println("없는 게시물입니다.");
					}
				}
			}
		}
	}

class Article{
	private String title;
	private String body;
	private int id;
	
	public Article(int id, String title, String body) {
		this.title = title;
		this.body= body;
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
