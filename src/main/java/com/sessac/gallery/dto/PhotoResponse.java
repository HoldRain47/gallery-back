package com.sessac.gallery.dto;

import com.sessac.gallery.entity.Photo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PhotoResponse {

    private Long id;
    private String title;
    private String description;
    private String imageUrl;

    public static PhotoResponse from(Photo photo) {
        return PhotoResponse.builder()
                .id(photo.getId())
                .title(photo.getTitle())
                .description(photo.getDescription())
                .imageUrl(photo.getImageUrl())
                .build();
    }

}
