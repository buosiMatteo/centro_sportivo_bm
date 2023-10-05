package it.euris.centrosportivobm.config.security;

import it.euris.centrosportivobm.data.enums.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConf {

  private final WhiteListConfiguration whiteList;

  public SecurityConf(WhiteListConfiguration whiteList) {
    this.whiteList = whiteList;
  }

  @Bean
  public static PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {

    http
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests((authorize) -> authorize
            .requestMatchers(whiteList.getUrls()).permitAll()
            .requestMatchers(HttpMethod.GET,"/address/v1").permitAll()
            .requestMatchers(HttpMethod.GET,"/courses/v1").permitAll()
            .requestMatchers(HttpMethod.GET,"/contacts/v1").permitAll()
            .requestMatchers(HttpMethod.GET,"/customers/v1").permitAll()
            .requestMatchers("/address/v1/**").hasRole(UserRole.MANAGER.toString())
            .requestMatchers("/courses/v1/**").hasRole(UserRole.MANAGER.toString())
            .requestMatchers("/contacts/v1/**").hasRole(UserRole.MANAGER.toString())
            .requestMatchers("/customers_courses/v1/**").hasRole(UserRole.MANAGER.toString())
            .requestMatchers(HttpMethod.DELETE,"/customers").hasRole(UserRole.MANAGER.toString())
            .requestMatchers("/customers").hasAnyRole(
                UserRole.MANAGER.toString(),
                UserRole.USER.toString())
            .anyRequest().authenticated()
        )
        .httpBasic(withDefaults());

    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService (){

    UserDetails user = User.builder()
        .username("user")
        .password(passwordEncoder().encode("user"))
        .roles(UserRole.USER.toString())
        .build();

    UserDetails admin = User.builder()
        .username("admin")
        .password(passwordEncoder().encode("admin"))
        .roles(UserRole.MANAGER.toString())
        .build();

    UserDetails visitor = User.builder()
        .username("visitor")
        .password(passwordEncoder().encode("visitor"))
        .roles(UserRole.VISITOR.toString())
        .build();

    return new InMemoryUserDetailsManager(user,admin,visitor);
  }

}
