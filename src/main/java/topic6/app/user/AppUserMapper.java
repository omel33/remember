package topic6.app.user;

import topic6.app.user.dto.AppUserDto;

public class AppUserMapper {

    public static AppUserDto toDto(AppUser entity) {
        if (entity == null) return null;

        AppUserDto dto = new AppUserDto();
        dto.setEmail(entity.getEmail());
        dto.setFullName(entity.getFullName());
        return dto;
    }

    public static AppUser toEntity(AppUserDto dto) {
        if (dto == null) return null;

        AppUser entity = new AppUser();
        entity.setEmail(dto.getEmail());
        entity.setFullName(dto.getFullName());
        return entity;
    }
}
