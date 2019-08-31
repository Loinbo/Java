import redis.clients.jedis.Jedis;
import com.lamb.*;
import java.io.*;

public class ArticleController implements Controller {
	public void doGet(Request request, Response response) throws IOException {
		String id = request.params.get("id");
		if (id == null) {
			response.status = "404 Not Found";
			response.println("Not Found");
			return;
		}
		Jedis jedis = new Jedis("127.0.0.1");
		String title = jedis.hget("article_" + id, "title");
		String content = jedis.hget("article_" + id, "content");
		if (title == null) {
			response.status = "404 Not Found";
			response.println("Not Found");
			return;
		}

		response.println("<h1>" + title + "</h1>");
		response.println("<p>" + content + "</p>");
	}
}