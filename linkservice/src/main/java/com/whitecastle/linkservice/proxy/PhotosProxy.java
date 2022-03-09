package com.whitecastle.linkservice.proxy;

import java.util.List;

import com.whitecastle.linkservice.response.Photos;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "photosjson", url = "https://jsonplaceholder.typicode.com/")
public interface PhotosProxy {

    @GetMapping("/photos")
    List<Photos> getPhotos();

    @GetMapping("/photos/{id}")
    Photos getPhotoId(@PathVariable Integer id);
    
}
