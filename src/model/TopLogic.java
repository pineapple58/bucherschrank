package model;

import java.util.ArrayList;
import java.util.List;

public class TopLogic {

	public List<Book> getBookList(){
		List<Book> bookList = new ArrayList<Book>() {
			{
				add(new Book("スッキリわかるJava入門"));
				add(new Book("javaプログラマBronzase7/8　スピードマスター問題集"));
				add(new Book("JavaプログラマBronza SE7/8 初心者でもらくらく合格"));
				add(new Book("1週間でCCNAの基礎が学べる本　第2版"));
				add(new Book("Cisco CCENT/CCNARouthing&Switching ICND1編　V3,0対応　問題集"));
				add(new Book("Cisco CCENT/CCNARouthing&Switching ICND1編　V3,0対応　教科書"));
				add(new Book("徹底攻略 Java SE 8 Silver 問題集[1Z0-808]対応"));
				add(new Book("徹底攻略 Java SE 8 Gold 問題集[1Z0-809]対応"));
				add(new Book("とにかく受かりたい人のためのJavaプログラマSilver se8　２週間速習口座"));
				add(new Book("徹底攻略　ネットワークスペシャリスト　教科書平成３０年度"));
				add(new Book("Linux教科書　LPICレベル１　Version5,0対応"));
				add(new Book("Linux教科書　LPICレベル２　Version4,5対応"));
				add(new Book("いちばんやさしいHTML5&CSS3の教本"));
				add(new Book("平成31/01年　栢木先生のITパスポート教室"));
				add(new Book("平成31/01年　栢木先生のI書き込み式ドリル　ITパスポート"));
				add(new Book("世界一わかりやすいIT業界のしくみとながれ　第5版"));
				add(new Book("入社1年目ビジネスマナーの教科書"));
				add(new Book("入社１年目の教科書"));
				add(new Book("JavaプログラマSilver se8"));
				add(new Book("PowerShell実践ガイドブック"));
				add(new Book("ゼロからわかる SQL超入門 (かんたんIT基礎講座) "));
				add(new Book("スッキリわかるSQL入門 第2版 ドリル222問付き! (スッキリシリーズ) "));
				add(new Book("スラスラ読める JavaScript ふりがなプログラミング (ふりがなプログラミングシリーズ) "));
				add(new Book("応用情報技術者テキスト&問題集　２０１９年度版"));
				add(new Book("Effective C++ 第三版"));
				add(new Book("ロベールのC++入門講座"));
			}
		};
		return bookList;
	}

	public List<Book> getRentalBookList(){
		List<Book> rentalBookList = new ArrayList<Book>() {
			{
				add(new Book("スッキリわかるJava入門"));
				add(new Book("1週間でCCNAの基礎が学べる本　第2版"));
				add(new Book("Linux教科書　LPICレベル１　Version5,0対応"));
				add(new Book("スッキリわかるSQL入門 第2版 ドリル222問付き! (スッキリシリーズ) "));
			}
		};
		return rentalBookList;
	}

}
