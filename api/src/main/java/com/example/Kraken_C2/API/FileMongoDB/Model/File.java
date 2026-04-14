package com.example.Kraken_C2.API.FileMongoDB.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "files")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class File {

    @Id
    private String id;
    private String filename;
    private String dateOfUpload;
}
