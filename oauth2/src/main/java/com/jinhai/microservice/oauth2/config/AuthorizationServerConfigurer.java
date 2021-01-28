package com.jinhai.microservice.oauth2.config;

import com.jinhai.microservice.oauth2.exception.OauthWebResponseExceptionTranslator;
import com.jinhai.microservice.oauth2.service.JdbcRedisableDetailsService;
import com.jinhai.microservice.oauth2.service.OauthUserDetaisService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

/**
 * Oauth2配置
 * @author Jinhai
 * @version 1.0
 * @className AuthorizationServerConfigurer
 * @date 2020/10/29 15:43
 */
@Configuration
@RequiredArgsConstructor
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;
    private final RedisConnectionFactory redisConnectionFactory;
    private final OauthUserDetaisService oauthUserDetaisService;
    /**
     *  数据源
     * @Author Jinhai
     * @param
     * @Date 16:25 2020/10/29
     * @return javax.sql.DataSource
     * @Exception
     **/
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     *  令牌安全约束
     * @Author Jinhai
     * @param security
     * @Date 15:45 2020/10/29
     * @return void
     * @Exception 
     **/
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //允许客户端权限访问
        security.allowFormAuthenticationForClients()
                // 开启/oauth/check_token验证端口认证权限访问
                .checkTokenAccess("isAuthenticated()");
    }

    /**
     *  配置客户端详情服务初始化
     * @Author Jinhai
     * @param clients
     * @Date 15:46 2020/10/29
     * @return void
     * @Exception 
     **/
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        JdbcRedisableDetailsService jdbcRedisableDetailsService = new JdbcRedisableDetailsService(dataSource());

        clients.withClientDetails(jdbcRedisableDetailsService);
    }

    /**
     *  授权及令牌服务
     * @Author Jinhai
     * @param endpoints
     * @Date 15:59 2020/10/29
     * @return void
     * @Exception 
     **/
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
        .authenticationManager(authenticationManager)
        // refresh_token需要userDetailsService
        .reuseRefreshTokens(false).userDetailsService(oauthUserDetaisService)
        .exceptionTranslator(new OauthWebResponseExceptionTranslator());
    }

    /**
     *  token Redis缓存
     * @Author Jinhai
     * @param
     * @Date 16:48 2020/10/29
     * @return org.springframework.security.oauth2.provider.token.TokenStore
     * @Exception
     **/
    @Bean
    public TokenStore tokenStore() {
        RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
        tokenStore.setPrefix("oauth2");
        return tokenStore;
    }
}
