package com.rcorrent.personsignup.filetransfer;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UploadFileResponseVO implements Serializable {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    public UploadFileResponseVO() {
    }

    public UploadFileResponseVO(final String fileName,
                                final String fileDownloadUri,
                                final String fileType,
                                final long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

}
