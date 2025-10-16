package topic6.app.user;

import topic6.app.user.dto.AppUserDto;

public class AppUserMapper {
    public static AppUser toEntity(AppUserDto dto) {
        AppUser u = new AppUser();
        u.setEmail(dto.getEmail());
        u.setFullName(dto.getFullName());
        return u;
    }
    public static AppUserDto toDto(AppUser u) {
        AppUserDto dto = new AppUserDto();
        dto.setEmail(u.getEmail());
        dto.setFullName(u.getFullName());
        return dto;
    }
}
