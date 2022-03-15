package org.ader.tobyspringstudy;

import org.ader.tobyspringstudy.dao.ArticleDao;
import org.ader.tobyspringstudy.dao.DaoFactory;
import org.ader.tobyspringstudy.domain.Article;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.time.LocalDateTime;

@SpringBootApplication
public class TobyspringstudyApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//SpringApplication.run(TobyspringstudyApplication.class, args);

		ApplicationContext ac = new AnnotationConfigApplicationContext(DaoFactory.class);

		ArticleDao articleDao = ac.getBean("articleDao", ArticleDao.class);

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

		System.out.println("1-6 싱글톤 확인을 위한 출력");
		DaoFactory factory = new DaoFactory();
		ArticleDao articleDao1 = factory.articleDao();
		ArticleDao articleDao2 = factory.articleDao();

		System.out.println("---일반적으로 생성---");
		System.out.println(articleDao1);
		System.out.println(articleDao2);

		System.out.println("---스프링 컨텍스트에서 가져옴---");
		ArticleDao articleDao3 = ac.getBean("articleDao", ArticleDao.class);
		ArticleDao articleDao4 = ac.getBean("articleDao", ArticleDao.class);
		System.out.println(articleDao3);
		System.out.println(articleDao4);
	}
}
