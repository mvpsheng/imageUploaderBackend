package com.example.imageupload.mapper;

import com.example.imageupload.model.ImageInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * FileName: ImageMapper
 * author: gxs
 * Date: 2023/2/24  16:28
 */
@Mapper
public interface ImageMapper {
    @Results({
            @Result(property = "url", column = "image_url"),
            @Result(property = "label", column = "image_label")
    })
    @Insert("insert into image (image_url, image_label) values (#{url}, #{label})")
    void addImage(String url, String label);

    @Results({
            @Result(property = "url", column = "image_url"),
            @Result(property = "label", column = "image_label")
    })
    @Select("SELECT image_url, image_label from image")
    List<ImageInfo> getAllImages();
}
