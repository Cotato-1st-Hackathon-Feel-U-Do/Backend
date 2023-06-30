package com.example.FeelUDo.domain.user.service;

import com.example.FeelUDo.domain.user.client.OAuthApiClient;
import com.example.FeelUDo.domain.user.dto.OAuthInfoResponse;
import com.example.FeelUDo.domain.user.entity.Member;
import com.example.FeelUDo.domain.user.jwt.AuthTokens;
import com.example.FeelUDo.domain.user.jwt.AuthTokensGenerator;
import com.example.FeelUDo.domain.user.dto.params.OAuthLoginParams;
import com.example.FeelUDo.domain.user.repsitory.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthLoginService {
    private final MemberRepository memberRepository;

    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;

    private final OAuthApiClient oAuthApiClient;
    /**
     * access Token 으로 카카오 로그인
     * */
    public AuthTokens testLogin(String accessToken){
        OAuthInfoResponse oAuthInfoResponse = oAuthApiClient.requestOauthInfo(accessToken);
        Long memberId = findOrCreateMember(oAuthInfoResponse);
        return authTokensGenerator.generate(memberId);
    }

    ///////////////////////////////////////////////////////////////////////
    public AuthTokens login(OAuthLoginParams params) {
        OAuthInfoResponse oAuthInfoResponse = requestOAuthInfoService.request(params);
        Long memberId = findOrCreateMember(oAuthInfoResponse);
        return authTokensGenerator.generate(memberId);
    }

    private Long findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {
        return memberRepository.findByEmail(oAuthInfoResponse.getEmail())
                .map(Member::getId)
                .orElseGet(() -> newMember(oAuthInfoResponse));
    }

    /**
     * 유저가 없으면 새로 생성해주는
     * */
    private Long newMember(OAuthInfoResponse oAuthInfoResponse) {
        Member member = Member.builder()
                .email(oAuthInfoResponse.getEmail())
                .nickname(oAuthInfoResponse.getNickname())
                .oAuthProvider(oAuthInfoResponse.getOAuthProvider())
                .build();

        return memberRepository.save(member).getId();
    }

}
