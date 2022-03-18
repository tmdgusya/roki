package com.example.domain.application

import com.example.domain.UseCase
import com.example.domain.model.UserRegisterFormModel
import com.example.domain.service.UserCommandService
import com.example.domain.service.UserQueryService
import isFalse

@UseCase
class UserRegisterFacade(
    private val userQueryService: UserQueryService,
    private val userCommandService: UserCommandService,
) {

    /**
     * 일반 회원가입은 만들었는데 일단.. 이 기능을 내야할지는 나중에 판단하자.
     */
    fun register(userRegisterFromModel: UserRegisterFormModel.In) {
        userQueryService.checkExist(userEmail = userRegisterFromModel.userEmail) isFalse {
            throw IllegalAccessException("이미 회원가입된 유저입니다.")
        }
        val user = userRegisterFromModel.toEntity()
        userCommandService.register(user)
    }

    /**
     * Github-Register API
     */
}
