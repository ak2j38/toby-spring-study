package org.ader.tobyspringstudy;

import org.ader.tobyspringstudy.dao.ArticleDao;
import org.ader.tobyspringstudy.dao.WooWahanArticleDao;
import org.ader.tobyspringstudy.domain.Article;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;
import java.time.LocalDateTime;

@SpringBootApplication
public class TobyspringstudyApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//SpringApplication.run(TobyspringstudyApplication.class, args);

		ArticleDao articleDao = new WooWahanArticleDao();

		Article article = new Article();
		article.setId(1L);
		article.setWriter("ader");
		article.setTitle("title test");
		article.setContents("contents test");
		article.setCreatedTime(LocalDateTime.now());
		article.setUpdatedTime(LocalDateTime.now());

		articleDao.add(article);
		System.out.println("등록 성공");

		Article findArticle = articleDao.get(article.getId());
		System.out.println("findArticle.getWriter() = " + findArticle.getWriter());
		System.out.println("findArticle.getTitle() = " + findArticle.getTitle());

		System.out.println(findArticle.getId() + " 조회 성공");
	}
}
