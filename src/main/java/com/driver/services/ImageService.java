package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;
    @Autowired
    private BlogRepository blogRepository2;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog

            Image image = new Image(description,dimensions,blog);

            List<Image> imageList=blogRepository2.findById(blog.getId()).get().getImageList();
            imageList.add(image);
            blog.setImageList(imageList);

            blogRepository2.save(blog);

            blog = blogRepository2.findById(blog.getId()).get();
            imageList= blog.getImageList();
            int size = imageList.size();

            return imageList.get(size-1);
    }

    public void deleteImage(Image image){
        imageRepository2.delete(imageRepository2.findById(image.getId()).get());
    }

    public Image findById(int id) {
        return imageRepository2.findById(id).get();
    }

    public int countImagesInScreen(Image image, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0

            if(image==null) return 0;

            //System.out.println(image.getDimensions()+"  "+screenDimensions+" "+image.getDescription());

            String imageDimension = image.getDimensions();
            String[] dimensions = imageDimension.substring(1,imageDimension.length()-1).split("X");
            //int imageArea = Integer.parseInt(dimensions[0])*Integer.parseInt(dimensions[1]);

            String[] screenD = screenDimensions.split("X");
            //int screenArea = Integer.parseInt(screenD[0])*Integer.parseInt(screenD[1]);

            int breadth = Integer.parseInt(screenD[0]) /Integer.parseInt(dimensions[0]);
            int length = Integer.parseInt(screenD[1]) /Integer.parseInt(dimensions[1]);

            return breadth*length;
    }
}
