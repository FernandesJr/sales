package com.siganatural.sales.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private Environment environment; //Ambiente de execução, nesta class focado para config o db h2

    public static final String[] PUBLIC = {"/oauth/token", "/h2-console/**"}; //login

    public static final String ROLE_MAIN = "MAIN";
    public static final String ROLE_SALESMAN = "SALESMAN";
    public static final String ROLE_ADMIN = "ADMIN";


    @Autowired
    private JwtTokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/oauth/token", "/h2-console/**").permitAll()

                //USER
                .antMatchers("/roles/**").hasRole(ROLE_MAIN)

                //USER
                .antMatchers(HttpMethod.POST, "/users").hasRole(ROLE_MAIN)
                .antMatchers("/users").hasAnyRole(ROLE_MAIN, ROLE_ADMIN, ROLE_SALESMAN)

                .anyRequest().authenticated(); //Informando que qualquer outra rota não especificada será necessário se autenticar

        //Configuração especial para rodar o H2 com a segurança dos recursos
        if(Arrays.asList(environment.getActiveProfiles()).contains("test")){
            http.headers().frameOptions().disable();
        }

        http.cors().configurationSource(corsConfigurationSource()); //Configurando o Cors
    }

    //IMPLEMENTAÇÃO NA NUVEM por default vem bloqueado
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOriginPatterns(Arrays.asList("*")); //Informando qual host poderá acessar esse backend: * = liberado para todos. Porém, deve informar em qual host está o front 'https://meudominio.com' assim somente este host terá acesso
        corsConfig.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "PATCH"));
        corsConfig.setAllowCredentials(true);
        corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return source;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean
                = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE); //Informando que desejamos maior prescedencia para a execução deste bean
        return bean;
    }

}
