package com.jinhai.microservice.oauth2.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * @author Jinhai
 * @version 1.0
 * @className JdbcRedisableDetailsService
 * @date 2020/10/29 16:06
 */
public class JdbcRedisableDetailsService extends JdbcClientDetailsService{
    public JdbcRedisableDetailsService(DataSource dataSource) {
        super(dataSource);
    }

    /**
     *  重写接口支持Redis缓存
     * @Author Jinhai
     * @param clientId
     * @Date 16:20 2020/10/29
     * @return org.springframework.security.oauth2.provider.ClientDetails
     * @Exception
     **/
    @Cacheable(value = "oauth2:client:details",key = "#clientId",unless = "#result==null")
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws InvalidClientException {
        return super.loadClientByClientId(clientId);
    }

}
