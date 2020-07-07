package com.cos.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// Bean 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것

// 아래 세개의 annotation이 스프링 시큐리티 사용시 반드시 필요한 것들!
@Configuration // 빈등록(IoC관리)
@EnableWebSecurity // 스프링 시큐리티가 등록이 된다.
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/auth/**") // auth 경로는
				.permitAll() // 누구나 들어올 수 있다.
				.anyRequest() // 그걸 제외한 모든 요청은 
				.authenticated() // 인증이 되야한다.
			.and()
				.formLogin() // localhost://8000 로 접근하면 자동으로
				.loginPage("/auth/loginForm"); // /auth/loginForm을 띄어준다
		
	}
	
}