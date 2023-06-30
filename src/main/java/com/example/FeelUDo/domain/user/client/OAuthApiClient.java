package com.example.FeelUDo.domain.user.client;

import com.example.FeelUDo.domain.user.dto.OAuthInfoResponse;
import com.example.FeelUDo.domain.user.entity.OAuthProvider;
import com.example.FeelUDo.domain.user.dto.params.OAuthLoginParams;

// OAuth 요청을 위한 Client 클래스
public interface OAuthApiClient {

    /**
     * Client 의 타입 반환
     * */
    OAuthProvider oAuthProvider();

    /**
     * Authorization Code 를 기반으로 인증 API 를 요청해서 Access Token 을 획득
     * */
    String requestAccessToken(OAuthLoginParams params);

    /**
     * Access Token 을 기반으로 Email, Nickname 이 포함된 프로필 정보를 획득
     * */
    OAuthInfoResponse requestOauthInfo(String accessToken);
}