package _4.web5.pae.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;


import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // si probleme : enlever cette methode 
    // Bean : hash les mdp veantn d'un string 
  


    @Bean
    DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2) 
            .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION) 
            .build();

    }
    

    // on definit nos utilisateurs 
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        // pr récupérer les utilisateurs
        manager.setUsersByUsernameQuery(
            "select username, password, enabled from Account where username=?"
        );
        //pr récupérer les rôles
        manager.setAuthoritiesByUsernameQuery(
            "select username, authority from Authority where username=?"
        );
        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {    
        return http
                .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/login").permitAll() 
                    .requestMatchers("/css/**", "/js/**", "/images/**").permitAll() 
                    .requestMatchers("/students/**").permitAll()
                    .requestMatchers("/courses/add", "/student/add").permitAll()

                    .anyRequest().authenticated() 
                )
                .formLogin(form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/", true) // Redirection après login
                    .permitAll()
                )
                .logout(logout -> logout.logoutSuccessUrl("/login?logout").permitAll()) // Déconnexion
                .exceptionHandling(e -> e.accessDeniedPage("/denied")) // Page en cas de refus d'accès
                .csrf(AbstractHttpConfigurer::disable) // Désactive la protection CSRF (facultatif)
                .build();
    }

    

  
}
