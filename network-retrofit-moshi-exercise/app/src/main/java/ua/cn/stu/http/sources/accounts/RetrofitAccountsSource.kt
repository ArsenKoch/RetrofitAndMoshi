package ua.cn.stu.http.sources.accounts

import kotlinx.coroutines.delay
import ua.cn.stu.http.app.model.accounts.AccountsSource
import ua.cn.stu.http.app.model.accounts.entities.Account
import ua.cn.stu.http.app.model.accounts.entities.SignUpData
import ua.cn.stu.http.sources.accounts.entities.SignInRequestEntity
import ua.cn.stu.http.sources.accounts.entities.SignUpRequestEntity
import ua.cn.stu.http.sources.base.BaseRetrofitSource
import ua.cn.stu.http.sources.base.RetrofitConfig

// todo #7: implement AccountSource methods:
//          - signUp -> should call ' POST /sign-up'
//          - getAccount -> should call 'GET /me' and return account data
//          - setUsername -> should call 'PUT /me'
class RetrofitAccountsSource(
    config: RetrofitConfig
) : BaseRetrofitSource(config), AccountsSource {

    private val accountsApi = retrofit.create(AccountsApi::class.java)

    override suspend fun signIn(
        email: String, password: String
    ): String = wrapRetrofitExceptions{
        delay(1000)
        val signIn = SignInRequestEntity(
            email = email,
            password = password
        )
        accountsApi.signIn(signIn).token
    }

    override suspend fun signUp(
        signUpData: SignUpData
    ) {
        delay(1000)
        val signUp = SignUpRequestEntity(
            email = signUpData.email,
            username = signUpData.username,
            password = signUpData.password
        )
        accountsApi.signUp(signUp)
    }

    override suspend fun getAccount(): Account {
        delay(1000)
        TODO()
    }

    override suspend fun setUsername(
        username: String
    ) {
        delay(1000)
        TODO()
    }

}