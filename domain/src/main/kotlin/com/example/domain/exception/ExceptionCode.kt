package com.example.domain.exception

enum class ExceptionCode(
    val message: String
) {
    DUPLICATE_USER("이미 회원가입을 완료한 유저입니다.")
}
