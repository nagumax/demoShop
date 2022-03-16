package com.example.demo.controller;

import com.example.demo.dto.BucketDTO;
import com.example.demo.entity.Bucket;
import com.example.demo.entity.Product;
import com.example.demo.service.BucketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class BucketController {

    private final BucketService bucketService;


    public BucketController(BucketService bucketService) {
        this.bucketService = bucketService;
    }

    @GetMapping("/bucket")
    public String bucketInfo(Model model, Principal principal){
        if (principal == null) {
            model.addAttribute("bucket", new BucketDTO());
        } else {
              BucketDTO bucketDTO = bucketService.getBucketByUser(principal.getName());
              model.addAttribute("bucket", bucketDTO);
        }
        return "bucket";
    }

    @DeleteMapping("/bucket/{productId}")
    public String deleteProductAtBucket(Bucket bucket, @PathVariable Long productId){

        bucketService.removeProductAtBucket(bucket, productId);
        return "redirect:/bucket";
    }


}
