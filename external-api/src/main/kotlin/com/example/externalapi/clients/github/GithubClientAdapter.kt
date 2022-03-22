package com.example.externalapi.clients.github

import org.springframework.stereotype.Service

@Service
class GithubClientAdapter(
    private val githubAuthorizationClient: GithubAuthorizationClient,
    private val githubClient: GithubClient,
) {

    fun getUserProfile(authToken: String): GithubUserProfileInfo {
        return githubClient.getUserProfile(
            authToken = "token $authToken"
        )
    }

    fun getAuthorizationToken(clientId: String, clientSecret: String, code: String): String {
        val authorizationToken = githubAuthorizationClient.getAuthorizationToken(
            clientId = clientId,
            clientSecret = clientSecret,
            code = code
        )

        val firstSeparator = "="
        val secondSeparator = "&"
        val separatedTokenKey = authorizationToken.split(firstSeparator)[1]
        return separatedTokenKey.split(secondSeparator)[0]
    }
}
