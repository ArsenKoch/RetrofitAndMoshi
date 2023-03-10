package ua.cn.stu.http.sources.accounts

import kotlinx.coroutines.delay
import ua.cn.stu.http.app.model.accounts.AccountsSource
import ua.cn.stu.http.app.model.accounts.entities.Account
import ua.cn.stu.http.app.model.accounts.entities.SignUpData
import ua.cn.stu.http.sources.accounts.entities.SignInRequestEntity
import ua.cn.stu.http.sources.accounts.entities.SignUpRequestEntity
import ua.cn.stu.http.sources.accounts.entities.UpdateUsernameRequestEntity
import ua.cn.stu.http.sources.base.BaseRetrofitSource
import ua.cn.stu.http.sources.base.RetrofitConfig

class RetrofitAccountsSource(
    config: RetrofitConfig
) : BaseRetrofitSource(config), AccountsSource {

    private val accountsApi = retrofit.create(AccountsApi::class.java)

    override suspend fun signIn(
        email: String, password: String
    ): String = wrapRetrofitExceptions {
        delay(1000)
        val signIn = SignInRequestEntity(
            email = email,
            password = password
        )
        accountsApi.signIn(signIn).token
    }

    override suspend fun signUp(
        signUpData: SignUpData
    ) = wrapRetrofitExceptions {
        delay(1000)
        val signUp = SignUpRequestEntity(
            email = signUpData.email,
            username = signUpData.username,
            password = signUpData.password
        )
        accountsApi.signUp(signUp)
    }

    override suspend fun getAccount(): Account = wrapRetrofitExceptions {
        delay(1000)
        accountsApi.getAccount().toAccount()
    }


    override suspend fun setUsername(
        username: String
    ) = wrapRetrofitExceptions {
        delay(1000)
        val updateUsernameRequestEntity = UpdateUsernameRequestEntity(username)
        accountsApi.setUsername(updateUsernameRequestEntity)
    }
}