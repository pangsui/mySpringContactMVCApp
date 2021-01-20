package tech.pangsui.mvcapp.test;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import tech.pangsui.mvcapp.config.SpringRootConfig;

public class TestDataSource {
	public static void main(String[] args) {

		try {
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			DataSource ds = ctx.getBean(DataSource.class);
			JdbcTemplate jt = new JdbcTemplate(ds);
			String sql = "INSERT INTO user(`name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES(?,?,?,?,?,?)";
			Object[] param = new Object[] { "Dam", "2376762271544", "upangsuddi@yahoo.com", "fianl", "pasui",
					"lingeh1990" };
			jt.update(sql, param);
			System.out.println("------SQL executed-----");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Connection failed!!!!");
		}

	}
}
