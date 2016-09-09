package us.shiroyama.android.common.usecase;

import android.support.annotation.NonNull;

import us.shiroyama.android.common.entity.User;
import us.shiroyama.android.common.exception.UserNotFoundException;
import us.shiroyama.android.common.repository.UserRepository;

/**
 * {@link User}エンティティを取得／保存するためのユースケース
 */
public class UserInfoUseCaseImpl implements UserInfoUseCase {
    private UserRepository userRepository;

    public UserInfoUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void findById(long id, UserFetchSuccess onSuccess, UserFetchFailure onFailure) {
        try {
            User user = userRepository.findById(id);
            if (user == null) {
                onFailure.onFailure(new UserNotFoundException("no such user"));
                return;
            }
            onSuccess.onSuccess(user);
        } catch (Exception e) {
            onFailure.onFailure(e);
        }
    }

    @Override
    public void save(@NonNull User user, UserSaveSuccess onSuccess, UserSaveFailure onFailure) {
        try {
            boolean isSuccessful = userRepository.save(user);
            if (isSuccessful) {
                onSuccess.onSuccess(isSuccessful);
                return;
            }
            onFailure.onFailure(new IllegalStateException("Failed to save user"));
        } catch (Exception e) {
            onFailure.onFailure(e);
        }
    }
}
