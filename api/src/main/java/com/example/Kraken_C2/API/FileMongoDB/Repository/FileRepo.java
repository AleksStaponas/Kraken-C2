package com.example.Kraken_C2.API.FileMongoDB.Repository;

import com.example.Kraken_C2.API.FileMongoDB.Model.File;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepo extends MongoRepository<File,String> {
}
