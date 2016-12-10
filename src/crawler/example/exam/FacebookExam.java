package crawler.example.exam;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 練習：取得任一篇或多篇文章的 Reactions 總數
 *
 *
 * 重點
 * 1. 先利用Graph Api調整出需要的資料
 * 2. 修改程式，使用爬蟲包取得資料
 * 3. 上傳至GitHub
 * 
 * @author Abola Lee
 *
 */
public class FacebookExam {
	
	public static void main(String[] args) {
		//狂新聞 按讚數
		// 遠端資料路徑

		String uri = 
				"https://graph.facebook.com/v2.6"
				+ "/crazyck101/feed?fields=id%2Clink%2Cmessage%2Ccreated_time%2Creactions.limit(0).summary(total_count)&since=1480849200&until=1480856400"
				+ "&access_token=EAACEdEose0cBAMpNLBaImZBYWs2ee6kv4woBZC7S9eiUDZAGUdBuiDhVA8ppuaaZBqM8AKH5QvSu7a17Wa5sHzJll8xEwelIPZClBrJnH4EpnzMwhtG7hcptZCXlh8NO4gIWoUDYcCvNilJmV5zM2s7VkIRCfROYCTvAxNoL6njAZDZD";


		Elements elems =
				CrawlerPack.start()
				.getFromJson(uri)
				.select("data");
		
		String output = "id ,reactions\n";

		// 遂筆處理
		for( Element data: elems ){
			String id = data.select("id").text();

			// FIXIT
			String reactions= data.select("reactions summary total_count").text();


			output += id + ",  " + reactions + "\n";
		}

		System.out.println( output );
	} 
}
