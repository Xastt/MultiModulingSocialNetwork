public interface PhotoService {
    Photo uploadPhoto(User user, Photo photo);
    Photo getPhotoById(Long id);
}
