package net.softsociety.testboot.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security 설정
 */
@Configuration
public class WebSecurityConfig {
    @Autowired
    private DataSource dataSource;

    //설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers(
        		"/",
        		//"/**", //모든 페이지에 로그인 필요 없게 임시로 
                "/assets/**",
                "/css/**",
                "/fonts/**",
                "/icons/**",
                "/img/**",
                "/js/**",
                "/member/join",
                "/member/logincheck",
                "/member/js/**", //이거 머임?;
                "/board/list").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()					
        .loginPage("/member/login")	
        .loginProcessingUrl("/member/login").permitAll()
        .usernameParameter("userid") //username에 userid를(로그인 폼의 id의 name)
        .passwordParameter("userpw") //password에 userpw를(로그인 폼의 pw의 name)
        .and()
        .logout()
        .logoutUrl("/member/logout")
        .logoutSuccessUrl("/").permitAll()
        .and()
        .cors()
        .and()
        .httpBasic();

        return http.build();
    }

    //인증을 위한 쿼리
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
        .dataSource(dataSource)
        // 인증 (로그인)
        //enabled가 필수, 앞의건 테이블의 컬럼명, 뒤에건 username과 password 고정
        .usersByUsernameQuery(
        		"select user_id username, user_pw password, enabled " +
                "from prolingo_user " +
                "where user_id = ?")
        // 권한
        //여기 role_name은 제대로 동작할지?
        .authoritiesByUsernameQuery(
        		"select user_id username, user_role role_name " +
                "from prolingo_user " +
                "where user_id = ?");
    }

    // 단방향 비밀번호 암호화
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
    
    //로그인 하고 현재 페이지에 있으려면?
    
}
