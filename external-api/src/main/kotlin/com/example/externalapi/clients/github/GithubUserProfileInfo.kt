package com.example.externalapi.clients.github

import com.fasterxml.jackson.annotation.JsonProperty

data class GithubUserProfileInfo(
    @JsonProperty("login")
    val userId: String,
    @JsonProperty("avatar_url")
    val avatarUrl: String,
    @JsonProperty("html_url")
    val githubUrl: String,
    val email: String
)
