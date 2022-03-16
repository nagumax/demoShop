package com.example.demo.service;

import com.example.demo.dto.BucketDTO;
import com.example.demo.entity.Bucket;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;

import java.util.List;

public interface BucketService{
    Bucket createBucket(User user, List<Long> productIds);

    void addProducts(Bucket bucket, List<Long> productIds);

    BucketDTO getBucketByUser(String name);

    void removeProductAtBucket(Bucket bucket, Long productId);
}
