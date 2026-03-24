package com.example.Kraken_C2.API.FileUpload.Storage;

import com.example.Kraken_C2.API.FileUpload.StorageException;

public class StorageFileNotFoundException extends StorageException {

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}