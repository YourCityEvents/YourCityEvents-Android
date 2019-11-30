package com.sharaga.yourcityevents_android.modules.auth.login.presenter
import com.sharaga.yourcityevents_android.extensions.showError
import com.sharaga.yourcityevents_android.modules.auth.login.view.LoginFragment
import com.sharaga.yourcityevents_android.repository.UserRepository
import com.sharaga.yourcityevents_android.repository.realmdto.RealmUser
import com.sharaga.yourcityevents_android.security.AppUser
import com.sharaga.yourcityevents_android.service.ApiFactory
import com.sharaga.yourcityevents_android.service.validators.EmailValidator
import com.sharaga.yourcityevents_android.service.validators.PasswordValidator
import io.realm.Realm
import io.realm.RealmList
import java.lang.ref.WeakReference

interface ILoginPresenter {
    fun login(email: String, password: String)
}

class LoginPresenter(private var view: WeakReference<LoginFragment>) : ILoginPresenter {

    private val emailValidator = EmailValidator()
    private val passwordValidator = PasswordValidator()
    private val identityApi = ApiFactory.identityApi
    private val userRepository = UserRepository(Realm.getDefaultInstance())

    override fun login(email: String, password: String) {
        if (emailValidator.validate(email) && passwordValidator.validate(password)) {
            identityApi.login(AppUser.current)

        } else {
            view.get()?.showError("invalid")
        }
    }

    fun cumshot() {
        userRepository.save(RealmUser("228", "ldsf", "ldsjf", "lsdfj", "dlskfj", "ldsfk", RealmList(), RealmList(), "ldsf", "ldsf"))
        view.get()?.showError(userRepository.getById("228").toString())

    }
}