public class SetPhoto {
    private final PhotoService photoService;
    private final UserService userService;

    public SetPhoto(PhotoService photoService, UserService userService) {
        this.photoService = photoService;
        this.userService = userService;
    }

    public void setPhoto(Long userId, Long photoId) {
        User user = userService.getUserById(userId);
        Photo photo = photoService.getPhotoById(photoId);
        photoService.uploadPhoto(user, photo);
    }

}
