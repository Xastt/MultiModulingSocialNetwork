import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


class SetPhotoTest {

    private UserService userService;
    private PhotoService photoService;
    private SetPhoto setPhoto;

    Long userId = 1L;
    long photoId = 2L;
    User user = new User(userId);
    Photo photo = new Photo(userId, photoId);

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        photoService = mock(PhotoService.class);
        setPhoto = new SetPhoto(photoService, userService);
    }

    @Test
    void setPhoto() {
        when(userService.getUserById(userId)).thenReturn(user);
        when(photoService.getPhotoById(photoId)).thenReturn(photo);
        setPhoto.setPhoto(userId, photoId);
        verify(photoService).uploadPhoto(user, photo);
    }
}