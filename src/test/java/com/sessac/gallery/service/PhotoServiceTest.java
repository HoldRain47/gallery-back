package com.sessac.gallery.service;

import com.sessac.gallery.dto.PhotoResponse;
import com.sessac.gallery.entity.Photo;
import com.sessac.gallery.repository.PhotoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class PhotoServiceTest {
    @Mock
    private PhotoRepository photoRepository;

    @Mock
    private FileStorageService fileStorageService;

    @InjectMocks
    private PhotoService photoService;

    @Test
    @DisplayName("사진 목록 조회")
    void findAll(){
        List<Photo> photos = List.of(
            createPhoto("사진1","/uploads/1.jpg"),
            createPhoto("사진2","/uploads/2.jpg")
        );
        given(photoRepository.findAll()).willReturn(photos);

        List<PhotoResponse> result = photoService.findAll();

        assertThat(result).hasSize(2);
    }


    private Photo createPhoto(String title, String imageUrl){
        return Photo.builder().title(title).imageUrl(imageUrl).build();
    }

    @Test
    @DisplayName("사진 상세 조회")
    void findById(){
        Photo photo = createPhoto("사진1","1.jpg");
        given(photoRepository.findById(1L)).willReturn(java.util.Optional.of(photo));
        PhotoResponse result = photoService.findById(1L);
        assertThat(result.getTitle()).isEqualTo("사진1");
        assertThat(result.getImageUrl()).isEqualTo("1.jpg");

    }

}
