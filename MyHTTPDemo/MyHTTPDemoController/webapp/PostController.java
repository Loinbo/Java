import redis.clients.jedis.Jedis;
import com.lamb.*;
import java.io.*;
import java.util.*;

public class PostController implements Controller {
	public void doPost(Request request, Response response) throws IOException {
		String title = request.params.get("title");
		String content = request.params.get("content");
		String id = UUID.randomUUID().toString();

		String key = "article_" + id;
		Jedis jedis = new Jedis("127.0.0.1");
		jedis.hset(key, "title", title);
		jedis.hset(key, "content", content);
		jedis.lpush("article_id_list", id + "@" + title);

		// 重定向到正文页
		response.status = "302 Temporarily Moved";
		response.setHeader("Location", "/a?id=" + id);
	}
}